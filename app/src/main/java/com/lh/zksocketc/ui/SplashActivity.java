package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.widget.Toast;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.ELog;
import com.lh.zksocketc.utils.SerialPortUtil;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity {

    private Timer timer;

    Handler hander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 333:
                    // msg.obj.toString();
                    if (HomeActivity.isFinish()) {
                        startActivity(new Intent(SplashActivity.this, HomeActivity.class));
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


//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
//                timer.cancel();
//            }
//        }, 3000);


//        if (isBind()) {
//            startActivity(new Intent(this, MainActivity.class));
//        } else {
//            startActivity(new Intent(this, BindActivity.class));
//        }
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
