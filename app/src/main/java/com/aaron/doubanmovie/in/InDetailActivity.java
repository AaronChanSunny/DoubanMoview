package com.aaron.doubanmovie.in;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.api.Api;
import com.aaron.doubanmovie.api.ApiImpl;
import com.aaron.doubanmovie.model.Movie;
import com.aaron.doubanmovie.util.Logger;
import com.aaron.doubanmovie.util.MovieParser;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class InDetailActivity extends AppCompatActivity {

    public static final String EXTRA_ID = InDetailActivity.class.getName() + ".EXTRA_ID";
    public static final String EXTRA_TITLE = InDetailActivity.class.getName() + ".EXTRA_TITLE";
    public static final String EXTRA_IMAGE_URL = InDetailActivity.class.getName() + ".EXTRA_IMAGE_URL";
    public static final String EXTRA_CASTS = InDetailActivity.class.getName() + ".EXTRA_CASTS";

    private static final Logger logger = new Logger(InDetailActivity.class);

    private Movie mMovieSelected;
    private Api mApi;
    private Subscription mSubsMovie;

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

    public static void actionStart(Context context, String id, String title, String imageUrl, String casts, String genres) {
        Intent intent = new Intent(context, InDetailActivity.class);
        intent.putExtra(EXTRA_ID, id);
        intent.putExtra(EXTRA_TITLE, title);
        intent.putExtra(EXTRA_IMAGE_URL, imageUrl);
        intent.putExtra(EXTRA_CASTS, casts);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_detail);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String id = getIntent().getStringExtra(EXTRA_ID);
        String title = getIntent().getStringExtra(EXTRA_TITLE);
        // String imageUrl = getIntent().getStringExtra(EXTRA_IMAGE_URL);
        String imageUrl = "https://img1.doubanio.com/view/photo/photo/public/p2323952737.jpg";
        String casts = getIntent().getStringExtra(EXTRA_CASTS);

        getSupportActionBar().setTitle(title);
        Picasso.with(this)
                .load(imageUrl)
                .into(mBackDrop);

        mCasts.setText(casts);

        mApi = ApiImpl.getInstance(this);

        fetchMovieDetail(id);

        fetchPhotosHtml(id);
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
        if (!mSubsMovie.isUnsubscribed()) {
            mSubsMovie.unsubscribe();
        }
        super.onDestroy();
    }

    private void fetchMovieDetail(String id) {
        mProgressBar.setVisibility(View.VISIBLE);

        mSubsMovie = mApi.getMovie(id)
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
                        Toast.makeText(InDetailActivity.this, R.string.server_error, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void fetchPhotosHtml(String id) {
        mApi.getMoviePhotos(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> s) {
                        logger.debug("Photos html:\n" + s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        logger.error(throwable);
                    }
                });
    }
}
