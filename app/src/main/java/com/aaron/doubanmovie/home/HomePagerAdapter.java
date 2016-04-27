package com.aaron.doubanmovie.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.in.InFragment;
import com.aaron.doubanmovie.soon.SoonFragment;
import com.aaron.doubanmovie.top.TopFragment;

/**
 * Created by aaronchan on 16/4/27.
 */
public class HomePagerAdapter extends FragmentPagerAdapter {
    private static final int COUNT = 3;

    private Context mContext;
    private int[] mPageTitles = new int[] {
            R.string.title_fragment_in,
            R.string.title_fragment_soon,
            R.string.title_fragment_top
    };

    public HomePagerAdapter(FragmentManager fm, Context context) {
        super(fm);

        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = InFragment.newInstance();
                break;
            case 1:
                fragment = SoonFragment.newInstance();
                break;
            case 2:
                fragment = TopFragment.newInstance();
                break;
            default:
                fragment = InFragment.newInstance();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(mPageTitles[position]);
    }
}
