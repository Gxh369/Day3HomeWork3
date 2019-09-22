package com.jy.gxh.day03homework01;

import com.jy.gxh.day03homework01.beans.HomeBean;
import com.jy.gxh.day03homework01.beans.ShowBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by GXH on 2019/9/22.
 */

public interface ApiServer {
    String HOME_DATA_URL="https://api.yunxuekeji.cn/";
    @GET("yunxue_app_api/content/getData/30/66597/1/10")
    Observable<HomeBean> getHomeBean();

    String SHOW_DATA_URL="https://api.yunxuekeji.cn/";
    @GET("yunxue_app_api/teacher/getTeacherPower/{path}")
    Observable<ShowBean> getShowBean(@Path("path") int id);


}
