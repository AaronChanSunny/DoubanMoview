package com.aaron.doubanmovie.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.aaron.doubanmovie.view.fragment.MovieDetailFragment;

public class MovieDetailActivity extends SingleFragmentActivity {

    private static final String EXTRA_MOVIE_ID = MovieDetailActivity.class.getName() + ".EXTRA_MOVIE_ID";

    public static void actionStart(Context context, String movieId) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(EXTRA_MOVIE_ID, movieId);

        context.startActivity(intent);
    }

    @Override
    protected Fragment createFragment() {
        String movieId = getIntent().getStringExtra(EXTRA_MOVIE_ID);

        return MovieDetailFragment.newInstance(movieId);
    }

}
