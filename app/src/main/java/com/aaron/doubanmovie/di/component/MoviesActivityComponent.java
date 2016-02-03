package com.aaron.doubanmovie.di.component;

import com.aaron.doubanmovie.di.module.MoviesActivityModule;
import com.aaron.doubanmovie.di.scope.ActivityScope;
import com.aaron.doubanmovie.view.activity.MoviesActivity;

import dagger.Component;

/**
 * Created by Git on 2016/1/23.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = MoviesActivityModule.class)
public interface MoviesActivityComponent {

    void inject(MoviesActivity activity);

}
