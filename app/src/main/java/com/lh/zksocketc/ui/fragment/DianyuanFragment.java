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

    @OnClick(R.id.btn_jdq_1)
    public void btn_jdq_1() {
        SerialPortUtil.sendMsg("MBS52");
    }

    @OnClick(R.id.btn_jdq_2)
    public void btn_jdq_2() {
        SerialPortUtil.sendMsg("MBS53");
    }

    @OnClick(R.id.btn_jdq_3)
    public void btn_jdq_3() {
        SerialPortUtil.sendMsg("MBS54");
    }

    @OnClick(R.id.btn_jdq_4)
    public void btn_jdq_4() {
        SerialPortUtil.sendMsg("MBS55");
    }

    @OnClick(R.id.btn_jdq_5)
    public void btn_jdq_5() {
        SerialPortUtil.sendMsg("MBS56");
    }

    @OnClick(R.id.btn_jdq_6)
    public void btn_jdq_6() {
        SerialPortUtil.sendMsg("MBS57");
    }

    @OnClick(R.id.btn_jdq_7)
    public void btn_jdq_7() {
        SerialPortUtil.sendMsg("MBS58");
    }

    @OnClick(R.id.btn_jdq_8)
    public void btn_jdq_8() {
        SerialPortUtil.sendMsg("MBS59");
    }


    @OnClick(R.id.btn_ck_1)
    public void btn_ck_1() {
        SerialPortUtil.sendMsg("MBS60");
    }

    @OnClick(R.id.btn_ck_2)
    public void btn_ck_2() {
        SerialPortUtil.sendMsg("MBS61");
    }

    @OnClick(R.id.btn_ck_3)
    public void btn_ck_3() {
        SerialPortUtil.sendMsg("MBS62");
    }

    @OnClick(R.id.btn_ck_4)
    public void btn_ck_4() {
        SerialPortUtil.sendMsg("MBS63");
    }

    @OnClick(R.id.btn_ck_5)
    public void btn_ck_5() {
        SerialPortUtil.sendMsg("MBS64");
    }

    @OnClick(R.id.btn_ck_6)
    public void btn_ck_6() {
        SerialPortUtil.sendMsg("MBS65");
    }

    @OnClick(R.id.btn_ck_7)
    public void btn_ck_7() {
        SerialPortUtil.sendMsg("MBS66");
    }

    @OnClick(R.id.btn_ck_8)
    public void btn_ck_8() {
        SerialPortUtil.sendMsg("MBS67");
    }


    @OnClick(R.id.btn_io_1)
    public void btn_io_1() {
        SerialPortUtil.sendMsg("MBS17");
    }

    @OnClick(R.id.btn_io_2)
    public void btn_io_2() {
        SerialPortUtil.sendMsg("MBS18");
    }

    @OnClick(R.id.btn_io_3)
    public void btn_io_3() {
        SerialPortUtil.sendMsg("MBS19");
    }

    @OnClick(R.id.btn_io_4)
    public void btn_io_4() {
        SerialPortUtil.sendMsg("MBS20");
    }


    @OnClick(R.id.btn_dout_1)
    public void btn_dout_1() {
        SerialPortUtil.sendMsg("MBS41");
    }

    @OnClick(R.id.btn_dout_2)
    public void btn_dout_2() {
        SerialPortUtil.sendMsg("MBS42");
    }

    @OnClick(R.id.btn_dout_3)
    public void btn_dout_3() {
        SerialPortUtil.sendMsg("MBS43");
    }

    @OnClick(R.id.btn_dout_4)
    public void btn_dout_4() {
        SerialPortUtil.sendMsg("MBS44");
    }




}
