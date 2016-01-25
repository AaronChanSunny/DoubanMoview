package com.aaron.doubanmovie.network;

import com.aaron.doubanmovie.model.InTheaters;
import com.aaron.doubanmovie.model.Movie;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Git on 2016/1/23.
 */
public class DoubanApi {

    private Retrofit mRetrofit;
    private DoubanApiService mDoubanApiService;

    @Inject
    public DoubanApi(Retrofit retrofit) {
        mRetrofit = retrofit;
        mDoubanApiService = mRetrofit.create(DoubanApiService.class);
    }

    public Subscription getInTheaters(String city, Action1<? super InTheaters> response, Action1<Throwable> throwable) {
        Observable<InTheaters> call = mDoubanApiService.getInTheaters(city);

        return call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response, throwable);
    }

    public Subscription getMovie(String id, Action1<? super Movie> response, Action1<Throwable> throwable) {
        Observable<Movie> call = mDoubanApiService.getMovie(id);

        return call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response, throwable);
    }
}
