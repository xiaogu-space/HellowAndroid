package com.xiaogu.mvp.press;

import com.google.gson.JsonElement;
import com.xiaogu.mvp.view.MainView;
import com.xiaogu.retrofit.ApiCallback;

import rx.internal.util.ObserverSubscriber;

/**
 * Created by xg on 2016/10/21.
 */
public class MainPressenter extends BasePresenter<MainView> {
    public MainPressenter(MainView view) {
        attachView(view);
    }

    public void getApi() {
        mvpView.showLoading();
        addSubscription(apiService.getApi(), new ObserverSubscriber(new ApiCallback<JsonElement>() {
            @Override
            public void onSuccess(JsonElement model) {
                mvpView.getDataSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        }));
    }
}
