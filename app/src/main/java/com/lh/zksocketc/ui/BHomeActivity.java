package com.lh.zksocketc.ui;

import android.os.Bundle;

import com.lh.zksocketc.R;

import butterknife.ButterKnife;

public class BHomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhome);
        ButterKnife.bind(this);

    }

}
