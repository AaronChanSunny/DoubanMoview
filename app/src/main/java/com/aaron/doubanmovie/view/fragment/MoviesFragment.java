package com.aaron.doubanmovie.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.aaron.doubanmovie.App;
import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.di.component.DaggerMoviesFragmentComponent;
import com.aaron.doubanmovie.di.module.MoviesFragmentModule;
import com.aaron.doubanmovie.model.InTheaters;
import com.aaron.doubanmovie.presenter.MoviesPresenter;
import com.aaron.doubanmovie.view.adapter.MoviesAdapter;
import com.aaron.doubanmovie.view.core.MoviesView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by Git on 2016/1/23.
 */
public class MoviesFragment extends BaseFragment implements MoviesView {

    @Inject
    MoviesPresenter mPresenter;
    @Inject
    MoviesAdapter mMoviesAdapter;

    @Bind(R.id.recycle_view_movies)
    RecyclerView mRecycleViewMovies;

    public static Fragment newInstance() {
        return new MoviesFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movies;
    }

    @Override
    protected void initInjection() {
        DaggerMoviesFragmentComponent.builder()
                .appComponent(App.getApp(getActivity()).getAppComponent())
                .moviesFragmentModule(new MoviesFragmentModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
        mRecycleViewMovies.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycleViewMovies.setAdapter(mMoviesAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.fetchMovies();
    }

    @Override
    public void updateRecycleViewMovies(List<InTheaters.Movie> movies) {
        mMoviesAdapter.setMovies(movies);
        mMoviesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT)
                .show();
    }
}
