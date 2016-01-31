package com.aaron.doubanmovie.store;

import com.aaron.doubanmovie.action.Action;
import com.aaron.doubanmovie.action.MovieAction;
import com.aaron.doubanmovie.bus.EventBus;
import com.aaron.doubanmovie.model.InTheaters;
import com.squareup.otto.Subscribe;

/**
 * Created by Aaron on 2016/1/31.
 */
public class InTheatersStore extends Store {

    private InTheaters mInTheaters;

    public InTheatersStore(EventBus bus) {
        mBus = bus;
    }

    public InTheaters getInTheaters() {
        return mInTheaters;
    }

    @Subscribe
    @Override
    public void onAction(Action action) {
        switch (action.getType()) {
            case MovieAction.ACTION_FETCH_MOVIES_SUCCESS:
                mInTheaters = (InTheaters) action.getData();
            default:
        }

        emitStoreChange();
    }

    @Override
    public StoreChangeEvent changeEvent() {
        return new StoreChangeEvent();
    }

}
