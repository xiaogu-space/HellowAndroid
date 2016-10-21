package com.xiaogu.ui;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by xg on 2016/10/21.
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}