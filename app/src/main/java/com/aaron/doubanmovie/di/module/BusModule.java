package com.aaron.doubanmovie.di.module;

import com.aaron.doubanmovie.bus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by OA on 2016/1/25.
 */
@Module
public class BusModule {

    @Provides
    @Singleton
    EventBus provideBus() {
        return new EventBus();
    }

}
