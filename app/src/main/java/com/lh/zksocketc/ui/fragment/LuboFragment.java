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

    @BindView(R.id.luzhi)
    CheckBox luzhi;
    @BindView(R.id.zanting)
    CheckBox zanting;
    @BindView(R.id.jixu)
    CheckBox jixu;
    @BindView(R.id.tingzhi)
    CheckBox tingzhi;
    @BindView(R.id.zhibo)
    CheckBox zhibo;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lubo_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.luzhi)
    public void luzhi() {
        luzhi.setChecked(true);
        zanting.setChecked(false);
        jixu.setChecked(false);
        tingzhi.setChecked(false);
        SerialPortUtil.sendMsg("LUB1");
    }

    @OnClick(R.id.zanting)
    public void zanting() {
        luzhi.setChecked(false);
        zanting.setChecked(true);
        jixu.setChecked(false);
        tingzhi.setChecked(false);
        SerialPortUtil.sendMsg("LUB2");
    }

    @OnClick(R.id.jixu)
    public void jixu() {
        luzhi.setChecked(false);
        zanting.setChecked(false);
        jixu.setChecked(true);
        tingzhi.setChecked(false);
        SerialPortUtil.sendMsg("LUB6");
    }

    @OnClick(R.id.tingzhi)
    public void tingzhi() {
        luzhi.setChecked(false);
        zanting.setChecked(false);
        jixu.setChecked(false);
        tingzhi.setChecked(true);
        SerialPortUtil.sendMsg("LUB3");
    }

    @OnClick(R.id.zhibo)
    public void zhibo() {
        if (zhibo.isChecked()) {
            SerialPortUtil.sendMsg("LUB4");
        } else {
            SerialPortUtil.sendMsg("LUB5");
        }
    }

}
