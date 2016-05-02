package com.aaron.doubanmovie.top;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.api.Api;
import com.aaron.doubanmovie.api.ApiImpl;
import com.aaron.doubanmovie.api.gson.Top;
import com.aaron.doubanmovie.common.BaseFragment;
import com.aaron.doubanmovie.common.MovieListAdapter;
import com.aaron.doubanmovie.detail.MovieDetailActivity;
import com.aaron.doubanmovie.model.Movie;
import com.aaron.doubanmovie.util.Logger;
import com.aaron.doubanmovie.util.MovieParser;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by aaronchan on 16/4/27.
 */
public class TopListFragment extends BaseFragment {
    private static final Logger logger = new Logger(TopListFragment.class);

    @Bind(R.id.list_movies)
    RecyclerView mListMovies;
    @Bind(R.id.swipe)
    SwipeRefreshLayout mSwipe;
    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;

    private Api mApi;
    private MovieListAdapter mAdapter;

    public static TopListFragment newInstance() {
        TopListFragment fragment = new TopListFragment();
        return fragment;
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
                MovieDetailActivity.actionStart(getActivity(),
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

        fetchMovies();
    }

    private void fetchMovies() {
        addSubscription(
                mApi.getTop(0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Top>() {
                    @Override
                    public void call(Top top) {
                        logger.debug("swipe is " + mSwipe);
                        mSwipe.setRefreshing(false);
                        mProgressBar.setVisibility(View.GONE);

                        mAdapter.setMovies(top.getMovies());
                        mAdapter.notifyDataSetChanged();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        logger.error(throwable);
                    }
                })
        );
    }

    private void fetchMoreMovies() {
        // add progress item
        mAdapter.getMovies().add(null);
        mAdapter.notifyItemInserted(mAdapter.getMovies().size() - 1);

        final int currentSize = mAdapter.getItemCount();

        addSubscription(mApi.getTop(currentSize, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Top>() {
                    @Override
                    public void call(Top top) {
                        mAdapter.getMovies().remove(mAdapter.getMovies().size() - 1);
                        mAdapter.notifyItemRemoved(mAdapter.getMovies().size());

                        mAdapter.getMovies().addAll(top.getMovies());
                        mAdapter.notifyItemRangeInserted(currentSize, currentSize + 20);

                        mAdapter.setLoaded();
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
