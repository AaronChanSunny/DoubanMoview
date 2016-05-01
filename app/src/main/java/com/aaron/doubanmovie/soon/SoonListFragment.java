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
import android.widget.ProgressBar;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.api.Api;
import com.aaron.doubanmovie.api.ApiImpl;
import com.aaron.doubanmovie.api.gson.ComingSoon;
import com.aaron.doubanmovie.common.MovieListAdapter;
import com.aaron.doubanmovie.model.Movie;
import com.aaron.doubanmovie.util.Logger;
import com.aaron.doubanmovie.util.MovieParser;

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
    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;

    private Api mApi;
    private MovieListAdapter mAdapter;
    private Subscription mSubsComingSoon;
    private Subscription mSubsMoreComingSoon;

    public static SoonListFragment newInstance() {
        SoonListFragment fragment = new SoonListFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();

        fetchMovies();
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


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mListMovies.setLayoutManager(layoutManager);

        mAdapter.bindRecyclerView(mListMovies);
        mAdapter.setOnItemClickListener(new MovieListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Movie movie = mAdapter.getMovies().get(position);
                SoonDetailActivity.actionStart(getActivity(),
                        movie.getId(),
                        movie.getTitle(),
                        movie.getImages().getLarge(),
                        MovieParser.parseCasts(movie.getCasts()),
                        MovieParser.parseGenres(movie.getGenres()));
            }
        });
        mAdapter.setOnLoadMoreListener(new MovieListAdapter.OnLoadMoreCallback() {
            @Override
            public void onLoadMore() {
                fetchMoreMovies();
            }
        });

        mListMovies.setAdapter(mAdapter);

        mProgressBar.setVisibility(mAdapter.getItemCount() > 0 ? View.GONE : View.VISIBLE);

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
        mAdapter = new MovieListAdapter();
    }

    private void fetchMovies() {
        mSubsComingSoon = mApi.getComingSoon(0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ComingSoon>() {
                    @Override
                    public void call(ComingSoon comingSoon) {
                        mSwipe.setRefreshing(false);
                        mProgressBar.setVisibility(View.GONE);

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

    private void fetchMoreMovies() {
        // add progress item
        mAdapter.getMovies().add(null);
        mAdapter.notifyItemInserted(mAdapter.getMovies().size() - 1);

        final int currentSize = mAdapter.getItemCount();

        mSubsMoreComingSoon = mApi.getComingSoon(currentSize, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ComingSoon>() {
                    @Override
                    public void call(ComingSoon comingSoon) {
                        mAdapter.getMovies().remove(mAdapter.getMovies().size() - 1);
                        mAdapter.notifyItemRemoved(mAdapter.getMovies().size());

                        mAdapter.getMovies().addAll(comingSoon.getMovies());
                        mAdapter.notifyItemRangeInserted(currentSize, currentSize + 20);

                        mAdapter.setLoaded();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        logger.error(throwable);
                    }
                });
    }
}
