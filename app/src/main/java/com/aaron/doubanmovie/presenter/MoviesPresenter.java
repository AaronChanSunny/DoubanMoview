package com.aaron.doubanmovie.presenter;

/**
 * Created by Git on 2016/1/23.
 */
public interface MoviesPresenter extends Presenter {

    /**
     * 从服务器拉取电影信息
     */
    void fetchMovies();

}
