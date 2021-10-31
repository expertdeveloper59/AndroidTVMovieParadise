package com.polplay.tv.movieparadise.dagger.modules;

import android.app.Application;

import com.polplay.tv.movieparadise.dagger.AppScope;
import com.polplay.tv.movieparadise.data.Api.TheMovieDbAPI;

import java.io.File;
import java.util.concurrent.TimeUnit;


import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class HttpClientModule {

    private static final long DISK_CACHE_SIZE = 50 * 1024 * 1024; // 50MB

    public static final String BACKDROP_URL = "https://image.tmdb.org/t/p/w1280/";
    public static final String POSTER_URL = "https://image.tmdb.org/t/p/w500/";
    public static final String API_URL = "https://4plays.pl/";
    public static final String NOW_PLAYING = "";
    public static final String POPULAR = "";
    public static final String TOP_RATED = "";
    public static final String UPCOMING = "";
    public static final String MOVIE = "/api/client/v1/movies";
    public static final String SEARCH_MOVIE = "/api/client/v1/movies";

    @Provides
    @AppScope
    public OkHttpClient provideOkHttpClient(Application app) {
        File cacheDir = new File(app.getCacheDir(), "http");
        return new OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .cache(new okhttp3.Cache(cacheDir, DISK_CACHE_SIZE))
                .build();
    }

    @Provides
    @AppScope
    public Retrofit provideFithubRestAdapter(MoshiConverterFactory moshiConverterFactory, OkHttpClient okHttpClient) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = okHttpClient.newBuilder()
                .addInterceptor(interceptor)
                .build();
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(moshiConverterFactory)
                .build();
    }

    @Provides
    public TheMovieDbAPI provideFithubApi(Retrofit restAdapter) {
        return restAdapter.create(TheMovieDbAPI.class);
    }

    @Provides
    @AppScope
    public MoshiConverterFactory provideMoshiConverterFactory() {
        return MoshiConverterFactory.create();
    }
}
