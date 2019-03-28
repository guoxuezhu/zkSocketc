package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.SerialPortUtil;

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

        SerialPortUtil.open();
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

    @OnClick(R.id.updata_seting)
    public void updata_seting() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent,1);

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
    }
}
