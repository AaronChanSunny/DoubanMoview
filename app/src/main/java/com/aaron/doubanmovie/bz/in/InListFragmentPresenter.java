package com.aaron.doubanmovie.bz.in;


import java.util.List;

import me.aaron.dao.model.Movie;

/**
 * Created by Chenll on 2016/10/13.
 */

public interface InListFragmentPresenter {

    void fetchMovies(String city);

    void fetchMoreMovies(String city);

    void onDestroy();

    interface IView {

        /**
         * 显示进度条
         */
        void showProgressBar();

        /**
         * 隐藏进度条
         */
        void hideProgressBar();

        /**
         * 刷新列表
         * @param movies 电影列表
         */
        void refreshMovies(List<Movie> movies);

        /**
         * 新增下拉刷新进度条
         */
        void addRefreshProgress();

        /**
         * 移除下拉刷新进度条
         */
        void removeRefreshProgress();

        /**
         * 获取列表项个数
         * @return 个数
         */
        int getItemsCount();

        /**
         * 列表加载更多的电影
         * @param currentSize
         * @param movies 新增的电影数据
         */
        void loadMoreMovies(int currentSize, List<Movie> movies);
    }

}
