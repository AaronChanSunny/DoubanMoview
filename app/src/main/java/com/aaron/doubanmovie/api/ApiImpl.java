package com.aaron.doubanmovie.api;

import android.content.Context;
import android.support.annotation.NonNull;

import com.aaron.doubanmovie.api.gson.ComingSoon;
import com.aaron.doubanmovie.api.gson.InTheater;
import com.aaron.doubanmovie.api.gson.Top;
import com.aaron.doubanmovie.api.http.OkHttpProvider;
import com.aaron.doubanmovie.api.retrofit.ApiService;
import com.aaron.doubanmovie.api.retrofit.RetrofitProvider;
import com.aaron.doubanmovie.model.Movie;
import com.aaron.doubanmovie.util.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by aaronchan on 16/4/22.
 */
public class ApiImpl implements Api {
    private static final Logger logger = new Logger(ApiImpl.class);

    private static ApiImpl sInstance;

    private ApiService mApiService;
    private OkHttpClient mOkHttpClient;

    public static ApiImpl getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new ApiImpl(context);
        }
        return sInstance;
    }

    private ApiImpl(Context context) {
        Retrofit retrofit = RetrofitProvider.getInstance(context).getRetrofit();
        mApiService = retrofit.create(ApiService.class);

        mOkHttpClient = OkHttpProvider.getInstance(context).getOkHttpClient();
    }

    @Override
    public Observable<InTheater> getInTheaters(String city, int start, int count) {
        return mApiService.getInTheaters(city, start, count);
    }

    @Override
    public Observable<Movie> getMovie(String id) {
        return mApiService.getMovie(id);
    }

    @Override
    public Observable<ComingSoon> getComingSoon(int start, int count) {
        return mApiService.getComingSoon(start, count);
    }

    @Override
    public Observable<Top> getTop(int start, int count) {
        return mApiService.getTop(start, count);
    }

    @Override
    public Observable<List<String>> getMoviePhotos(final String id) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                String url = "https://movie.douban.com/subject/" + id + "/photos?type=S";

                try {
                    subscriber.onNext(parseUrl(url));
                } catch (IOException e) {
                    e.printStackTrace();
                    subscriber.onError(e);
                }
            }
        }).map(new Func1<String, List<String>>() {
            @Override
            public List<String> call(String html) {
                List<String> images = getImageLinks(html);
                return images;
            }
        }).map(new Func1<List<String>, List<String>>() {
            @Override
            public List<String> call(List<String> images) {
                List<String> urls = new ArrayList<>();
                for (String image : images) {
                    try {
                        String html = parseUrl(image);

                        urls.add(getImageUrl(html));
                    } catch (IOException e) {
                        e.printStackTrace();
                        Observable.error(e);
                    }
                }

                logger.debug("urls size is " + urls.size());
                return urls;
            }
        });
    }

    @Override
    public Observable<String> getRandomMoviePhoto(final String id) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                String url = "https://movie.douban.com/subject/" + id + "/photos?type=S";

                try {
                    subscriber.onNext(parseUrl(url));
                } catch (IOException e) {
                    e.printStackTrace();
                    subscriber.onError(e);
                }
            }
        }).map(new Func1<String, String>() {
            @Override
            public String call(String html) {
                List<String> links = getImageLinks(html);
                int idx = new Random().nextInt(links.size());
                return links.get(idx);
            }
        }).map(new Func1<String, String>() {
            @Override
            public String call(String link) {
                String url = "";
                try {
                    String html = parseUrl(link);
                    url = getImageUrl(html);
                } catch (IOException e) {
                    e.printStackTrace();
                    Observable.error(e);
                }
                return url;
            }
        });
    }

    private String parseUrl(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = mOkHttpClient.newCall(request).execute();
        return response.body().string();
    }

    @NonNull
    private List<String> getImageLinks(String html) {
        List<String> images = new ArrayList<>();

        Document document = Jsoup.parse(html);
        Element body = document.body();

        Elements hrefs = body.select("a[href^=https://movie.douban.com/photos/photo/]");
        for (Element href : hrefs) {
            String image = href.attr("href");
            if (image.endsWith("/")) {
                images.add(image);
            }
        }
        return images;
    }

    private String getImageUrl(String html) {
        Document document = Jsoup.parse(html);
        Element body = document.body();

        Elements images = body.select("img[src~=(https://img.*?doubanio.com/view/photo/photo/public/)]");

        return images.get(0).attr("src");
    }

}
