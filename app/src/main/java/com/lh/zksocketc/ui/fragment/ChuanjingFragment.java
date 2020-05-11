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


    @BindView(R.id.spbtn_all_gpy)
    CheckBox spbtn_all_gpy;
    @BindView(R.id.spbtn_all_diannao)
    CheckBox spbtn_all_diannao;
    @BindView(R.id.spbtn_all_bjb_1)
    CheckBox spbtn_all_bjb_1;
    @BindView(R.id.spbtn_all_laoshi_diannao)
    CheckBox spbtn_all_laoshi_diannao;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.changjing_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;

    }


    @OnClick(R.id.spbtn_all_laoshi_diannao)
    public void spbtn_all_laoshi_diannao() {
        SerialPortUtil.sendMsg("VIDC1");
        spbtn_all_gpy.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_bjb_1.setChecked(false);
        spbtn_all_laoshi_diannao.setChecked(true);
    }

    @OnClick(R.id.spbtn_all_diannao)
    public void spbtn_all_diannao() {
        SerialPortUtil.sendMsg("VIDC2");
        spbtn_all_gpy.setChecked(false);
        spbtn_all_diannao.setChecked(true);
        spbtn_all_bjb_1.setChecked(false);
        spbtn_all_laoshi_diannao.setChecked(false);
    }

    @OnClick(R.id.spbtn_all_bjb_1)
    public void spbtn_all_bjb_1() {
        SerialPortUtil.sendMsg("VIDC3");
        spbtn_all_gpy.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_bjb_1.setChecked(true);
        spbtn_all_laoshi_diannao.setChecked(false);
    }

    @OnClick(R.id.spbtn_all_gpy)
    public void spbtn_all_gpy() {
        SerialPortUtil.sendMsg("VIDC4");
        spbtn_all_gpy.setChecked(true);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_bjb_1.setChecked(false);
        spbtn_all_laoshi_diannao.setChecked(false);
    }



}
