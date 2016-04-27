package com.aaron.doubanmovie.soon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aaron.doubanmovie.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SoonFragment extends Fragment {
    @Bind(R.id.txt_label)
    TextView mTxtLabel;

    public SoonFragment() {
    }

    public static SoonFragment newInstance() {
        SoonFragment fragment = new SoonFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_soon, container, false);
        ButterKnife.bind(this, view);

        mTxtLabel.setText("Hi, Soon Fragment.");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
