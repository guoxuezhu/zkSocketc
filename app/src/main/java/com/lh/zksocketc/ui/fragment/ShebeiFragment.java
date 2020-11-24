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

public class ShebeiFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shebei_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.rbtn_cl_all_open)
    public void rbtn_cl_all_open() {
        SerialPortUtil.sendMsg("MBS3");
    }

    @OnClick(R.id.rbtn_cl_all_close)
    public void rbtn_cl_all_close() {
        SerialPortUtil.sendMsg("MBS4");
    }

    @OnClick(R.id.rbtn_cl1_open)
    public void rbtn_cl1_open() {
        SerialPortUtil.sendMsg("MBS5");
    }

    @OnClick(R.id.rbtn_cl1_close)
    public void rbtn_cl1_close() {
        SerialPortUtil.sendMsg("MBS6");
    }

    @OnClick(R.id.rbtn_cl2_open)
    public void rbtn_cl2_open() {
        SerialPortUtil.sendMsg("MBS7");
    }

    @OnClick(R.id.rbtn_cl2_close)
    public void rbtn_cl2_close() {
        SerialPortUtil.sendMsg("MBS8");
    }


}
