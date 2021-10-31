package com.polplay.tv.movieparadise;

import android.app.Application;

import com.polplay.tv.movieparadise.dagger.components.ApplicationComponent;
import com.polplay.tv.movieparadise.dagger.modules.ApplicationModule;
import com.polplay.tv.movieparadise.dagger.modules.HttpClientModule;

import rx.android.BuildConfig;
import timber.log.Timber;

public class App extends Application {

    private static App instance;
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        // Creates Dagger Graph
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .httpClientModule(new HttpClientModule())
                .build();

        applicationComponent.inject(this);
    }

    public static App instance() {
        return instance;
    }

    public ApplicationComponent appComponent() {
        return applicationComponent;
    }

}
