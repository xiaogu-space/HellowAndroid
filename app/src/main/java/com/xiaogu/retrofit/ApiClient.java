package com.xiaogu.retrofit;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xg on 2016/6/24.
 */
public class ApiClient {
    public static final String BASE_TRC_URL = "https://api.github.com";
    private static Retrofit retrofit = null;

    public static ApiService createApiService() {
        if (retrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

            builder.addNetworkInterceptor(new StethoInterceptor());//facebook抓包
            OkHttpClient client = builder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_TRC_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return retrofit.create(ApiService.class);
    }


}
