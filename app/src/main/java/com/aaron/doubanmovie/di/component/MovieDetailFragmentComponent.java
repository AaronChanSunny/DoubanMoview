package com.aaron.doubanmovie.di.component;

import com.aaron.doubanmovie.di.module.MovieDetailFragmentModule;
import com.aaron.doubanmovie.di.scope.FragmentScope;
import com.aaron.doubanmovie.view.fragment.MovieDetailFragment;

import dagger.Component;

/**
 * Created by OA on 2016/1/26.
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = MovieDetailFragmentModule.class)
public interface MovieDetailFragmentComponent {

    void inject(MovieDetailFragment fragment);

}
