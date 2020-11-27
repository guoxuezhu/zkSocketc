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
}
