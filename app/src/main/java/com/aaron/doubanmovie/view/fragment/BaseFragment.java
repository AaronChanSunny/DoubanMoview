package com.aaron.doubanmovie.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.aaron.doubanmovie.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Git on 2016/1/23.
 */
public abstract class BaseFragment extends Fragment {

    private ActionBar mSupportActionBar;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    protected abstract int getLayoutId();

    protected abstract void initInjection();

    public ActionBar getSupportActionBar() {
        return mSupportActionBar;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);

        ButterKnife.bind(this, view);
        initInjection();

        initViews();

        return view;
    }

    private void initViews() {
        if (mToolbar != null) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();

            activity.setSupportActionBar(mToolbar);
            mSupportActionBar = activity.getSupportActionBar();
        } else {
            throw new RuntimeException(getActivity().toString()
                    + " must contain toolbar.");
        }

        setHasOptionsMenu(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case android.R.id.home:
                getActivity().finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
