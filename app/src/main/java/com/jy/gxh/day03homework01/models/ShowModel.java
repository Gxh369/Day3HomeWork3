package com.jy.gxh.day03homework01.models;

import android.util.Log;

import com.jy.gxh.day03homework01.ApiServer;
import com.jy.gxh.day03homework01.beans.ShowBean;

import java.lang.reflect.Array;
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

public class ShowModel {
    private MyCallBack myCallBack;

    public ShowModel(MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }

    private static final String TAG = "ShowModel";

    public void setDatas(int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServer.SHOW_DATA_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        apiServer.getShowBean(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShowBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShowBean showBean) {
                        ArrayList<ShowBean.BodyBean.ResultBean> result = (ArrayList<ShowBean.BodyBean.ResultBean>) showBean.getBody().getResult();
                        myCallBack.onSucceed(result);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: "+e.getMessage());
                        myCallBack.onFiled("请求错误,请检查网络");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface MyCallBack{
        void onFiled(String string);
        void onSucceed(ArrayList<ShowBean.BodyBean.ResultBean> result);
    }
}
