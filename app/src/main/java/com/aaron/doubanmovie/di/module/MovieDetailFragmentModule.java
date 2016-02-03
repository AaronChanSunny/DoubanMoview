package com.aaron.doubanmovie.di.module;

import com.aaron.doubanmovie.bus.EventBus;
import com.aaron.doubanmovie.di.scope.FragmentScope;
import com.aaron.doubanmovie.flux.action.ActionsCreator;
import com.aaron.doubanmovie.flux.dispatcher.Dispatcher;
import com.aaron.doubanmovie.flux.store.MovieDetailStore;
import com.aaron.doubanmovie.view.fragment.MovieDetailFragment;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

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
    ActionsCreator provideActionCreator(Dispatcher dispatcher, Retrofit retrofit) {
        return new ActionsCreator(dispatcher, retrofit);
    }

    @Provides
    @FragmentScope
    MovieDetailStore provideMovieDetailStore(EventBus bus) {
        return new MovieDetailStore(bus);
    }

}
