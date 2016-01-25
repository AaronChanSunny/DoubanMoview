package com.aaron.doubanmovie.bus.event;

import com.aaron.doubanmovie.network.DoubanApiException;

/**
 * Created by OA on 2016/1/25.
 */
public class DoubanApiExceptionEvent {

    public final DoubanApiException mException;

    public DoubanApiExceptionEvent(DoubanApiException exception) {
        this.mException = exception;
    }

}
