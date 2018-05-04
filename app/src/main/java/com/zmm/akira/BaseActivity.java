package com.zmm.akira;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.library.view.CustomProgressDialog;
import com.android.library.view.UIHelper;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ZMM on 2018/4/13 19:29.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private CustomProgressDialog progDialog;
    private Unbinder unbinder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
    }

    public abstract int getLayoutId();

    public abstract void initView();

    protected void showLoadingDialog(String argText) {
        if (progDialog == null) {
            progDialog = UIHelper.newNormalProgressDialog(this, argText);
            progDialog.getDialog().setCancelable(false);
            progDialog.getDialog().setCanceledOnTouchOutside(true);
        }
        progDialog.show();
    }

    protected void dismissLoadingDialog() {
        if (progDialog != null) {
            progDialog.dismiss();
            progDialog = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissLoadingDialog();
        unbinder.unbind();
    }
}
