package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.data.DbDao.IcCardNumerDao;
import com.lh.zksocketc.data.model.IcCardNumer;
import com.lh.zksocketc.utils.ELog;
import com.lh.zksocketc.utils.HttpUtil;
import com.lh.zksocketc.utils.SerialPortUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class IcActivity extends BaseActivity {


    @BindView(R.id.et_kaohao)
    EditText et_kaohao;
    @BindView(R.id.et_ic_http)
    EditText et_ic_http;

    @BindView(R.id.rbtn_add)
    RadioButton rbtn_add;
    @BindView(R.id.rbtn_http)
    RadioButton rbtn_http;
    private IcCardNumerDao icCardNumerDao;

    Handler icHander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 333:
                    ELog.e("======icHander====cardNumers=======" + msg.obj.toString());
                    et_kaohao.setText(msg.obj.toString());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ic);

        ButterKnife.bind(this);
        icCardNumerDao = MyApplication.getDaoSession().getIcCardNumerDao();
        if (icCardNumerDao.loadAll().size() != 0) {
            if (MyApplication.prefs.getIsAddCrad()) {
                rbtn_add.setChecked(true);
                et_kaohao.setText(icCardNumerDao.loadAll().get(0).cardNum);
            } else {
                rbtn_http.setChecked(true);
                et_ic_http.setText(MyApplication.prefs.getHttpUrl());
            }
        }

        readCard();
    }

    private void readCard() {
        SerialPortUtil.flowReadCard().subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe((kahao) -> {
                    ELog.e("======IcActivity====readCard===" + kahao);
                    Message msg = new Message();
                    msg.obj = kahao.trim().toString();
                    msg.what = 333;
                    icHander.sendMessage(msg);

                });
    }


    @OnClick(R.id.btn_ic_baocun)
    public void btn_ic_baocun() {

        if (rbtn_add.isChecked()) {
            if (et_kaohao.getText().toString().length() == 0) {
                Toast.makeText(this, "请输入IC卡号", Toast.LENGTH_SHORT).show();
                return;
            }

            if (et_kaohao.getText().toString().length() != 10) {
                Toast.makeText(this, "请输入十位数IC卡号", Toast.LENGTH_SHORT).show();
                return;
            }
            MyApplication.prefs.setIsAddCrad(true);

            List<IcCardNumer> cardNumers = icCardNumerDao.queryBuilder()
                    .where(IcCardNumerDao.Properties.CardNum.eq(et_kaohao.getText().toString()))
                    .list();
            ELog.e("======IcActivity====add=======" + cardNumers.size());
            if (cardNumers.size() == 0) {
                icCardNumerDao.insert(new IcCardNumer(et_kaohao.getText().toString()));
            }
        } else if (rbtn_http.isChecked()) {
            if (et_ic_http.getText().toString().length() == 0) {
                Toast.makeText(this, "请输入服务器IC卡数据接口", Toast.LENGTH_SHORT).show();
                return;
            }
            MyApplication.prefs.setIsAddCrad(false);
            MyApplication.prefs.setHttpUrl(et_ic_http.getText().toString());
            HttpUtil.getCards(et_ic_http.getText().toString());
        }

        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();

    }


    @OnClick(R.id.ic_back)
    public void ic_back() {
        SerialPortUtil.stopReadCard();
        startActivity(new Intent(this, AdminActivity.class));
        finish();
    }
}
