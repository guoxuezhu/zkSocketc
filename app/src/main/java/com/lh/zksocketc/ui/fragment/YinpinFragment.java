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

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.data.DbDao.MicDatasDao;
import com.lh.zksocketc.data.model.MicDatas;
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

    private MicDatasDao micDatasDao;

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
        micDatasDao = MyApplication.getDaoSession().getMicDatasDao();
        if (micDatasDao.loadAll().size() == 0) {
            micDatasDao.insert(new MicDatas("22", 1, "22", 1, "22", 1));
        }
        MicDatas smicdata = micDatasDao.loadAll().get(0);
        if (smicdata.mic_a_status == 1) {
            jingyin.setChecked(false);
            seek_bar_yl.setProgress(22 - Integer.valueOf(smicdata.mic_a));
        } else {
            jingyin.setChecked(true);
            seek_bar_yl.setProgress(0);
        }
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
                int yl = 22 - seekBar.getProgress();
                String ylstr;
                if (yl < 10) {
                    ylstr = "0" + yl;
                } else {
                    ylstr = "" + yl;
                }
                if (zongyinliang.isChecked()) {
                    SerialPortUtil.sendMsg("MICA" + ylstr);
                    smicdata.setMic_a(ylstr);
                } else if (yinxiang.isChecked()) {
                    SerialPortUtil.sendMsg("MICB" + ylstr);
                    smicdata.setMic_b(ylstr);
                } else if (maikefeng.isChecked()) {
                    SerialPortUtil.sendMsg("MICC" + ylstr);
                    smicdata.setMic_c(ylstr);
                }
                micDatasDao.deleteAll();
                micDatasDao.insert(smicdata);
                ELog.i("=======yinpin=======" + micDatasDao.loadAll().toString());
            }
        });
    }

    @OnClick(R.id.zongyinliang)
    public void zongyinliang() {
        MicDatas micdata = micDatasDao.loadAll().get(0);
        if (micdata.mic_a_status == 1) {
            jingyin.setChecked(false);
            seek_bar_yl.setProgress(22 - Integer.valueOf(micdata.mic_a));
        } else {
            jingyin.setChecked(true);
            seek_bar_yl.setProgress(0);
        }
    }

    @OnClick(R.id.yinxiang)
    public void yinxiang() {
        MicDatas micdata = micDatasDao.loadAll().get(0);
        if (micdata.mic_b_status == 1) {
            jingyin.setChecked(false);
            seek_bar_yl.setProgress(22 - Integer.valueOf(micdata.mic_b));
        } else {
            jingyin.setChecked(true);
            seek_bar_yl.setProgress(0);
        }
    }

    @OnClick(R.id.maikefeng)
    public void maikefeng() {
        MicDatas micdata = micDatasDao.loadAll().get(0);
        if (micdata.mic_c_status == 1) {
            jingyin.setChecked(false);
            seek_bar_yl.setProgress(22 - Integer.valueOf(micdata.mic_c));
        } else {
            jingyin.setChecked(true);
            seek_bar_yl.setProgress(0);
        }
    }


    @OnClick(R.id.jingyin)
    public void jingyin() {
        MicDatas micdata = micDatasDao.loadAll().get(0);
        if (jingyin.isChecked()) {
            seek_bar_yl.setProgress(0);
            if (zongyinliang.isChecked()) {
                SerialPortUtil.sendMsg("MICAJY");
                micdata.setMic_a_status(0);
            } else if (yinxiang.isChecked()) {
                SerialPortUtil.sendMsg("MICBJY");
                micdata.setMic_b_status(0);
            } else if (maikefeng.isChecked()) {
                SerialPortUtil.sendMsg("MICCJY");
                micdata.setMic_c_status(0);
            }
        } else {
            if (zongyinliang.isChecked()) {
                SerialPortUtil.sendMsg("MICA" + micdata.mic_a);
                seek_bar_yl.setProgress(22 - Integer.valueOf(micdata.mic_a));
                micdata.setMic_a_status(1);
            } else if (yinxiang.isChecked()) {
                SerialPortUtil.sendMsg("MICB" + micdata.mic_b);
                seek_bar_yl.setProgress(22 - Integer.valueOf(micdata.mic_b));
                micdata.setMic_b_status(1);
            } else if (maikefeng.isChecked()) {
                SerialPortUtil.sendMsg("MICC" + micdata.mic_c);
                seek_bar_yl.setProgress(22 - Integer.valueOf(micdata.mic_c));
                micdata.setMic_c_status(1);
            }
        }
        micDatasDao.deleteAll();
        micDatasDao.insert(micdata);
        ELog.i("=======111===jingyin====" + micDatasDao.loadAll().toString());
    }

}
