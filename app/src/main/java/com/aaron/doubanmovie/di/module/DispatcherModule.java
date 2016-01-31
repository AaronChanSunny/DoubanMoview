package com.aaron.doubanmovie.di.module;


import com.aaron.doubanmovie.dispatcher.Dispatcher;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aaron on 2016/1/31.
 */
@Module
public class DispatcherModule {

    @Provides
    @Singleton
    Dispatcher provideDispatcher() {
        return new Dispatcher();
    }

}
