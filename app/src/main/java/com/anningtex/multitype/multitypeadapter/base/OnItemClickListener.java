package com.anningtex.multitype.multitypeadapter.base;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Song
 */
public interface OnItemClickListener<T> {
    void onItemClick(View view, RecyclerView.ViewHolder holder, T t, int position);

    boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, T t, int position);
}
