package com.zmm.akira.greendao;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.TextView;

import com.zmm.akira.BaseActivity;
import com.zmm.akira.R;
import com.zmm.akira.model.TestEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ZMM on 2018/5/4 11:51.
 */

public class GreenDaoActivity extends BaseActivity {
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.content)
    ConstraintLayout content;
    private List<TestEntity> testList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_dao;
    }

    @Override
    public void initView() {
        TestEntity entity;
        for (int i = 0; i < 99; i++) {
            testList.add(entity = new TestEntity(i, "我是NO." + i, i));
        }
    }

    @OnClick({R.id.btn_insert, R.id.btn_delete, R.id.btn_modify, R.id.btn_query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_insert:
//                DaoHelper.insertData(this, testList);
                DaoHelper.insertData(this, new TestEntity(2, "fff", 16));
                break;
            case R.id.btn_delete:
                break;
            case R.id.btn_modify:
                break;
            case R.id.btn_query:
                List<TestEntity> testEntities = DaoHelper.queryAll(this);
                tvResult.setText(testEntities.toString());
                break;
        }
    }
}
