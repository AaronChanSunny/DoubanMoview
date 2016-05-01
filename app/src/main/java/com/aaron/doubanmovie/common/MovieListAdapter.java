package com.aaron.doubanmovie.common;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.model.Movie;
import com.aaron.doubanmovie.util.Logger;
import com.aaron.doubanmovie.util.MovieParser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Git on 2016/1/23.
 */
public class MovieListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final Logger logger = new Logger(MovieListAdapter.class);
    private static final int VIEW_ITEM = 0;
    private static final int VIEW_LOADING = 1;
    private static final int VISIBLE_THRESHOLD = 5;

    private List<Movie> mMovies;
    private boolean mIsLoading;
    private OnItemClickListener mOnItemClickListener;
    private OnLoadMoreCallback mOnLoadMoreListener;

    public MovieListAdapter() {
        mMovies = new ArrayList<>();
    }

    /**
     * 在 RecyclerView 设置 LayoutManager 之后调用
     * @param recyclerView
     */
    public void bindRecyclerView(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            final LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    int totalItemCount = layoutManager.getItemCount();
                    int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
                    if (!mIsLoading && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD)) {
                        // End has been reached
                        // Do something
                        if (mOnLoadMoreListener != null) {
                            mOnLoadMoreListener.onLoadMore();
                        }
                        mIsLoading = true;
                    }
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setOnLoadMoreListener(OnLoadMoreCallback onLoadMoreListener) {
        this.mOnLoadMoreListener = onLoadMoreListener;
    }

    public List<Movie> getMovies() {
        return mMovies;
    }

    public void setMovies(List<Movie> movies) {
        mMovies = movies;
    }

    public void setLoaded() {
        mIsLoading = false;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;

        if (viewType == VIEW_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_movie_list, parent, false);
            holder = new ViewHolder1(itemView);
        } else {
            View loadingView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_loading, parent, false);
            holder = new ViewHolder2(loadingView);
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == VIEW_ITEM) {
            Movie movie = mMovies.get(position);

            ViewHolder1 holder1 = (ViewHolder1) holder;
            holder1.mTitle.setText(movie.getTitle());
            holder1.mYear.setText(movie.getYear());

            double average = movie.getRating().getAverage();
            double max = movie.getRating().getMax();
            float rating = (float) (average / max);

            holder1.mRatingBar.setRating(rating * holder1.mRatingBar.getNumStars());
            Context context = holder1.mRatingValue.getContext();
            holder1.mRatingValue.setText(rating == 0.0 ? context.getString(R.string.label_rating_unavailable) :
                    String.format(Locale.CHINA, "%.1f", average));

            String genres = MovieParser.parseGenres(movie.getGenres());
            holder1.mType.setText(genres);

            String casts = MovieParser.parseCasts(movie.getCasts());
            holder1.mCasts.setText(casts);

            String imageUrl = movie.getImages().getLarge();
            Picasso.with(holder1.mImage.getContext())
                    .load(imageUrl)
                    .into(holder1.mImage);
        } else {
            ViewHolder2 holder2 = (ViewHolder2) holder;
            holder2.mLoading.setIndeterminate(true);
        }
    }

    /**
     * 下拉刷新的进度条也算一个列表项
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mMovies.get(position) != null ? VIEW_ITEM : VIEW_LOADING;
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        @Bind(R.id.title)
        TextView mTitle;
        @Bind(R.id.year)
        TextView mYear;
        @Bind(R.id.image)
        ImageView mImage;
        @Bind(R.id.rating_value)
        TextView mRatingValue;
        @Bind(R.id.rating_bar)
        RatingBar mRatingBar;
        @Bind(R.id.type)
        TextView mType;
        @Bind(R.id.casts)
        TextView mCasts;

        public ViewHolder1(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(itemView, getLayoutPosition());
                    }
                }
            });
        }

    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        @Bind(R.id.loading)
        ProgressBar mLoading;

        public ViewHolder2(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnLoadMoreCallback {
        void onLoadMore();
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }
}
