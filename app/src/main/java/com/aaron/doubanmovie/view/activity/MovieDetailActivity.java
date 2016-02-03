package com.aaron.doubanmovie.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aaron.doubanmovie.App;
import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.di.component.DaggerMovieDetailActivityComponent;
import com.aaron.doubanmovie.di.module.MovieDetailActivityModule;
import com.aaron.doubanmovie.flux.action.ActionsCreator;
import com.aaron.doubanmovie.flux.dispatcher.Dispatcher;
import com.aaron.doubanmovie.flux.store.MovieDetailStore;
import com.aaron.doubanmovie.flux.store.Store;
import com.aaron.doubanmovie.network.model.InTheaters;
import com.aaron.doubanmovie.network.model.Movie;
import com.aaron.doubanmovie.util.Logger;
import com.aaron.doubanmovie.util.MovieParser;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;

public class MovieDetailActivity extends BaseActivity {

    private static final Logger logger = new Logger(MovieDetailActivity.class);

    private static final String EXTRA_MOVIE = MovieDetailActivity.class.getName() + ".EXTRA_MOVIE";

    @Inject
    Dispatcher mDispatcher;
    @Inject
    ActionsCreator mActionsCreator;
    @Inject
    MovieDetailStore mMovieDetailStore;

    private InTheaters.Movie mMovieSelected;

    @Bind(R.id.back_drop)
    ImageView mBackDrop;
    @Bind(R.id.directors)
    TextView mDirectors;
    @Bind(R.id.casts)
    TextView mCasts;
    @Bind(R.id.summary)
    TextView mSummary;
    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;

    public static void actionStart(Context context, InTheaters.Movie movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(EXTRA_MOVIE, movie);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMovieSelected = getIntent().getParcelableExtra(EXTRA_MOVIE);
    }

    @Override
    public void onResume() {
        super.onResume();

        mDispatcher.register(mMovieDetailStore);
        mMovieDetailStore.register(this);

        if (!mMovieDetailStore.isLoaded()) {
            fetchMovieDetail(mMovieSelected.getId());
        }
    }

    @Override
    public void onPause() {
        mDispatcher.unregister(mMovieDetailStore);
        mMovieDetailStore.unregister(this);

        super.onPause();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_movie_detail;
    }

    @Override
    protected void di() {
        DaggerMovieDetailActivityComponent.builder()
                .appComponent(App.getApp(this).getAppComponent())
                .movieDetailActivityModule(new MovieDetailActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initData() {
        super.initData();

        mMovieSelected = getIntent().getParcelableExtra(EXTRA_MOVIE);
    }

    @Override
    protected void initViews() {
        super.initViews();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(mMovieSelected.getTitle());

        Picasso.with(this)
                .load(mMovieSelected.getImages().getLarge())
                .into(mBackDrop);

        mDirectors.setText(MovieParser.parseDirectorsInTheaters(mMovieSelected.getDirectors()));
        mCasts.setText(MovieParser.parseCastsInTheaters(mMovieSelected.getCasts()));
    }

    /**
     * 获取电影详情信息
     * @param id
     */
    private void fetchMovieDetail(String id) {
        mActionsCreator.fetchMovieDetail(id);
    }

    @Subscribe
    public void onStoreChange(Store.StoreChangeEvent event) {
        render(mMovieDetailStore);
    }

    private void render(MovieDetailStore movieDetailStore) {
        renderProgressBar(movieDetailStore.isProgressBarShown());

        if (movieDetailStore.isLoaded()) {
            Movie movie = movieDetailStore.getMovie();

            String summary = movie.getSummary();
            setSummary(summary);

            String directors = MovieParser.parseDirectors(movie.getDirectors());
            setDirectors(directors);

            String casts = MovieParser.parseCasts(movie.getCasts());
            setCasts(casts);
        }
    }

    /**
     * 设置剧情梗概
     * @param summary
     */
    private void setSummary(String summary) {
        mSummary.setText(summary);
    }

    /**
     * 设置导演
     * @param directors
     */
    private void setDirectors(String directors) {
        mDirectors.setText(directors);
    }

    /**
     * 设置演员表
     * @param casts
     */
    private void setCasts(String casts) {
        mCasts.setText(casts);
    }

    /**
     * 是否显示进度条
     */
    private void renderProgressBar(boolean isShown) {
        mProgressBar.setVisibility(isShown ? View.VISIBLE : View.INVISIBLE);
    }

}
