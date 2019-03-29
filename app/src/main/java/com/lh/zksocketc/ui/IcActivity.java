package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.data.DbDao.IcCardNumerDao;
import com.lh.zksocketc.data.model.IcCardNumer;
import com.lh.zksocketc.utils.HttpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IcActivity extends BaseActivity {


    @BindView(R.id.et_kaohao)
    EditText et_kaohao;
    @BindView(R.id.et_ic_http)
    EditText et_ic_http;

    @BindView(R.id.rbtn_add)
    RadioButton rbtn_add;
    @BindView(R.id.rbtn_http)
    RadioButton rbtn_http;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ic);

        ButterKnife.bind(this);

        if (MyApplication.prefs.getIsAddCrad()) {
            rbtn_add.setChecked(true);
        } else {
            rbtn_http.setChecked(true);
        }


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
            IcCardNumerDao icCardNumerDao = MyApplication.getDaoSession().getIcCardNumerDao();
            icCardNumerDao.deleteAll();
            icCardNumerDao.insert(new IcCardNumer(et_kaohao.getText().toString()));
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
        startActivity(new Intent(this, AdminActivity.class));
        finish();
    }
}
