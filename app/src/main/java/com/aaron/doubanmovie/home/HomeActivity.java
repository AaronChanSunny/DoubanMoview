package com.aaron.doubanmovie.home;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.in.InListFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tab)
    TabLayout mTab;
    @Bind(R.id.pager)
    ViewPager mPager;
    @Bind(R.id.app_bar)
    AppBarLayout mAppBar;

    private HomePagerAdapter mPagerAdapter;

    @OnClick(R.id.fab)
    void fabClicked() {
        String tag = mPagerAdapter.getFragmentTags().get(mTab.getSelectedTabPosition() + "");

        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (currentFragment != null && currentFragment instanceof InListFragment) {
            ((InListFragment) currentFragment).refreshMovies();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }

        mPagerAdapter = new HomePagerAdapter(getSupportFragmentManager(), this);
        mPager.setAdapter(mPagerAdapter);
        mTab.setupWithViewPager(mPager);
    }

}
