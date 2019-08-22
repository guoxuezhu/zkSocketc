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

public class LuboFragment extends Fragment {




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lubo_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_xf_open)
    public void btn_xf_open() {
        SerialPortUtil.sendMsg("MBS60");
    }

    @OnClick(R.id.btn_xf_close)
    public void btn_xf_close() {
        SerialPortUtil.sendMsg("MBS61");
    }

    @OnClick(R.id.btn_xf_zidong)
    public void btn_xf_zidong() {
        SerialPortUtil.sendMsg("MBS33");
    }

    @OnClick(R.id.btn_xf_fs_1)
    public void btn_xf_fs_1() {
        SerialPortUtil.sendMsg("MBS34");
    }

    @OnClick(R.id.btn_xf_fs_2)
    public void btn_xf_fs_2() {
        SerialPortUtil.sendMsg("MBS35");
    }

    @OnClick(R.id.btn_xf_fs_3)
    public void btn_xf_fs_3() {
        SerialPortUtil.sendMsg("MBS36");
    }

}
