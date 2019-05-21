package com.lh.zksocketc.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.lh.zksocketc.R;
import com.lh.zksocketc.ui.SplashActivity;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChuanjingFragment extends Fragment {


    @BindView(R.id.spbtn_all_lubo)
    CheckBox spbtn_all_lubo;
    @BindView(R.id.spbtn_all_diannao)
    CheckBox spbtn_all_diannao;
    @BindView(R.id.spbtn_all_touping)
    CheckBox spbtn_all_touping;
    @BindView(R.id.spbtn_all_zu_1)
    CheckBox spbtn_all_zu_1;
    @BindView(R.id.spbtn_all_zu_2)
    CheckBox spbtn_all_zu_2;
    @BindView(R.id.spbtn_all_zu_3)
    CheckBox spbtn_all_zu_3;
    @BindView(R.id.spbtn_all_zu_4)
    CheckBox spbtn_all_zu_4;
    @BindView(R.id.spbtn_all_zu_5)
    CheckBox spbtn_all_zu_5;
    @BindView(R.id.spbtn_all_zu_6)
    CheckBox spbtn_all_zu_6;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.changjing_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;

    }


    @OnClick(R.id.spbtn_all_lubo)
    public void spbtn_all_lubo() {
        SerialPortUtil.sendMsg("VIDC8");
        spbtn_all_lubo.setChecked(true);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(false);
    }

    @OnClick(R.id.spbtn_all_diannao)
    public void spbtn_all_diannao() {
        SerialPortUtil.sendMsg("VIDC9");
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(true);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(false);
    }

    @OnClick(R.id.spbtn_all_touping)
    public void spbtn_all_touping() {
        SerialPortUtil.sendMsg("VIDC1");
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(true);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(false);
    }

    @OnClick(R.id.spbtn_all_zu_1)
    public void spbtn_all_zu_1() {
        SerialPortUtil.sendMsg("VIDC2");
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(true);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(false);
    }

    @OnClick(R.id.spbtn_all_zu_2)
    public void spbtn_all_zu_2() {
        SerialPortUtil.sendMsg("VIDC3");
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(true);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(false);
    }

    @OnClick(R.id.spbtn_all_zu_3)
    public void spbtn_all_zu_3() {
        SerialPortUtil.sendMsg("VIDC4");
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(true);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(false);
    }

    @OnClick(R.id.spbtn_all_zu_4)
    public void spbtn_all_zu_4() {
        SerialPortUtil.sendMsg("VIDC5");
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(true);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(false);
    }

    @OnClick(R.id.spbtn_all_zu_5)
    public void spbtn_all_zu_5() {
        SerialPortUtil.sendMsg("VIDC6");
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(true);
        spbtn_all_zu_6.setChecked(false);
    }

    @OnClick(R.id.spbtn_all_zu_6)
    public void spbtn_all_zu_6() {
        SerialPortUtil.sendMsg("VIDC7");
        spbtn_all_lubo.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_touping.setChecked(false);
        spbtn_all_zu_1.setChecked(false);
        spbtn_all_zu_2.setChecked(false);
        spbtn_all_zu_3.setChecked(false);
        spbtn_all_zu_4.setChecked(false);
        spbtn_all_zu_5.setChecked(false);
        spbtn_all_zu_6.setChecked(true);
    }


}
