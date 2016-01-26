package com.aaron.doubanmovie.view.fragment;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.aaron.doubanmovie.App;
import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.di.component.DaggerMovieDetailFragmentComponent;
import com.aaron.doubanmovie.di.module.MovieDetailFragmentModule;
import com.aaron.doubanmovie.presenter.MovieDetailPresenter;
import com.aaron.doubanmovie.view.core.MovieDetailView;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by OA on 2016/1/25.
 */
public class MovieDetailFragment extends BaseFragment implements MovieDetailView {

    private static final String EXTRA_MOVIE_ID = MovieDetailFragment.class.getName() + ".EXTRA_MOVIE_ID";
    private static final String EXTRA_MOVIE_TITLE = MovieDetailFragment.class.getName() + ".EXTRA_MOVIE_TITLE";

    @Inject
    MovieDetailPresenter mPresenter;

    private String mTitle;
    private String mMovieId;

    @Bind(R.id.back_drop)
    ImageView mBackDrop;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @Bind(R.id.directors)
    TextView mDirectors;
    @Bind(R.id.casts)
    TextView mCasts;
    @Bind(R.id.summary)
    TextView mSummary;

    public static Fragment newInstance(String movieId, String title) {
        Bundle args = new Bundle();
        args.putString(EXTRA_MOVIE_ID, movieId);
        args.putString(EXTRA_MOVIE_TITLE, title);

        Fragment fragment = new MovieDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMovieId = getArguments().getString(EXTRA_MOVIE_ID);
        mTitle = getArguments().getString(EXTRA_MOVIE_TITLE);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.resume();
        mPresenter.fetchMovieDetail(mMovieId);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.pause();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie_detail;
    }

    @Override
    protected void initInjection() {
        DaggerMovieDetailFragmentComponent.builder()
                .appComponent(App.getApp(getActivity()).getAppComponent())
                .movieDetailFragmentModule(new MovieDetailFragmentModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void initialize() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    public void setSummary(String summary) {
        mSummary.setText(summary);
    }

    @Override
    public void setBackDrop(String url) {
        Picasso.with(getActivity())
                .load(url)
                .into(mBackDrop);
    }

    @Override
    public void setDirectors(String directors) {
        mDirectors.setText(directors);
    }

    @Override
    public void setCasts(String casts) {
        mCasts.setText(casts);
    }

}
