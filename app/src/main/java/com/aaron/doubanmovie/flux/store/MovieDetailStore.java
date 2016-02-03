package com.aaron.doubanmovie.flux.store;

import com.aaron.doubanmovie.bus.EventBus;
import com.aaron.doubanmovie.flux.action.Action;
import com.aaron.doubanmovie.flux.action.MovieDetailAction;
import com.aaron.doubanmovie.network.model.Movie;
import com.aaron.doubanmovie.util.StringUtil;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 2016/1/31.
 */
public class MovieDetailStore extends Store {

    private String mSummary;
    private String mDirectors;
    private String mCasts;
    private boolean mIsProgressBarShown = false;
    private boolean mIsLoaded = false;

    public MovieDetailStore(EventBus bus) {
        mBus = bus;
    }

    public boolean isProgressBarShown() {
        return mIsProgressBarShown;
    }

    public boolean isLoaded() {
        return mIsLoaded;
    }

    public String getSummary() {
        return mSummary;
    }

    public String getDirectors() {
        return mDirectors;
    }

    public String getCasts() {
        return mCasts;
    }

    @Subscribe
    @Override
    public void onAction(Action action) {
        switch (action.getType()) {
            case MovieDetailAction.ACTION_FETCH_MOVIE_DETAIL_SUCCESS:
                Movie movie = (Movie) action.getData();

                mSummary = movie.getSummary();

                List<String> directories = new ArrayList<>();
                for (Movie.Director director : movie.getDirectors()) {
                    directories.add(director.getName());
                }
                mDirectors = StringUtil.formatStringList(directories);

                List<String> casts = new ArrayList<>();
                for (Movie.Cast cast : movie.getCasts()) {
                    casts.add(cast.getName());
                }
                mCasts = StringUtil.formatStringList(casts);

                mIsLoaded = true;
                break;
            case MovieDetailAction.ACTION_START_FETCH_MOVIE_DETAIL:
                mIsProgressBarShown = true;
                break;
            case MovieDetailAction.ACTION_END_FETCH_MOVIE_DETAIL:
                mIsProgressBarShown = false;
                break;
            default:
                break;
        }

        emitStoreChange();
    }

    @Override
    public StoreChangeEvent changeEvent() {
        return new StoreChangeEvent();
    }

}
