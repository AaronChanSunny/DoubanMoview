package com.aaron.doubanmovie.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.aaron.doubanmovie.network.model.InTheaters;
import com.aaron.doubanmovie.view.fragment.MovieDetailFragment;

public class MovieDetailActivity extends SingleFragmentActivity {

    private static final String EXTRA_MOVIE = MovieDetailActivity.class.getName() + ".EXTRA_MOVIE";

    public static void actionStart(Context context, String movieId, String title, String imageUrl, InTheaters.Movie movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(EXTRA_MOVIE, movie);

        context.startActivity(intent);
    }

    @Override
    protected Fragment createFragment() {
        InTheaters.Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        return MovieDetailFragment.newInstance(movie);
    }

}
