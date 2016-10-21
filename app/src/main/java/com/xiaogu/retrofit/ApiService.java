package com.xiaogu.retrofit;

import com.google.gson.JsonElement;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by xg on 2016/6/24.
 */
public interface ApiService {
    /**
     * 得到首页的config
     *
     * @return
     */
    @GET("/")
    Observable<JsonElement> getApi();
}
