package com.aaron.doubanmovie.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aaron.doubanmovie.R;
import com.aaron.doubanmovie.model.InTheaters;

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

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
