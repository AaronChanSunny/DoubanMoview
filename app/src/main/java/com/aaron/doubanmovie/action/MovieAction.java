package com.aaron.doubanmovie.action;

import com.aaron.doubanmovie.model.InTheaters;

/**
 * Created by Aaron on 2016/1/31.
 */
public class MovieAction extends Action<InTheaters> {

    public static final String ACTION_FETCH_MOVIES_SUCCESS = "fetch_movies_success";
    public static final String ACTION_FETCH_MOVIES_FAIL = "fetch_movies_fail";

    public MovieAction(String type, InTheaters data) {
        super(type, data);
    }

    public MovieAction(String type) {
        super(type, null);
    }
}
