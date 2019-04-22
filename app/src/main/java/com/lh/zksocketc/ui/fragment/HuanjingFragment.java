package com.lh.zksocketc.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.data.DbDao.WsdDataDao;
import com.lh.zksocketc.data.model.WsdData;
import com.lh.zksocketc.utils.ELog;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HuanjingFragment extends Fragment {

    @BindView(R.id.tv_wsd_wd)
    TextView tv_wsd_wd;
    @BindView(R.id.tv_wsd_sd)
    TextView tv_wsd_sd;
    @BindView(R.id.tv_wsd_pm)
    TextView tv_wsd_pm;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.huanjing_fragment, container, false);
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


    @OnClick(R.id.huanjng_btn_kai)
    public void huanjng_btn_kai() {
        SerialPortUtil.sendMsg("MBS39");
    }

    @OnClick(R.id.huanjng_btn_guan)
    public void huanjng_btn_guan() {
        SerialPortUtil.sendMsg("MBS48");
    }

    @OnClick(R.id.huanjng_btn_baifeng)
    public void huanjng_btn_baifeng() {
        SerialPortUtil.sendMsg("MBS49");
    }

    @OnClick(R.id.huanjng_btn_moshi)
    public void huanjng_btn_moshi() {
        SerialPortUtil.sendMsg("MBS40");
    }


    @OnClick(R.id.huanjng_btn_fengsu)
    public void huanjng_btn_fengsu() {
        SerialPortUtil.sendMsg("MBS41");
    }


    @OnClick(R.id.huanjng_btn_wd_jia)
    public void huanjng_btn_wd_jia() {
        SerialPortUtil.sendMsg("MBS43");
    }


    @OnClick(R.id.huanjng_btn_wd_jian)
    public void huanjng_btn_wd_jian() {
        SerialPortUtil.sendMsg("MBS44");
    }


    @OnClick(R.id.huanjng_btn_fengxiang)
    public void huanjng_btn_fengxiang() {
        SerialPortUtil.sendMsg("MBS42");
    }

}
