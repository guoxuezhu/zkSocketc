package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.ELog;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.ButterKnife;

public class LauncherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        ButterKnife.bind(this);
        SerialPortUtil.open();
        SerialPortUtil.readSerialPortData();
        startActivity(new Intent(this, SplashActivity.class));

    }


    @Override
    public void onBackPressed() {
        return;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ELog.e("=====11111111111111111111111====onRestart=======");
        startActivity(new Intent(this, SplashActivity.class));
    }


}
