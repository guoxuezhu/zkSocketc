package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


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

        tv_zh_mm.setText("帐号:" + MyApplication.prefs.getZhanghao() + "        密码:" + MyApplication.prefs.getMima());

    }


    @OnClick(R.id.btn_fix_ok)
    public void btn_fix_ok() {
        if (et_new_user.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "请输入新帐号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (et_new_password.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "请输入新密码", Toast.LENGTH_SHORT).show();
            return;
        }
        MyApplication.prefs.setZhanghao(et_new_user.getText().toString().trim());
        MyApplication.prefs.setMima(et_new_password.getText().toString().trim());

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


}
