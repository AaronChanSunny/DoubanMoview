package com.aaron.doubanmovie.bz.detail;

import java.util.List;

/**
 * Created by Chenll on 2016/10/13.
 */

public interface MovieDetailActivityPresenter {

    /**
     * 获取电影详情
     * @param id 电影Id
     */
    void fetchMovieDetail(String id);

    /**
     * 获取电影剧照
     * @param id 电影Id
     * @param count 数量
     */
    void fetchMoviePhotos(String id, int count);

    /**
     * 销毁
     */
    void onDestroy();

    interface IView {

        /**
         * 展开剧情梗概
         */
        void expandSummaryText();

        /**
         * 缩起剧情梗概
         */
        void collapseSummaryText();

        /**
         * 显示进度条
         */
        void showProgressBar();

        /**
         * 隐藏进度条
         */
        void hideProgressBar();

        /**
         * 设置剧情梗概
         * @param summary 剧情梗概
         */
        void setSummary(String summary);

        /**
         * 显示空视图
         */
        void showEmptyView();

        /**
         * 刷新剧照
         * @param photos
         */
        void refreshPhotos(List<String> photos);

        /**
         * 设置背景图
         * @param photo 背景图
         */
        void loadBackDrop(String photo);

    }

}
