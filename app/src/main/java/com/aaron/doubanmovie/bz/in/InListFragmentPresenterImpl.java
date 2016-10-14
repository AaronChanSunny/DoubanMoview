package com.aaron.doubanmovie.bz.in;

import android.content.Context;

import com.aaron.doubanmovie.common.ExceptionHandler;
import com.aaron.doubanmovie.util.LogUtil;

import me.aaron.dao.api.Api;
import me.aaron.dao.api.gson.InTheater;
import retrofit2.HttpException;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import static android.content.ContentValues.TAG;

/**
 * Created by Chenll on 2016/10/13.
 */
public class InListFragmentPresenterImpl implements InListFragmentPresenter {

    private Context mContext;
    private Api mApi;
    private IView mView;
    private CompositeSubscription mAllSubscription;

    public InListFragmentPresenterImpl(Context context, IView view, Api api) {
        mContext = context;
        mView = view;
        mApi = api;

        mAllSubscription = new CompositeSubscription();
    }

    @Override
    public void fetchMovies(String city) {
        Subscription subscription = mApi.getInTheaters(city, 0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<InTheater>() {
                    @Override
                    public void call(InTheater inTheater) {
                        mView.hideProgressBar();
                        mView.refreshMovies(inTheater.getMovies());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        LogUtil.error(TAG, "fetchMovies", throwable);
                        if (throwable instanceof HttpException) {
                            ExceptionHandler.handleHttpException(mContext, (HttpException) throwable);
                        }
                    }
                });
        mAllSubscription.add(subscription);
    }

    @Override
    public void fetchMoreMovies(String city) {
        mView.addRefreshProgress();

        final int currentSize = mView.getItemsCount();

        Subscription subscription = mApi.getInTheaters(city, currentSize, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<InTheater>() {
                    @Override
                    public void call(InTheater inTheater) {
                        mView.removeRefreshProgress();
                        mView.loadMoreMovies(currentSize, inTheater.getMovies());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        LogUtil.error(TAG, "fetchMoreMovies", throwable);
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
