package com.lh.zksocketc.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.EditText;
import android.widget.Toast;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.data.DbDao.MLsListsDao;
import com.lh.zksocketc.data.model.MLsLists;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdminActivity extends BaseActivity {


//    @BindView(R.id.et_ml_shangke)
//    EditText et_ml_shangke;


//    private MLsListsDao mLsListsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ButterKnife.bind(this);

//        mLsListsDao = MyApplication.getDaoSession().getMLsListsDao();
//        if (mLsListsDao.loadAll().size() == 0) {
//            mLsListsDao.insert(new MLsLists((long) 1, "上课", ""));
//        }

        initView();

    }

    private void initView() {
//        et_ml_shangke.setText(mLsListsDao.load((long) 1).mlStrs);

    }


    @OnClick(R.id.xitong_seting)
    public void xitong_seting() {
        startActivity(new Intent(Settings.ACTION_SETTINGS));
    }

    @OnClick(R.id.updata_seting)
    public void updata_seting() {
//        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//        intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
//        intent.addCategory(Intent.CATEGORY_OPENABLE);
//        startActivityForResult(intent, 1);

        File apkFile = new File("/mnt/usbhost1/lh/操作面板-release-1.0.2.apk");
        if (apkFile.exists()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
            startActivity(intent);
        } else {
            Toast.makeText(this, "请插入有升级包的U盘", Toast.LENGTH_SHORT).show();
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
