package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.data.DbDao.MLsListsDao;
import com.lh.zksocketc.data.model.MLsLists;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    private MLsListsDao mLsListsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        mLsListsDao = MyApplication.getDaoSession().getMLsListsDao();
    }


    @OnClick(R.id.shangke_btn)
    public void shangke_btn() {
        if (mLsListsDao.loadAll().size() == 0) {
            Toast.makeText(this, "请绑定事件命令", Toast.LENGTH_SHORT).show();
        } else {
            SerialPortUtil.sendMsg(1, mLsListsDao.load((long) 1).mlStrs);
        }
    }

    @OnClick(R.id.chongzhi_btn)
    public void chongzhi_btn() {
        SerialPortUtil.sendMsg(1, "3-1-1");
    }


    @OnClick(R.id.lamp_btn)
    public void lamp_btn() {
        SerialPortUtil.sendMsg(1, "2-1-1");
    }


}
