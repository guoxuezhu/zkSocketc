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

public class ShebeiFragment extends Fragment {

    @BindView(R.id.rbtn_cl_all_open)
    RadioButton rbtn_cl_all_open;
    @BindView(R.id.rbtn_cl_all_close)
    RadioButton rbtn_cl_all_close;
    @BindView(R.id.rbtn_cl_all_stop)
    RadioButton rbtn_cl_all_stop;

    @BindView(R.id.rbtn_cl1_open)
    RadioButton rbtn_cl1_open;
    @BindView(R.id.rbtn_cl1_close)
    RadioButton rbtn_cl1_close;
    @BindView(R.id.rbtn_cl1_stop)
    RadioButton rbtn_cl1_stop;

    @BindView(R.id.rbtn_cl2_open)
    RadioButton rbtn_cl2_open;
    @BindView(R.id.rbtn_cl2_close)
    RadioButton rbtn_cl2_close;
    @BindView(R.id.rbtn_cl2_stop)
    RadioButton rbtn_cl2_stop;

    @BindView(R.id.radio_group_cl_all)
    RadioGroup radio_group_cl_all;

    private Handler clFragmentHander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 563:
                    ELog.e("==========dgFragmentHander===563=====");
//                    initBtnView();
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shebei_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
//        SerialPortUtil.setCLHander(clFragmentHander);
//        initBtnView();
    }

    @Override
    public void onStop() {
        super.onStop();
//        SerialPortUtil.closeCLHander();
    }

    private void initBtnView() {
        WgBtnStatusDao wgBtnStatusDao = MyApplication.getDaoSession().getWgBtnStatusDao();
        if (wgBtnStatusDao.loadAll().size() != 0) {
            if (wgBtnStatusDao.loadAll().get(0).Mstatus1.equals("1")) {
                rbtn_cl1_open.setChecked(true);
            } else {
                rbtn_cl1_close.setChecked(true);
            }
            if (wgBtnStatusDao.loadAll().get(0).Mstatus2.equals("1")) {
                rbtn_cl2_open.setChecked(true);
            } else {
                rbtn_cl2_close.setChecked(true);
            }
            if (wgBtnStatusDao.loadAll().get(0).Mstatus1.equals("1") && wgBtnStatusDao.loadAll().get(0).Mstatus2.equals("1")) {
                rbtn_cl_all_open.setChecked(true);
            } else if (wgBtnStatusDao.loadAll().get(0).Mstatus1.equals("0") && wgBtnStatusDao.loadAll().get(0).Mstatus2.equals("0")) {
                rbtn_cl_all_close.setChecked(true);
            } else {
                radio_group_cl_all.clearCheck();
            }
        }
    }

    @OnClick(R.id.rbtn_cl_all_open)
    public void rbtn_cl_all_open() {
        SerialPortUtil.sendMsg("MBS3");
        rbtn_cl1_open.setChecked(true);
        rbtn_cl2_open.setChecked(true);
    }

    @OnClick(R.id.rbtn_cl_all_close)
    public void rbtn_cl_all_close() {
        SerialPortUtil.sendMsg("MBS4");
        rbtn_cl1_close.setChecked(true);
        rbtn_cl2_close.setChecked(true);
    }

    @OnClick(R.id.rbtn_cl_all_stop)
    public void rbtn_cl_all_stop() {
        SerialPortUtil.sendMsg("HWG1001");
        rbtn_cl1_stop.setChecked(true);
        rbtn_cl2_stop.setChecked(true);
    }


    @OnClick(R.id.rbtn_cl1_open)
    public void rbtn_cl1_open() {
        SerialPortUtil.sendMsg("MBS5");
        radio_group_cl_all.clearCheck();
        if (rbtn_cl2_open.isChecked()) {
            rbtn_cl_all_open.setChecked(true);
        }
    }

    @OnClick(R.id.rbtn_cl1_close)
    public void rbtn_cl1_close() {
        SerialPortUtil.sendMsg("MBS6");
        radio_group_cl_all.clearCheck();
        if (rbtn_cl2_close.isChecked()) {
            rbtn_cl_all_close.setChecked(true);
        }
    }

    @OnClick(R.id.rbtn_cl1_stop)
    public void rbtn_cl1_stop() {
        SerialPortUtil.sendMsg("HWG1002");
        radio_group_cl_all.clearCheck();
        if (rbtn_cl2_stop.isChecked()) {
            rbtn_cl_all_stop.setChecked(true);
        }
    }


    @OnClick(R.id.rbtn_cl2_open)
    public void rbtn_cl2_open() {
        SerialPortUtil.sendMsg("MBS7");
        radio_group_cl_all.clearCheck();
        if (rbtn_cl1_open.isChecked()) {
            rbtn_cl_all_open.setChecked(true);
        }
    }

    @OnClick(R.id.rbtn_cl2_close)
    public void rbtn_cl2_close() {
        SerialPortUtil.sendMsg("MBS8");
        radio_group_cl_all.clearCheck();
        if (rbtn_cl1_close.isChecked()) {
            rbtn_cl_all_close.setChecked(true);
        }
    }

    @OnClick(R.id.rbtn_cl2_stop)
    public void rbtn_cl2_stop() {
        SerialPortUtil.sendMsg("HWG1003");
        radio_group_cl_all.clearCheck();
        if (rbtn_cl1_stop.isChecked()) {
            rbtn_cl_all_stop.setChecked(true);
        }
    }

}
