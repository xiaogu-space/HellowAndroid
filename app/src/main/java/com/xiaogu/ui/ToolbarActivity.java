package com.xiaogu.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.xiaogu.R;
import com.xiaogu.utils.ToastUtils;

import butterknife.BindView;

/**
 * toobar 的用法
 */
public class ToolbarActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbarTb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toobar);
        setSupportActionBar(mToolbarTb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//设置返回按钮

        mToolbarTb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {//menu的点击事件
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
//                    case R.id.t1:
//                        ToastUtils.showShortToast(ToolbarActivity.this, "点击了t1");
//                        break;
//                    case R.id.t2:
//                        ToastUtils.showShortToast(ToolbarActivity.this, "点击了t2");
//                        break;
////                    case R.id.t3:
////                        ToastUtils.showShortToast(ToolbarActivity.this, "点击了t3");
////                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//菜单监听
        switch (item.getItemId()) {
            case R.id.action_search:
                ToastUtils.showShortToast(ToolbarActivity.this, "点击了搜索");
                break;
            case R.id.action_set:
                ToastUtils.showShortToast(ToolbarActivity.this, "点击了设置");
                break;
            case android.R.id.home://左上角的返回键
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
