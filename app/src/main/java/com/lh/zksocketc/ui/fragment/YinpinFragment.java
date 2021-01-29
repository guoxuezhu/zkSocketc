package com.lh.zksocketc.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.ELog;
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
    @BindView(R.id.seek_bar_yl)
    SeekBar seek_bar_yl;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.yinpin_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        showypView();
    }

    private void showypView() {
        zongyinliang.setChecked(true);
        seek_bar_yl.setProgress(1);
        seek_bar_yl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                ELog.e("===========SeekBar=====onStopTrackingTouch=======" + seekBar.getProgress());
                int ylstr = 22 - seekBar.getProgress();
                if (zongyinliang.isChecked()) {
                    SerialPortUtil.sendMsg("MICA" + ylstr);
                } else if (yinxiang.isChecked()) {
                    SerialPortUtil.sendMsg("MICB" + ylstr);
                } else if (maikefeng.isChecked()) {
                    SerialPortUtil.sendMsg("MICC" + ylstr);
                }
            }
        });
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


    @OnClick(R.id.jingyin)
    public void jingyin() {
        if (jingyin.isChecked()) {
            seek_bar_yl.setProgress(0);
            if (zongyinliang.isChecked()) {
                SerialPortUtil.sendMsg("MICAJY");
            } else if (yinxiang.isChecked()) {
                SerialPortUtil.sendMsg("MICBJY");
            } else if (maikefeng.isChecked()) {
                SerialPortUtil.sendMsg("MICCJY");
            }
        } else {
            seek_bar_yl.setProgress(1);
            if (zongyinliang.isChecked()) {
                SerialPortUtil.sendMsg("MICA01");
            } else if (yinxiang.isChecked()) {
                SerialPortUtil.sendMsg("MICB01");
            } else if (maikefeng.isChecked()) {
                SerialPortUtil.sendMsg("MICC01");
            }
        }
    }

}
