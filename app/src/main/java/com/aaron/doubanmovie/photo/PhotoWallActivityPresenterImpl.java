package com.aaron.doubanmovie.photo;

import android.content.Context;

import com.aaron.doubanmovie.util.LogUtil;

import java.util.List;

import me.aaron.dao.api.Api;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import static android.content.ContentValues.TAG;

/**
 * Created by Chenll on 2016/10/13.
 */
public class PhotoWallActivityPresenterImpl implements PhotoWallActivityPresenter {

    private Context mContext;
    private Api mApi;

    private IView mView;
    private CompositeSubscription mAllSubscription;

    public PhotoWallActivityPresenterImpl(Context context, IView view, Api api) {
        mContext = context;
        mView = view;
        mApi = api;

        mAllSubscription = new CompositeSubscription();
    }

    @Override
    public void fetchAllPhotos(String id) {
        mView.showProgressBar();

        Subscription subscription = mApi.getMoviePhotos(id, Integer.MAX_VALUE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> photos) {
                        mView.hideProgressBar();
                        mView.showAllPhotos(photos);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        LogUtil.error(TAG, "fetchAllPhotos", throwable);
                        mView.hideProgressBar();
                    }
                });
        mAllSubscription.add(subscription);
    }

    @Override
    public void onDestroy() {
        if (!mAllSubscription.isUnsubscribed()) {
            mAllSubscription.unsubscribe();
        }
    }

}
