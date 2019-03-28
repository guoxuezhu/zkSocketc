package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;

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
        if (et_name.getText().toString().length() == 0) {
            Toast.makeText(this, "请输入管理员帐号", Toast.LENGTH_SHORT).show();
            return;
        }

        if (et_password.getText().toString().length() == 0) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (et_name.getText().toString().equals("hzlhadmin")) {
            if (et_password.getText().toString().equals("hzlhadmin")) {
                startActivity(new Intent(this, AdminActivity.class));
                finish();
                return;
            }
        }


        if (et_name.getText().toString().equals("admin")) {
            if (et_password.getText().toString().equals("admin")) {
                startActivity(new Intent(this, AdminActivity.class));
                finish();
                return;
            }
        }

        Toast.makeText(this, "帐号或密码错误", Toast.LENGTH_SHORT).show();


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
