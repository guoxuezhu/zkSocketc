package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.lh.zksocketc.R;
import com.lh.zksocketc.ui.fragment.ChuanjingFragment;
import com.lh.zksocketc.ui.fragment.DengguangFragment;
import com.lh.zksocketc.ui.fragment.DianyuanFragment;
import com.lh.zksocketc.ui.fragment.DoorFragment;
import com.lh.zksocketc.ui.fragment.HuanjingFragment;
import com.lh.zksocketc.ui.fragment.JuzhenFragment;
import com.lh.zksocketc.ui.fragment.LuboFragment;
import com.lh.zksocketc.ui.fragment.ShebeiFragment;
import com.lh.zksocketc.ui.fragment.YinpinFragment;
import com.lh.zksocketc.utils.DateUtil;
import com.lh.zksocketc.utils.ELog;
import com.lh.zksocketc.utils.SerialPortUtil;
import com.lh.zksocketc.utils.TishiDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity implements TishiDialog.DialogCallBack {

    @BindView(R.id.rbtn_changjing)
    RadioButton rbtn_changjing;
    @BindView(R.id.rbtn_shangke)
    RadioButton rbtn_shangke;
    @BindView(R.id.rbtn_xiake)
    RadioButton rbtn_xiake;

    @BindView(R.id.time_tv_home)
    TextView time_tv_home;

    private List<Fragment> fragments = new ArrayList<>();
    private Fragment fragment;
    private boolean isShangke = false;
    private Timer timeTimer;
    private Handler homeHander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 326:
//                    ELog.e("======HomeActivity====homeHander===326=====" + msg.obj.toString());
                    time_tv_home.setText(msg.obj.toString());
                    break;
            }
        }
    };
    private TishiDialog tishiDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        rbtn_changjing.setChecked(true);
//        rbtn_fuwei.setChecked(true);

        fragments = getFragments(); //添加布局
        showFragment(0);
        isShangke = false;
        SerialPortUtil.sendMsg("VOLABC");
        tvgetTime();
    }

    private void tvgetTime() {
        stopTimeTimer();
        timeTimer = new Timer();
        timeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.obj = DateUtil.getNow();
                message.what = 326;
                homeHander.sendMessage(message);
            }
        }, 100, 1000);
    }

    private void stopTimeTimer() {
        if (timeTimer != null) {
            timeTimer.cancel();
            timeTimer = null;
        }
    }


    public List<Fragment> getFragments() {
        fragments.add(new ChuanjingFragment());
        fragments.add(new JuzhenFragment());
        fragments.add(new LuboFragment());
        fragments.add(new DianyuanFragment());
        fragments.add(new ShebeiFragment());
        fragments.add(new DengguangFragment());
        fragments.add(new HuanjingFragment());
        fragments.add(new DoorFragment());
        fragments.add(new YinpinFragment());
        return fragments;
    }

    @OnClick(R.id.rbtn_changjing)
    public void rbtn_changjing() {
        showFragment(0);
    }

    @OnClick(R.id.rbtn_juzhen)
    public void rbtn_juzhen() {
        showFragment(1);
    }


    @OnClick(R.id.rbtn_lubo)
    public void rbtn_lubo() {
        showFragment(2);
    }

    @OnClick(R.id.rbtn_dmt)
    public void rbtn_dmt() {
        showFragment(3);
    }


    @OnClick(R.id.rbtn_cl)
    public void rbtn_cl() {
        showFragment(4);
    }


    @OnClick(R.id.rbtn_dg)
    public void rbtn_dg() {
        showFragment(5);
    }

    @OnClick(R.id.rbtn_kt)
    public void rbtn_kt() {
        showFragment(6);
    }

    @OnClick(R.id.rbtn_door)
    public void rbtn_door() {
        showFragment(7);
    }

    @OnClick(R.id.rbtn_yinpin)
    public void rbtn_yinpin() {
        showFragment(8);
    }


    private void showFragment(int i) {
        fragment = fragments.get(i);
        getSupportFragmentManager().beginTransaction().replace(R.id.mFragment, fragment).commit();
    }

//    @OnClick(R.id.rbtn_fuwei)
//    public void rbtn_fuwei() {
//        SerialPortUtil.sendMsg("FWS0");
//    }


    @OnClick(R.id.rbtn_shangke)
    public void rbtn_shangke() {
        if (!isShangke) {
            SerialPortUtil.sendMsg("MBS1");
            isShangke = true;
        }
    }


    @OnClick(R.id.rbtn_xiake)
    public void rbtn_xiake() {
        if (tishiDialog == null) {
            tishiDialog = new TishiDialog(this, this);
        }
        if (tishiDialog != null) {
            tishiDialog.show();
            tishiDialog.setCanceledOnTouchOutside(false);
        }
    }

    @Override
    public void tishiOkDialog() {
        if (tishiDialog != null) {
            tishiDialog.dismiss();
            tishiDialog = null;
        }
        SerialPortUtil.sendMsg("MBS2");
        isShangke = false;
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }

    @Override
    public void tishiCancelDialog() {
        if (tishiDialog != null) {
            tishiDialog.dismiss();
            tishiDialog = null;
        }
        if (isShangke) {
            rbtn_shangke.setChecked(true);
        } else {
            rbtn_xiake.setChecked(false);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopTimeTimer();
    }
}
