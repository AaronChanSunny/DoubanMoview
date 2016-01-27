package com.aaron.doubanmovie.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.model.InTheaters;
import com.aaron.doubanmovie.util.StringUtil;
import com.aaron.doubanmovie.view.activity.MovieDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Git on 2016/1/23.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private Context mContext;
    private List<InTheaters.Movie> mMovies;

    public MoviesAdapter(Context context) {
        mContext = context;
        mMovies = new ArrayList<>();
    }

    public void setMovies(List<InTheaters.Movie> movies) {
        mMovies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        InTheaters.Movie movie = mMovies.get(position);
        holder.mTitle.setText(movie.getTitle());
        holder.mYear.setText(movie.getYear());

        double average = movie.getRating().getAverage();
        double max = movie.getRating().getMax();
        float rating = (float) (average / max);

        holder.mRatingBar.setRating(rating * holder.mRatingBar.getNumStars());
        holder.mRatingValue.setText(String.format("%.1f", average));

        String genres = StringUtil.formatStringList(movie.getGenres());
        holder.mType.setText(genres);

        List<String> casts = new ArrayList<>();
        for (InTheaters.Movie.Cast cast : movie.getCasts()) {
            casts.add(cast.getName());
        }
        holder.mCasts.setText(StringUtil.formatStringList(casts));

        String image = movie.getImages().getLarge();
        Picasso.with(mContext).load(image).into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

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

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InTheaters.Movie movie = mMovies.get(getLayoutPosition());
                    String movieId = movie.getId();
                    String title = movie.getTitle();
                    MovieDetailActivity.actionStart(mContext, movieId, title);
                }
            });
        }

    }

}
