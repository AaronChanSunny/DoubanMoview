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
import com.aaron.doubanmovie.api.model.InTheaters;
import com.aaron.doubanmovie.api.model.Movie;
import com.aaron.doubanmovie.util.Logger;
import com.aaron.doubanmovie.util.MovieParser;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class InDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = InDetailActivity.class.getName() + ".EXTRA_MOVIE";

    private static final Logger logger = new Logger(InDetailActivity.class);

    private InTheaters.Movie mMovieSelected;
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

    public static void actionStart(Context context, InTheaters.Movie movie) {
        Intent intent = new Intent(context, InDetailActivity.class);
        intent.putExtra(EXTRA_MOVIE, movie);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_detail);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mMovieSelected = getIntent().getParcelableExtra(EXTRA_MOVIE);

        getSupportActionBar().setTitle(mMovieSelected.getTitle());
        Picasso.with(this)
                .load(mMovieSelected.getImages().getLarge())
                .into(mBackDrop);
        mDirectors.setText(MovieParser.parseDirectorsInTheaters(mMovieSelected.getDirectors()));
        mCasts.setText(MovieParser.parseCastsInTheaters(mMovieSelected.getCasts()));

        mApi = ApiImpl.getInstance(this);

        fetchMovieDetail(mMovieSelected.getId());
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
                        mDirectors.setText(MovieParser.parseDirectorsInTheaters(mMovieSelected.getDirectors()));
                        mCasts.setText(MovieParser.parseCastsInTheaters(mMovieSelected.getCasts()));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Toast.makeText(InDetailActivity.this, R.string.server_error, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
