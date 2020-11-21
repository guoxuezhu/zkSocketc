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

public class DoorFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.door_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.btn_mj_1)
    public void btn_mj_1() {
        SerialPortUtil.sendMsg("MJD46");
    }

    @OnClick(R.id.btn_mj_2)
    public void btn_mj_2() {
        SerialPortUtil.sendMsg("MBS47");
    }
}
