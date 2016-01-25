package com.aaron.doubanmovie.view.core;

import com.aaron.doubanmovie.model.InTheaters;

import java.util.List;

/**
 * Created by Git on 2016/1/23.
 */
public interface MoviesView extends View {

    /**
     * 刷新电影列表
     * @param movies
     */
    void refreshMovies(List<InTheaters.Movie> movies);

    void showToast(String msg);

    /**
     * 显示进度条
     */
    void showProgressBar();

    /**
     * 隐藏进度条
     */
    void hideProgressBar();

}
