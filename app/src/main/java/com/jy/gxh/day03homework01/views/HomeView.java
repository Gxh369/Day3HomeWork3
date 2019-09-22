package com.jy.gxh.day03homework01.views;

import com.jy.gxh.day03homework01.beans.HomeBean;

import java.util.ArrayList;

/**
 * Created by GXH on 2019/9/22.
 */

public interface HomeView {
    void setDatas(ArrayList<HomeBean.BodyBean.ResultBean> result);

    void showToast(String string);
}
