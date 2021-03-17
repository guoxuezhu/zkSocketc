package com.lh.zksocketc.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JuzhenFragment extends Fragment {

    @BindView(R.id.radio_group_out)
    RadioGroup radio_group_out;

    @BindView(R.id.spbtn_dan_in_lsdn)
    RadioButton spbtn_dan_in_lsdn;
    @BindView(R.id.spbtn_dan_in_tsj)
    RadioButton spbtn_dan_in_tsj;
    @BindView(R.id.spbtn_dan_in_bjb)
    RadioButton spbtn_dan_in_bjb;
    @BindView(R.id.spbtn_dan_in_gpy)
    RadioButton spbtn_dan_in_gpy;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.juzhen_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.spbtn_all_lsdn)
    public void spbtn_all_lsdn() {
        SerialPortUtil.sendMsg("VIDC1");
    }

    @OnClick(R.id.spbtn_all_tsj)
    public void spbtn_all_tsj() {
        SerialPortUtil.sendMsg("VIDC2");
    }

    @OnClick(R.id.spbtn_all_bjb)
    public void spbtn_all_bjb() {
        SerialPortUtil.sendMsg("VIDC3");
    }

    @OnClick(R.id.spbtn_all_gpy)
    public void spbtn_all_gpy() {
        SerialPortUtil.sendMsg("VIDC4");
    }


    @OnClick(R.id.spbtn_dan_in_lsdn)
    public void spbtn_dan_in_lsdn() {
        outBtnClosed();
    }

    @OnClick(R.id.spbtn_dan_in_tsj)
    public void spbtn_dan_in_tsj() {
        outBtnClosed();
    }

    @OnClick(R.id.spbtn_dan_in_bjb)
    public void spbtn_dan_in_bjb() {
        outBtnClosed();
    }

    @OnClick(R.id.spbtn_dan_in_gpy)
    public void spbtn_dan_in_gpy() {
        outBtnClosed();
    }


    private void outBtnClosed() {
        radio_group_out.clearCheck();
    }

    @OnClick(R.id.spbtn_dan_out_ty)
    public void spbtn_dan_out_ty() {
        sendDan(1);
    }

    @OnClick(R.id.spbtn_dan_out_ping1)
    public void spbtn_dan_out_ping1() {
        sendDan(2);
    }

    @OnClick(R.id.spbtn_dan_out_ping2)
    public void spbtn_dan_out_ping2() {
        sendDan(3);
    }

    private void sendDan(int i) {
        if (spbtn_dan_in_lsdn.isChecked()) {
            SerialPortUtil.sendMsg("VIDA1," + i);
        } else if (spbtn_dan_in_tsj.isChecked()) {
            SerialPortUtil.sendMsg("VIDA2," + i);
        } else if (spbtn_dan_in_bjb.isChecked()) {
            SerialPortUtil.sendMsg("VIDA3," + i);
        } else if (spbtn_dan_in_gpy.isChecked()) {
            SerialPortUtil.sendMsg("VIDA4," + i);
        }
    }

}
