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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.shangke_btn)
    public void shangke_btn() {

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
