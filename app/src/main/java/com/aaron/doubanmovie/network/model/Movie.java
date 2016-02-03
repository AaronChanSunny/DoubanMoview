package com.aaron.doubanmovie.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by OA on 2016/1/25.
 */
public class Movie {

    /**
     * max : 10
     * average : 7.4
     * stars : 40
     * min : 0
     */

    @SerializedName("rating")
    private Rating mRating;
    /**
     * rating : {"max":10,"average":7.4,"stars":"40","min":0}
     * reviews_count : 289
     * wish_count : 14638
     * collect_count : 69751
     * douban_site :
     * year : 2009
     * images : {"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p494268647.jpg","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p494268647.jpg","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p494268647.jpg"}
     * alt : http://movie.douban.com/subject/1764796/
     * id : 1764796
     * mobile_url : http://movie.douban.com/subject/1764796/mobile
     * title : 机器人9号
     * do_count : null
     * share_url : http://m.douban.com/movie/subject/1764796
     * seasons_count : null
     * schedule_url :
     * episodes_count : null
     * genres : ["动画","冒险","奇幻"]
     * countries : ["美国"]
     * casts : [{"avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/51597.jpg","large":"http://img3.doubanio.com/img/celebrity/large/51597.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/51597.jpg"},"alt":"http://movie.douban.com/celebrity/1054395/","id":"1054395","name":"伊利亚·伍德"},{"avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/3996.jpg","large":"http://img3.doubanio.com/img/celebrity/large/3996.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/3996.jpg"},"alt":"http://movie.douban.com/celebrity/1016673/","id":"1016673","name":"詹妮弗·康纳利"},{"avatars":{"small":"http://img3.douban.com/img/celebrity/small/55994.jpg","large":"http://img3.douban.com/img/celebrity/large/55994.jpg","medium":"http://img3.douban.com/img/celebrity/medium/55994.jpg"},"alt":"http://movie.douban.com/celebrity/1017907/","id":"1017907","name":"约翰·C·赖利"},{"avatars":{"small":"http://img3.douban.com/img/celebrity/small/42033.jpg","large":"http://img3.douban.com/img/celebrity/large/42033.jpg","medium":"http://img3.douban.com/img/celebrity/medium/42033.jpg"},"alt":"http://movie.douban.com/celebrity/1036321/","id":"1036321","name":"克里斯托弗·普卢默"}]
     * current_season : null
     * original_title : 9
     * summary : 机器人9号（伊利亚•伍德 Elijah Wood 饰）突然醒来，发现身边的世界充满危机，四处残败，一片末世景象。9号带着一个画有三个奇怪符号的圆形物体逃到街上，幸遇发明家机器人2号（马丁•兰道 Martin Landau 饰）给自己装上了声音，但2号却不幸被机器怪兽抓走。9号找到了老兵1号（克里斯托弗•普卢默 Christopher Plummer 饰）、机械工5号（约翰•雷利 John C. Reilly 饰）、疯癫画家6号（克里斯品•格拉夫 Crispin Glover 饰）和大力士8号（弗雷德•塔塔绍尔 Fred Tatasciore 饰）。9号与5号擅自出行援救2号，危急时被女武士7号（詹妮佛•康纳利 Jennifer Connelly 饰）救下，但无意中9号却令终极机器兽复活。带着自己从哪里来以及生存使命的问题，9号决定想尽办法制服机器兽，拯救全世界……©豆瓣
     * subtype : movie
     * directors : [{"avatars":{"small":"http://img3.douban.com/img/celebrity/small/1351678808.44.jpg","large":"http://img3.douban.com/img/celebrity/large/1351678808.44.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1351678808.44.jpg"},"alt":"http://movie.douban.com/celebrity/1276787/","id":"1276787","name":"申·阿克"}]
     * comments_count : 11324
     * ratings_count : 55815
     * aka : ["9：末世决战","九","Number 9","机器人9号"]
     */

    @SerializedName("reviews_count")
    private int mReviewsCount;
    @SerializedName("wish_count")
    private int mWishCount;
    @SerializedName("collect_count")
    private int mCollectCount;
    @SerializedName("douban_site")
    private String mDoubanSite;
    @SerializedName("year")
    private String mYear;
    /**
     * small : http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p494268647.jpg
     * large : http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p494268647.jpg
     * medium : http://img3.doubanio.com/view/movie_poster_cover/spst/public/p494268647.jpg
     */

