package com.lh.zksocketc.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DengguangFragment extends Fragment {

    @BindView(R.id.rbtn_dg_all_open)
    RadioButton rbtn_dg_all_open;
    @BindView(R.id.rbtn_dg_all_close)
    RadioButton rbtn_dg_all_close;

    @BindView(R.id.rbtn_hbd_open)
    RadioButton rbtn_hbd_open;
    @BindView(R.id.rbtn_hbd_close)
    RadioButton rbtn_hbd_close;

    @BindView(R.id.rbtn_jsd_open)
    RadioButton rbtn_jsd_open;
    @BindView(R.id.rbtn_jsd_close)
    RadioButton rbtn_jsd_close;

    @BindView(R.id.radio_group_dg_all)
    RadioGroup radio_group_dg_all;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dengguang_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.rbtn_dg_all_open)
    public void rbtn_dg_all_open() {
        SerialPortUtil.sendMsg("MBS13");
        rbtn_hbd_open.setChecked(true);
        rbtn_jsd_open.setChecked(true);
    }

    @OnClick(R.id.rbtn_dg_all_close)
    public void rbtn_dg_all_close() {
        SerialPortUtil.sendMsg("MBS14");
        rbtn_hbd_close.setChecked(true);
        rbtn_jsd_close.setChecked(true);
    }

    @OnClick(R.id.rbtn_hbd_open)
    public void rbtn_hbd_open() {
        SerialPortUtil.sendMsg("MBS62");
        radio_group_dg_all.clearCheck();
        if (rbtn_jsd_open.isChecked()) {
            rbtn_dg_all_open.setChecked(true);
        }
    }

    @OnClick(R.id.rbtn_hbd_close)
    public void rbtn_hbd_close() {
        SerialPortUtil.sendMsg("MBS63");
        radio_group_dg_all.clearCheck();
        if (rbtn_jsd_close.isChecked()) {
            rbtn_dg_all_close.setChecked(true);
        }
    }

    @OnClick(R.id.rbtn_jsd_open)
    public void rbtn_jsd_open() {
        SerialPortUtil.sendMsg("MBS64");
        radio_group_dg_all.clearCheck();
        if (rbtn_hbd_open.isChecked()) {
            rbtn_dg_all_open.setChecked(true);
        }
    }

    @OnClick(R.id.rbtn_jsd_close)
    public void rbtn_jsd_close() {
        SerialPortUtil.sendMsg("MBS65");
        radio_group_dg_all.clearCheck();
        if (rbtn_hbd_close.isChecked()) {
            rbtn_dg_all_close.setChecked(true);
        }
    }

}
