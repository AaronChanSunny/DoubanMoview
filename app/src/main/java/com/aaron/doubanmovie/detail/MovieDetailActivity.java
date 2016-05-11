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
import com.aaron.doubanmovie.photo.PhotoListAdapter;
import com.aaron.doubanmovie.photo.PhotoWallActivity;
import com.aaron.doubanmovie.util.Logger;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.OnClick;
import retrofit2.HttpException;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MovieDetailActivity extends BaseActivity {

    private static final Logger logger = new Logger(MovieDetailActivity.class);
    private static final String EXTRA_ID = MovieDetailActivity.class.getName() + ".EXTRA_ID";
    private static final String EXTRA_TITLE = MovieDetailActivity.class.getName() + ".EXTRA_TITLE";
    private static final String EXTRA_IMAGE_URL = MovieDetailActivity.class.getName() + ".EXTRA_IMAGE_URL";
    private static final String EXTRA_CELEBRITIES = MovieDetailActivity.class.getName() + "" + ".EXTRA_CELEBRITIES";

    @Bind(R.id.back_drop)
    ImageView mBackDrop;
    @Bind(R.id.summary)
    TextView mSummary;
    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.btn_summary_more)
    Button mExpand;
    @Bind(R.id.list_celebrity)
    RecyclerView mListCelebrity;
    @Bind(R.id.list_photo)
    RecyclerView mListPhoto;
    @Bind(R.id.btn_photo_more)
    Button mButtonPhotoMore;

    @OnClick(R.id.btn_summary_more)
    void onBtnExpandClicked() {
        if (!mIsExpanded) {
            expandSummaryText();
        } else {
            collapseSummaryText();
        }
    }
    @OnClick(R.id.btn_photo_more)
    void onButtonMoreClicked() {
        PhotoWallActivity.actionStart(this, mTitle, mId, mPhotos);
    }

    private String mId;
    private String mImageUrl;
    private String mTitle;
    private List<Celebrity> mCelebritis;
    private boolean mIsExpanded;
    private List<Celebrity> mCelebrities;
    private List<String> mPhotos;
    private CelebrityListAdapter mCelebrityAdapter;
    private PhotoListAdapter mPhotoAdapter;
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

        mId = getIntent().getStringExtra(EXTRA_ID);
        mImageUrl = getIntent().getStringExtra(EXTRA_IMAGE_URL);
        mTitle = getIntent().getStringExtra(EXTRA_TITLE);
        mCelebritis = getIntent().getParcelableArrayListExtra(EXTRA_CELEBRITIES);

        mApi = ApiImpl.getInstance(this);

        mCelebrities = new ArrayList<>();
        mCelebrityAdapter = new CelebrityListAdapter(mCelebrities);

        mPhotos = new ArrayList<>();
        mPhotoAdapter = new PhotoListAdapter(mPhotos);

        mIsExpanded = false;
    }

    @Override
    protected void initView() {
        super.initView();

        setStatusBarColor(android.R.color.transparent);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListCelebrity.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mListCelebrity.setAdapter(mCelebrityAdapter);

        mListPhoto.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mListPhoto.setAdapter(mPhotoAdapter);

        getSupportActionBar().setTitle(mTitle);

        loadBackDrop(mImageUrl);
        loadCelebrities(mCelebritis);

        fetchMovieDetail(mId);

        fetchMoviePhotos(mId, 5);
    }

    private void loadBackDrop(String url) {
        Picasso.with(this)
                .load(url)
                .into(mBackDrop);
    }

    private void loadCelebrities(List<Celebrity> celebrities) {
        mCelebrities.addAll(celebrities);
        mCelebrityAdapter.notifyDataSetChanged();
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

    private void fetchMoviePhotos(String id, int count) {
        addSubscription(
                mApi.getMoviePhotos(id, count)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<List<String>>() {
                            @Override
                            public void call(List<String> photos) {
                                if (photos.size() == 0) {
                                    showEmptyView();
                                    return;
                                }

                                mPhotos.addAll(photos);
                                mPhotoAdapter.notifyDataSetChanged();

                                String randomPhoto = photos.get(new Random().nextInt(photos.size()));
                                loadBackDrop(randomPhoto);
                            }
                        }, new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                logger.error(throwable);
                                showEmptyView();
                            }
                        })
        );
    }

    private void showEmptyView() {
        mPhotos.add(null);
        mPhotoAdapter.notifyDataSetChanged();

        mButtonPhotoMore.setVisibility(View.INVISIBLE);
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

                mExpand.setText(R.string.btn_more);
                mIsExpanded = false;
            }
        });

        animator.start();
    }
}
