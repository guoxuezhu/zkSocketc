package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.data.DbDao.WsdDataDao;
import com.lh.zksocketc.utils.ELog;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BHomeActivity extends BaseActivity {

    @BindView(R.id.B_tv_wsd_wd)
    TextView B_tv_wsd_wd;
    @BindView(R.id.B_tv_wsd_sd)
    TextView B_tv_wsd_sd;
    @BindView(R.id.B_tv_wsd_pm)
    TextView B_tv_wsd_pm;


    @BindView(R.id.B_ckbox_kt_open_close)
    CheckBox B_ckbox_kt_open_close;

    Handler smHander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 567:
                    ELog.e("======smHander====SmallActivity====567=========" + msg.obj.toString());
                    initView();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhome);
        ButterKnife.bind(this);

        initView();
        SerialPortUtil.setWSDmsg(smHander);
    }


    private void initView() {
        WsdDataDao wsdDataDao = MyApplication.getDaoSession().getWsdDataDao();
        if (wsdDataDao.loadAll().size() == 0) {
            B_tv_wsd_wd.setText("");
            B_tv_wsd_sd.setText("");
            B_tv_wsd_pm.setText("");
        } else {
            B_tv_wsd_wd.setText(wsdDataDao.loadAll().get(0).wendu);
            B_tv_wsd_sd.setText(wsdDataDao.loadAll().get(0).shidu);
            B_tv_wsd_pm.setText(wsdDataDao.loadAll().get(0).pm25);
        }

    }

    @OnClick(R.id.B_rbtn_shangke)
    public void B_rbtn_shangke() {
        SerialPortUtil.sendMsg("MBS1");
    }


    @OnClick(R.id.B_rbtn_xiake)
    public void B_rbtn_xiake() {
        SerialPortUtil.stopWSDmsg(smHander);
        SerialPortUtil.sendMsg("MBS2");
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }

    @OnClick(R.id.B_rbtn_cl_open)
    public void B_rbtn_cl_open() {
        SerialPortUtil.sendMsg("MBS5");
    }


    @OnClick(R.id.B_rbtn_cl_close)
    public void B_rbtn_cl_close() {
        SerialPortUtil.sendMsg("MBS6");
    }


    @OnClick(R.id.B_rbtn_dg_open)
    public void B_rbtn_dg_open() {
        SerialPortUtil.sendMsg("MBS13");
    }

    @OnClick(R.id.B_rbtn_dg_close)
    public void B_rbtn_dg_close() {
        SerialPortUtil.sendMsg("MBS14");

    }


    @OnClick(R.id.B_rbtn_tyj_open)
    public void B_rbtn_tyj_open() {
        SerialPortUtil.sendMsg("MBS9");

    }

    @OnClick(R.id.B_rbtn_tyj_close)
    public void B_rbtn_tyj_close() {
        SerialPortUtil.sendMsg("MBS10");

    }


    @OnClick(R.id.B_rbtn_tyj_bu_open)
    public void B_rbtn_tyj_bu_open() {
        SerialPortUtil.sendMsg("MBS11");
    }

    @OnClick(R.id.B_rbtn_tyj_bu_close)
    public void B_rbtn_tyj_bu_close() {
        SerialPortUtil.sendMsg("MBS12");
    }


    @OnClick(R.id.B_ckbox_kt_open_close)
    public void B_ckbox_kt_open_close() {
        if (B_ckbox_kt_open_close.isChecked()) {
            SerialPortUtil.sendMsg("MBS39");
        } else {
            SerialPortUtil.sendMsg("MBS48");
        }
    }


    @OnClick(R.id.B_btn_kt_wd_y)
    public void B_btn_kt_wd_y() {
        SerialPortUtil.sendMsg("MBS43");
    }

    @OnClick(R.id.B_btn_kt_wd_n)
    public void B_btn_kt_wd_n() {
        SerialPortUtil.sendMsg("MBS44");
    }

    @OnClick(R.id.B_btn_mj_pc)
    public void B_btn_mj_pc() {
        SerialPortUtil.sendMsg("MJD46");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
