package com.aaron.doubanmovie.di.module;

import com.aaron.doubanmovie.di.scope.FragmentScope;
import com.aaron.doubanmovie.network.DoubanApi;
import com.aaron.doubanmovie.presenter.MoviesPresenter;
import com.aaron.doubanmovie.presenter.MoviesPresenterImpl;
import com.aaron.doubanmovie.view.adapter.MoviesAdapter;
import com.aaron.doubanmovie.view.fragment.MoviesFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Git on 2016/1/23.
 */
@Module
public class MoviesFragmentModule {

    private MoviesFragment mFragment;

    public MoviesFragmentModule(MoviesFragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @FragmentScope
    MoviesPresenter provideMoviesPresenter(DoubanApi doubanApi) {
        return new MoviesPresenterImpl(doubanApi, mFragment);
    }

    @Provides
    @FragmentScope
    MoviesAdapter provideMoviesAdapter() {
        return new MoviesAdapter(mFragment.getActivity());
    }
}
