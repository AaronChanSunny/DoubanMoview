package com.aaron.doubanmovie.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aaronchan on 16/4/30.
 */
public class Movie {
    @SerializedName("id")
    private String mId;
    @SerializedName("rating")
    private Rating mRating;
    @SerializedName("year")
    private String mYear;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("summary")
    private String mSummary;
    @SerializedName("images")
    private Images mImages;
    @SerializedName("directors")
    private List<Director> mDirectors;
    @SerializedName("casts")
    private List<Cast> mCasts;
    @SerializedName("genres")
    private List<String> mGenres;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public Rating getRating() {
        return mRating;
    }

    public void setRating(Rating rating) {
        mRating = rating;
    }

    public String getYear() {
        return mYear;
    }

    public void setYear(String year) {
        mYear = year;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public Images getImages() {
        return mImages;
    }

    public void setImages(Images images) {
        mImages = images;
    }

    public List<Director> getDirectors() {
        return mDirectors;
    }

    public void setDirectors(List<Director> directors) {
        mDirectors = directors;
    }

    public List<Cast> getCasts() {
        return mCasts;
    }

    public void setCasts(List<Cast> casts) {
        mCasts = casts;
    }

    public List<String> getGenres() {
        return mGenres;
    }

    public void setGenres(List<String> genres) {
        mGenres = genres;
    }
}
