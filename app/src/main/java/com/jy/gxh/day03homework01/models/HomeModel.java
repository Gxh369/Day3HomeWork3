package com.jy.gxh.day03homework01.models;

import android.util.Log;

import com.jy.gxh.day03homework01.ApiServer;
import com.jy.gxh.day03homework01.beans.HomeBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GXH on 2019/9/22.
 */

public class HomeModel {
    private static final String TAG = "HomeModel";
    private MyCallBack myCallBack;

    public HomeModel(MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }

    public void setDatas() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServer.HOME_DATA_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        apiServer.getHomeBean().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        ArrayList<HomeBean.BodyBean.ResultBean> result = (ArrayList<HomeBean.BodyBean.ResultBean>) homeBean.getBody().getResult();
                        myCallBack.onSucceed(result);


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: "+e.getMessage());
                        myCallBack.onField("请求错误");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface MyCallBack{
        void onSucceed(ArrayList<HomeBean.BodyBean.ResultBean> result);
        void onField(String string);
    }

}
