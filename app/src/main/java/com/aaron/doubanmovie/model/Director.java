package com.aaron.doubanmovie.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aaronchan on 16/4/30.
 */
public class Director {
    @SerializedName("name")
    private String mName;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }
}
