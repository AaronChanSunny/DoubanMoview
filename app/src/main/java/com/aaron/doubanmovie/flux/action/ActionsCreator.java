package com.aaron.doubanmovie.flux.action;


import com.aaron.doubanmovie.flux.dispatcher.Dispatcher;
import com.aaron.doubanmovie.network.ApiService;
import com.aaron.doubanmovie.network.model.InTheaters;
import com.aaron.doubanmovie.network.model.Movie;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Aaron on 2016/1/31.
 */
public class ActionsCreator {

    private final Dispatcher mDispatcher;
    private Retrofit mRetrofit;
    private ApiService mApiService;

    @Inject
    public ActionsCreator(Dispatcher dispatcher, Retrofit retrofit) {
        mDispatcher = dispatcher;
        mRetrofit = retrofit;
        mApiService = mRetrofit.create(ApiService.class);
    }

    public void fetchMovies() {
        Observable<InTheaters> call = mApiService.getInTheaters("福州");

        mDispatcher.dispatch(new MoviesAction(MoviesAction.ACTION_START_FETCH_MOVIES));

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<InTheaters>() {
                    @Override
                    public void call(InTheaters inTheaters) {
                        mDispatcher.dispatch(new MoviesAction(MoviesAction.ACTION_FETCH_MOVIES_SUCCESS, inTheaters.getMovies()));
                        mDispatcher.dispatch(new MoviesAction(MoviesAction.ACTION_END_FETCH_MOVIES));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mDispatcher.dispatch(new MoviesAction(MoviesAction.ACTION_END_FETCH_MOVIES));
                    }
                });
    }

    public void fetchMovieDetail(String id) {
        Observable<Movie> call = mApiService.getMovie(id);

        mDispatcher.dispatch(new MovieDetailAction(MovieDetailAction.ACTION_START_FETCH_MOVIE_DETAIL));

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Movie>() {
                    @Override
                    public void call(Movie movie) {
                        mDispatcher.dispatch(new MovieDetailAction(MovieDetailAction.ACTION_FETCH_MOVIE_DETAIL_SUCCESS, movie));
                        mDispatcher.dispatch(new MovieDetailAction(MovieDetailAction.ACTION_END_FETCH_MOVIE_DETAIL));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mDispatcher.dispatch(new MovieDetailAction(MovieDetailAction.ACTION_END_FETCH_MOVIE_DETAIL));
                    }
                });
    }

}
