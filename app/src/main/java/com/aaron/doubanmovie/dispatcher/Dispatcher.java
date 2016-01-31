package com.aaron.doubanmovie.dispatcher;

import com.aaron.doubanmovie.action.Action;
import com.aaron.doubanmovie.store.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 2016/1/31.
 */
public class Dispatcher {

    private List<Store> mStores = new ArrayList<>();

    public Dispatcher() {
    }

    public void register(final Store store) {
        mStores.add(store);
    }

    public void unregister(final Store store) {
        mStores.remove(store);
    }

    public void dispatch(Action action) {
        post(action);
    }

    private void post(final Action action) {
        for (Store store : mStores) {
            store.onAction(action);
        }
    }
}
