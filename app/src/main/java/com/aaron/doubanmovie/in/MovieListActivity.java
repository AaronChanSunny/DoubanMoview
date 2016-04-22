package com.aaron.doubanmovie.in;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.api.Api;
import com.aaron.doubanmovie.api.ApiImpl;
import com.aaron.doubanmovie.api.model.InTheaters;
import com.aaron.doubanmovie.util.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MovieListActivity extends AppCompatActivity {

    private static final Logger logger = new Logger(MovieListActivity.class);

    private MovieListAdapter mAdapter;
    private Api mApi;
    private Subscription mSubsInTheater;

    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;
    @Bind(R.id.movies_recycle_view)
    RecyclerView mMoviesRecycleView;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @OnClick(R.id.fab)
    void fabClick() {
        refreshMovies();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_movie_list);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        initData();

        mMoviesRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mMoviesRecycleView.setAdapter(mAdapter);

        fetchMovies();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        if (!mSubsInTheater.isUnsubscribed()) {
            mSubsInTheater.unsubscribe();
        }
        super.onDestroy();
    }

    private void initData() {
        mAdapter = new MovieListAdapter(this);
        mApi = ApiImpl.getInstance(this);
    }

    private void fetchMovies() {
        mProgressBar.setVisibility(View.VISIBLE);

        mSubsInTheater = mApi.getInTheaters("福州")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<InTheaters>() {
                    @Override
                    public void call(InTheaters inTheaters) {
                        mProgressBar.setVisibility(View.GONE);

                        mAdapter.setMovies(inTheaters.getMovies());
                        mAdapter.notifyDataSetChanged();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Toast.makeText(MovieListActivity.this, R.string.server_error, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void refreshMovies() {
        Toast.makeText(this, R.string.refresh_list, Toast.LENGTH_SHORT).show();
        mMoviesRecycleView.smoothScrollToPosition(0);

        fetchMovies();
    }

}
