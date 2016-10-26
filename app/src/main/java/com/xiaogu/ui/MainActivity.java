package com.xiaogu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.xiaogu.R;
import com.xiaogu.mvp.other.MvpActivity;
import com.xiaogu.mvp.press.MainPressenter;
import com.xiaogu.mvp.view.MainView;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends MvpActivity<MainPressenter> implements MainView {
    @BindView(R.id.tv_content)
    TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected MainPressenter createPresenter() {
        return new MainPressenter(this);
    }

    @OnClick({R.id.btn_toolbar, R.id.btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_toolbar:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ToolbarActivity.class);
                startActivity(intent);
                break;
            case R.id.btn:
                mvpPresenter.getApi();
                break;
        }
    }

    @Override
    public void getDataSuccess(JsonElement string) {
        tv_content.setText(string.toString());
    }

    @Override
    public void getDataFail(String msg) {

    }
}
