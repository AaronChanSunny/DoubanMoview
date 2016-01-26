package com.aaron.doubanmovie.di.module;

import com.aaron.doubanmovie.bus.EventBus;
import com.aaron.doubanmovie.di.scope.FragmentScope;
import com.aaron.doubanmovie.network.DoubanApi;
import com.aaron.doubanmovie.presenter.MovieDetailPresenter;
import com.aaron.doubanmovie.presenter.MovieDetailPresenterImpl;
import com.aaron.doubanmovie.view.fragment.MovieDetailFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by OA on 2016/1/26.
 */
@Module
public class MovieDetailFragmentModule {

    MovieDetailFragment mFragment;

    public MovieDetailFragmentModule(MovieDetailFragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @FragmentScope
    MovieDetailPresenter provideMovieDetailPresenter(DoubanApi doubanApi, EventBus bus) {
        return new MovieDetailPresenterImpl(doubanApi, bus, mFragment);
    }

}
