package com.polplay.tv.movieparadise.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v17.leanback.app.SearchFragment;

import com.polplay.tv.movieparadise.R;
import com.polplay.tv.movieparadise.ui.base.BaseTVActivity;

public class SearchActivity extends BaseTVActivity {

    SearchFragment searchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFragment(com.polplay.tv.movieparadise.ui.search.SearchFragment.newInstance());

        searchFragment = (SearchFragment) getFragmentManager().findFragmentById(R.id.search_fragment);

    }


    @Override
    public boolean onSearchRequested() {
        startActivity(new Intent(this, SearchActivity.class));
        return true;
    }
}
