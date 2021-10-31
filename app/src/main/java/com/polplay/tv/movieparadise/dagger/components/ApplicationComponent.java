package com.polplay.tv.movieparadise.dagger.components;


import com.polplay.tv.movieparadise.App;
import com.polplay.tv.movieparadise.dagger.AppScope;
import com.polplay.tv.movieparadise.dagger.modules.ApplicationModule;
import com.polplay.tv.movieparadise.dagger.modules.HttpClientModule;
import com.polplay.tv.movieparadise.ui.detail.DetailFragment;
import com.polplay.tv.movieparadise.ui.main.MainFragment;
import com.polplay.tv.movieparadise.ui.search.SearchFragment;

import javax.inject.Singleton;

import dagger.Component;

@AppScope
@Singleton
@Component(modules = {
        ApplicationModule.class,
        HttpClientModule.class,
})
public interface ApplicationComponent {

    void inject(App app);
    void inject(MainFragment mainFragment);
    void inject(DetailFragment movieDetailsFragment);
    void inject(SearchFragment searchFragment);
}
