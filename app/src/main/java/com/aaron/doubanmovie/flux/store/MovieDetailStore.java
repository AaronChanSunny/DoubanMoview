package com.aaron.doubanmovie.flux.store;

import com.aaron.doubanmovie.bus.EventBus;
import com.aaron.doubanmovie.flux.action.Action;
import com.aaron.doubanmovie.flux.action.MovieDetailAction;
import com.aaron.doubanmovie.network.model.Movie;
import com.squareup.otto.Subscribe;

/**
 * Created by Aaron on 2016/1/31.
 */
public class MovieDetailStore extends Store {

    private Movie mMovie;
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

    public Movie getMovie() {
        return mMovie;
    }

    @Subscribe
    @Override
    public void onAction(Action action) {
        switch (action.getType()) {
            case MovieDetailAction.ACTION_FETCH_MOVIE_DETAIL_SUCCESS:
                mMovie = (Movie) action.getData();
                break;
            case MovieDetailAction.ACTION_START_FETCH_MOVIE_DETAIL:
                mIsProgressBarShown = true;
                mIsLoaded = false;
                break;
            case MovieDetailAction.ACTION_END_FETCH_MOVIE_DETAIL:
                mIsProgressBarShown = false;
                mIsLoaded = true;
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
