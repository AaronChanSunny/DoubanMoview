package com.aaron.doubanmovie.top;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aaron.doubanmovie.R;

/**
 * Created by aaronchan on 16/4/27.
 */
public class TopListFragment extends Fragment {
    public static TopListFragment newInstance() {
        return new TopListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top_list, container, false);
    }
}
