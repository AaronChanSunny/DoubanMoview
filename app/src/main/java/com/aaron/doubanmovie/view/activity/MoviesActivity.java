package com.aaron.doubanmovie.view.activity;

import android.support.v4.app.Fragment;

import com.aaron.doubanmovie.view.fragment.MoviesFragment;

public class MoviesActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return MoviesFragment.newInstance();
    }

}
