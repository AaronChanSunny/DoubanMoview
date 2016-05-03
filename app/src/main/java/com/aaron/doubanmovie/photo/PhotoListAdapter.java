package com.aaron.doubanmovie.photo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aaron.doubanmovie.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by aaronchan on 16/5/2.
 */
public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolder> {

    private List<String> mPhotos;

    public PhotoListAdapter(List<String> photos) {
        mPhotos = photos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_photo_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String photo = mPhotos.get(position);

        Picasso.with(holder.mImgPhoto.getContext())
                .load(photo)
                .placeholder(R.drawable.ic_image_white_24dp)
                .into(holder.mImgPhoto);
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.img_photo)
        ImageView mImgPhoto;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PhotoPreviewActivity.actionStart(v.getContext(), mPhotos.get(getLayoutPosition()));
                }
            });
        }
    }
}
