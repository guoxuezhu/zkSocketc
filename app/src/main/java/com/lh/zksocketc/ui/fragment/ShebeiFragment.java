package com.lh.zksocketc.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.data.DbDao.WsdDataDao;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShebeiFragment extends Fragment {

    @BindView(R.id.tv_wsd_wd)
    TextView tv_wsd_wd;
    @BindView(R.id.tv_wsd_sd)
    TextView tv_wsd_sd;
    @BindView(R.id.tv_wsd_pm)
    TextView tv_wsd_pm;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shebei_fragment, container, false);
        ButterKnife.bind(this, view);
        showView();
        return view;
    }

    private void showView() {
        WsdDataDao wsdDataDao = MyApplication.getDaoSession().getWsdDataDao();
        if (wsdDataDao.loadAll().size() == 0) {
            tv_wsd_wd.setText("");
            tv_wsd_sd.setText("");
            tv_wsd_pm.setText("");
        } else {
            tv_wsd_wd.setText(wsdDataDao.loadAll().get(0).wendu);
            tv_wsd_sd.setText(wsdDataDao.loadAll().get(0).shidu);
            tv_wsd_pm.setText(wsdDataDao.loadAll().get(0).pm25);
        }

    }


    @OnClick(R.id.rbtn_cl_open)
    public void rbtn_cl_open() {
        SerialPortUtil.sendMsg("MBS3");
    }


    @OnClick(R.id.rbtn_cl_close)
    public void rbtn_cl_close() {
        SerialPortUtil.sendMsg("MBS4");
    }


    @OnClick(R.id.rbtn_dg_open)
    public void rbtn_dg_open() {
        SerialPortUtil.sendMsg("MBS13");
    }

    @OnClick(R.id.rbtn_dg_close)
    public void rbtn_dg_close() {
        SerialPortUtil.sendMsg("MBS14");

    }


    @OnClick(R.id.rbtn_tyj_open)
    public void rbtn_tyj_open() {
        SerialPortUtil.sendMsg("MBS15");

    }

    @OnClick(R.id.rbtn_tyj_close)
    public void rbtn_tyj_close() {
        SerialPortUtil.sendMsg("MBS16");

    }


    @OnClick(R.id.rbtn_tyj_bu_open)
    public void rbtn_tyj_bu_open() {
        SerialPortUtil.sendMsg("MBS66");
    }

    @OnClick(R.id.rbtn_tyj_bu_close)
    public void rbtn_tyj_bu_close() {
        SerialPortUtil.sendMsg("MBS67");
    }


    @OnClick(R.id.btn_kt_open)
    public void btn_kt_open() {
        SerialPortUtil.sendMsg("MBS39");
    }


    @OnClick(R.id.btn_kt_close)
    public void btn_kt_close() {
        SerialPortUtil.sendMsg("MBS40");
    }

    @OnClick(R.id.btn_kt_leng)
    public void btn_kt_leng() {
        SerialPortUtil.sendMsg("MBS42");
    }


    @OnClick(R.id.btn_kt_re)
    public void btn_kt_re() {
        SerialPortUtil.sendMsg("MBS43");
    }

//
//    @OnClick(R.id.btn_kt_zidong)
//    public void btn_kt_zidong() {
//        SerialPortUtil.sendMsg("MBS41");
//    }
//
//    @OnClick(R.id.btn_mj_pc)
//    public void btn_mj_pc() {
//        SerialPortUtil.sendMsg("MJD46");
//    }


}
