package com.lh.zksocketc.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChuanjingFragment extends Fragment {

    @BindView(R.id.btn_shangke)
    CheckBox btn_shangke;
    @BindView(R.id.btn_xiake)
    CheckBox btn_xiake;
    @BindView(R.id.btn_zixi)
    CheckBox btn_zixi;
    @BindView(R.id.btn_xiuxi)
    CheckBox btn_xiuxi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.changjing_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;

    }


    @OnClick(R.id.btn_shangke)
    public void btn_shangke() {
        SerialPortUtil.sendMsg("1");
        btn_shangke.setChecked(true);
        btn_xiake.setChecked(false);
        btn_zixi.setChecked(false);
        btn_xiuxi.setChecked(false);
    }

    @OnClick(R.id.btn_xiake)
    public void btn_xiake() {
        SerialPortUtil.sendMsg("2");
        btn_shangke.setChecked(false);
        btn_xiake.setChecked(true);
        btn_zixi.setChecked(false);
        btn_xiuxi.setChecked(false);

        getActivity().finish();
    }

    @OnClick(R.id.btn_zixi)
    public void btn_zixi() {
        SerialPortUtil.sendMsg("3");
        btn_shangke.setChecked(false);
        btn_xiake.setChecked(false);
        btn_zixi.setChecked(true);
        btn_xiuxi.setChecked(false);
    }

    @OnClick(R.id.btn_xiuxi)
    public void btn_xiuxi() {
        SerialPortUtil.sendMsg("4");
        btn_shangke.setChecked(false);
        btn_xiake.setChecked(false);
        btn_zixi.setChecked(false);
        btn_xiuxi.setChecked(true);
    }

}
