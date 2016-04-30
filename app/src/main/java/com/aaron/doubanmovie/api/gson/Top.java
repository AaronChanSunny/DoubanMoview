package com.aaron.doubanmovie.api.gson;

import com.aaron.doubanmovie.model.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aaronchan on 16/4/30.
 */
public class Top extends BaseResponse {
    @SerializedName("subjects")
    private List<Movie> mMovies;

    public List<Movie> getMovies() {
        return mMovies;
    }

    public void setMovies(List<Movie> movies) {
        mMovies = movies;
    }
}
