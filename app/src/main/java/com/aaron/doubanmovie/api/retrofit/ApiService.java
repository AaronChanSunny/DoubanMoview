package com.aaron.doubanmovie.api.retrofit;


import com.aaron.doubanmovie.api.model.InTheaters;
import com.aaron.doubanmovie.api.model.Movie;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Git on 2016/1/23.
 */
public interface ApiService {

    @GET("/v2/movie/in_theaters")
    Observable<InTheaters> getInTheaters(@Query("city") String city);

    @GET("/v2/movie/subject/{id}")
    Observable<Movie> getMovie(@Path("id") String id);
}
