package com.aaron.doubanmovie.view.fragment;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aaron.doubanmovie.App;
import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.di.component.DaggerMovieDetailFragmentComponent;
import com.aaron.doubanmovie.di.module.MovieDetailFragmentModule;
import com.aaron.doubanmovie.model.InTheaters;
import com.aaron.doubanmovie.presenter.MovieDetailPresenter;
import com.aaron.doubanmovie.util.Logger;
import com.aaron.doubanmovie.util.StringUtil;
import com.aaron.doubanmovie.view.core.MovieDetailView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by OA on 2016/1/25.
 */
public class MovieDetailFragment extends BaseFragment implements MovieDetailView {

    private static final Logger logger = new Logger(MovieDetailFragment.class);

    private static final String EXTRA_MOVIE = MovieDetailFragment.class.getName() + ".EXTRA_MOVIE";

    @Inject
    MovieDetailPresenter mPresenter;

    private InTheaters.Movie mMovie;

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
    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;

    public static Fragment newInstance(InTheaters.Movie movie) {
        Bundle args = new Bundle();
        args.putParcelable(EXTRA_MOVIE, movie);

        Fragment fragment = new MovieDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMovie = getArguments().getParcelable(EXTRA_MOVIE);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.resume();
        mPresenter.fetchMovieDetail(mMovie.getId());
    }

    @Override
    public void onPause() {
        mPresenter.pause();
        super.onPause();
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
    protected void initViews() {
        super.initViews();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(mMovie.getTitle());

        Picasso.with(getActivity())
                .load(mMovie.getImages().getLarge())
                .into(mBackDrop);

        List<String> directories = new ArrayList<>();
        for (InTheaters.Movie.Director director : mMovie.getDirectors()) {
            directories.add(director.getName());
        }
        mDirectors.setText(StringUtil.formatStringList(directories));

        List<String> casts = new ArrayList<>();
        for (InTheaters.Movie.Cast cast : mMovie.getCasts()) {
            casts.add(cast.getName());
        }
        mCasts.setText(StringUtil.formatStringList(casts));
    }

    @Override
    public void setSummary(String summary) {
        mSummary.setText(summary);
    }

    @Override
    public void setDirectors(String directors) {
        mDirectors.setText(directors);
    }

    @Override
    public void setCasts(String casts) {
        mCasts.setText(casts);
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

}
