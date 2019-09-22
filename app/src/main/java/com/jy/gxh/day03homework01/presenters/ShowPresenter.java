package com.jy.gxh.day03homework01.presenters;

import com.jy.gxh.day03homework01.beans.ShowBean;
import com.jy.gxh.day03homework01.models.ShowModel;
import com.jy.gxh.day03homework01.views.ShowView;

import java.util.ArrayList;

/**
 * Created by GXH on 2019/9/22.
 */

public class ShowPresenter implements ShowModel.MyCallBack {
    private ShowView showView;
    private ShowModel showModel;

    public ShowPresenter(ShowView showView) {
        this.showView = showView;
        this.showModel=new ShowModel(this);
    }


    public void setDatas(int id) {
        showModel.setDatas(id);
    }



    @Override
    public void onFiled(String string) {
        showView.onFiled(string);
    }

    @Override
    public void onSucceed(ArrayList<ShowBean.BodyBean.ResultBean> result) {
        showView.addDatas(result);
    }
}