    @SerializedName("images")
    private Images mImages;
    @SerializedName("alt")
    private String mAlt;
    @SerializedName("id")
    private String mId;
    @SerializedName("mobile_url")
    private String mMobileUrl;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("do_count")
    private Object mDoCount;
    @SerializedName("share_url")
    private String mShareUrl;
    @SerializedName("seasons_count")
    private Object mSeasonsCount;
    @SerializedName("schedule_url")
    private String mScheduleUrl;
    @SerializedName("episodes_count")
    private Object mEpisodesCount;
    @SerializedName("current_season")
    private Object mCurrentSeason;
    @SerializedName("original_title")
    private String mOriginalTitle;
    @SerializedName("summary")
    private String mSummary;
    @SerializedName("subtype")
    private String mSubtype;
    @SerializedName("comments_count")
    private int mCommentsCount;
    @SerializedName("ratings_count")
    private int mRatingsCount;
    @SerializedName("genres")
    private List<String> mGenres;
    @SerializedName("countries")
    private List<String> mCountries;
    /**
     * avatars : {"small":"http://img3.doubanio.com/img/celebrity/small/51597.jpg","large":"http://img3.doubanio.com/img/celebrity/large/51597.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/51597.jpg"}
     * alt : http://movie.douban.com/celebrity/1054395/
     * id : 1054395
     * name : 伊利亚·伍德
     */

    @SerializedName("casts")
    private List<Cast> mCasts;
    /**
     * avatars : {"small":"http://img3.douban.com/img/celebrity/small/1351678808.44.jpg","large":"http://img3.douban.com/img/celebrity/large/1351678808.44.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1351678808.44.jpg"}
     * alt : http://movie.douban.com/celebrity/1276787/
     * id : 1276787
     * name : 申·阿克
     */

    @SerializedName("directors")
    private List<Director> mDirectors;
    @SerializedName("aka")
    private List<String> mAka;

    public void setRating(Rating rating) {
        this.mRating = rating;
    }

    public void setReviewsCount(int reviewsCount) {
        this.mReviewsCount = reviewsCount;
    }

    public void setWishCount(int wishCount) {
        this.mWishCount = wishCount;
    }

    public void setCollectCount(int collectCount) {
        this.mCollectCount = collectCount;
    }

    public void setDoubanSite(String doubanSite) {
        this.mDoubanSite = doubanSite;
    }

    public void setYear(String year) {
        this.mYear = year;
    }

    public void setImages(Images images) {
        this.mImages = images;
    }

