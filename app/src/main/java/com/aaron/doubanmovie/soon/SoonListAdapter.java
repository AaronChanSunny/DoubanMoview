package com.aaron.doubanmovie.soon;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.api.model.ComingSoon;
import com.aaron.doubanmovie.util.Logger;
import com.aaron.doubanmovie.util.MovieParser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Git on 2016/1/23.
 */
public class SoonListAdapter extends RecyclerView.Adapter<SoonListAdapter.ViewHolder> {

    private static final Logger logger = new Logger(SoonListAdapter.class);

    private List<ComingSoon.Movie> mMovies;

    public SoonListAdapter() {
        mMovies = new ArrayList<>();
    }

    public void setMovies(List<ComingSoon.Movie> movies) {
        mMovies.clear();
        mMovies.addAll(movies);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_soon_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ComingSoon.Movie movie = mMovies.get(position);
        holder.mTitle.setText(movie.getTitle());
        holder.mYear.setText(movie.getYear());

        double average = movie.getRating().getAverage();
        double max = movie.getRating().getMax();
        float rating = (float) (average / max);

        holder.mRatingBar.setRating(rating * holder.mRatingBar.getNumStars());
        holder.mRatingValue.setText(String.format("%.1f", average));

        String genres = MovieParser.parseGenres(movie.getGenres());
        holder.mType.setText(genres);

        List<String> castNames = new ArrayList<>();
        for (ComingSoon.Movie.Cast cast : movie.getCasts()) {
            castNames.add(cast.getName());
        }
        String casts = MovieParser.parseCasts(castNames);
        holder.mCasts.setText(casts);

        String imageUrl = movie.getImages().getLarge();
        Picasso.with(holder.mImage.getContext())
                .load(imageUrl)
                .into(holder.mImage);
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
                    ComingSoon.Movie movie = mMovies.get(getLayoutPosition());
                    // InDetailActivity.actionStart(mContext, movie);
                }
            });
        }

    }

}
