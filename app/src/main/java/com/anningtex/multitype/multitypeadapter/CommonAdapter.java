package com.anningtex.multitype.multitypeadapter;

import android.content.Context;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.anningtex.multitype.multitypeadapter.base.MultiItemView;
import com.anningtex.multitype.multitypeadapter.base.ViewHolder;

/**
 * @author Song
 */
public abstract class CommonAdapter<T> extends MultiTypeAdapter {
    Context mContext;
    @LayoutRes
    int layoutId;

    public CommonAdapter(Context context, Class<? extends T> clazz, @LayoutRes final int layoutId) {
        super();
        mContext = context;
        this.layoutId = layoutId;
        register(clazz, new MultiItemView<T>() {
            @NonNull
            @Override
            public int getLayoutId() {
                return layoutId;
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull T item, int position) {
                convert(holder, item, position);
            }
        });
    }

    public CommonAdapter(Context context, Class<? extends T> clazz, @LayoutRes final int layoutId, final int maxRecyclerCount) {
        super();
        mContext = context;
        this.layoutId = layoutId;
        register(clazz, new MultiItemView<T>() {

            @NonNull
            @Override
            public int getLayoutId() {
                return layoutId;
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull T item, int position) {
                convert(holder, item, position);
            }

            @Override
            public int getMaxRecycleCount() {
                return maxRecyclerCount;
            }
        });
    }

    protected abstract void convert(ViewHolder holder, T t, int position);
}
