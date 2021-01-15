package com.anningtex.multitype.multitypeadapter.sticky;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;

import com.anningtex.multitype.multitypeadapter.base.ViewHolder;

/**
 * @author Song
 */
public abstract class StickyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements StickyHeaderAdapter<ViewHolder> {
    private Context mContext;
    protected LayoutInflater mInflater;
    protected RecyclerView.Adapter mAdapter;

    @Override
    public int getItemViewType(int position) {
        return mAdapter.getItemViewType(position);
    }

    public StickyAdapter(Context context, RecyclerView.Adapter adapter) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mAdapter = adapter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return mAdapter.onCreateViewHolder(viewGroup, i);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mAdapter.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return mAdapter.getItemCount();
    }


    public ViewHolder onCreateHeaderViewHolder(ViewGroup parent, int position) {
        final View view = mInflater.inflate(getLayoutId(), parent, false);
        return new ViewHolder(mInflater.getContext(), view);
    }

    public void onBindHeaderViewHolder(final ViewHolder viewholder, final int position) {
    }

    protected abstract @LayoutRes
    int getLayoutId();
}
