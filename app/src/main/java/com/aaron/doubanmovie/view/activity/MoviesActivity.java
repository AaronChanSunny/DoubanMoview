package com.aaron.doubanmovie.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.aaron.doubanmovie.App;
import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.di.component.DaggerMoviesActivityComponent;
import com.aaron.doubanmovie.di.module.MoviesActivityModule;
import com.aaron.doubanmovie.flux.action.ActionsCreator;
import com.aaron.doubanmovie.flux.dispatcher.Dispatcher;
import com.aaron.doubanmovie.flux.store.MoviesStore;
import com.aaron.doubanmovie.flux.store.Store;
import com.aaron.doubanmovie.util.Logger;
import com.aaron.doubanmovie.view.adapter.MoviesAdapter;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

public class MoviesActivity extends BaseActivity {

    private static final Logger logger = new Logger(MoviesActivity.class);

    @Inject
    Dispatcher mDispatcher;
    @Inject
    ActionsCreator mActionCreator;
    @Inject
    MoviesStore mMoviesStore;
    @Inject
    MoviesAdapter mMoviesAdapter;

    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;
    @Bind(R.id.movies_recycle_view)
    RecyclerView mMoviesRecycleView;

    @OnClick(R.id.fab)
    void fabClick() {
        Toast.makeText(this, R.string.refresh_list, Toast.LENGTH_SHORT)
                .show();
        fetchMovies();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_movies;
    }

    @Override
    protected void di() {
        DaggerMoviesActivityComponent.builder()
                .appComponent(App.getApp(this).getAppComponent())
                .moviesActivityModule(new MoviesActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        super.initViews();

        mMoviesRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mMoviesRecycleView.setAdapter(mMoviesAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        mDispatcher.register(mMoviesStore);
        mMoviesStore.register(this);

        if (mMoviesStore.getMovies().size() == 0) {
            fetchMovies();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        mDispatcher.unregister(mMoviesStore);
        mMoviesStore.unregister(this);
    }

    /**
     * 从服务器拉取电影数据
     */
    private void fetchMovies() {
        mActionCreator.fetchMovies();
    }

    @Subscribe
    public void onStoreChange(Store.StoreChangeEvent event) {
        render(mMoviesStore);
    }

    /**
     * 前端渲染
     * @param moviesStore
     */
    private void render(MoviesStore moviesStore) {
        logger.debug("movies size is " + moviesStore.getMovies().size());

        renderProgressBar(mMoviesStore.isProgressBarShown());

        if (mMoviesStore.isLoaded()) {
            refreshMovies();
        }
    }

    /**
     * 刷新电影列表
     */
    private void refreshMovies() {
        mMoviesAdapter.setMovies(mMoviesStore.getMovies());
        mMoviesAdapter.notifyDataSetChanged();
        scrollRecycleViewTop();
    }

    /**
     * 是否显示进度条
     */
    private void renderProgressBar(boolean isShown) {
        mProgressBar.setVisibility(isShown ? View.VISIBLE : View.INVISIBLE);
    }

    /**
     * 返回列表顶部
     */
    private void scrollRecycleViewTop() {
        mMoviesRecycleView.scrollToPosition(0);
    }

}
