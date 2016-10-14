package com.aaron.doubanmovie.bz.photo;

import java.util.List;

/**
 * Created by Chenll on 2016/10/13.
 */

public interface PhotoWallActivityPresenter {

    /**
     * 获取所有的照片
     * @param id 电影Id
     */
    void fetchAllPhotos(String id);

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
         * 显示照片墙
         * @param photos 所有照片
         */
        void showAllPhotos(List<String> photos);
    }

}
