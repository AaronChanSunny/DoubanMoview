package me.aaron.dao.api.http;

import android.content.Context;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by aaronchan on 16/5/1.
 */
public class OkHttpProvider {
    private static OkHttpProvider sInstance;

    private OkHttpClient mOkHttpClient;

    public static OkHttpProvider getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new OkHttpProvider(context);
        }
        return sInstance;
    }

    private OkHttpProvider(Context context) {
        Cache cache = provideOkHttpCache(context);

        mOkHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }

    private Cache provideOkHttpCache(Context context) {
        int size = 10 * 1024 * 1024;
        Cache cache = new Cache(context.getCacheDir(), size);
        return cache;
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }
}
