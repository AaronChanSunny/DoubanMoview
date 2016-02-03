package com.aaron.doubanmovie.di.module;

import com.aaron.doubanmovie.bus.EventBus;
import com.aaron.doubanmovie.di.scope.FragmentScope;
import com.aaron.doubanmovie.flux.action.ActionsCreator;
import com.aaron.doubanmovie.flux.dispatcher.Dispatcher;
import com.aaron.doubanmovie.flux.store.MoviesStore;
import com.aaron.doubanmovie.view.adapter.MoviesAdapter;
import com.aaron.doubanmovie.view.fragment.MoviesFragment;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

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
    MoviesAdapter provideMoviesAdapter() {
        return new MoviesAdapter(mFragment.getActivity());
    }

    @Provides
    @FragmentScope
    ActionsCreator provideActionsCreator(Dispatcher dispatcher, Retrofit retrofit) {
        return new ActionsCreator(dispatcher, retrofit);
    }

    @Provides
    @FragmentScope
    MoviesStore provideMoviesStore(EventBus bus) {
        return  new MoviesStore(bus);
    }

}
