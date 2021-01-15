package com.anningtex.multitype.multitypeadapter.sticky;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Song
 */
public interface StickyHeaderAdapter<T extends RecyclerView.ViewHolder> {
    boolean isHeader(int position);
}
