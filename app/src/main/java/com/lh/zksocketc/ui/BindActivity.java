package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import android.widget.Toast;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.ELog;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BindActivity extends BaseActivity {

    @BindView(R.id.et_name)
    EditText et_name;
    @BindView(R.id.et_password)
    EditText et_password;

    private Handler loginHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 20:
                    ELog.e("======loginHandler=====20====" + msg.obj.toString());
                    SerialPortUtil.handerMsgstop();
                    startActivity(new Intent(BindActivity.this, AdminActivity.class));
                    finish();
                    break;
                case 21:
                    ELog.e("======loginHandler=====21====" + msg.obj.toString());
                    if (msg.obj.toString().equals("5")) {
                        Toast.makeText(BindActivity.this, "请使用初始帐号密码登录", Toast.LENGTH_SHORT).show();
                    } else if (msg.obj.toString().equals("7")) {
                        Toast.makeText(BindActivity.this, "帐号错误", Toast.LENGTH_SHORT).show();
                    } else if (msg.obj.toString().equals("8")) {
                        Toast.makeText(BindActivity.this, "此帐号已锁定,请使用其它帐号登录", Toast.LENGTH_SHORT).show();
                    } else if (msg.obj.toString().equals("4")) {
                        Toast.makeText(BindActivity.this, "密码错误,此帐号锁定", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(BindActivity.this, "密码错误," + msg.obj.toString() + "次后此帐号锁定", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_lianjie)
    public void btn_lianjie() {
        if (et_name.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "请输入管理员帐号", Toast.LENGTH_SHORT).show();
            return;
        }

        if (et_password.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        SerialPortUtil.loginMsg(loginHandler);
        SerialPortUtil.sendMsg("USER," + et_name.getText().toString().trim() + "," + et_password.getText().toString().trim());

//        if (et_name.getText().toString().trim().equals("hzlhadmin")) {
//            if (et_password.getText().toString().trim().equals("hzlhadmin")) {
//                MyApplication.prefs.setZhanghao("hzlhadmin");
//                MyApplication.prefs.setMima("hzlhadmin");
//                startActivity(new Intent(this, AdminActivity.class));
//                finish();
//                return;
//            }
//        }
//
//        ELog.d("==========getZhanghao=======" + MyApplication.prefs.getZhanghao());
//        ELog.d("==========getMima===========" + MyApplication.prefs.getMima());
//
//        if (et_name.getText().toString().trim().equals(MyApplication.prefs.getZhanghao())) {
//            if (et_password.getText().toString().trim().equals(MyApplication.prefs.getMima())) {
//                startActivity(new Intent(this, AdminActivity.class));
//                finish();
//                return;
//            }
//        }
//
//        Toast.makeText(this, "帐号或密码错误", Toast.LENGTH_SHORT).show();


    }

    @OnClick(R.id.login_back)
    public void login_back() {
        loginHandler = null;
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
