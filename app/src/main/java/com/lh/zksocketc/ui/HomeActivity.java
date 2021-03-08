package com.lh.zksocketc.ui;

import android.os.Bundle;

import com.lh.zksocketc.R;

import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