    public void setAlt(String alt) {
        this.mAlt = alt;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mMobileUrl = mobileUrl;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setDoCount(Object doCount) {
        this.mDoCount = doCount;
    }

    public void setShareUrl(String shareUrl) {
        this.mShareUrl = shareUrl;
    }

    public void setSeasonsCount(Object seasonsCount) {
        this.mSeasonsCount = seasonsCount;
    }

    public void setScheduleUrl(String scheduleUrl) {
        this.mScheduleUrl = scheduleUrl;
    }

    public void setEpisodesCount(Object episodesCount) {
        this.mEpisodesCount = episodesCount;
    }

    public void setCurrentSeason(Object currentSeason) {
        this.mCurrentSeason = currentSeason;
    }

    public void setOriginalTitle(String originalTitle) {
        this.mOriginalTitle = originalTitle;
    }

    public void setSummary(String summary) {
        this.mSummary = summary;
    }

    public void setSubtype(String subtype) {
        this.mSubtype = subtype;
    }

    public void setCommentsCount(int commentsCount) {
        this.mCommentsCount = commentsCount;
    }

    public void setRatingsCount(int ratingsCount) {
        this.mRatingsCount = ratingsCount;
    }

    public void setGenres(List<String> genres) {
        this.mGenres = genres;
    }

    public void setCountries(List<String> countries) {
        this.mCountries = countries;
    }

    public void setCasts(List<Cast> casts) {
        this.mCasts = casts;
    }

    public void setDirectors(List<Director> directors) {
        this.mDirectors = directors;
    }

    public void setAka(List<String> aka) {
        this.mAka = aka;
    }

    public Rating getRating() {
        return mRating;
    }

    public int getReviewsCount() {
        return mReviewsCount;
    }

    public int getWishCount() {
        return mWishCount;
    }

    public int getCollectCount() {
        return mCollectCount;
    }

    public String getDoubanSite() {
        return mDoubanSite;
    }

    public String getYear() {
        return mYear;
    }

    public Images getImages() {
        return mImages;
    }

    public String getAlt() {
        return mAlt;
    }

    public String getId() {
        return mId;
    }

    public String getMobileUrl() {
        return mMobileUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public Object getDoCount() {
        return mDoCount;
    }

    public String getShareUrl() {
        return mShareUrl;
    }

    public Object getSeasonsCount() {
        return mSeasonsCount;
    }

    public String getScheduleUrl() {
        return mScheduleUrl;
    }

    public Object getEpisodesCount() {
        return mEpisodesCount;
    }

    public Object getCurrentSeason() {
        return mCurrentSeason;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public String getSummary() {
        return mSummary;
    }

    public String getSubtype() {
        return mSubtype;
    }

    public int getCommentsCount() {
        return mCommentsCount;
    }

    public int getRatingsCount() {
        return mRatingsCount;
    }

    public List<String> getGenres() {
        return mGenres;
    }

    public List<String> getCountries() {
        return mCountries;
    }

    public List<Cast> getCasts() {
        return mCasts;
    }

    public List<Director> getDirectors() {
        return mDirectors;
    }

    public List<String> getAka() {
        return mAka;
    }

    public static class Rating {
        @SerializedName("max")
        private int mMax;
        @SerializedName("average")
        private double mAverage;
        @SerializedName("stars")
        private String mStars;
        @SerializedName("min")
        private int mMin;

        public void setMax(int max) {
            this.mMax = max;
        }

        public void setAverage(double average) {
            this.mAverage = average;
        }

        public void setStars(String stars) {
            this.mStars = stars;
        }

        public void setMin(int min) {
            this.mMin = min;
        }

        public int getMax() {
            return mMax;
        }

        public double getAverage() {
            return mAverage;
        }

        public String getStars() {
            return mStars;
        }

        public int getMin() {
            return mMin;
        }
    }

    public static class Images {
        @SerializedName("small")
        private String mSmall;
        @SerializedName("large")
        private String mLarge;
        @SerializedName("medium")
        private String mMedium;

        public void setSmall(String small) {
            this.mSmall = small;
        }

        public void setLarge(String large) {
            this.mLarge = large;
        }

        public void setMedium(String medium) {
            this.mMedium = medium;
        }

        public String getSmall() {
            return mSmall;
        }

        public String getLarge() {
            return mLarge;
        }

        public String getMedium() {
            return mMedium;
        }
    }

    public static class Cast {
        /**
         * small : http://img3.doubanio.com/img/celebrity/small/51597.jpg
         * large : http://img3.doubanio.com/img/celebrity/large/51597.jpg
         * medium : http://img3.doubanio.com/img/celebrity/medium/51597.jpg
         */

        @SerializedName("avatars")
        private Avatars mAvatars;
        @SerializedName("alt")
        private String mAlt;
        @SerializedName("id")
        private String mId;
        @SerializedName("name")
        private String mName;

        public void setAvatars(Avatars avatars) {
            this.mAvatars = avatars;
        }

        public void setAlt(String alt) {
            this.mAlt = alt;
        }

        public void setId(String id) {
            this.mId = id;
        }

        public void setName(String name) {
            this.mName = name;
        }

        public Avatars getAvatars() {
            return mAvatars;
        }

        public String getAlt() {
            return mAlt;
        }

        public String getId() {
            return mId;
        }

        public String getName() {
            return mName;
        }

        public static class Avatars {
            @SerializedName("small")
            private String mSmall;
            @SerializedName("large")
            private String mLarge;
            @SerializedName("medium")
            private String mMedium;

            public void setSmall(String small) {
                this.mSmall = small;
            }

            public void setLarge(String large) {
                this.mLarge = large;
            }

            public void setMedium(String medium) {
                this.mMedium = medium;
            }

            public String getSmall() {
                return mSmall;
            }

            public String getLarge() {
                return mLarge;
            }

            public String getMedium() {
                return mMedium;
            }
        }
    }

    public static class Director {
        /**
         * small : http://img3.douban.com/img/celebrity/small/1351678808.44.jpg
         * large : http://img3.douban.com/img/celebrity/large/1351678808.44.jpg
         * medium : http://img3.douban.com/img/celebrity/medium/1351678808.44.jpg
         */

        @SerializedName("avatars")
        private Avatars mAvatars;
        @SerializedName("alt")
        private String mAlt;
        @SerializedName("id")
        private String mId;
        @SerializedName("name")
        private String mName;

        public void setAvatars(Avatars avatars) {
            this.mAvatars = avatars;
        }

        public void setAlt(String alt) {
            this.mAlt = alt;
        }

        public void setId(String id) {
            this.mId = id;
        }

        public void setName(String name) {
            this.mName = name;
        }

        public Avatars getAvatars() {
            return mAvatars;
        }

        public String getAlt() {
            return mAlt;
        }

        public String getId() {
            return mId;
        }

        public String getName() {
            return mName;
        }

        public static class Avatars {
            @SerializedName("small")
            private String mSmall;
            @SerializedName("large")
            private String mLarge;
            @SerializedName("medium")
            private String mMedium;

            public void setSmall(String small) {
                this.mSmall = small;
            }

            public void setLarge(String large) {
                this.mLarge = large;
            }

            public void setMedium(String medium) {
                this.mMedium = medium;
            }

            public String getSmall() {
                return mSmall;
            }

            public String getLarge() {
                return mLarge;
            }

            public String getMedium() {
                return mMedium;
            }
        }
    }
}
