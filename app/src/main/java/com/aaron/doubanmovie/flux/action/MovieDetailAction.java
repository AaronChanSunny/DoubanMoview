package com.aaron.doubanmovie.flux.action;

import com.aaron.doubanmovie.network.model.Movie;

/**
 * Created by Aaron on 2016/1/31.
 */
public class MovieDetailAction extends Action<Movie> {

    public static final String ACTION_FETCH_MOVIE_DETAIL_SUCCESS = "fetch_movie_detail_success";
    public static final String ACTION_FETCH_MOVIE_DETAIL_FAIL = "fetch_movie_detail_fail";
    public static final String ACTION_START_FETCH_MOVIE_DETAIL = "start_fetch_movie_detail";
    public static final String ACTION_END_FETCH_MOVIE_DETAIL = "end_fetch_movie_detail";

    public MovieDetailAction(String type, Movie movie) {
        super(type, movie);
    }

    public MovieDetailAction(String type) {
        super(type, null);
    }

}
