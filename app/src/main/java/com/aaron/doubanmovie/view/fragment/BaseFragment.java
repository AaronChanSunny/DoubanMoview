package com.aaron.doubanmovie.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Git on 2016/1/23.
 */
public abstract class BaseFragment extends Fragment {

    protected abstract int getLayoutId();

    protected abstract void initInjection();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);

        ButterKnife.bind(this, view);
        initInjection();

        initViews();

        return view;
    }

    protected void initViews() {
        // TODO: 2016/1/23
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
