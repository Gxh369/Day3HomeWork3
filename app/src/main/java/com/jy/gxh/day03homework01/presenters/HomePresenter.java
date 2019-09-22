package com.jy.gxh.day03homework01.presenters;

import com.jy.gxh.day03homework01.beans.HomeBean;
import com.jy.gxh.day03homework01.models.HomeModel;
import com.jy.gxh.day03homework01.views.HomeView;

import java.util.ArrayList;

/**
 * Created by GXH on 2019/9/22.
 */

public class HomePresenter implements HomeModel.MyCallBack {
    private HomeView homeView;
    private HomeModel homeModel;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
        this.homeModel=new HomeModel(this);
    }


    public void setDatas() {
        homeModel.setDatas();
    }

    @Override
    public void onSucceed(ArrayList<HomeBean.BodyBean.ResultBean> result) {
        homeView.setDatas(result);
    }

    @Override
    public void onField(String string) {
        homeView.showToast(string);
    }
}
