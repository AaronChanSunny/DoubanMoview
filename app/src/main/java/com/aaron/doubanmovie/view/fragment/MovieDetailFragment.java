package com.aaron.doubanmovie.view.fragment;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.view.core.MovieDetailView;

import butterknife.Bind;

/**
 * Created by OA on 2016/1/25.
 */
public class MovieDetailFragment extends BaseFragment implements MovieDetailView {

    private static final String EXTRA_MOVIE_ID = MovieDetailFragment.class.getName() + ".EXTRA_MOVIE_ID";
    private static final String EXTRA_MOVIE_TITLE = MovieDetailFragment.class.getName() + ".EXTRA_MOVIE_TITLE";

    @Bind(R.id.text)
    TextView mText;
    @Bind(R.id.back_drop)
    ImageView mBackDrop;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;

    public static Fragment newInstance(String movieId, String title) {
        Bundle args = new Bundle();
        args.putString(EXTRA_MOVIE_ID, movieId);
        args.putString(EXTRA_MOVIE_TITLE, title);

        Fragment fragment = new MovieDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie_detail;
    }

    @Override
    protected void initInjection() {

    }

    @Override
    protected void initViews() {
        super.initViews();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String title = getArguments().getString(EXTRA_MOVIE_TITLE);
        getSupportActionBar().setTitle(title);

        mText.setText(getArguments().getString(EXTRA_MOVIE_ID));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getActivity().finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
