package com.aaron.doubanmovie.soon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aaron.doubanmovie.R;

public class SoonFragment extends Fragment {
    public SoonFragment() {
    }

    public static SoonFragment newInstance() {
        SoonFragment fragment = new SoonFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_soon, container, false);
    }

}
