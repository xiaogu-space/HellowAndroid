package com.xiaogu.mvp.view;

import com.google.gson.JsonElement;

/**
 * Created by xg on 2016/10/21.
 */

public interface MainView extends BaseView {
    void getDataSuccess(JsonElement string);

    void getDataFail(String msg);
}
