package com.aaron.doubanmovie.in;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.api.Api;
import com.aaron.doubanmovie.api.ApiImpl;
import com.aaron.doubanmovie.api.gson.InTheater;
import com.aaron.doubanmovie.common.BaseFragment;
import com.aaron.doubanmovie.common.ExceptionHandler;
import com.aaron.doubanmovie.common.MovieListAdapter;
import com.aaron.doubanmovie.util.Logger;

import butterknife.Bind;
import retrofit2.HttpException;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by aaronchan on 16/4/27.
 */
public class InListFragment extends BaseFragment {
    private static final Logger logger = new Logger(InListFragment.class);
    private static final String CITY = "福州";

    @Bind(R.id.list_movies)
    RecyclerView mListMovies;
    @Bind(R.id.swipe)
    SwipeRefreshLayout mSwipe;
    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;

    private MovieListAdapter mAdapter;
    private Api mApi;

    public static InListFragment newInstance() {
        return new InListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_movie_list;
    }

    @Override
    protected void initData() {
        super.initData();

        mApi = ApiImpl.getInstance(getActivity());
        mAdapter = new MovieListAdapter();
    }

    @Override
    protected void initView() {
        super.initView();

        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchMovies();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mListMovies.setLayoutManager(layoutManager);

        mAdapter.bindRecyclerView(mListMovies);
        mAdapter.setOnLoadMoreListener(new MovieListAdapter.OnLoadMoreCallback() {
            @Override
            public void onLoadMore() {
                fetchMoreMovies();
            }
        });
        mListMovies.setAdapter(mAdapter);

        mSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorPrimary, R.color.colorPrimaryDark);

        mProgressBar.setVisibility(mAdapter.getItemCount() > 0 ? View.GONE : View.VISIBLE);

        fetchMovies();
    }

    private void fetchMovies() {
        addSubscription(
                mApi.getInTheaters(CITY, 0, 20)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<InTheater>() {
                            @Override
                            public void call(InTheater inTheater) {
                                mSwipe.setRefreshing(false);
                                mProgressBar.setVisibility(View.GONE);

                                mAdapter.setMovies(inTheater.getMovies());
                                mAdapter.notifyDataSetChanged();
                            }
                        }, new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                logger.error(throwable);

                                if (throwable instanceof HttpException) {
                                    ExceptionHandler.handleHttpException(getActivity(), (HttpException) throwable);
                                }
                            }
                        })
        );
    }

    public void refreshMovies() {
        mSwipe.setRefreshing(true);
        mListMovies.smoothScrollToPosition(0);

        fetchMovies();
    }

    private void fetchMoreMovies() {
        // add progress item
        mAdapter.getMovies().add(null);
        mAdapter.notifyItemInserted(mAdapter.getMovies().size() - 1);

        final int currentSize = mAdapter.getItemCount();

        addSubscription(
                mApi.getInTheaters(CITY, currentSize, 20)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<InTheater>() {
                            @Override
                            public void call(InTheater inTheater) {
                                mAdapter.getMovies().remove(mAdapter.getMovies().size() - 1);
                                mAdapter.notifyItemRemoved(mAdapter.getMovies().size());
                                mAdapter.setLoaded();

                                mAdapter.getMovies().addAll(inTheater.getMovies());
                                mAdapter.notifyItemRangeInserted(currentSize, currentSize + 20);
                            }
                        }, new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                logger.error(throwable);
                            }
                        })
        );
    }

}
