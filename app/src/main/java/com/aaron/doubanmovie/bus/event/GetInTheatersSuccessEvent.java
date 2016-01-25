package com.aaron.doubanmovie.bus.event;

import com.aaron.doubanmovie.model.InTheaters;

import java.util.List;

/**
 * Created by OA on 2016/1/25.
 */
public class GetInTheatersSuccessEvent {

    public final List<InTheaters.Movie> mMovies;

    public GetInTheatersSuccessEvent(List<InTheaters.Movie> movies) {
        mMovies = movies;
    }

}
