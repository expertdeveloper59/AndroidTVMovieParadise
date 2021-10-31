package com.polplay.tv.movieparadise.ui.detail;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.polplay.tv.movieparadise.R;
import com.polplay.tv.movieparadise.dagger.modules.HttpClientModule;
import com.polplay.tv.movieparadise.data.models.Movie;
import com.polplay.tv.movieparadise.ui.base.BaseTVActivity;
import com.polplay.tv.movieparadise.ui.base.GlideBackgroundManager;


public class DetailActivity extends BaseTVActivity {

    GlideBackgroundManager glideBackgroundManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Movie movie = getIntent().getExtras().getParcelable(Movie.class.getSimpleName());
        DetailFragment detailsFragment = DetailFragment.newInstance(movie);
        addFragment(detailsFragment);

        glideBackgroundManager = new GlideBackgroundManager(this);
        if (movie != null && movie.getBackdropPath() != null) {
            glideBackgroundManager.loadImage(HttpClientModule.BACKDROP_URL + movie.getBackdropPath());
        } else {
            glideBackgroundManager.setBackground(ContextCompat.getDrawable(this, R.drawable.material_bg));
        }
    }
}
