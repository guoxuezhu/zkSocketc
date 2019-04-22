package com.lh.zksocketc.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.lh.zksocketc.R;
import com.lh.zksocketc.ui.SplashActivity;
import com.lh.zksocketc.utils.SerialPortUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChuanjingFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.changjing_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;

    }


    @OnClick(R.id.btn_shangke)
    public void btn_shangke() {
        SerialPortUtil.sendMsg("MBS1");

    }

    @OnClick(R.id.btn_xiake)
    public void btn_xiake() {
        SerialPortUtil.sendMsg("MBS2");
        startActivity(new Intent(getActivity(), SplashActivity.class));
        getActivity().finish();
    }

    @OnClick(R.id.btn_zixi)
    public void btn_zixi() {
        SerialPortUtil.sendMsg("MBS3");

    }

    @OnClick(R.id.btn_xiuxi)
    public void btn_xiuxi() {
        SerialPortUtil.sendMsg("MBS4");
    }

}
