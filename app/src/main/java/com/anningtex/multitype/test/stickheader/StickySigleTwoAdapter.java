package com.anningtex.multitype.test.stickheader;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.anningtex.multitype.multitypeadapter.sticky.StickyAnyAdapter;

/**
 * @author Song
 */
public class StickySigleTwoAdapter extends StickyAnyAdapter {
    public StickySigleTwoAdapter(Context context, RecyclerView.Adapter mAdapter) {
        super(context, mAdapter);
    }

    @Override
    public boolean isHeader(int position) {
        if (position == 0 || position == 8 || position == 15 || position == 21 || position == 28) {
            return true;
        } else {
            return false;
        }
    }
}
