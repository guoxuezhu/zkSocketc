package com.lh.zksocketc;

import android.app.Application;

import com.lh.zksocketc.utils.SharePreferenceUtil;

public class MyApplication extends Application {

    public static SharePreferenceUtil prefs;

    @Override
    public void onCreate() {
        super.onCreate();
        prefs = new SharePreferenceUtil(this, "zkcSaveDates");
    }
}
