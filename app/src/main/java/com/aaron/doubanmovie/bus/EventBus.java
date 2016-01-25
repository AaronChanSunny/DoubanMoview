package com.aaron.doubanmovie.bus;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by OA on 2016/1/25.
 */
public class EventBus extends Bus {

    private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());

    public EventBus() {
        // 允许非主线程生产事件
        super(ThreadEnforcer.ANY);
    }

    public void postOnMainThread(final Object event) {
        if(Looper.myLooper() == Looper.getMainLooper()) {
            super.post(event);
        } else {
            this.mMainThreadHandler.post(new Runnable() {
                public void run() {
                    EventBus.super.post(event);
                }
            });
        }
    }

}
