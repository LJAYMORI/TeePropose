package com.tee.teepropose;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tee on 16. 5. 22..
 */
public class LetterListAdapter extends RecyclerView.Adapter<LetterListAdapter.LetterViewHolder> {

    List<LetterListData> mItems = new ArrayList<>();

    public void addItems(LetterListData... data) {
        Collections.addAll(mItems, data);
        notifyDataSetChanged();
    }

    @Override
    public LetterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == 0) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.letter_item_first, parent, false);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.letter_item, parent, false);
        }

        return new LetterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LetterViewHolder holder, int position) {
        holder.tv.setText(mItems.get(position).text);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0/* || position == getItemCount() - 1*/) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class LetterViewHolder extends RecyclerView.ViewHolder {
        public TextView tv;

        public LetterViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_letter);
        }
    }
}
