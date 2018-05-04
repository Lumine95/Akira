package com.zmm.akira;

import android.content.Intent;
import android.widget.GridView;

import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;
import com.zmm.akira.greendao.GreenDaoActivity;
import com.zmm.akira.model.MenuEntity;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.grid_view)
    GridView gridView;

    private ArrayList<MenuEntity> menuList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        menuList.add(new MenuEntity(getString(R.string.green_dao), R.mipmap.ic_database, GreenDaoActivity.class));

        gridView.setAdapter(new CommonAdapter<MenuEntity>(this, R.layout.item_menu, menuList) {
            @Override
            protected void convert(ViewHolder holder, MenuEntity item, int position) {
                holder.setText(R.id.tv_menu, item.getName());
                holder.setImageResource(R.id.iv_menu, item.getImage());
                holder.getConvertView().setOnClickListener(v -> startActivity(new Intent(mContext, item.getActivity())));
            }
        });
    }
}
