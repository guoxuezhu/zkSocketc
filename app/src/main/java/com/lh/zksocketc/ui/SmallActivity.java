package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.data.DbDao.IcCardNumerDao;
import com.lh.zksocketc.data.DbDao.WsdDataDao;
import com.lh.zksocketc.data.model.IcCardNumer;
import com.lh.zksocketc.utils.ELog;
import com.lh.zksocketc.utils.SerialPortUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SmallActivity extends BaseActivity {

    @BindView(R.id.tv_wsd_wd)
    TextView tv_wsd_wd;
    @BindView(R.id.tv_wsd_sd)
    TextView tv_wsd_sd;
    @BindView(R.id.tv_wsd_pm)
    TextView tv_wsd_pm;


    @BindView(R.id.ckbox_kt_open_close)
    CheckBox ckbox_kt_open_close;

    Handler smHander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 444:
                    ELog.e("======sHander====SmallActivity====444=========" + msg.obj.toString());

                    break;
                case 333:
                    ELog.e("======sHander=====333=====SmallActivity=======" + msg.obj.toString());

                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
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

    @OnClick(R.id.rbtn_shangke)
    public void rbtn_shangke() {
        SerialPortUtil.sendMsg("MBS1");
    }


    @OnClick(R.id.rbtn_xiake)
    public void rbtn_xiake() {
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


    @OnClick(R.id.ckbox_kt_open_close)
    public void ckbox_kt_open_close() {
        if (ckbox_kt_open_close.isChecked()) {
            SerialPortUtil.sendMsg("MBS39");
        } else {
            SerialPortUtil.sendMsg("MBS48");
        }
    }


    @OnClick(R.id.btn_kt_wd_y)
    public void btn_kt_wd_y() {
        SerialPortUtil.sendMsg("MBS43");
    }

    @OnClick(R.id.btn_kt_wd_n)
    public void btn_kt_wd_n() {
        SerialPortUtil.sendMsg("MBS44");
    }

    @OnClick(R.id.btn_mj_pc)
    public void btn_mj_pc() {
        SerialPortUtil.sendMsg("MJD46");
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
