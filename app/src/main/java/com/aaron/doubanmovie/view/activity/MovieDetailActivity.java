package com.aaron.doubanmovie.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.aaron.doubanmovie.view.fragment.MovieDetailFragment;

public class MovieDetailActivity extends SingleFragmentActivity {

    private static final String EXTRA_MOVIE_ID = MovieDetailActivity.class.getName() + ".EXTRA_MOVIE_ID";
    private static final String EXTRA_MOVIE_TITLE = MovieDetailActivity.class.getName() + ".EXTRA_MOVIE_TITLE";

    public static void actionStart(Context context, String movieId, String title) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(EXTRA_MOVIE_ID, movieId);
        intent.putExtra(EXTRA_MOVIE_TITLE, title);

        context.startActivity(intent);
    }

    @Override
    protected Fragment createFragment() {
        String movieId = getIntent().getStringExtra(EXTRA_MOVIE_ID);
        String title = getIntent().getStringExtra(EXTRA_MOVIE_TITLE);

        return MovieDetailFragment.newInstance(movieId, title);
    }

}
