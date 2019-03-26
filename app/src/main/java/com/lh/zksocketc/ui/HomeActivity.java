package com.lh.zksocketc.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.lh.zksocketc.R;
import com.lh.zksocketc.ui.fragment.ChuanjingFragment;
import com.lh.zksocketc.ui.fragment.DianyuanFragment;
import com.lh.zksocketc.ui.fragment.HuanjingFragment;
import com.lh.zksocketc.ui.fragment.JuzhenFragment;
import com.lh.zksocketc.ui.fragment.LuboFragment;
import com.lh.zksocketc.ui.fragment.ShebeiFragment;
import com.lh.zksocketc.ui.fragment.YinpinFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.rbtn_changjing)
    RadioButton rbtn_changjing;

//    @BindView(R.id.mFragment)
//    FrameLayout mFragment;

    private List<Fragment> fragments = new ArrayList<>();
    private FragmentManager fm;
    private FragmentTransaction transaction;
    private Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        rbtn_changjing.setChecked(true);


        fragments = getFragments(); //添加布局
        showFragment(0);


    }

    public List<Fragment> getFragments() {
        fragments.add(new ChuanjingFragment());
        fragments.add(new ShebeiFragment());
        fragments.add(new LuboFragment());
        fragments.add(new JuzhenFragment());
        fragments.add(new HuanjingFragment());
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


    @OnClick(R.id.rbtn_huanjing)
    public void rbtn_huanjing() {
        showFragment(4);
    }


    @OnClick(R.id.rbtn_yinpin)
    public void rbtn_yinpin() {
        showFragment(5);
    }


    @OnClick(R.id.rbtn_dianyuan)
    public void rbtn_dianyuan() {
        showFragment(6);
    }


    private void showFragment(int i) {
        fragment = fragments.get(i);
        getFragmentManager().beginTransaction()
                .replace(R.id.mFragment, fragment).commit();
//        getFragmentManager().beginTransaction().show(fragment);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
