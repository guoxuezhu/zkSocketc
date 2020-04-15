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

public class DianyuanFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dianyuan_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.dy_all_open)
    public void dy_all_open() {
        SerialPortUtil.sendMsg("MBS37");
    }

    @OnClick(R.id.dy_all_close)
    public void dy_all_close() {
        SerialPortUtil.sendMsg("MBS38");
    }


    @OnClick(R.id.btn_hw_ds_1)
    public void btn_hw_ds_1() {
        SerialPortUtil.sendMsg("MBS52");
    }

    @OnClick(R.id.btn_hw_ds_2)
    public void btn_hw_ds_2() {
        SerialPortUtil.sendMsg("MBS53");
    }

    @OnClick(R.id.btn_hw_ds_3)
    public void btn_hw_ds_3() {
        SerialPortUtil.sendMsg("MBS54");
    }

    @OnClick(R.id.btn_hw_ds_4)
    public void btn_hw_ds_4() {
        SerialPortUtil.sendMsg("MBS55");
    }

    @OnClick(R.id.rbtn_nei_hdmi)
    public void rbtn_nei_hdmi() {
        SerialPortUtil.sendMsg("MBS50");
    }

    @OnClick(R.id.rbtn_wai_hdmi)
    public void rbtn_wai_hdmi() {
        SerialPortUtil.sendMsg("MBS51");
    }
}
