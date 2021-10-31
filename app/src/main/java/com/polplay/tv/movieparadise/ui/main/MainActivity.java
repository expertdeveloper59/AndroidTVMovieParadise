package com.polplay.tv.movieparadise.ui.main;

import android.os.Bundle;

import com.polplay.tv.movieparadise.ui.base.BaseTVActivity;


public class MainActivity extends BaseTVActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFragment(MainFragment.newInstance());
    }

}
