package com.lh.zksocketc.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShebeiFragment extends Fragment {

//    @BindView(R.id.rbtn_cl_1_open)
//    RadioButton rbtn_cl_1_open;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shebei_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


//    @OnClick(R.id.rbtn_cl_1_open)
//    public void rbtn_cl_1_open() {
//        SerialPortUtil.sendMsg("MBS5");
//    }
//
//
//    @OnClick(R.id.rbtn_cl_1_close)
//    public void rbtn_cl_1_close() {
//        SerialPortUtil.sendMsg("MBS6");
//    }
//
//
//    @OnClick(R.id.rbtn_cl_2_open)
//    public void rbtn_cl_2_open() {
//        SerialPortUtil.sendMsg("MBS7");
//    }
//
//    @OnClick(R.id.rbtn_cl_2_close)
//    public void rbtn_cl_2_close() {
//        SerialPortUtil.sendMsg("MBS8");
//
//    }
//
//
//    @OnClick(R.id.rbtn_tyj_open)
//    public void rbtn_tyj_open() {
//        SerialPortUtil.sendMsg("MBS9");
//
//    }
//
//    @OnClick(R.id.rbtn_tyj_close)
//    public void rbtn_tyj_close() {
//        SerialPortUtil.sendMsg("MBS10");
//
//    }
//
//
//    @OnClick(R.id.rbtn_tyj_bu_open)
//    public void rbtn_tyj_bu_open() {
//        SerialPortUtil.sendMsg("MBS11");
//    }
//
//    @OnClick(R.id.rbtn_tyj_bu_close)
//    public void rbtn_tyj_bu_close() {
//        SerialPortUtil.sendMsg("MBS12");
//    }
//
//
//    @OnClick(R.id.rbtn_dg_1_open)
//    public void rbtn_dg_1_open() {
//        SerialPortUtil.sendMsg("MBS13");
//    }
//
//    @OnClick(R.id.rbtn_dg_1_close)
//    public void rbtn_dg_1_close() {
//        SerialPortUtil.sendMsg("MBS14");
//    }
//
//    @OnClick(R.id.rbtn_dg_2_open)
//    public void rbtn_dg_2_open() {
//        SerialPortUtil.sendMsg("MBS15");
//    }
//
//    @OnClick(R.id.rbtn_dg_2_close)
//    public void rbtn_dg_2_close() {
//        SerialPortUtil.sendMsg("MBS16");
//    }
//
//
//    @OnClick(R.id.rbtn_dg_3_open)
//    public void rbtn_dg_3_open() {
//        SerialPortUtil.sendMsg("MBS17");
//
//    }
//
//    @OnClick(R.id.rbtn_dg_3_close)
//    public void rbtn_dg_3_close() {
//        SerialPortUtil.sendMsg("MBS18");
//    }
//
//
//    @OnClick(R.id.rbtn_dg_4_open)
//    public void rbtn_dg_4_open() {
//        SerialPortUtil.sendMsg("MBS19");
//    }
//
//    @OnClick(R.id.rbtn_dg_4_close)
//    public void rbtn_dg_4_close() {
//        SerialPortUtil.sendMsg("MBS20");
//    }
//
//
//
//    @OnClick(R.id.rbtn_mj_1_open)
//    public void rbtn_mj_1_open() {
//        SerialPortUtil.sendMsg("MBS46");
//    }
//
//    @OnClick(R.id.rbtn_mj_1_close)
//    public void rbtn_mj_1_close() {
//        SerialPortUtil.sendMsg("MBS47");
//    }
}
