package com.aaron.doubanmovie.detail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.api.Api;
import com.aaron.doubanmovie.api.ApiImpl;
import com.aaron.doubanmovie.common.BaseActivity;
import com.aaron.doubanmovie.model.Movie;
import com.aaron.doubanmovie.util.Logger;
import com.aaron.doubanmovie.util.MovieParser;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MovieDetailActivity extends BaseActivity {

    private static final Logger logger = new Logger(MovieDetailActivity.class);
    public static final String EXTRA_ID = MovieDetailActivity.class.getName() + ".EXTRA_ID";
    public static final String EXTRA_TITLE = MovieDetailActivity.class.getName() + ".EXTRA_TITLE";
    public static final String EXTRA_IMAGE_URL = MovieDetailActivity.class.getName() + ".EXTRA_IMAGE_URL";
    public static final String EXTRA_CASTS = MovieDetailActivity.class.getName() + ".EXTRA_CASTS";

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
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.btn_expand)
    Button mExpand;

    @OnClick(R.id.btn_expand)
    void onBtnExpandClicked() {
        if (!mIsExpanded) {
            expandSummaryText();
        } else {
            collapseSummaryText();
        }
    }

    private boolean mIsExpanded;
    private Api mApi;

    public static void actionStart(Context context, String id, String title, String imageUrl, String casts, String genres) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(EXTRA_ID, id);
        intent.putExtra(EXTRA_TITLE, title);
        intent.putExtra(EXTRA_IMAGE_URL, imageUrl);
        intent.putExtra(EXTRA_CASTS, casts);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_movie_detail;
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
    protected void initData() {
        super.initData();

        mApi = ApiImpl.getInstance(this);
        mIsExpanded = false;
    }

    @Override
    protected void initView() {
        super.initView();

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String id = getIntent().getStringExtra(EXTRA_ID);
        String url = getIntent().getStringExtra(EXTRA_IMAGE_URL);
        String title = getIntent().getStringExtra(EXTRA_TITLE);
        String casts = getIntent().getStringExtra(EXTRA_CASTS);

        getSupportActionBar().setTitle(title);
        loadBackDrop(url);

        mCasts.setText(casts);

        fetchMovieDetail(id);

        fetchMoviePhoto(id);
    }

    private void fetchMovieDetail(String id) {
        mProgressBar.setVisibility(View.VISIBLE);

        addSubscription(
                mApi.getMovie(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Movie>() {
                    @Override
                    public void call(Movie movie) {
                        mProgressBar.setVisibility(View.GONE);

                        mSummary.setText(movie.getSummary());
                        mDirectors.setText(MovieParser.parseDirectors(movie.getDirectors()));

                        mCasts.setText(MovieParser.parseCasts(movie.getCasts()));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Toast.makeText(MovieDetailActivity.this, R.string.server_error, Toast.LENGTH_SHORT).show();
                    }
                })
        );
    }

    private void fetchMoviePhoto(String id) {
        addSubscription(
                mApi.getRandomMoviePhoto(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String url) {
                        loadBackDrop(url);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Toast.makeText(MovieDetailActivity.this, R.string.server_error, Toast.LENGTH_SHORT).show();
                    }
                })
        );
    }

    private void loadBackDrop(String url) {
        Picasso.with(this)
                .load(url)
                .into(mBackDrop);
    }

    private void expandSummaryText() {
        Animator animator = ObjectAnimator.ofInt(mSummary, "maxLines", mSummary
                .getLineCount())
                .setDuration(200);

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                mExpand.setText(R.string.btn_collapse);
                mIsExpanded = true;
            }
        });

        animator.start();
    }

    private void collapseSummaryText() {
        Animator animator = ObjectAnimator.ofInt(mSummary, "maxLines", mSummary.getLineCount(), 4)
                .setDuration(200);

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                mExpand.setText(R.string.btn_expand);
                mIsExpanded = false;
            }
        });

        animator.start();
    }
}
