package com.wyk.coordinatorlayoutdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToolBarMoreActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar_more);
        ButterKnife.bind(this);
        initToolBar();
        initRecyclerView();
    }

    private void initToolBar() {
//        mToolBar.setTitle("Title");
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationIcon(R.mipmap.ic_launcher); // 需要放在setSupportActionBar()方法之后
        //        mToolBar.set
        mCollapsingToolbarLayout.setTitle("title");
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(ToolBarMoreActivity.this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(ToolBarMoreActivity.this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(new ToolBarMoreActivity.MyAdapter());
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, ToolBarMoreActivity.class);
        context.startActivity(intent);
    }

    private class MyAdapter extends RecyclerView.Adapter<ToolBarMoreActivity.MyAdapter.MyViewHolder> {

        @Override
        public ToolBarMoreActivity.MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ToolBarMoreActivity.MyAdapter.MyViewHolder holder = new ToolBarMoreActivity.MyAdapter.MyViewHolder(LayoutInflater.from(ToolBarMoreActivity.this).inflate(R.layout.item_recyclerview, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final ToolBarMoreActivity.MyAdapter.MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 25;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.tv);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_setting) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
