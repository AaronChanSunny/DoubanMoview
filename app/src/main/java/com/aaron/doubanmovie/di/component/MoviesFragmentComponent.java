package com.aaron.doubanmovie.di.component;

import com.aaron.doubanmovie.di.module.MoviesFragmentModule;
import com.aaron.doubanmovie.di.scope.FragmentScope;
import com.aaron.doubanmovie.view.fragment.MoviesFragment;

import dagger.Component;

/**
 * Created by Git on 2016/1/23.
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = MoviesFragmentModule.class)
public interface MoviesFragmentComponent {

    void inject(MoviesFragment fragment);

}
