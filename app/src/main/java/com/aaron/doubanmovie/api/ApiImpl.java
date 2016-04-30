package com.aaron.doubanmovie.api;

import android.content.Context;

import com.aaron.doubanmovie.api.gson.ComingSoon;
import com.aaron.doubanmovie.api.gson.InTheater;
import com.aaron.doubanmovie.api.gson.Top;
import com.aaron.doubanmovie.api.retrofit.ApiService;
import com.aaron.doubanmovie.api.retrofit.RetrofitProvider;
import com.aaron.doubanmovie.model.Movie;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by aaronchan on 16/4/22.
 */
public class ApiImpl implements Api {
    private static ApiImpl sInstance;

    private ApiService mApiService;

    public static ApiImpl getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new ApiImpl(context);
        }
        return sInstance;
    }

    private ApiImpl(Context context) {
        Retrofit retrofit = RetrofitProvider.getInstance(context).getRetrofit();
        mApiService = retrofit.create(ApiService.class);
    }

    @Override
    public Observable<InTheater> getInTheaters(String city) {
        return mApiService.getInTheaters(city);
    }

    @Override
    public Observable<Movie> getMovie(String id) {
        return mApiService.getMovie(id);
    }

    @Override
    public Observable<ComingSoon> getComingSoon(int start, int count) {
        return mApiService.getComingSoon(start, count);
    }

    @Override
    public Observable<Top> getTop(int start, int count) {
        return mApiService.getTop(start, count);
    }

}
