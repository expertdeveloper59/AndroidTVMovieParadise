package com.polplay.tv.movieparadise.ui.detail;

import android.support.v17.leanback.widget.Presenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.polplay.tv.movieparadise.R;
import com.polplay.tv.movieparadise.data.models.MovieDetails;


public class DetailDescriptionPresenter extends Presenter {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail, parent, false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        MovieDetails movieDetails = (MovieDetails) item;
        DetailViewHolder holder = (DetailViewHolder) viewHolder;
        holder.bind(movieDetails);
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }
}
