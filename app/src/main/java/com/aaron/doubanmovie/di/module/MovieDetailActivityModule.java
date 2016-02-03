package com.aaron.doubanmovie.di.module;

import com.aaron.doubanmovie.bus.EventBus;
import com.aaron.doubanmovie.di.scope.ActivityScope;
import com.aaron.doubanmovie.flux.action.ActionsCreator;
import com.aaron.doubanmovie.flux.dispatcher.Dispatcher;
import com.aaron.doubanmovie.flux.store.MovieDetailStore;
import com.aaron.doubanmovie.view.activity.MovieDetailActivity;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by OA on 2016/1/26.
 */
@Module
public class MovieDetailActivityModule {

    MovieDetailActivity mActivity;

    public MovieDetailActivityModule(MovieDetailActivity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    ActionsCreator provideActionCreator(Dispatcher dispatcher, Retrofit retrofit) {
        return new ActionsCreator(dispatcher, retrofit);
    }

    @Provides
    @ActivityScope
    MovieDetailStore provideMovieDetailStore(EventBus bus) {
        return new MovieDetailStore(bus);
    }

}
