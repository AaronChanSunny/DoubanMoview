package com.aaron.doubanmovie.in;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.api.Api;
import com.aaron.doubanmovie.api.ApiImpl;
import com.aaron.doubanmovie.api.model.InTheaters;
import com.aaron.doubanmovie.util.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by aaronchan on 16/4/27.
 */
public class InFragment extends Fragment {
    private static final Logger logger = new Logger(InFragment.class);

    @Bind(R.id.list_movies)
    RecyclerView mMoviesRecycleView;

    private MovieListAdapter mAdapter;
    private Api mApi;
    private Subscription mSubsInTheater;

    public static InFragment newInstance() {
        return new InFragment();
    }

    @OnClick(R.id.fab)
    void fabClick() {
        refreshMovies();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_in, container, false);
        ButterKnife.bind(this, view);

        mMoviesRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMoviesRecycleView.setAdapter(mAdapter);

        fetchMovies();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        if (!mSubsInTheater.isUnsubscribed()) {
            mSubsInTheater.unsubscribe();
        }
        super.onDestroy();
    }

    private void initData() {
        mAdapter = new MovieListAdapter(getActivity());
        mApi = ApiImpl.getInstance(getActivity());
    }

    private void fetchMovies() {
        mSubsInTheater = mApi.getInTheaters("福州")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<InTheaters>() {
                    @Override
                    public void call(InTheaters inTheaters) {
                        mAdapter.setMovies(inTheaters.getMovies());
                        mAdapter.notifyDataSetChanged();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Toast.makeText(getActivity(), R.string.server_error, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void refreshMovies() {
        Toast.makeText(getActivity(), R.string.refresh_list, Toast.LENGTH_SHORT).show();
        mMoviesRecycleView.smoothScrollToPosition(0);

        fetchMovies();
    }

}
