package com.aaron.doubanmovie.soon;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.api.Api;
import com.aaron.doubanmovie.api.ApiImpl;
import com.aaron.doubanmovie.api.gson.ComingSoon;
import com.aaron.doubanmovie.util.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class SoonListFragment extends Fragment {

    private static final Logger logger = new Logger(SoonListFragment.class);

    @Bind(R.id.list_movies)
    RecyclerView mListMovies;

    @Bind(R.id.swipe)
    SwipeRefreshLayout mSwipe;
    private Api mApi;
    private SoonListAdapter mAdapter;
    private Subscription mSubsComingSoon;

    public static SoonListFragment newInstance() {
        SoonListFragment fragment = new SoonListFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_soon_list, container, false);
        ButterKnife.bind(this, view);

        mSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorPrimary, R.color.colorPrimaryDark);
        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchMovies();
            }
        });
        mSwipe.post(new Runnable() {
            @Override
            public void run() {
                mSwipe.setRefreshing(true);
            }
        });

        mListMovies.setLayoutManager(new LinearLayoutManager(getActivity()));
        mListMovies.setAdapter(mAdapter);

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
        if (!mSubsComingSoon.isUnsubscribed()) {
            mSubsComingSoon.unsubscribe();
        }
        super.onDestroy();
    }

    private void initData() {
        mApi = ApiImpl.getInstance(getActivity());
        mAdapter = new SoonListAdapter();
    }

    private void fetchMovies() {
        mSubsComingSoon = mApi.getComingSoon(0, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ComingSoon>() {
                    @Override
                    public void call(ComingSoon comingSoon) {
                        mSwipe.setRefreshing(false);

                        mAdapter.setMovies(comingSoon.getMovies());
                        mAdapter.notifyDataSetChanged();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        logger.error(throwable);
                    }
                });
    }
}
