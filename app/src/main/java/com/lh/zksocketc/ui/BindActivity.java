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

    @BindView(R.id.et_ip)
    EditText et_ip;
    @BindView(R.id.et_port)
    EditText et_port;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_lianjie)
    public void btn_lianjie() {
        if (et_ip.getText().toString().length() != 0) {
            MyApplication.prefs.setZKIP(et_ip.getText().toString());
        } else {
            Toast.makeText(this, "请输入中控的ip", Toast.LENGTH_SHORT).show();
            return;
        }

        if (et_port.getText().toString().length() != 0) {
            MyApplication.prefs.setZKPORT(et_port.getText().toString());
        } else {
            Toast.makeText(this, "请输入中控的端口", Toast.LENGTH_SHORT).show();
            return;
        }

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


}
