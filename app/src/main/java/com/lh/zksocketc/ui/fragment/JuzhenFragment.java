package com.lh.zksocketc.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.Nullable;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JuzhenFragment extends Fragment {



    @BindView(R.id.spbtn_dan_in_lubo)
    CheckBox spbtn_dan_in_lubo;
    @BindView(R.id.spbtn_dan_in_diannao)
    CheckBox spbtn_dan_in_diannao;
    @BindView(R.id.spbtn_dan_in_touping)
    CheckBox spbtn_dan_in_touping;
    @BindView(R.id.spbtn_dan_in_zu_1)
    CheckBox spbtn_dan_in_zu_1;
    @BindView(R.id.spbtn_dan_in_zu_2)
    CheckBox spbtn_dan_in_zu_2;
    @BindView(R.id.spbtn_dan_in_zu_3)
    CheckBox spbtn_dan_in_zu_3;
    @BindView(R.id.spbtn_dan_in_zu_4)
    CheckBox spbtn_dan_in_zu_4;
    @BindView(R.id.spbtn_dan_in_zu_5)
    CheckBox spbtn_dan_in_zu_5;
    @BindView(R.id.spbtn_dan_in_zu_6)
    CheckBox spbtn_dan_in_zu_6;


    @BindView(R.id.spbtn_dan_out_lubo)
    CheckBox spbtn_dan_out_lubo;
    @BindView(R.id.spbtn_dan_out_diannao)
    CheckBox spbtn_dan_out_diannao;
    @BindView(R.id.spbtn_dan_out_touping)
    CheckBox spbtn_dan_out_touping;
    @BindView(R.id.spbtn_dan_out_zu_1)
    CheckBox spbtn_dan_out_zu_1;
    @BindView(R.id.spbtn_dan_out_zu_2)
    CheckBox spbtn_dan_out_zu_2;
    @BindView(R.id.spbtn_dan_out_zu_3)
    CheckBox spbtn_dan_out_zu_3;
    @BindView(R.id.spbtn_dan_out_zu_4)
    CheckBox spbtn_dan_out_zu_4;
    @BindView(R.id.spbtn_dan_out_zu_5)
    CheckBox spbtn_dan_out_zu_5;
    @BindView(R.id.spbtn_dan_out_zu_6)
    CheckBox spbtn_dan_out_zu_6;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.juzhen_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }



    @OnClick(R.id.spbtn_dan_in_lubo)
    public void spbtn_dan_in_lubo() {
        spbtn_dan_in_lubo.setChecked(true);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }

    @OnClick(R.id.spbtn_dan_in_diannao)
    public void spbtn_dan_in_diannao() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(true);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }


    @OnClick(R.id.spbtn_dan_in_touping)
    public void spbtn_dan_in_touping() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(true);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }

    @OnClick(R.id.spbtn_dan_in_zu_1)
    public void spbtn_dan_in_zu_1() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(true);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }


    @OnClick(R.id.spbtn_dan_in_zu_2)
    public void spbtn_dan_in_zu_2() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(true);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }

    @OnClick(R.id.spbtn_dan_in_zu_3)
    public void spbtn_dan_in_zu_3() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(true);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }


    @OnClick(R.id.spbtn_dan_in_zu_4)
    public void spbtn_dan_in_zu_4() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(true);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }


    @OnClick(R.id.spbtn_dan_in_zu_5)
    public void spbtn_dan_in_zu_5() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(true);
        spbtn_dan_in_zu_6.setChecked(false);
        outBtnClosed();
    }


    @OnClick(R.id.spbtn_dan_in_zu_6)
    public void spbtn_dan_in_zu_6() {
        spbtn_dan_in_lubo.setChecked(false);
        spbtn_dan_in_diannao.setChecked(false);
        spbtn_dan_in_touping.setChecked(false);
        spbtn_dan_in_zu_1.setChecked(false);
        spbtn_dan_in_zu_2.setChecked(false);
        spbtn_dan_in_zu_3.setChecked(false);
        spbtn_dan_in_zu_4.setChecked(false);
        spbtn_dan_in_zu_5.setChecked(false);
        spbtn_dan_in_zu_6.setChecked(true);
        outBtnClosed();

    }

    private void outBtnClosed() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
    }


    @OnClick(R.id.spbtn_dan_out_lubo)
    public void spbtn_dan_out_lubo() {
        spbtn_dan_out_lubo.setChecked(true);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(0);


    }

    @OnClick(R.id.spbtn_dan_out_diannao)
    public void spbtn_dan_out_diannao() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(true);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(1);
    }


    @OnClick(R.id.spbtn_dan_out_touping)
    public void spbtn_dan_out_touping() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(true);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(2);
    }

    @OnClick(R.id.spbtn_dan_out_zu_1)
    public void spbtn_dan_out_zu_1() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(true);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(3);
    }


    @OnClick(R.id.spbtn_dan_out_zu_2)
    public void spbtn_dan_out_zu_2() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(true);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(4);
    }

    @OnClick(R.id.spbtn_dan_out_zu_3)
    public void spbtn_dan_out_zu_3() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(true);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(5);
    }


    @OnClick(R.id.spbtn_dan_out_zu_4)
    public void spbtn_dan_out_zu_4() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(true);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(6);
    }


    @OnClick(R.id.spbtn_dan_out_zu_5)
    public void spbtn_dan_out_zu_5() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(true);
        spbtn_dan_out_zu_6.setChecked(false);
        sendDan(7);
    }


    @OnClick(R.id.spbtn_dan_out_zu_6)
    public void spbtn_dan_out_zu_6() {
        spbtn_dan_out_lubo.setChecked(false);
        spbtn_dan_out_diannao.setChecked(false);
        spbtn_dan_out_touping.setChecked(false);
        spbtn_dan_out_zu_1.setChecked(false);
        spbtn_dan_out_zu_2.setChecked(false);
        spbtn_dan_out_zu_3.setChecked(false);
        spbtn_dan_out_zu_4.setChecked(false);
        spbtn_dan_out_zu_5.setChecked(false);
        spbtn_dan_out_zu_6.setChecked(true);

        sendDan(8);
    }

    private void sendDan(int i) {
        if (spbtn_dan_in_lubo.isChecked()) {
            SerialPortUtil.sendMsg("VIDA7," + i);
        } else if (spbtn_dan_in_diannao.isChecked()) {
            SerialPortUtil.sendMsg("VIDA8," + i);
        } else if (spbtn_dan_in_touping.isChecked()) {
            SerialPortUtil.sendMsg("VIDA0," + i);
        } else if (spbtn_dan_in_zu_1.isChecked()) {
            SerialPortUtil.sendMsg("VIDA1," + i);
        } else if (spbtn_dan_in_zu_2.isChecked()) {
            SerialPortUtil.sendMsg("VIDA2," + i);
        } else if (spbtn_dan_in_zu_3.isChecked()) {
            SerialPortUtil.sendMsg("VIDA3," + i);
        } else if (spbtn_dan_in_zu_4.isChecked()) {
            SerialPortUtil.sendMsg("VIDA4," + i);
        } else if (spbtn_dan_in_zu_5.isChecked()) {
            SerialPortUtil.sendMsg("VIDA5," + i);
        } else if (spbtn_dan_in_zu_6.isChecked()) {
            SerialPortUtil.sendMsg("VIDA6," + i);
        }
    }


}
