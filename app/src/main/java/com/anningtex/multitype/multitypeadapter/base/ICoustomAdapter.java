package com.anningtex.multitype.multitypeadapter.base;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Song
 */
public interface ICoustomAdapter {
    void onViewAttachedToWindow(RecyclerView.ViewHolder holder, int postion);
}
