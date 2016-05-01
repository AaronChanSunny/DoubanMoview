package com.aaron.doubanmovie.api.retrofit;


import com.aaron.doubanmovie.api.gson.ComingSoon;
import com.aaron.doubanmovie.api.gson.InTheater;
import com.aaron.doubanmovie.api.gson.Top;
import com.aaron.doubanmovie.model.Movie;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Git on 2016/1/23.
 */
public interface ApiService {

    @GET("/v2/movie/in_theaters")
    Observable<InTheater> getInTheaters(@Query("city") String city, @Query("start") int start, @Query("count") int count);

    @GET("/v2/movie/subject/{id}")
    Observable<Movie> getMovie(@Path("id") String id);

    @GET("/v2/movie/coming_soon")
    Observable<ComingSoon> getComingSoon(@Query("start") int start, @Query("count") int count);

    @GET("/v2/movie/top250")
    Observable<Top> getTop(@Query("start") int start, @Query("count") int count);
}
