package com.aaron.doubanmovie.presenter;

import android.view.View;

/**
 * Created by Git on 2016/1/23.
 */
public interface MoviesPresenter extends Presenter {

    /**
     * 从服务器拉取电影信息
     */
    void fetchMovies();

    /**
     * 处理Fab点击事件
     */
    void onFabClick(View view);
}
