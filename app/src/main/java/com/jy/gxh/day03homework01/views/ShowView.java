package com.jy.gxh.day03homework01.views;

import com.jy.gxh.day03homework01.beans.ShowBean;

import java.util.ArrayList;

/**
 * Created by GXH on 2019/9/22.
 */

public interface ShowView {
    void onFiled(String string);
    void addDatas(ArrayList<ShowBean.BodyBean.ResultBean> result);
}
