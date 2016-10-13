package com.aaron.doubanmovie.detail;

import android.content.Context;

import com.aaron.doubanmovie.common.ExceptionHandler;
import com.aaron.doubanmovie.util.LogUtil;

import java.util.List;
import java.util.Random;

import me.aaron.dao.api.Api;
import me.aaron.dao.model.Movie;
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
public class MovieDetailActivityPresenterImpl implements MovieDetailActivityPresenter {

    private Context mContext;
    private Api mApi;
    private IView mView;
    private CompositeSubscription mAllSubscription;

    public MovieDetailActivityPresenterImpl(Context context, IView view, Api api) {
        mContext = context;
        mView = view;
        mApi = api;

        mAllSubscription = new CompositeSubscription();
    }

    @Override
    public void fetchMovieDetail(String id) {
        mView.showProgressBar();

        Subscription subscription = mApi.getMovie(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Movie>() {
                    @Override
                    public void call(Movie movie) {
                        mView.hideProgressBar();

                        mView.setSummary(movie.getSummary());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        LogUtil.error(TAG, "fetchMovieDetail", throwable);
                        ExceptionHandler.handleHttpException(mContext, (HttpException) throwable);
                    }
                });
        mAllSubscription.add(subscription);
    }

    @Override
    public void fetchMoviePhotos(String id, int count) {
        mApi.getMoviePhotos(id, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> photos) {
                        if (photos.size() == 0) {
                            mView.showEmptyView();
                            return;
                        }

                        mView.refreshPhotos(photos);

                        String randomPhoto = photos.get(new Random().nextInt(photos.size()));
                        mView.loadBackDrop(randomPhoto);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        LogUtil.error(TAG, "fetchMoviePhotos", throwable);
                        ExceptionHandler.handleHttpException(mContext, (HttpException) throwable);

                        mView.showEmptyView();
                    }
                });
    }

    @Override
    public void onDestroy() {
        if (!mAllSubscription.isUnsubscribed()) {
            mAllSubscription.unsubscribe();
        }
    }

}
