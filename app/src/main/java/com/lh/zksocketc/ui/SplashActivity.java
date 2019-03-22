package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);
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



    @OnClick(R.id.xitong_seting)
    public void xitong_seting() {
        startActivity(new Intent(Settings.ACTION_SETTINGS));
    }



    @OnClick(R.id.admin_seting)
    public void admin_seting() {
        startActivity(new Intent(this, BindActivity.class));
    }



    @OnClick(R.id.huanjing_seting)
    public void huanjing_seting() {
        startActivity(new Intent(this, HomeActivity.class));
    }









    private boolean isBind() {
        if (MyApplication.prefs.getZKIP() != null && MyApplication.prefs.getZKPORT() != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        return;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
