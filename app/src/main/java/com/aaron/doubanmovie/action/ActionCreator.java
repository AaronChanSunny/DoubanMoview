package com.aaron.doubanmovie.action;


import com.aaron.doubanmovie.dispatcher.Dispatcher;
import com.aaron.doubanmovie.model.InTheaters;
import com.aaron.doubanmovie.network.DoubanApiService;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Aaron on 2016/1/31.
 */
public class ActionCreator {

    private final Dispatcher mDispatcher;
    private Retrofit mRetrofit;
    private DoubanApiService mDoubanApiService;

    @Inject
    public ActionCreator(Dispatcher dispatcher, Retrofit retrofit) {
        mDispatcher = dispatcher;
        mRetrofit = retrofit;
        mDoubanApiService = mRetrofit.create(DoubanApiService.class);
    }

    public void fetchMovies() {
        Observable<InTheaters> call = mDoubanApiService.getInTheaters("福州");

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<InTheaters>() {
                    @Override
                    public void call(InTheaters inTheaters) {
                        mDispatcher.dispatch(new MovieAction(MovieAction.ACTION_FETCH_MOVIES_SUCCESS, inTheaters));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }

}
