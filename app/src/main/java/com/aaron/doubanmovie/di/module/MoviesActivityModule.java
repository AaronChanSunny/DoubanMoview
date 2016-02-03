package com.aaron.doubanmovie.di.module;

import com.aaron.doubanmovie.bus.EventBus;
import com.aaron.doubanmovie.di.scope.ActivityScope;
import com.aaron.doubanmovie.flux.action.ActionsCreator;
import com.aaron.doubanmovie.flux.dispatcher.Dispatcher;
import com.aaron.doubanmovie.flux.store.MoviesStore;
import com.aaron.doubanmovie.view.activity.MoviesActivity;
import com.aaron.doubanmovie.view.adapter.MoviesAdapter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Git on 2016/1/23.
 */
@Module
public class MoviesActivityModule {

    private MoviesActivity mActivity;

    public MoviesActivityModule(MoviesActivity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    MoviesAdapter provideMoviesAdapter() {
        return new MoviesAdapter(mActivity);
    }

    @Provides
    @ActivityScope
    ActionsCreator provideActionsCreator(Dispatcher dispatcher, Retrofit retrofit) {
        return new ActionsCreator(dispatcher, retrofit);
    }

    @Provides
    @ActivityScope
    MoviesStore provideMoviesStore(EventBus bus) {
        return  new MoviesStore(bus);
    }

}
