package com.aaron.doubanmovie;

import android.app.Application;
import android.content.Context;

import com.aaron.doubanmovie.di.component.AppComponent;
import com.aaron.doubanmovie.di.component.DaggerAppComponent;
import com.aaron.doubanmovie.di.module.ApiModule;
import com.aaron.doubanmovie.di.module.AppModule;
import com.facebook.stetho.Stetho;

/**
 * Created by Git on 2016/1/23.
 */
public class App extends Application {

    private AppComponent mAppComponent;

    public static App getApp(Context context) {
        return (App) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initAppComponent();

        Stetho.initializeWithDefaults(this);
    }

    private void initAppComponent() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://api.douban.com"))
                .build();
    }

}
