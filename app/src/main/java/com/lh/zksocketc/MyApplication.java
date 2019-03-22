package com.lh.zksocketc;

import android.app.Application;

import com.lh.zksocketc.data.DbDao.DaoMaster;
import com.lh.zksocketc.data.DbDao.DaoSession;
import com.lh.zksocketc.utils.SharePreferenceUtil;

public class MyApplication extends Application {

    public static SharePreferenceUtil prefs;
    public static DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();
        prefs = new SharePreferenceUtil(this, "zkcSaveDates");
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "lhzkc.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        daoSession = daoMaster.newSession();
    }




    public static DaoSession getDaoSession() {
        return daoSession;
    }





}
