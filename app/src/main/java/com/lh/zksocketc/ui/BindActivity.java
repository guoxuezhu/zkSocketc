package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.ELog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BindActivity extends BaseActivity {

    @BindView(R.id.et_name)
    EditText et_name;
    @BindView(R.id.et_password)
    EditText et_password;

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

        if (et_name.getText().toString().trim().equals("admin")) {
            if (et_password.getText().toString().trim().equals("hik12345")) {
                MyApplication.prefs.setZhanghao("admin");
                MyApplication.prefs.setMima("hik12345");
                startActivity(new Intent(this, AdminActivity.class));
                finish();
                return;
            }
        }

        ELog.d("==========getZhanghao=======" + MyApplication.prefs.getZhanghao());
        ELog.d("==========getMima===========" + MyApplication.prefs.getMima());

        if (et_name.getText().toString().trim().equals(MyApplication.prefs.getZhanghao())) {
            if (et_password.getText().toString().trim().equals(MyApplication.prefs.getMima())) {
                startActivity(new Intent(this, AdminActivity.class));
                finish();
                return;
            }
        }

        Toast.makeText(this, "帐号或密码错误", Toast.LENGTH_SHORT).show();


    }

    @OnClick(R.id.login_back)
    public void login_back() {
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
