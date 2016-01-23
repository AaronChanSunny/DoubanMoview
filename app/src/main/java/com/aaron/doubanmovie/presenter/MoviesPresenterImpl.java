package com.aaron.doubanmovie.presenter;

import android.content.Context;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.model.InTheaters;
import com.aaron.doubanmovie.network.DoubanApi;
import com.aaron.doubanmovie.util.Logger;
import com.aaron.doubanmovie.view.core.MoviesView;
import com.aaron.doubanmovie.view.fragment.MoviesFragment;

import java.util.List;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by Git on 2016/1/23.
 */
public class MoviesPresenterImpl implements MoviesPresenter {

    private static final Logger logger = new Logger(MoviesPresenterImpl.class);

    private DoubanApi mDoubanApi;
    private MoviesView mView;
    private Context mContext;

    @Inject
    public MoviesPresenterImpl(DoubanApi doubanApi, MoviesView view) {
        mDoubanApi = doubanApi;
        mView = view;
        mContext = ((MoviesFragment)view).getActivity();
    }

    @Override
    public void pause() {
        // TODO: 2016/1/23
    }

    @Override
    public void resume() {
        // TODO: 2016/1/23
    }

    @Override
    public void destroy() {
        // TODO: 2016/1/23
    }

    @Override
    public void fetchMovies() {
        mDoubanApi.getInTheaters("福州", new Action1<InTheaters>() {
            @Override
            public void call(InTheaters inTheaters) {
                logger.debug("fetch movies success.");

                List<InTheaters.Movie> movies = inTheaters.getMovies();
                mView.updateRecycleViewMovies(movies);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                logger.error(throwable);

                mView.showToast(mContext.getString(R.string.network_error));
            }
        });
    }
}
