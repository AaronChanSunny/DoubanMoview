package com.aaron.doubanmovie.in;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public class InListAdapter extends RecyclerView.Adapter<InListAdapter.ViewHolder> {

    private static final Logger logger = new Logger(InListAdapter.class);

    private List<Movie> mMovies;

    public InListAdapter() {
        mMovies = new ArrayList<>();
    }

    public void setMovies(List<Movie> movies) {
        mMovies.clear();
        mMovies.addAll(movies);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_in_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = mMovies.get(position);
        holder.mTitle.setText(movie.getTitle());
        holder.mYear.setText(movie.getYear());

        float average = movie.getRating().getAverage();
        int max = movie.getRating().getMax();
        float rating = average / max;

        holder.mRatingBar.setRating(rating * holder.mRatingBar.getNumStars());
        Context context = holder.mRatingValue.getContext();
        holder.mRatingValue.setText(rating == 0.0 ? context.getString(R.string.label_rating_unavailable) :
                String.format(Locale.CHINA, "%.1f", average));

        String genres = MovieParser.parseGenres(movie.getGenres());
        holder.mType.setText(genres);

        String casts = MovieParser.parseCasts(movie.getCasts());
        holder.mCasts.setText(casts);

        String imageUrl = movie.getImages().getLarge();
        Picasso.with(context)
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

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Movie movie = mMovies.get(getLayoutPosition());
                    InDetailActivity.actionStart(itemView.getContext(),
                            movie.getId(),
                            movie.getTitle(),
                            movie.getImages().getLarge(),
                            MovieParser.parseCasts(movie.getCasts()),
                            MovieParser.parseGenres(movie.getGenres()));
                }
            });
        }

    }

}
