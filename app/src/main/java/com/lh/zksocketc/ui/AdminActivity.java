package com.lh.zksocketc.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.DisplayTools;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdminActivity extends BaseActivity {

    @BindView(R.id.updata_seting)
    Button updata_seting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ButterKnife.bind(this);
        updata_seting.setText("升级" + DisplayTools.getVersionName(this));
    }

    @OnClick(R.id.xitong_seting)
    public void xitong_seting() {
        startActivity(new Intent(Settings.ACTION_SETTINGS));
    }

    @OnClick(R.id.updata_seting)
    public void updata_seting() {
        File apkFile1 = new File("/mnt/usbhost1/lh/操作面板.apk");
        File apkFile2 = new File("/mnt/usbhost2/lh/操作面板.apk");
        File apkFile3 = new File("/mnt/usbhost3/lh/操作面板.apk");
        if (apkFile1.exists()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(apkFile1), "application/vnd.android.package-archive");
            startActivity(intent);
        } else if (apkFile2.exists()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(apkFile2), "application/vnd.android.package-archive");
            startActivity(intent);
        } else if (apkFile3.exists()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(apkFile3), "application/vnd.android.package-archive");
            startActivity(intent);
        } else {
//            Toast.makeText(this, "请插入有升级包的U盘", Toast.LENGTH_SHORT).show();
            startActivity(getPackageManager().getLaunchIntentForPackage("com.softwinner.explore"));
        }
    }


    @OnClick(R.id.btn_user)
    public void btn_user() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


    @OnClick(R.id.btn_ic)
    public void btn_ic() {
        startActivity(new Intent(this, IcActivity.class));
        finish();

    }

    @OnClick(R.id.admin_back)
    public void admin_back() {
        finish();
    }


}
