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

public class DengguangFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dengguang_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.rbtn_dg_all_open)
    public void rbtn_dg_all_open() {
        SerialPortUtil.sendMsg("MBS13");
    }

    @OnClick(R.id.rbtn_dg_all_close)
    public void rbtn_dg_all_close() {
        SerialPortUtil.sendMsg("MBS14");
    }

    @OnClick(R.id.rbtn_hbd_open)
    public void rbtn_hbd_open() {
        SerialPortUtil.sendMsg("MBS62");
    }

    @OnClick(R.id.rbtn_hbd_close)
    public void rbtn_hbd_close() {
        SerialPortUtil.sendMsg("MBS63");
    }

    @OnClick(R.id.rbtn_jsd_open)
    public void rbtn_jsd_open() {
        SerialPortUtil.sendMsg("MBS64");
    }

    @OnClick(R.id.rbtn_jsd_close)
    public void rbtn_jsd_close() {
        SerialPortUtil.sendMsg("MBS65");
    }

}
