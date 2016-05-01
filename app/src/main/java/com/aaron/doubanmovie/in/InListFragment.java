package com.aaron.doubanmovie.in;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.api.Api;
import com.aaron.doubanmovie.api.ApiImpl;
import com.aaron.doubanmovie.api.gson.InTheater;
import com.aaron.doubanmovie.common.BaseFragment;
import com.aaron.doubanmovie.common.MovieListAdapter;
import com.aaron.doubanmovie.model.Movie;
import com.aaron.doubanmovie.util.Logger;
import com.aaron.doubanmovie.util.MovieParser;

import butterknife.Bind;
import butterknife.ButterKnife;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        logger.debug("onCreate");

        initData();

        fetchMovies();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        logger.debug("onCreateView");

        View view = inflater.inflate(R.layout.fragment_in_list, container, false);
        ButterKnife.bind(this, view);

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
                InDetailActivity.actionStart(getActivity(),
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

        mSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorPrimary, R.color.colorPrimaryDark);

        mProgressBar.setVisibility(mAdapter.getItemCount() > 0 ? View.GONE : View.VISIBLE);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private void initData() {
        mApi = ApiImpl.getInstance(getActivity());
        mAdapter = new MovieListAdapter();
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
                        Toast.makeText(getActivity(), R.string.server_error, Toast.LENGTH_SHORT).show();
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

                        mAdapter.getMovies().addAll(inTheater.getMovies());
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
