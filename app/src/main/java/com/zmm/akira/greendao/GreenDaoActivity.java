package com.zmm.akira.greendao;

import android.view.View;
import android.widget.TextView;

import com.zmm.akira.BaseActivity;
import com.zmm.akira.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ZMM on 2018/5/4 11:51.
 */

public class GreenDaoActivity extends BaseActivity {
    @BindView(R.id.tv_result)
    TextView tvResult;

    @Override
    public int getLayoutId() {
        return R.layout.activity_dao;
    }

    @Override
    public void initView() {


    }

    @OnClick({R.id.btn_insert, R.id.btn_delete, R.id.btn_modify, R.id.btn_query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_insert:
                break;
            case R.id.btn_delete:
                break;
            case R.id.btn_modify:
                break;
            case R.id.btn_query:
                break;
        }
    }
}
