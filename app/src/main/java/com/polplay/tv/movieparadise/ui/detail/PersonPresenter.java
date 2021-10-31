package com.polplay.tv.movieparadise.ui.detail;

import android.content.Context;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.support.v7.view.ContextThemeWrapper;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.polplay.tv.movieparadise.R;
import com.polplay.tv.movieparadise.dagger.modules.HttpClientModule;
import com.polplay.tv.movieparadise.data.models.CastMember;


public class PersonPresenter extends Presenter {

    Context context;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {

        if (context == null) {
            context = new ContextThemeWrapper(parent.getContext(), R.style.PersonCardTheme);
        }

        return new ViewHolder(new ImageCardView(context));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        ImageCardView imageCardView = (ImageCardView) viewHolder.view;
        CastMember castMember = (CastMember) item;

        Glide.with(imageCardView.getContext())
                .load(HttpClientModule.POSTER_URL + castMember.getProfilePath())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageCardView.getMainImageView());

        imageCardView.setTitleText(castMember.getName());
        imageCardView.setContentText(castMember.getCharacter());
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }
}
