package com.lh.zksocketc.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.lh.zksocketc.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TishiDialog extends Dialog {

    private Context mContext;
    private DialogCallBack mDialogCallBack;

    public TishiDialog(@NonNull Context context, DialogCallBack dialogCallBack) {
        super(context);
//        super(context, R.style.FullHeightDialog);
        mContext = context;
        mDialogCallBack = dialogCallBack;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tishi_dialog_view);
        ButterKnife.bind(this);
    }

    public interface DialogCallBack {
        void tishiOkDialog();

        void tishiCancelDialog();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        cancelDismissDialog();
    }

    private void cancelDismissDialog() {
        mDialogCallBack.tishiCancelDialog();
    }

    @OnClick(R.id.tishi_dialog_btn_no)
    public void tishi_dialog_btn_no() {
        cancelDismissDialog();
    }

    @OnClick(R.id.tishi_dialog_btn_ok)
    public void tishi_dialog_btn_ok() {
        mDialogCallBack.tishiOkDialog();
    }

}
