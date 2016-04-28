package com.aaron.doubanmovie.in;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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
    @Bind(R.id.swipe)
    SwipeRefreshLayout mSwipe;

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

        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchMovies();
            }
        });

        mMoviesRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMoviesRecycleView.setAdapter(mAdapter);

        mSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorPrimary, R.color.colorPrimaryDark);
        // SwipeRefreshLayout indicator does not appear when the setRefreshing(true) is called before the SwipeRefreshLayout.onMeasure()
        // reference: http://stackoverflow.com/questions/26858692/swiperefreshlayout-setrefreshing-not-showing-indicator-initially
        mSwipe.post(new Runnable() {
            @Override
            public void run() {
                mSwipe.setRefreshing(true);
            }
        });

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
                        mSwipe.setRefreshing(false);

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
        mSwipe.setRefreshing(true);
        mMoviesRecycleView.smoothScrollToPosition(0);

        fetchMovies();
    }

}
