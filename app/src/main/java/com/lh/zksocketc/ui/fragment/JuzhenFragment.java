package com.lh.zksocketc.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JuzhenFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.juzhen_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.dg_all_open)
    public void dg_all_open() {
        SerialPortUtil.sendMsg("MBS13");
    }

    @OnClick(R.id.dg_all_close)
    public void dg_all_close() {
        SerialPortUtil.sendMsg("MBS14");
    }


    @OnClick(R.id.rbtn_dg_open_1)
    public void rbtn_dg_open_1() {
        SerialPortUtil.sendMsg("MBS15");
    }

    @OnClick(R.id.rbtn_dg_close_1)
    public void rbtn_dg_close_1() {
        SerialPortUtil.sendMsg("MBS16");
    }

    @OnClick(R.id.rbtn_dg_open_2)
    public void rbtn_dg_open_2() {
        SerialPortUtil.sendMsg("MBS17");
    }

    @OnClick(R.id.rbtn_dg_close_2)
    public void rbtn_dg_close_2() {
        SerialPortUtil.sendMsg("MBS18");
    }


    @OnClick(R.id.rbtn_dg_open_3)
    public void rbtn_dg_open_3() {
        SerialPortUtil.sendMsg("MBS19");
    }

    @OnClick(R.id.rbtn_dg_close_3)
    public void rbtn_dg_close_3() {
        SerialPortUtil.sendMsg("MBS20");
    }

}
