package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.data.DbDao.UIsetDataDao;
import com.lh.zksocketc.data.DbDao.WsdDataDao;
import com.lh.zksocketc.ui.fragment.DuomeitiFragment;
import com.lh.zksocketc.ui.fragment.HuanjingFragment;
import com.lh.zksocketc.ui.fragment.JuzhenFragment;
import com.lh.zksocketc.ui.fragment.LuboFragment;
import com.lh.zksocketc.ui.fragment.YinpinFragment;
import com.lh.zksocketc.utils.DateUtil;
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
//
//    @BindView(R.id.xian_view_1)
//    View xian_view_1;
//    @BindView(R.id.xian_view_2)
//    View xian_view_2;
//    @BindView(R.id.xian_view_3)
//    View xian_view_3;
//    @BindView(R.id.xian_view_4)
//    View xian_view_4;
//    @BindView(R.id.xian_view_5)
//    View xian_view_5;
//    @BindView(R.id.xian_view_6)
//    View xian_view_6;
//    @BindView(R.id.xian_view_7)
//    View xian_view_7;
//    @BindView(R.id.xian_view_8)
//    View xian_view_8;

    //    @BindView(R.id.rbtn_changjing)
//    RadioButton rbtn_changjing;
    @BindView(R.id.rbtn_juzhen)
    RadioButton rbtn_juzhen;
    //    @BindView(R.id.rbtn_lubo)
//    RadioButton rbtn_lubo;
//    @BindView(R.id.rbtn_dmt)
//    RadioButton rbtn_dmt;
//    @BindView(R.id.rbtn_cl)
//    RadioButton rbtn_cl;
//    @BindView(R.id.rbtn_dg)
//    RadioButton rbtn_dg;
//    @BindView(R.id.rbtn_kt)
//    RadioButton rbtn_kt;
//    @BindView(R.id.rbtn_door)
//    RadioButton rbtn_door;
    @BindView(R.id.rbtn_yinpin)
    RadioButton rbtn_yinpin;
    @BindView(R.id.rbtn_shangke)
    RadioButton rbtn_shangke;
    @BindView(R.id.rbtn_xiake)
    RadioButton rbtn_xiake;

    @BindView(R.id.tv_wendu)
    TextView tv_wendu;
    @BindView(R.id.tv_shidu)
    TextView tv_shidu;
    @BindView(R.id.tv_pm)
    TextView tv_pm;
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
                case 223:
                    wsdInitView();
                    break;
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

        fragments = getFragments(); //添加布局
        isShangke = false;
