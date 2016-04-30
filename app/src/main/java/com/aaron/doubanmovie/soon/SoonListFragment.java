package com.aaron.doubanmovie.soon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aaron.doubanmovie.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SoonListFragment extends Fragment {

    @Bind(R.id.list_movies)
    RecyclerView mListMovies;
    @Bind(R.id.swipe)
    SwipeRefreshLayout mSwipe;

    public static SoonListFragment newInstance() {
        SoonListFragment fragment = new SoonListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_soon_list, container, false);
        ButterKnife.bind(this, view);

        mSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorPrimary, R.color.colorPrimaryDark);
        mSwipe.post(new Runnable() {
            @Override
            public void run() {
                mSwipe.setRefreshing(true);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
