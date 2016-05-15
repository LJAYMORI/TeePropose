package com.tee.teepropose;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jonguk on 2016. 5. 14..
 */
public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageViewHolder> {

    List<ImageListData> mItems = new ArrayList<>();

    public void addItems(ImageListData... data) {
        Collections.addAll(mItems, data);
        notifyDataSetChanged();
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        holder.bind(mItems.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView descriptionView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_item);
            descriptionView = (TextView) itemView.findViewById(R.id.item_text);
        }

        public void bind(ImageListData data, int position) {
            itemView.setRotation(position % 2 == 0 ? 10f : -10f);
            imageView.setImageResource(data.imageResource);
            descriptionView.setText(data.description);
        }
    }
}
