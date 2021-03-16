package com.lh.zksocketc.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lh.zksocketc.R;

import butterknife.ButterKnife;

public class LuboFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lubo_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }



}
