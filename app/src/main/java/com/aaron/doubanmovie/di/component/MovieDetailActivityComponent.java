package com.aaron.doubanmovie.di.component;

import com.aaron.doubanmovie.di.module.MovieDetailActivityModule;
import com.aaron.doubanmovie.di.scope.ActivityScope;
import com.aaron.doubanmovie.view.activity.MovieDetailActivity;

import dagger.Component;

/**
 * Created by OA on 2016/1/26.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = MovieDetailActivityModule.class)
public interface MovieDetailActivityComponent {

    void inject(MovieDetailActivity activity);

}
