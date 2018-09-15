package com.lh.zksocketc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (isBind()) {
            startActivity(new Intent(this, MainActivity.class));
        } else {
            startActivity(new Intent(this, BindActivity.class));
        }
        finish();
    }

    private boolean isBind() {
        if (MyApplication.prefs.getZKIP() != null && MyApplication.prefs.getZKPORT() != null) {
            return true;
        } else {
            return false;
        }
    }


}
