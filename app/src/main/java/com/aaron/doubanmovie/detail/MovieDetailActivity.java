package com.aaron.doubanmovie.detail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.api.Api;
import com.aaron.doubanmovie.api.ApiImpl;
import com.aaron.doubanmovie.celebrity.CelebrityListAdapter;
import com.aaron.doubanmovie.common.BaseActivity;
import com.aaron.doubanmovie.common.ExceptionHandler;
import com.aaron.doubanmovie.model.Celebrity;
import com.aaron.doubanmovie.model.Movie;
import com.aaron.doubanmovie.util.Logger;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import retrofit2.HttpException;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MovieDetailActivity extends BaseActivity {

    private static final Logger logger = new Logger(MovieDetailActivity.class);
    public static final String EXTRA_ID = MovieDetailActivity.class.getName() + ".EXTRA_ID";
    public static final String EXTRA_TITLE = MovieDetailActivity.class.getName() + ".EXTRA_TITLE";
    public static final String EXTRA_IMAGE_URL = MovieDetailActivity.class.getName() + ".EXTRA_IMAGE_URL";
    public static final String EXTRA_CELEBRITIES = MovieDetailActivity.class.getName() + "" + ".EXTRA_CELEBRITIES";

    @Bind(R.id.back_drop)
    ImageView mBackDrop;
    @Bind(R.id.summary)
    TextView mSummary;
    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.btn_expand)
    Button mExpand;
    @Bind(R.id.list_celebrity)
    RecyclerView mListCelebrity;

    @OnClick(R.id.btn_expand)
    void onBtnExpandClicked() {
        if (!mIsExpanded) {
            expandSummaryText();
        } else {
            collapseSummaryText();
        }
    }

    private boolean mIsExpanded;
    private List<Celebrity> mCelebrities;
    private CelebrityListAdapter mAdapter;
    private Api mApi;

    public static void actionStart(Context context, String id, String title, String imageUrl, List<Celebrity> celebrities) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(EXTRA_ID, id);
        intent.putExtra(EXTRA_TITLE, title);
        intent.putExtra(EXTRA_IMAGE_URL, imageUrl);
        intent.putParcelableArrayListExtra(EXTRA_CELEBRITIES, (ArrayList<? extends Parcelable>) celebrities);
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
        mCelebrities = new ArrayList<>();
        mAdapter = new CelebrityListAdapter(mCelebrities);
        mIsExpanded = false;
    }

    @Override
    protected void initView() {
        super.initView();

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListCelebrity.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mListCelebrity.setAdapter(mAdapter);
        mListCelebrity.setNestedScrollingEnabled(false);

        String id = getIntent().getStringExtra(EXTRA_ID);
        String url = getIntent().getStringExtra(EXTRA_IMAGE_URL);
        String title = getIntent().getStringExtra(EXTRA_TITLE);
        List<Celebrity> celebrities = getIntent().getParcelableArrayListExtra(EXTRA_CELEBRITIES);

        getSupportActionBar().setTitle(title);

        loadBackDrop(url);
        loadCelebrities(celebrities);

        fetchMovieDetail(id);

        fetchMoviePhoto(id);
    }

    private void loadBackDrop(String url) {
        Picasso.with(this)
                .load(url)
                .into(mBackDrop);
    }

    private void loadCelebrities(List<Celebrity> celebrities) {
        mCelebrities.addAll(celebrities);
        mAdapter.notifyDataSetChanged();
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
                            }
                        }, new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                logger.error(throwable);

                                ExceptionHandler.handleHttpException(MovieDetailActivity.this, (HttpException) throwable);
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
                                logger.error(throwable);
                            }
                        })
        );
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
