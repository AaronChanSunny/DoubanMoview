package com.aaron.doubanmovie.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by aaronchan on 16/5/2.
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * RxJava 队列
     */
    private List<Subscription> mSubscriptionList;

    protected abstract int getLayoutResId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);

        initData();

        initView();
    }

    @Override
    protected void onDestroy() {
        unSubscribeAll();
        super.onDestroy();
    }

    /**
     * 子类重写该方法，进行数据初始化
     */
    protected void initData() {
        mSubscriptionList = new ArrayList<>();
    }

    /**
     * 子类重写该方法，进行 View 初始化
     */
    protected void initView() {

    }

    /**
     * Fragment 中生成的所有 RxJava Subscription 都需要调用此方法添加到队列
     * @param subscription
     */
    protected void addSubscription(Subscription subscription) {
        mSubscriptionList.add(subscription);
    }

    /**
     * 对所有 Subscription 取消订阅
     */
    private void unSubscribeAll() {
        for (Subscription subscription : mSubscriptionList) {
            if (!subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }
}
