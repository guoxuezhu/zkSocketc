package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoshiActivity extends BaseActivity {

    @BindView(R.id.rbtn_ms_1)
    RadioButton rbtn_ms_1;
    @BindView(R.id.rbtn_ms_2)
    RadioButton rbtn_ms_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moshi);
        ButterKnife.bind(this);

        if (MyApplication.prefs.getMoshi().equals("A")) {
            rbtn_ms_1.setChecked(true);
        } else {
            rbtn_ms_2.setChecked(true);
        }
    }

    @OnClick(R.id.btn_ms_baocun)
    public void btn_ms_baocun() {
        if (rbtn_ms_1.isChecked()) {
            MyApplication.prefs.setMoshi("A");
        } else {
            MyApplication.prefs.setMoshi("B");
        }
        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.ms_back)
    public void ms_back() {
        startActivity(new Intent(this, AdminActivity.class));
        finish();
    }


}
