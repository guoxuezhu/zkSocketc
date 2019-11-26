package com.lh.zksocketc.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.DateUtil;

import butterknife.BindView;

public class PingbaoActivity extends BaseActivity {



    @BindView(R.id.tv_week)
    TextView tv_week;
    @BindView(R.id.tv_time)
    TextView tv_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pingbao);


        tv_week.setText(DateUtil.getWeek());
        tv_time.setText(DateUtil.getTimeyyyyMMdd());

    }





}
