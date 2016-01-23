package com.aaron.doubanmovie.di.component;

import com.aaron.doubanmovie.di.module.AppModule;
import com.aaron.doubanmovie.di.module.DoubanApiModule;
import com.aaron.doubanmovie.network.DoubanApi;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Git on 2016/1/23.
 */
@Singleton
@Component(modules = {AppModule.class, DoubanApiModule.class})
public interface AppComponent {

    DoubanApi doubanApi();

}
