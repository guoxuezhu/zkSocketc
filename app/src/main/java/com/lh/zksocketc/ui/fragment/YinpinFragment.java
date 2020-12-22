package com.lh.zksocketc.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.annotation.Nullable;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YinpinFragment extends Fragment {

    @BindView(R.id.zongyinliang)
    RadioButton zongyinliang;
    @BindView(R.id.yinxiang)
    RadioButton yinxiang;
    @BindView(R.id.maikefeng)
    RadioButton maikefeng;


    @BindView(R.id.jingyin)
    CheckBox jingyin;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.yinpin_fragment, container, false);
        ButterKnife.bind(this, view);
        zongyinliang.setChecked(true);
        return view;
    }

    @OnClick(R.id.zongyinliang)
    public void zongyinliang() {
        jingyin.setChecked(false);
    }

    @OnClick(R.id.yinxiang)
    public void yinxiang() {
        jingyin.setChecked(false);
    }

    @OnClick(R.id.maikefeng)
    public void maikefeng() {
        jingyin.setChecked(false);
    }

    @OnClick(R.id.yinliang_jia)
    public void yinliang_jia() {
        if (zongyinliang.isChecked()) {
            SerialPortUtil.sendMsg("MBS21");
        } else if (yinxiang.isChecked()) {
            SerialPortUtil.sendMsg("MBS25");
        } else if (maikefeng.isChecked()) {
            SerialPortUtil.sendMsg("MBS29");
        }

    }


    @OnClick(R.id.yinliang_jian)
    public void yinliang_jian() {
        if (zongyinliang.isChecked()) {
            SerialPortUtil.sendMsg("MBS22");
        } else if (yinxiang.isChecked()) {
            SerialPortUtil.sendMsg("MBS26");
        } else if (maikefeng.isChecked()) {
            SerialPortUtil.sendMsg("MBS30");
        }
    }

    @OnClick(R.id.jingyin)
    public void jingyin() {
        if (jingyin.isChecked()) {
            if (zongyinliang.isChecked()) {
                SerialPortUtil.sendMsg("MBS23");
            } else if (yinxiang.isChecked()) {
                SerialPortUtil.sendMsg("MBS27");
            } else if (maikefeng.isChecked()) {
                SerialPortUtil.sendMsg("MBS31");
            }
        } else {
            if (zongyinliang.isChecked()) {
                SerialPortUtil.sendMsg("MBS24");
            } else if (yinxiang.isChecked()) {
                SerialPortUtil.sendMsg("MBS28");
            } else if (maikefeng.isChecked()) {
                SerialPortUtil.sendMsg("MBS32");
            }
        }


    }


}
