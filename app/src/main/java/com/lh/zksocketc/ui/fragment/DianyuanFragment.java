package com.lh.zksocketc.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DianyuanFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dianyuan_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.rbtn_tyj_open)
    public void rbtn_tyj_open() {
        SerialPortUtil.sendMsg("MBS9");
    }

    @OnClick(R.id.rbtn_tyj_close)
    public void rbtn_tyj_close() {
        SerialPortUtil.sendMsg("MBS10");
    }


    @OnClick(R.id.rbtn_tyj_bu_open)
    public void rbtn_tyj_bu_open() {
        SerialPortUtil.sendMsg("MBS11");
    }

    @OnClick(R.id.rbtn_tyj_bu_close)
    public void rbtn_tyj_bu_close() {
        SerialPortUtil.sendMsg("MBS12");
    }



    @OnClick(R.id.rbtn_ytj_open)
    public void rbtn_ytj_open() {
        SerialPortUtil.sendMsg("MBS5001");
    }

    @OnClick(R.id.rbtn_ytj_close)
    public void rbtn_ytj_close() {
        SerialPortUtil.sendMsg("MBS5002");
    }

    @OnClick(R.id.rbtn_nei_hdmi)
    public void rbtn_nei_hdmi() {
        SerialPortUtil.sendMsg("MBS5003");
    }

    @OnClick(R.id.rbtn_wai_hdmi)
    public void rbtn_wai_hdmi() {
        SerialPortUtil.sendMsg("MBS5004");
    }



    @OnClick(R.id.btn_hw_ds_1)
    public void btn_hw_ds_1() {
        SerialPortUtil.sendMsg("MBS5005");
    }

    @OnClick(R.id.btn_hw_ds_2)
    public void btn_hw_ds_2() {
        SerialPortUtil.sendMsg("MBS5006");
    }

    @OnClick(R.id.btn_hw_ds_3)
    public void btn_hw_ds_3() {
        SerialPortUtil.sendMsg("MBS5007");
    }

    @OnClick(R.id.btn_hw_ds_4)
    public void btn_hw_ds_4() {
        SerialPortUtil.sendMsg("MBS5008");
    }


    @OnClick(R.id.btn_hw_ds_5)
    public void btn_hw_ds_5() {
        SerialPortUtil.sendMsg("MBS5009");
    }

    @OnClick(R.id.btn_hw_ds_6)
    public void btn_hw_ds_6() {
        SerialPortUtil.sendMsg("MBS5010");
    }


    @OnClick(R.id.btn_hw_ds_7)
    public void btn_hw_ds_7() {
        SerialPortUtil.sendMsg("MBS5011");
    }

    @OnClick(R.id.btn_hw_ds_8)
    public void btn_hw_ds_8() {
        SerialPortUtil.sendMsg("MBS5012");
    }



}
