package com.aaron.doubanmovie.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aaronchan on 16/5/2.
 */
public class Celebrity {
    @SerializedName("name")
    private String mName;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
