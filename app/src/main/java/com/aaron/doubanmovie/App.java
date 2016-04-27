package com.aaron.doubanmovie;

import android.app.Application;

import butterknife.ButterKnife;

/**
 * Created by aaronchan on 16/4/27.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ButterKnife.setDebug(true);
    }
}
