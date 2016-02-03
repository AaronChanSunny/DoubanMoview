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
import com.aaron.doubanmovie.flux.action.ActionsCreator;
import com.aaron.doubanmovie.flux.dispatcher.Dispatcher;
import com.aaron.doubanmovie.flux.store.MovieDetailStore;
import com.aaron.doubanmovie.flux.store.Store;
import com.aaron.doubanmovie.network.model.InTheaters;
import com.aaron.doubanmovie.util.Logger;
import com.aaron.doubanmovie.util.StringUtil;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by OA on 2016/1/25.
 */
public class MovieDetailFragment extends BaseFragment {

    private static final Logger logger = new Logger(MovieDetailFragment.class);

    private static final String EXTRA_MOVIE = MovieDetailFragment.class.getName() + ".EXTRA_MOVIE";

    @Inject
    Dispatcher mDispatcher;
    @Inject
    ActionsCreator mActionsCreator;
    @Inject
    MovieDetailStore mMovieDetailStore;

    private InTheaters.Movie mMovieSelected;

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

        mMovieSelected = getArguments().getParcelable(EXTRA_MOVIE);
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

        getSupportActionBar().setTitle(mMovieSelected.getTitle());

        Picasso.with(getActivity())
                .load(mMovieSelected.getImages().getLarge())
                .into(mBackDrop);

        List<String> directories = new ArrayList<>();
        for (InTheaters.Movie.Director director : mMovieSelected.getDirectors()) {
            directories.add(director.getName());
        }
        mDirectors.setText(StringUtil.formatStringList(directories));

        List<String> casts = new ArrayList<>();
        for (InTheaters.Movie.Cast cast : mMovieSelected.getCasts()) {
            casts.add(cast.getName());
        }
        mCasts.setText(StringUtil.formatStringList(casts));
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
        setSummary(movieDetailStore.getSummary());
        setDirectors(movieDetailStore.getDirectors());
        setCasts(movieDetailStore.getCasts());
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
