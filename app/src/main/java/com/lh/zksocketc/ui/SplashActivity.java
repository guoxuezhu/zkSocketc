package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.widget.Toast;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.data.DbDao.IcCardNumerDao;
import com.lh.zksocketc.data.model.IcCardNumer;
import com.lh.zksocketc.utils.ELog;
import com.lh.zksocketc.utils.SerialPortUtil;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity {

    private IcCardNumerDao icCardNumerDao;

    Handler hander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 333:
                    // msg.obj.toString();
                    if (icCardNumerDao.loadAll().size() != 0) {
                        List<IcCardNumer> cardNumers = icCardNumerDao.queryBuilder()
                                .where(IcCardNumerDao.Properties.CardNum.eq(msg.obj.toString()))
                                .list();
                        ELog.e("==========cardNumers=======" + cardNumers.size());
                        if (cardNumers.size() != 0) {
                            if (HomeActivity.isFinish()) {
                                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                            }
                        }
                    }
                    break;
            }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        SerialPortUtil.open();
        SerialPortUtil.readCard(hander);
        SerialPortUtil.readSerialPortData();

        icCardNumerDao = MyApplication.getDaoSession().getIcCardNumerDao();

    }


    @OnClick(R.id.admin_seting)
    public void admin_seting() {
        startActivity(new Intent(this, BindActivity.class));
    }


    @OnClick(R.id.huanjing_seting)
    public void huanjing_seting() {
        startActivity(new Intent(this, HomeActivity.class));
    }


    @Override
    public void onBackPressed() {
        return;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SerialPortUtil.stopReadCard();
    }
}
