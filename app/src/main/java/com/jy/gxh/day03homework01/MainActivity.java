package com.jy.gxh.day03homework01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import com.jy.gxh.day03homework01.adapters.MyRecyAadapter;
import com.jy.gxh.day03homework01.beans.HomeBean;
import com.jy.gxh.day03homework01.presenters.HomePresenter;
import com.jy.gxh.day03homework01.views.HomeView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HomeView, MyRecyAadapter.MyClickListener {

    private Toolbar mToolbar;
    private RecyclerView mRecy;
    private ArrayList<HomeBean.BodyBean.ResultBean> mlist;
    private MyRecyAadapter recyAadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "asd", Toast.LENGTH_SHORT).show();
            }
        });

        mRecy = (RecyclerView) findViewById(R.id.recy);
        mRecy.setLayoutManager(new LinearLayoutManager(this));
        mlist = new ArrayList<>();
        recyAadapter = new MyRecyAadapter(this, mlist);
        mRecy.setAdapter(recyAadapter);
        HomePresenter presenter = new HomePresenter(this);
        presenter.setDatas();

        recyAadapter.setMyClickListener(this);

    }

    @Override
    public void setDatas(ArrayList<HomeBean.BodyBean.ResultBean> result) {
        this.mlist.addAll(result);
        recyAadapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickListener(int position) {
        HomeBean.BodyBean.ResultBean bean = mlist.get(position);
        Intent intent = new Intent(this, ShowActivity.class);
        intent.putExtra("bean",bean);
        startActivity(intent);
    }
}
