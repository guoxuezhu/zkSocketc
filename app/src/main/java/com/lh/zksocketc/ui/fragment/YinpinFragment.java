package com.lh.zksocketc.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.ELog;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YinpinFragment extends Fragment {

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
//        jingyin.setChecked(true);
        seek_bar_yl.setProgress(MyApplication.prefs.getYinliang());
        seek_bar_yl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                ELog.i("===========SeekBar=====onStopTrackingTouch=======" + seekBar.getProgress());
                SerialPortUtil.sendMsg("MBS" + (21 + seekBar.getProgress()));
                jingyin.setChecked(false);
                MyApplication.prefs.setYinliang(seekBar.getProgress());
            }
        });
    }

    @OnClick(R.id.jingyin)
    public void jingyin() {
        if (jingyin.isChecked()) {
//            seek_bar_yl.setProgress(0);
            SerialPortUtil.sendMsg("MBS31");
        } else {
            SerialPortUtil.sendMsg("MBS" + (21 + MyApplication.prefs.getYinliang()));
//            seek_bar_yl.setProgress(2);
        }
    }

}
