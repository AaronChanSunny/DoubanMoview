package com.aaron.doubanmovie.api.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aaronchan on 16/4/30.
 */
public class BaseResponse {
    @SerializedName("start")
    private String mStart;
    @SerializedName("count")
    private String mCount;
    @SerializedName("total")
    private String mTotal;

    public String getStart() {
        return mStart;
    }

    public void setStart(String start) {
        mStart = start;
    }

    public String getCount() {
        return mCount;
    }

    public void setCount(String count) {
        mCount = count;
    }

    public String getTotal() {
        return mTotal;
    }

    public void setTotal(String total) {
        mTotal = total;
    }
}
