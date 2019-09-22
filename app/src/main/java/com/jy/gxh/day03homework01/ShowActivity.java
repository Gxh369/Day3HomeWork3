package com.jy.gxh.day03homework01;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.jy.gxh.day03homework01.adapters.MyFPAdapter;
import com.jy.gxh.day03homework01.beans.HomeBean;
import com.jy.gxh.day03homework01.beans.ShowBean;
import com.jy.gxh.day03homework01.fragments.CourseFragment;
import com.jy.gxh.day03homework01.fragments.SpecialFragment;
import com.jy.gxh.day03homework01.fragments.StateFragment;
import com.jy.gxh.day03homework01.presenters.ShowPresenter;
import com.jy.gxh.day03homework01.views.ShowView;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener, ShowView {

    private ImageView show_pic;
    private TextView show_name;
    /**
     * 关注
     */
    private Button show_btn;
    private TextView show_title;
    private TabLayout mTab;
    private Toolbar mShowToolbar;
    private FragmentManager manager;
    private HomeBean.BodyBean.ResultBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();

    }

    private void initView() {
        mShowToolbar = (Toolbar) findViewById(R.id.show_toolbar);
        mShowToolbar.setTitle("");
        setSupportActionBar(mShowToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mShowToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        show_pic = (ImageView) findViewById(R.id.show_pic);
        show_name = (TextView) findViewById(R.id.show_name);
        show_btn = (Button) findViewById(R.id.show_btn);
        show_btn.setOnClickListener(this);
        show_title = (TextView) findViewById(R.id.show_title);
        mTab = (TabLayout) findViewById(R.id.tab);
        setView();

    }

    private void setView() {
        Intent intent = getIntent();
        bean = (HomeBean.BodyBean.ResultBean) intent.getSerializableExtra("bean");
        Glide.with(this).load(bean.getTeacherPic())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(show_pic);
        show_name.setText(bean.getTeacherName());
        show_title.setText(bean.getTitle());
        int id = bean.getID();
        initTab(id);
    }

//    private void initVp(HomeBean.BodyBean.ResultBean bean) {
//        StateFragment stateFragment = new StateFragment();
//        Bundle bundle=new Bundle();
//        bundle.putString("content",bean.getTeacherName()+bean.getTitle());
//        stateFragment.setArguments(bundle);
//
//        CourseFragment courseFragment = new CourseFragment();
//
//        SpecialFragment specialFragment = new SpecialFragment();
//    }


    private void initTab(int id) {
        ShowPresenter presenter = new ShowPresenter(this);
        presenter.setDatas(id);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.item_btn:
                break;
        }
    }

    @Override
    public void onFiled(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addDatas(ArrayList<ShowBean.BodyBean.ResultBean> result) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            mTab.addTab(mTab.newTab().setText(result.get(i).getDescription()), i);
        }
        manager = getSupportFragmentManager();
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        StateFragment stateFragment = new StateFragment();
                        Bundle bundle=new Bundle();
                        bundle.putString("content",bean.getTeacherName()+bean.getTitle());
                        stateFragment.setArguments(bundle);
                        manager.beginTransaction().replace(R.id.frame,stateFragment).commit();
                        break;
                    case 1:
                        CourseFragment courseFragment = new CourseFragment();
                        manager.beginTransaction().replace(R.id.frame,courseFragment).commit();
                        break;
                    case 2:
                        SpecialFragment specialFragment = new SpecialFragment();
                        manager.beginTransaction().replace(R.id.frame,specialFragment).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        StateFragment stateFragment = new StateFragment();
        Bundle bundle=new Bundle();
        bundle.putString("content",bean.getTeacherName()+bean.getTitle());
        stateFragment.setArguments(bundle);
        manager.beginTransaction().replace(R.id.frame,stateFragment).commit();
    }
}
