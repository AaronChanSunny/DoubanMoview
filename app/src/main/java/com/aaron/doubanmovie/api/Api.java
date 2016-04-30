package com.aaron.doubanmovie.api;

import com.aaron.doubanmovie.api.model.ComingSoon;
import com.aaron.doubanmovie.api.model.InTheaters;
import com.aaron.doubanmovie.api.model.Movie;
import com.aaron.doubanmovie.api.model.Top;

import rx.Observable;

/**
 * Created by aaronchan on 16/4/22.
 */
public interface Api {
    Observable<InTheaters> getInTheaters(String city);

    Observable<Movie> getMovie(String id);

    Observable<ComingSoon> getComingSoon(int start, int count);

    Observable<Top> getTop(int start, int count);
}
