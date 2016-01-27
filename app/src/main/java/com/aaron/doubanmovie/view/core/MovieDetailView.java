package com.aaron.doubanmovie.view.core;

/**
 * Created by OA on 2016/1/25.
 */
public interface MovieDetailView extends View {

    void setSummary(String summary);

    void setDirectors(String directors);

    void setCasts(String casts);

    void showProgressBar();

    void hideProgressBar();
}
