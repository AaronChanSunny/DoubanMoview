package com.aaron.doubanmovie.presenter;

import android.content.Context;
import android.view.View;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.bus.EventBus;
import com.aaron.doubanmovie.bus.event.DoubanApiExceptionEvent;
import com.aaron.doubanmovie.bus.event.GetInTheatersSuccessEvent;
import com.aaron.doubanmovie.model.InTheaters;
import com.aaron.doubanmovie.network.DoubanApi;
import com.aaron.doubanmovie.util.Logger;
import com.aaron.doubanmovie.view.core.MoviesView;
import com.aaron.doubanmovie.view.fragment.MoviesFragment;
import com.squareup.otto.Subscribe;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Git on 2016/1/23.
 */
public class MoviesPresenterImpl implements MoviesPresenter {

    private static final Logger logger = new Logger(MoviesPresenterImpl.class);

    private EventBus mBus;
    private DoubanApi mDoubanApi;
    private MoviesView mView;
    private Context mContext;

    @Inject
    public MoviesPresenterImpl(DoubanApi doubanApi, MoviesView view, EventBus bus) {
        mDoubanApi = doubanApi;
        mView = view;
        mBus = bus;
        mContext = ((MoviesFragment)view).getActivity();
    }

    @Override
    public void resume() {
        mBus.register(this);
        mView.initialize();
    }

    @Override
    public void pause() {
        mBus.unregister(this);
    }

    @Override
    public void destroy() {
        // TODO: 2016/1/23
    }

    @Override
    public void fetchMovies() {
        mView.showProgressBar();
        mDoubanApi.getInTheaters("福州");
    }

    @Override
    public void onFabClick(View view) {
        mView.showToast(mContext.getString(R.string.refresh_list));

        fetchMovies();
    }

    @Subscribe
    public void getInTheatersSuccess(GetInTheatersSuccessEvent event) {
        logger.debug("get in_theaters movies success.");

        List<InTheaters.Movie> movies = event.mMovies;
        mView.refreshMovies(movies);
        mView.hideProgressBar();
    }

    @Subscribe
    public void doubanApiExceptionEvent(DoubanApiExceptionEvent event) {
        logger.error(event.mException);
    }

}
