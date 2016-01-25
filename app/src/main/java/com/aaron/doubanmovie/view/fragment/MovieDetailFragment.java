package com.aaron.doubanmovie.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.aaron.doubanmovie.R;

import butterknife.Bind;

/**
 * Created by OA on 2016/1/25.
 */
public class MovieDetailFragment extends BaseFragment {

    private static final String EXTRA_MOVIE_ID = MovieDetailFragment.class.getName() + ".EXTRA_MOVIE_ID";

    @Bind(R.id.text)
    TextView mText;

    public static Fragment newInstance(String movieId) {
        Bundle args = new Bundle();
        args.putString(EXTRA_MOVIE_ID, movieId);

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

        ((AppCompatActivity)getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);

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
