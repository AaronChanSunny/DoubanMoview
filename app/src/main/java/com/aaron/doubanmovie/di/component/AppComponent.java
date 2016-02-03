package com.aaron.doubanmovie.di.component;

import com.aaron.doubanmovie.bus.EventBus;
import com.aaron.doubanmovie.di.module.AppModule;
import com.aaron.doubanmovie.di.module.BusModule;
import com.aaron.doubanmovie.di.module.DispatcherModule;
import com.aaron.doubanmovie.di.module.ApiModule;
import com.aaron.doubanmovie.flux.dispatcher.Dispatcher;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Git on 2016/1/23.
 */
@Singleton
@Component(modules = {AppModule.class, BusModule.class, DispatcherModule.class, ApiModule.class})
public interface AppComponent {

    EventBus bus();

    Retrofit retrofit();

    Dispatcher dispatcher();

}
