package com.aaron.doubanmovie.photo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.api.Api;
import com.aaron.doubanmovie.api.ApiImpl;
import com.aaron.doubanmovie.common.BaseActivity;
import com.aaron.doubanmovie.common.DividerGridItemDecoration;
import com.aaron.doubanmovie.util.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class PhotoWallActivity extends BaseActivity {

    private static final Logger logger = new Logger(PhotoWallActivity.class);
    private static final String EXTRA_TITLE = PhotoWallActivity.class.getName() + ".EXTRA_TITLE";
    private static final String EXTRA_ID = PhotoWallActivity.class.getName() + ".EXTRA_ID";
    private static final String EXTRA_LOADED = PhotoWallActivity.class.getName() + ".EXTRA_LOADED";

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.list_photo)
    RecyclerView mListPhoto;
    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;

    private String mTitle;
    private String mId;
    private List<String> mPhotos;
    private PhotoWallAdapter mAdapter;
    private Api mApi;

    public static void actionStart(Context context, String title, String id, List<String> loaded) {
        Intent intent = new Intent(context, PhotoWallActivity.class);
        intent.putExtra(EXTRA_TITLE, title);
        intent.putExtra(EXTRA_ID, id);
        intent.putStringArrayListExtra(EXTRA_LOADED, (ArrayList<String>) loaded);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_photo_wall;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initData() {
        super.initData();

        mApi = ApiImpl.getInstance(this);

        mPhotos = new ArrayList<>();

        mTitle = getIntent().getStringExtra(EXTRA_TITLE);
        mId = getIntent().getStringExtra(EXTRA_ID);

        mPhotos.addAll(getIntent().getStringArrayListExtra(EXTRA_LOADED));

        mAdapter = new PhotoWallAdapter(mPhotos);
    }

    @Override
    protected void initView() {
        super.initView();

        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle(mTitle + getString(R.string.suffix_photo_wall));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListPhoto.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        mListPhoto.addItemDecoration(new DividerGridItemDecoration(this));
        mListPhoto.setAdapter(mAdapter);

        fetchAllPhotos(mId);
    }

    private void fetchAllPhotos(String id) {
        mProgressBar.setVisibility(View.VISIBLE);

        addSubscription(
                mApi.getMoviePhotos(id, Integer.MAX_VALUE)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<List<String>>() {
                            @Override
                            public void call(List<String> photos) {
                                mProgressBar.setVisibility(View.GONE);

                                mPhotos.clear();
                                mPhotos.addAll(photos);
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
}