//        SerialPortUtil.sendMsg("VOLABC");
        tvgetTime();
        initView();
        wsdInitView();
        SerialPortUtil.getWsdMsg(homeHander);
    }

    private void wsdInitView() {
        WsdDataDao wsdDataDao = MyApplication.getDaoSession().getWsdDataDao();
        if (wsdDataDao.loadAll().size() != 0) {
            tv_wendu.setText("温度" + "\n" + wsdDataDao.loadAll().get(0).wendu);
            tv_shidu.setText("湿度" + "\n" + wsdDataDao.loadAll().get(0).shidu);
            tv_pm.setText("PM2.5" + "\n" + wsdDataDao.loadAll().get(0).pm25);
        } else {
            tv_wendu.setText("温度" + "\n" + 0 + "°C");
            tv_shidu.setText("湿度" + "\n" + 0 + "%RH");
            tv_pm.setText("PM2.5" + "\n" + 0 + "ug/m3");
        }
    }

    private void initView() {
        UIsetDataDao uIsetDataDao = MyApplication.getDaoSession().getUIsetDataDao();
        if (uIsetDataDao.loadAll().size() == 0) {
            rbtn_juzhen.setChecked(true);
            showFragment(0);
            return;
        }
        String statusstr = uIsetDataDao.loadAll().get(0).btn_1_status + ";" + uIsetDataDao.loadAll().get(0).btn_2_status + ";"
                + uIsetDataDao.loadAll().get(0).btn_3_status + ";" + uIsetDataDao.loadAll().get(0).btn_4_status + ";"
                + uIsetDataDao.loadAll().get(0).btn_5_status + ";" + uIsetDataDao.loadAll().get(0).btn_6_status + ";"
                + uIsetDataDao.loadAll().get(0).btn_7_status + ";" + uIsetDataDao.loadAll().get(0).btn_8_status + ";"
                + uIsetDataDao.loadAll().get(0).btn_9_status + "";
        String[] statuslist = statusstr.split(";");
        for (int i = 0; i < statuslist.length; i++) {
            if (statuslist[i].equals("1")) {
                showFragment(i);
                break;
            }
        }

//        if (uIsetDataDao.loadAll().get(0).btn_1_status.equals("0")) {
//            rbtn_changjing.setVisibility(View.GONE);
//            xian_view_1.setVisibility(View.GONE);
//        } else {
//            rbtn_changjing.setVisibility(View.VISIBLE);
//            xian_view_1.setVisibility(View.VISIBLE);
//        }
//        if (uIsetDataDao.loadAll().get(0).btn_2_status.equals("0")) {
//            rbtn_juzhen.setVisibility(View.GONE);
//            xian_view_2.setVisibility(View.GONE);
//        } else {
//            rbtn_juzhen.setVisibility(View.VISIBLE);
//            xian_view_2.setVisibility(View.VISIBLE);
//        }
//        if (uIsetDataDao.loadAll().get(0).btn_3_status.equals("0")) {
//            rbtn_lubo.setVisibility(View.GONE);
//            xian_view_3.setVisibility(View.GONE);
//        } else {
//            rbtn_lubo.setVisibility(View.VISIBLE);
//            xian_view_3.setVisibility(View.VISIBLE);
//        }
//        if (uIsetDataDao.loadAll().get(0).btn_4_status.equals("0")) {
//            rbtn_dmt.setVisibility(View.GONE);
//            xian_view_4.setVisibility(View.GONE);
//        } else {
//            rbtn_dmt.setVisibility(View.VISIBLE);
//            xian_view_4.setVisibility(View.VISIBLE);
//        }
//        if (uIsetDataDao.loadAll().get(0).btn_5_status.equals("0")) {
//            rbtn_cl.setVisibility(View.GONE);
//            xian_view_5.setVisibility(View.GONE);
//        } else {
//            rbtn_cl.setVisibility(View.VISIBLE);
//            xian_view_5.setVisibility(View.VISIBLE);
//        }
//        if (uIsetDataDao.loadAll().get(0).btn_6_status.equals("0")) {
//            rbtn_dg.setVisibility(View.GONE);
//            xian_view_6.setVisibility(View.GONE);
//        } else {
//            rbtn_dg.setVisibility(View.VISIBLE);
//            xian_view_6.setVisibility(View.VISIBLE);
//        }
//        if (uIsetDataDao.loadAll().get(0).btn_7_status.equals("0")) {
//            rbtn_kt.setVisibility(View.GONE);
//            xian_view_7.setVisibility(View.GONE);
//        } else {
//            rbtn_kt.setVisibility(View.VISIBLE);
//            xian_view_7.setVisibility(View.VISIBLE);
//        }
//        if (uIsetDataDao.loadAll().get(0).btn_8_status.equals("0")) {
//            rbtn_door.setVisibility(View.GONE);
//            xian_view_8.setVisibility(View.GONE);
//        } else {
//            rbtn_door.setVisibility(View.VISIBLE);
//            xian_view_8.setVisibility(View.VISIBLE);
//        }
//        if (uIsetDataDao.loadAll().get(0).btn_9_status.equals("0")) {
//            rbtn_yinpin.setVisibility(View.GONE);
//        } else {
//            rbtn_yinpin.setVisibility(View.VISIBLE);
//        }
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
        fragments.add(new JuzhenFragment());
        fragments.add(new DuomeitiFragment());
        fragments.add(new HuanjingFragment());
        fragments.add(new LuboFragment());
        fragments.add(new YinpinFragment());
        return fragments;
    }


    @OnClick(R.id.rbtn_juzhen)
    public void rbtn_juzhen() {
        showFragment(0);
    }

    @OnClick(R.id.rbtn_dmt)
    public void rbtn_dmt() {
        showFragment(1);
    }

    @OnClick(R.id.rbtn_hjkz)
    public void rbtn_hjkz() {
        showFragment(2);
    }

    @OnClick(R.id.rbtn_lubo)
    public void rbtn_lubo() {
        showFragment(3);
    }

    @OnClick(R.id.rbtn_yinpin)
    public void rbtn_yinpin() {
        showFragment(4);
    }


    private void showFragment(int i) {
        fragment = fragments.get(i);
        getSupportFragmentManager().beginTransaction().replace(R.id.mFragment, fragment).commit();
    }

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
        homeHander = null;
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
