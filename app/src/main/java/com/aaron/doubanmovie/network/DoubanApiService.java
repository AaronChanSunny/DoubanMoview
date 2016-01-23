package com.aaron.doubanmovie.network;

import com.aaron.doubanmovie.model.InTheaters;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Git on 2016/1/23.
 */
public interface DoubanApiService {

    @GET("/v2/movie/in_theaters")
    Observable<InTheaters> getInTheaters(@Query("city") String city);

}
