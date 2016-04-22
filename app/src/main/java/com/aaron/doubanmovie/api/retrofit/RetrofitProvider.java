package com.aaron.doubanmovie.api.retrofit;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;

/**
 * Created by aaronchan on 16/4/22.
 */
public class RetrofitProvider {
    private static final String BASE_URL = "https://api.douban.com";

    private static RetrofitProvider sInstance;
    private Retrofit mRetrofit;

    public static RetrofitProvider getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new RetrofitProvider(context);
        }
        return sInstance;
    }

    private RetrofitProvider(Context context) {
        Gson gson = provideGson();
        Cache cache = provideOkHttpCache(context);
        OkHttpClient client = provideOkHttp(cache);
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build();
    }

    private Gson provideGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return builder.create();
    }

    private Cache provideOkHttpCache(Context context) {
        int size = 10 * 1024 * 1024;
        Cache cache = new Cache(context.getCacheDir(), size);
        return cache;
    }

    private OkHttpClient provideOkHttp(Cache cache) {
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .build();
        return client;
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
