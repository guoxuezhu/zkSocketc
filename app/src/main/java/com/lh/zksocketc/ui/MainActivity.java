package com.lh.zksocketc.ui;

import android.annotation.SuppressLint;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.ScreenOffAdminReceiver;
import com.lh.zksocketc.utils.ELog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    private Socket clientSocket;
    private PrintWriter out;
    private Timer timer;
    private ComponentName adminReceiver;
    private PowerManager mPowerManager;
    private DevicePolicyManager policyManager;
    private PowerManager.WakeLock mWakeLock;


    @BindView(R.id.tv_zh_mm)
    TextView tv_zh_mm;
    @BindView(R.id.et_new_user)
    EditText et_new_user;
    @BindView(R.id.et_new_password)
    EditText et_new_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        adminReceiver = new ComponentName(MainActivity.this, ScreenOffAdminReceiver.class);
        mPowerManager = (PowerManager) getSystemService(POWER_SERVICE);
        policyManager = (DevicePolicyManager) MainActivity.this.getSystemService(Context.DEVICE_POLICY_SERVICE);
        checkAndTurnOnDeviceManager(null);

        tv_zh_mm.setText("帐号:" + MyApplication.prefs.getZhanghao() + "        密码:" + MyApplication.prefs.getMima());

    }


    @OnClick(R.id.btn_fix_ok)
    public void btn_fix_ok() {
        if (et_new_user.getText().toString().length() == 0) {
            Toast.makeText(this, "请输入新帐号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (et_new_password.getText().toString().length() == 0) {
            Toast.makeText(this, "请输入新密码", Toast.LENGTH_SHORT).show();
            return;
        }
        MyApplication.prefs.setZhanghao(et_new_user.getText().toString());
        MyApplication.prefs.setMima(et_new_password.getText().toString());

        tv_zh_mm.setText("帐号:" + MyApplication.prefs.getZhanghao() + "        密码:" + MyApplication.prefs.getMima());
        Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.zh_back)
    public void zh_back() {
        startActivity(new Intent(this, AdminActivity.class));
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    /**
     * @param view 检测并去激活设备管理器权限
     */
    public void checkAndTurnOnDeviceManager(View view) {
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, adminReceiver);
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "开启后就可以使用锁屏功能了...");//显示位置见图二
        startActivityForResult(intent, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        isOpen();
    }


    private void isOpen() {
        if (policyManager.isAdminActive(adminReceiver)) {//判断超级管理员是否激活
            showToast("设备已被激活");
        } else {
            showToast("设备没有被激活");

        }
    }


    /**
     * @param view 检测屏幕状态
     */
    public void checkScreen(View view) {
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        boolean screenOn = pm.isScreenOn();
        if (!screenOn) {//如果灭屏
            //相关操作
            showToast("屏幕是息屏");
        } else {
            showToast("屏幕是亮屏");

        }
    }


    /**
     * @param view 亮屏
     */
    @SuppressLint("InvalidWakeLockTag")
    public void checkScreenOn(View view) {
        mWakeLock = mPowerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "tag");
        mWakeLock.acquire();
        mWakeLock.release();
    }

    /**
     * @param view 熄屏
     */
    @SuppressLint("InvalidWakeLockTag")
    public void checkScreenOff(View view) {
        mWakeLock = mPowerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "tag");
        boolean admin = policyManager.isAdminActive(adminReceiver);
        mWakeLock.acquire();
        if (admin) {
            policyManager.lockNow();
        } else {
            showToast("没有设备管理权限");
        }
    }

    /**
     * @param view 熄屏并延时亮屏
     */
    @SuppressLint("InvalidWakeLockTag")
    public void checkScreenOffAndDelayOn(View view) {
        mWakeLock = mPowerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "tag");
        boolean admin = policyManager.isAdminActive(adminReceiver);
        if (admin) {
            policyManager.lockNow();
        } else {
            showToast("没有设备管理权限");
        }
    }


    private void showToast(String Str) {
        Toast.makeText(this, Str, Toast.LENGTH_SHORT).show();
    }


}
