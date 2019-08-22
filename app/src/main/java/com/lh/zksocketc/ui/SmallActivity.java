package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.ELog;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SmallActivity extends BaseActivity {

    Handler smHander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 567:
                    ELog.e("======smHander====SmallActivity====567=========" + msg.obj.toString());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.rbtn_shangke)
    public void rbtn_shangke() {
        SerialPortUtil.sendMsg("MBS1");
    }


    @OnClick(R.id.rbtn_xiake)
    public void rbtn_xiake() {
        SerialPortUtil.stopWSDmsg(smHander);
        SerialPortUtil.sendMsg("MBS2");
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }

    @OnClick(R.id.rbtn_cl_open)
    public void rbtn_cl_open() {
        SerialPortUtil.sendMsg("MBS5");
    }


    @OnClick(R.id.rbtn_cl_close)
    public void rbtn_cl_close() {
        SerialPortUtil.sendMsg("MBS6");
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
        SerialPortUtil.sendMsg("MBS9");

    }

    @OnClick(R.id.rbtn_tyj_close)
    public void rbtn_tyj_close() {
        SerialPortUtil.sendMsg("MBS10");

    }


    @OnClick(R.id.rbtn_tyj_bu_open)
    public void rbtn_tyj_bu_open() {
        SerialPortUtil.sendMsg("MBS11");
    }

    @OnClick(R.id.rbtn_tyj_bu_close)
    public void rbtn_tyj_bu_close() {
        SerialPortUtil.sendMsg("MBS12");
    }


    @OnClick(R.id.btn_kt_open)
    public void btn_kt_open() {
        SerialPortUtil.sendMsg("MBS39");
    }

    @OnClick(R.id.btn_kt_close)
    public void btn_kt_close() {
        SerialPortUtil.sendMsg("MBS48");
    }

    @OnClick(R.id.btn_xf_open)
    public void btn_xf_open() {
        SerialPortUtil.sendMsg("MBS58");
    }

    @OnClick(R.id.btn_xf_close)
    public void btn_xf_close() {
        SerialPortUtil.sendMsg("MBS59");
    }

//    @OnClick(R.id.btn_kt_wd_y)
//    public void btn_kt_wd_y() {
//        SerialPortUtil.sendMsg("MBS43");
//    }
//
//    @OnClick(R.id.btn_kt_wd_n)
//    public void btn_kt_wd_n() {
//        SerialPortUtil.sendMsg("MBS44");
//    }

    @OnClick(R.id.btn_mj_pc)
    public void btn_mj_pc() {
        SerialPortUtil.sendMsg("MJD46");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
