package com.lh.zksocketc.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.lh.zksocketc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShebeiFragment extends Fragment {

    @BindView(R.id.rbtn_cl_1_open)
    RadioButton rbtn_cl_1_open;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shebei_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.rbtn_cl_1_open)
    public void rbtn_cl_1_open() {


    }


    @OnClick(R.id.rbtn_cl_1_close)
    public void rbtn_cl_1_close() {


    }


    @OnClick(R.id.rbtn_cl_2_open)
    public void rbtn_cl_2_open() {


    }

    @OnClick(R.id.rbtn_cl_2_close)
    public void rbtn_cl_2_close() {


    }


    @OnClick(R.id.rbtn_tyj_open)
    public void rbtn_tyj_open() {


    }

    @OnClick(R.id.rbtn_tyj_close)
    public void rbtn_tyj_close() {


    }


    @OnClick(R.id.rbtn_tyj_bu_open)
    public void rbtn_tyj_bu_open() {


    }

    @OnClick(R.id.rbtn_tyj_bu_close)
    public void rbtn_tyj_bu_close() {


    }


    @OnClick(R.id.rbtn_dg_1_open)
    public void rbtn_dg_1_open() {


    }

    @OnClick(R.id.rbtn_dg_1_close)
    public void rbtn_dg_1_close() {


    }

    @OnClick(R.id.rbtn_dg_2_open)
    public void rbtn_dg_2_open() {


    }

    @OnClick(R.id.rbtn_dg_2_close)
    public void rbtn_dg_2_close() {


    }


    @OnClick(R.id.rbtn_dg_3_open)
    public void rbtn_dg_3_open() {


    }

    @OnClick(R.id.rbtn_dg_3_close)
    public void rbtn_dg_3_close() {


    }


    @OnClick(R.id.rbtn_dg_4_open)
    public void rbtn_dg_4_open() {


    }

    @OnClick(R.id.rbtn_dg_4_close)
    public void rbtn_dg_4_close() {


    }


}
