package com.aaron.doubanmovie.flux.store;

import com.aaron.doubanmovie.flux.action.Action;
import com.aaron.doubanmovie.flux.action.MoviesAction;
import com.aaron.doubanmovie.bus.EventBus;
import com.aaron.doubanmovie.network.model.InTheaters;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 2016/1/31.
 */
public class MoviesStore extends Store {

    private List<InTheaters.Movie> mMovies;
    private boolean mIsProgressBarShown = false;
    private boolean mIsLoaded = false;

    public MoviesStore(EventBus bus) {
        mBus = bus;
        mMovies = new ArrayList<>();
    }

    public List<InTheaters.Movie> getMovies() {
        return mMovies;
    }

    public boolean isProgressBarShown() {
        return mIsProgressBarShown;
    }

    public boolean isLoaded() {
        return mIsLoaded;
    }

    @Subscribe
    @Override
    public void onAction(Action action) {
        switch (action.getType()) {
            case MoviesAction.ACTION_START_FETCH_MOVIES:
                mIsProgressBarShown = true;
                mIsLoaded = false;
                break;
            case MoviesAction.ACTION_FETCH_MOVIES_SUCCESS:
                mMovies = (List<InTheaters.Movie>) action.getData();
                break;
            case MoviesAction.ACTION_END_FETCH_MOVIES:
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
