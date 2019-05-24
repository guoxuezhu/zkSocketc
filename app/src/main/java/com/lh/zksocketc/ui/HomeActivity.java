package com.lh.zksocketc.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.lh.zksocketc.R;
import com.lh.zksocketc.ui.fragment.ChuanjingFragment;
import com.lh.zksocketc.ui.fragment.DianyuanFragment;
import com.lh.zksocketc.ui.fragment.JuzhenFragment;
import com.lh.zksocketc.ui.fragment.LuboFragment;
import com.lh.zksocketc.ui.fragment.ShebeiFragment;
import com.lh.zksocketc.ui.fragment.YinpinFragment;
import com.lh.zksocketc.utils.SerialPortUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.rbtn_changjing)
    RadioButton rbtn_changjing;

    private List<Fragment> fragments = new ArrayList<>();
    private Fragment fragment;
    private boolean isShangke = false;

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

    }

    public List<Fragment> getFragments() {
        fragments.add(new ChuanjingFragment());
        fragments.add(new ShebeiFragment());
        fragments.add(new LuboFragment());
        fragments.add(new JuzhenFragment());
//        fragments.add(new HuanjingFragment());
        fragments.add(new YinpinFragment());
        fragments.add(new DianyuanFragment());
        return fragments;
    }

    @OnClick(R.id.rbtn_changjing)
    public void rbtn_changjing() {
        showFragment(0);
    }

    @OnClick(R.id.rbtn_shebei)
    public void rbtn_shebei() {
        showFragment(1);
    }


    @OnClick(R.id.rbtn_lubo)
    public void rbtn_lubo() {
        showFragment(2);
    }

    @OnClick(R.id.rbtn_juzhen)
    public void rbtn_juzhen() {
        showFragment(3);
    }


    @OnClick(R.id.rbtn_yinpin)
    public void rbtn_yinpin() {
        showFragment(4);
    }


    @OnClick(R.id.rbtn_dianyuan)
    public void rbtn_dianyuan() {
        showFragment(5);
    }


    private void showFragment(int i) {
        fragment = fragments.get(i);
        getFragmentManager().beginTransaction()
                .replace(R.id.mFragment, fragment).commit();
//        getFragmentManager().beginTransaction().show(fragment);

    }

    @OnClick(R.id.rbtn_fuwei)
    public void rbtn_fuwei() {
        SerialPortUtil.sendMsg("FWS0");
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
        SerialPortUtil.sendMsg("MBS2");
        isShangke = false;
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }

    @OnClick(R.id.rbtn_nei_hdmi)
    public void rbtn_nei_hdmi(View view) {
        SerialPortUtil.sendMsg("MBS50");
    }

    @OnClick(R.id.rbtn_wai_hdmi)
    public void rbtn_wai_hdmi() {
        SerialPortUtil.sendMsg("MBS51");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
