package me.aaron.dao.api.retrofit;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import me.aaron.dao.api.http.OkHttpProvider;
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
    private OkHttpClient mOkHttpClient;

    public static RetrofitProvider getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new RetrofitProvider(context);
        }
        return sInstance;
    }

    private RetrofitProvider(Context context) {
        Gson gson = provideGson();
        mOkHttpClient = OkHttpProvider.getInstance(context).getOkHttpClient();

        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .client(mOkHttpClient)
                .build();
    }

    private Gson provideGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return builder.create();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
