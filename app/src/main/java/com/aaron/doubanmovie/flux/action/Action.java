package com.aaron.doubanmovie.flux.action;

/**
 * Created by Aaron on 2016/1/31.
 */
public class Action<T> {

    private final String mType;
    private final T mData;

    public Action(String type, T data) {
        mType = type;
        mData = data;
    }

    public String getType() {
        return mType;
    }

    public T getData() {
        return mData;
    }

}
