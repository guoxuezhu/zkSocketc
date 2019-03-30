package com.lh.zksocketc.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HuanjingFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.huanjing_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.huanjng_btn_kaiguan)
    public void huanjng_btn_kaiguan() {
        SerialPortUtil.sendMsg("39");
    }


    @OnClick(R.id.huanjng_btn_moshi)
    public void huanjng_btn_moshi() {
        SerialPortUtil.sendMsg("40");
    }



    @OnClick(R.id.huanjng_btn_fengsu)
    public void huanjng_btn_fengsu() {
        SerialPortUtil.sendMsg("41");
    }



    @OnClick(R.id.huanjng_btn_wd_jia)
    public void huanjng_btn_wd_jia() {
        SerialPortUtil.sendMsg("43");
    }



    @OnClick(R.id.huanjng_btn_wd_jian)
    public void huanjng_btn_wd_jian() {
        SerialPortUtil.sendMsg("44");
    }



    @OnClick(R.id.huanjng_btn_fengxiang)
    public void huanjng_btn_fengxiang() {
        SerialPortUtil.sendMsg("42");
    }

}
