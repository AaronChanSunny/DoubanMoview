package com.aaron.doubanmovie.network;

import com.aaron.doubanmovie.bus.EventBus;
import com.aaron.doubanmovie.bus.event.DoubanApiExceptionEvent;
import com.aaron.doubanmovie.bus.event.GetInTheatersSuccessEvent;
import com.aaron.doubanmovie.bus.event.GetMovieSuccessEvent;
import com.aaron.doubanmovie.model.InTheaters;
import com.aaron.doubanmovie.model.Movie;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Git on 2016/1/23.
 */
public class DoubanApi {

    private Retrofit mRetrofit;
    private EventBus mBus;
    private DoubanApiService mDoubanApiService;

    @Inject
    public DoubanApi(Retrofit retrofit, EventBus bus) {
        mRetrofit = retrofit;
        mBus = bus;
        mDoubanApiService = mRetrofit.create(DoubanApiService.class);
    }

    public void getInTheaters(String city) {
        Observable<InTheaters> call = mDoubanApiService.getInTheaters(city);

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<InTheaters>() {
                    @Override
                    public void call(InTheaters inTheaters) {
                        mBus.post(new GetInTheatersSuccessEvent(inTheaters.getMovies()));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mBus.post(new DoubanApiExceptionEvent(new DoubanApiException(throwable)));
                    }
                });
    }

    public void getMovie(String id) {
        Observable<Movie> call = mDoubanApiService.getMovie(id);

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Movie>() {
                    @Override
                    public void call(Movie movie) {
                        mBus.post(new GetMovieSuccessEvent(movie));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mBus.post(new DoubanApiExceptionEvent(new DoubanApiException(throwable)));
                    }
                });
    }
}
