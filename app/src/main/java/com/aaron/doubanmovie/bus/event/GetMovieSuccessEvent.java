package com.aaron.doubanmovie.bus.event;

import com.aaron.doubanmovie.model.Movie;

/**
 * Created by OA on 2016/1/25.
 */
public class GetMovieSuccessEvent {

    public final Movie mMovie;

    public GetMovieSuccessEvent(Movie movie) {
        mMovie = movie;
    }

}
