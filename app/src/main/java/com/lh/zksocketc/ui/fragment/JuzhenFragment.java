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



    @BindView(R.id.spbtn_dan_in_gaopaiyi)
    CheckBox spbtn_dan_in_gaopaiyi;
    @BindView(R.id.spbtn_dan_in_diannao)
    CheckBox spbtn_dan_in_diannao;
    @BindView(R.id.spbtn_dan_in_bjb_1)
    CheckBox spbtn_dan_in_bjb_1;
    @BindView(R.id.spbtn_dan_in_bjb_2)
    CheckBox spbtn_dan_in_bjb_2;


    @BindView(R.id.spbtn_dan_out_touying)
    CheckBox spbtn_dan_out_touying;
    @BindView(R.id.spbtn_dan_out_dp_1)
    CheckBox spbtn_dan_out_dp_1;
    @BindView(R.id.spbtn_dan_out_dp_2)
    CheckBox spbtn_dan_out_dp_2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.juzhen_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }



    @OnClick(R.id.spbtn_dan_in_gaopaiyi)
    public void spbtn_dan_in_gaopaiyi() {
        spbtn_dan_in_gaopaiyi.setChecked(true);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_bjb_1.setChecked(false);
        spbtn_dan_in_bjb_2.setChecked(false);
        outBtnClosed();
    }

    @OnClick(R.id.spbtn_dan_in_diannao)
    public void spbtn_dan_in_diannao() {
        spbtn_dan_in_gaopaiyi.setChecked(false);
        spbtn_dan_in_diannao.setChecked(true);
        spbtn_dan_in_bjb_1.setChecked(false);
        spbtn_dan_in_bjb_2.setChecked(false);
        outBtnClosed();
    }


    @OnClick(R.id.spbtn_dan_in_bjb_1)
    public void spbtn_dan_in_bjb_1() {
        spbtn_dan_in_gaopaiyi.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_bjb_1.setChecked(true);
        spbtn_dan_in_bjb_2.setChecked(false);
        outBtnClosed();
    }

    @OnClick(R.id.spbtn_dan_in_bjb_2)
    public void spbtn_dan_in_bjb_2() {
        spbtn_dan_in_gaopaiyi.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_bjb_1.setChecked(false);
        spbtn_dan_in_bjb_2.setChecked(true);
        outBtnClosed();
    }


    private void outBtnClosed() {
        spbtn_dan_out_touying.setChecked(false);
        spbtn_dan_out_dp_1.setChecked(false);
        spbtn_dan_out_dp_2.setChecked(false);
    }


    @OnClick(R.id.spbtn_dan_out_touying)
    public void spbtn_dan_out_touying() {
        spbtn_dan_out_touying.setChecked(true);
        spbtn_dan_out_dp_1.setChecked(false);
        spbtn_dan_out_dp_2.setChecked(false);
        sendDan(2);


    }

    @OnClick(R.id.spbtn_dan_out_dp_1)
    public void spbtn_dan_out_dp_1() {
        spbtn_dan_out_touying.setChecked(false);
        spbtn_dan_out_dp_1.setChecked(true);
        spbtn_dan_out_dp_2.setChecked(false);
        sendDan(3);
    }


    @OnClick(R.id.spbtn_dan_out_dp_2)
    public void spbtn_dan_out_dp_2() {
        spbtn_dan_out_touying.setChecked(false);
        spbtn_dan_out_dp_1.setChecked(false);
        spbtn_dan_out_dp_2.setChecked(true);
        sendDan(4);
    }

    private void sendDan(int i) {
        if (spbtn_dan_in_gaopaiyi.isChecked()) {
            SerialPortUtil.sendMsg("VIDA1," + i);
        } else if (spbtn_dan_in_diannao.isChecked()) {
            SerialPortUtil.sendMsg("VIDA2," + i);
        } else if (spbtn_dan_in_bjb_1.isChecked()) {
            SerialPortUtil.sendMsg("VIDA4," + i);
        } else if (spbtn_dan_in_bjb_2.isChecked()) {
            SerialPortUtil.sendMsg("VIDA3," + i);
        }
    }


}
