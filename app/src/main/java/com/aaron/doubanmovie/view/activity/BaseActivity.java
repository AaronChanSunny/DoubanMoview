package com.aaron.doubanmovie.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.aaron.doubanmovie.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by OA on 2016/2/3.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        di();

        initData();

        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    /**
     * 初始化Data，子类如果需要初始化Data，重写该方法
     */
    protected void initData() {
        // TODO: 2016/2/3
    }

    /**
     * 初始化View，子类如果需要初始化View，重写该方法
     */
    protected void initViews() {
        if (mToolbar != null) {
            // enable toolbar
            setSupportActionBar(mToolbar);
        } else {
            throw new RuntimeException(this.toString()
                    + " must contain toolbar.");
        }
    }

    /**
     * 依赖注入，交给子类
     */
    protected abstract void di();

    /**
     * 指定布局Id，交给子类
     *
     * @return
     */
    protected abstract int getLayoutResId();

}
