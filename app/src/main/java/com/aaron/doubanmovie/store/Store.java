package com.aaron.doubanmovie.store;

import com.aaron.doubanmovie.action.Action;
import com.aaron.doubanmovie.bus.EventBus;

/**
 * Created by Aaron on 2016/1/31.
 */
public abstract class Store {

    protected EventBus mBus;

    public void register(final Object view) {
        mBus.register(view);
    }

    public void unregister(final Object view) {
        mBus.unregister(view);
    }

    void emitStoreChange() {
        mBus.post(changeEvent());
    }

    public abstract void onAction(Action action);
    public abstract StoreChangeEvent changeEvent();

    public class StoreChangeEvent {
    }

}
