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

public class ChuanjingFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.changjing_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;

    }


    @OnClick(R.id.cl_all_open)
    public void cl_all_open() {
        SerialPortUtil.sendMsg("MBS3");
    }

    @OnClick(R.id.cl_all_close)
    public void cl_all_close() {
        SerialPortUtil.sendMsg("MBS4");
    }

    @OnClick(R.id.rbtn_cl_open_1)
    public void rbtn_cl_open_1() {
        SerialPortUtil.sendMsg("MBS5");
    }

    @OnClick(R.id.rbtn_cl_close_1)
    public void rbtn_cl_close_1() {
        SerialPortUtil.sendMsg("MBS6");
    }

    @OnClick(R.id.rbtn_cl_open_2)
    public void rbtn_cl_open_2() {
        SerialPortUtil.sendMsg("MBS7");
    }

    @OnClick(R.id.rbtn_cl_close_2)
    public void rbtn_cl_close_2() {
        SerialPortUtil.sendMsg("MBS8");
    }


    @OnClick(R.id.rbtn_cl_open_3)
    public void rbtn_cl_open_3() {
        SerialPortUtil.sendMsg("MBS62");
    }

    @OnClick(R.id.rbtn_cl_close_3)
    public void rbtn_cl_close_3() {
        SerialPortUtil.sendMsg("MBS63");
    }


    @OnClick(R.id.rbtn_cl_open_4)
    public void rbtn_cl_open_4() {
        SerialPortUtil.sendMsg("MBS64");
    }

    @OnClick(R.id.rbtn_cl_close_4)
    public void rbtn_cl_close_4() {
        SerialPortUtil.sendMsg("MBS65");
    }


    @OnClick(R.id.rbtn_cl_open_5)
    public void rbtn_cl_open_5() {
        SerialPortUtil.sendMsg("MBS66");
    }

    @OnClick(R.id.rbtn_cl_close_5)
    public void rbtn_cl_close_5() {
        SerialPortUtil.sendMsg("MBS67");
    }


}
