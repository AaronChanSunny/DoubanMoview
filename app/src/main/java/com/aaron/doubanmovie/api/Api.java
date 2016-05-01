package com.aaron.doubanmovie.api;

import com.aaron.doubanmovie.api.gson.ComingSoon;
import com.aaron.doubanmovie.api.gson.InTheater;
import com.aaron.doubanmovie.api.gson.Top;
import com.aaron.doubanmovie.model.Movie;

import java.util.List;

import rx.Observable;

/**
 * Created by aaronchan on 16/4/22.
 */
public interface Api {
    Observable<InTheater> getInTheaters(String city, int start, int count);

    Observable<Movie> getMovie(String id);

    Observable<ComingSoon> getComingSoon(int start, int count);

    Observable<Top> getTop(int start, int count);

    Observable<List<String>> getMoviePhotos(String id);

    Observable<String> getRandomMoviePhoto(String id);
}
