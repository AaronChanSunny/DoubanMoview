package com.aaron.doubanmovie.flux.action;

import com.aaron.doubanmovie.network.model.InTheaters;

import java.util.List;

/**
 * Created by Aaron on 2016/1/31.
 */
public class MoviesAction extends Action<List<InTheaters.Movie>> {

    public static final String ACTION_FETCH_MOVIES_SUCCESS = "fetch_movies_success";
    public static final String ACTION_FETCH_MOVIES_FAIL = "fetch_movies_fail";
    public static final String ACTION_START_FETCH_MOVIES = "start_fetch_movies";
    public static final String ACTION_END_FETCH_MOVIES = "end_fetch_movies";

    public MoviesAction(String type, List<InTheaters.Movie> movies) {
        super(type, movies);
    }

    public MoviesAction(String type) {
        super(type, null);
    }

}
