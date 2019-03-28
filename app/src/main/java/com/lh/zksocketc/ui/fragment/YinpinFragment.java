package com.lh.zksocketc.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;

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
        } else if (yinxiang.isChecked()) {
        } else if (maikefeng.isChecked()) {
        }

    }


    @OnClick(R.id.yinliang_jian)
    public void yinliang_jian() {
        if (zongyinliang.isChecked()) {
        } else if (yinxiang.isChecked()) {
        } else if (maikefeng.isChecked()) {
            SerialPortUtil.sendMsg("VID1");
        }
    }

    @OnClick(R.id.jingyin)
    public void jingyin() {
        if (zongyinliang.isChecked()) {
        } else if (yinxiang.isChecked()) {
        } else if (maikefeng.isChecked()) {
        }

//        if (jingyin.isChecked()) {
//            jingyin.setChecked(false);
//        } else {
//            jingyin.setChecked(true);
//        }


    }


}
