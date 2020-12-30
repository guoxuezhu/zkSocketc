package com.lh.zksocketc.ui;

import android.annotation.SuppressLint;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.widget.Toast;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.ScreenOffAdminReceiver;
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

    private ComponentName adminReceiver;
    private PowerManager mPowerManager;
    private DevicePolicyManager policyManager;
    private PowerManager.WakeLock mWakeLock;
    private Timer offTimer;


    Handler sHander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 555:
                    ELog.e("======sHander====SplashActivity====555=========" + msg.obj.toString());
                    screenOn();
                    break;
                case 444:
                    ELog.e("======sHander====SplashActivity====444=========" + msg.obj.toString());
                    screenOn();
                    SerialPortUtil.sendMsg("MBS37");
                    destroyFinish();
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    finish();
                    break;
                case 333:
                    ELog.e("======sHander=====333=====SplashActivity=======" + msg.obj.toString());
                    screenOn();
                    if (icCardNumerDao.loadAll().size() != 0) {
                        List<IcCardNumer> cardNumers = icCardNumerDao.queryBuilder()
                                .where(IcCardNumerDao.Properties.CardNum.eq(msg.obj.toString()))
                                .list();
                        ELog.e("==========cardNumers=======" + cardNumers.size());
                        if (cardNumers.size() != 0) {
                            SerialPortUtil.sendMsg("CRD" + msg.obj.toString());
                            destroyFinish();
                            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                            finish();
                        } else {
                            startTimerOff();
                        }
                    } else {
                        startTimerOff();
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


        icCardNumerDao = MyApplication.getDaoSession().getIcCardNumerDao();


        adminReceiver = new ComponentName(SplashActivity.this, ScreenOffAdminReceiver.class);
        mPowerManager = (PowerManager) getSystemService(POWER_SERVICE);
        policyManager = (DevicePolicyManager) SplashActivity.this.getSystemService(Context.DEVICE_POLICY_SERVICE);
        checkAndTurnOnDeviceManager();

        startTimerOff();
        SerialPortUtil.readCardnumer(sHander);
    }


    //检测并去激活设备管理器权限
    public void checkAndTurnOnDeviceManager() {
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
//            showToast("设备已被激活");
        } else {
            showToast("设备没有被激活");

        }
    }


    //亮屏
    @SuppressLint("InvalidWakeLockTag")
    public void screenOn() {
        mWakeLock = mPowerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "tag");
        mWakeLock.acquire();
        mWakeLock.release();
    }

    //熄屏
    @SuppressLint("InvalidWakeLockTag")
    public void screenOff() {
        mWakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "tag");
        boolean admin = policyManager.isAdminActive(adminReceiver);
        mWakeLock.acquire();
        if (admin) {
            policyManager.lockNow();
        } else {
            showToast("没有设备管理权限");
        }
    }


    private void showToast(String Str) {
        Toast.makeText(this, Str, Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.admin_seting)
    public void admin_seting() {
        destroyFinish();
        startActivity(new Intent(this, BindActivity.class));
        finish();
    }


    @Override
    public void onBackPressed() {
        return;
    }


    private void startTimerOff() {
        stopTimerOff();
        offTimer = new Timer();
        offTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                screenOff();
                stopTimerOff();
            }
        }, 1500 * 60);

    }


    private void stopTimerOff() {
        if (offTimer != null) {
            offTimer.cancel();
            offTimer = null;
        }
    }


    private void destroyFinish() {
        ELog.e("==============================destroyFinish=======");
        SerialPortUtil.stopReadCard();
        stopTimerOff();
        sHander = null;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}
