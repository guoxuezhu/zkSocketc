package com.lh.zksocketc.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.data.DbDao.WgBtnStatusDao;
import com.lh.zksocketc.utils.ELog;
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

    private Handler dgFragmentHander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 369:
                    ELog.e("==========dgFragmentHander===369=====");
                    initBtnView();
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dengguang_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        SerialPortUtil.setDgHander(dgFragmentHander);
        initBtnView();
    }

    @Override
    public void onStop() {
        super.onStop();
        SerialPortUtil.closeDgHander();
    }

    private void initBtnView() {
        WgBtnStatusDao wgBtnStatusDao = MyApplication.getDaoSession().getWgBtnStatusDao();
        if (wgBtnStatusDao.loadAll().size() != 0) {
            if (wgBtnStatusDao.loadAll().get(0).Lstatus1.equals("1")) {
                rbtn_hbd_open.setChecked(true);
            } else {
                rbtn_hbd_close.setChecked(true);
            }
            if (wgBtnStatusDao.loadAll().get(0).Lstatus2.equals("1")) {
                rbtn_jsd_open.setChecked(true);
            } else {
                rbtn_jsd_close.setChecked(true);
            }
            if (wgBtnStatusDao.loadAll().get(0).Lstatus1.equals("1") && wgBtnStatusDao.loadAll().get(0).Lstatus2.equals("1")) {
                rbtn_dg_all_open.setChecked(true);
            } else if (wgBtnStatusDao.loadAll().get(0).Lstatus1.equals("0") && wgBtnStatusDao.loadAll().get(0).Lstatus2.equals("0")) {
                rbtn_dg_all_close.setChecked(true);
            } else {
                radio_group_dg_all.clearCheck();
            }
        }
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
