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
        SerialPortUtil.sendMsg("MBS3");
    }


    @OnClick(R.id.rbtn_cl_close)
    public void rbtn_cl_close() {
        SerialPortUtil.sendMsg("MBS4");
    }


    @OnClick(R.id.rbtn_cl_open_1)
    public void rbtn_cl_open_1() {
        SerialPortUtil.sendMsg("MBS5");
    }


    @OnClick(R.id.rbtn_cl_close_1)
    public void rbtn_cl_close_1() {
        SerialPortUtil.sendMsg("MBS6");
    }


    @OnClick(R.id.rbtn_cl_open_2)
    public void rbtn_cl_open_2() {
        SerialPortUtil.sendMsg("MBS7");
    }


    @OnClick(R.id.rbtn_cl_close_2)
    public void rbtn_cl_close_2() {
        SerialPortUtil.sendMsg("MBS8");
    }

    @OnClick(R.id.rbtn_cl_open_3)
    public void rbtn_cl_open_3() {
        SerialPortUtil.sendMsg("MBS62");
    }


    @OnClick(R.id.rbtn_cl_close_3)
    public void rbtn_cl_close_3() {
        SerialPortUtil.sendMsg("MBS63");
    }


    @OnClick(R.id.rbtn_cl_open_4)
    public void rbtn_cl_open_4() {
        SerialPortUtil.sendMsg("MBS64");
    }


    @OnClick(R.id.rbtn_cl_close_4)
    public void rbtn_cl_close_4() {
        SerialPortUtil.sendMsg("MBS65");
    }


    @OnClick(R.id.rbtn_cl_open_5)
    public void rbtn_cl_open_5() {
        SerialPortUtil.sendMsg("MBS66");
    }

    @OnClick(R.id.rbtn_cl_close_5)
    public void rbtn_cl_close_5() {
        SerialPortUtil.sendMsg("MBS67");
    }


    @OnClick(R.id.rbtn_dg_open)
    public void rbtn_dg_open() {
        SerialPortUtil.sendMsg("MBS13");
    }

    @OnClick(R.id.rbtn_dg_close)
    public void rbtn_dg_close() {
        SerialPortUtil.sendMsg("MBS14");
    }

    @OnClick(R.id.rbtn_dg_open_1)
    public void rbtn_dg_open_1() {
        SerialPortUtil.sendMsg("MBS15");
    }

    @OnClick(R.id.rbtn_dg_close_1)
    public void rbtn_dg_close_1() {
        SerialPortUtil.sendMsg("MBS16");
    }

    @OnClick(R.id.rbtn_dg_open_2)
    public void rbtn_dg_open_2() {
        SerialPortUtil.sendMsg("MBS17");
    }

    @OnClick(R.id.rbtn_dg_close_2)
    public void rbtn_dg_close_2() {
        SerialPortUtil.sendMsg("MBS18");
    }

    @OnClick(R.id.rbtn_dg_open_3)
    public void rbtn_dg_open_3() {
        SerialPortUtil.sendMsg("MBS19");
    }

    @OnClick(R.id.rbtn_dg_close_3)
    public void rbtn_dg_close_3() {
        SerialPortUtil.sendMsg("MBS20");
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
        SerialPortUtil.sendMsg("MBS40");
    }

    @OnClick(R.id.btn_kt_zidong)
    public void btn_kt_zidong() {
        SerialPortUtil.sendMsg("MBS41");
    }

    @OnClick(R.id.btn_kt_zlen)
    public void btn_kt_zlen() {
        SerialPortUtil.sendMsg("MBS42");
    }

    @OnClick(R.id.btn_kt_zre)
    public void btn_kt_zre() {
        SerialPortUtil.sendMsg("MBS43");
    }


    @OnClick(R.id.btn_xf_open)
    public void btn_xf_open() {
        SerialPortUtil.sendMsg("MBS60");
    }

    @OnClick(R.id.btn_xf_close)
    public void btn_xf_close() {
        SerialPortUtil.sendMsg("MBS61");
    }


    @OnClick(R.id.btn_xf_zidong)
    public void btn_xf_zidong() {
        SerialPortUtil.sendMsg("MBS33");
    }

    @OnClick(R.id.btn_xf_fs_1)
    public void btn_xf_fs_1() {
        SerialPortUtil.sendMsg("MBS34");
    }

    @OnClick(R.id.btn_xf_fs_2)
    public void btn_xf_fs_2() {
        SerialPortUtil.sendMsg("MBS35");
    }

    @OnClick(R.id.btn_xf_fs_3)
    public void btn_xf_fs_3() {
        SerialPortUtil.sendMsg("MBS36");
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
