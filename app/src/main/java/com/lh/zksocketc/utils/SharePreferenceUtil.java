package com.lh.zksocketc.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 共享参数类
 */
@SuppressLint("CommitPrefEdits")
public class SharePreferenceUtil {
    private SharedPreferences sp;
    private Editor editor;


    /**
     * 构造函数
     */
    public SharePreferenceUtil(Context context, String file) {
        sp = context.getSharedPreferences(file, Context.MODE_PRIVATE);
        // 利用edit()方法获取Editor对象。
        editor = sp.edit();
    }

    public void setZhanghao(String user) {
        editor.putString("user", user);
        editor.commit();
    }

    public String getZhanghao() {
        return sp.getString("user", "admin");
    }

    public void setMima(String mima) {
        editor.putString("mima", mima);
        editor.commit();
    }

    public String getMima() {
        return sp.getString("mima", "admin");
    }

    public void setIsAddCrad(boolean isAddCrad) {
        editor.putBoolean("isAddCrad", isAddCrad);
        editor.commit();
    }

    public boolean getIsAddCrad() {
        return sp.getBoolean("isAddCrad", true);
    }


    public void setHttpUrl(String httpUrl) {
        editor.putString("httpUrl", httpUrl);
        editor.commit();
    }

    public String getHttpUrl() {
        return sp.getString("httpUrl", "");
    }

    public void setMoshi(String moshi) {
        editor.putString("moshi", moshi);
        editor.commit();
    }

    public String getMoshi() {
        return sp.getString("moshi", "A");
    }

}
