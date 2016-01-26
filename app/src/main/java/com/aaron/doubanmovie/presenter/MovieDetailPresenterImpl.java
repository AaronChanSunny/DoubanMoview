package com.aaron.doubanmovie.presenter;

import com.aaron.doubanmovie.bus.EventBus;
import com.aaron.doubanmovie.bus.event.DoubanApiExceptionEvent;
import com.aaron.doubanmovie.bus.event.GetMovieSuccessEvent;
import com.aaron.doubanmovie.model.Movie;
import com.aaron.doubanmovie.network.DoubanApi;
import com.aaron.doubanmovie.util.Logger;
import com.aaron.doubanmovie.view.core.MovieDetailView;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

/**
 * Created by OA on 2016/1/26.
 */
public class MovieDetailPresenterImpl implements MovieDetailPresenter {

    private static final Logger logger = new Logger(MovieDetailPresenterImpl.class);

    private DoubanApi mDoubanApi;
    private EventBus mBus;
    private MovieDetailView mView;

    @Inject
    public MovieDetailPresenterImpl(DoubanApi doubanApi, EventBus bus, MovieDetailView view) {
        mDoubanApi = doubanApi;
        mBus = bus;
        mView = view;
    }

    @Override
    public void fetchMovieDetail(String movieId) {
        mDoubanApi.getMovie(movieId);
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
        // TODO: 2016/1/26
    }

    @Subscribe
    public void getMovieSuccess(GetMovieSuccessEvent event) {
        logger.debug("fetch movie detail success.");

        Movie movie = event.mMovie;

        mView.setBackDrop(movie.getImages().getLarge());
        mView.setSummary(movie.getSummary());
    }

    @Subscribe
    public void doubanApiException(DoubanApiExceptionEvent event) {
        logger.error(event.mException);
    }

}
