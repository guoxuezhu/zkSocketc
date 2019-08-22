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



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.huanjing_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }



    @OnClick(R.id.btn_kt_open)
    public void btn_kt_open() {
        SerialPortUtil.sendMsg("MBS39");
    }


    @OnClick(R.id.btn_kt_close)
    public void btn_kt_close() {
        SerialPortUtil.sendMsg("MBS40");
    }

    @OnClick(R.id.btn_kt_zidong)
    public void btn_kt_zidong() {
        SerialPortUtil.sendMsg("MBS41");
    }

    @OnClick(R.id.btn_kt_zhileng)
    public void btn_kt_zhileng() {
        SerialPortUtil.sendMsg("MBS42");
    }


    @OnClick(R.id.btn_kt_zhire)
    public void btn_kt_zhire() {
        SerialPortUtil.sendMsg("MBS43");
    }



//    @OnClick(R.id.btn_mj_pc)
//    public void btn_mj_pc() {
//        SerialPortUtil.sendMsg("MJD46");
//    }


}
