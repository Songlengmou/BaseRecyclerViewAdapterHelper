package com.anningtex.multitype.multitypeadapter.base;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Song
 */
public abstract class MultiItemView<T> {
    private final List<MultiItemView<T>> list;

    public MultiItemView() {
        list = new ArrayList<>();
    }

    @NonNull
    public abstract @LayoutRes
    int getLayoutId();

    public abstract void onBindViewHolder(@NonNull ViewHolder holder, @NonNull T item, int position);

    public boolean isForViewType(T item, int position) {
        return true;
    }

    public MultiItemView<T> addChildeItemView(MultiItemView<T> multiItemView) {
        list.add(multiItemView);
        return this;
    }

    public boolean haveChild() {
        if (list.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public List<MultiItemView<T>> getChildList() {
        return list;
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
    }

    public int getMaxRecycleCount() {
        return 5;
    }
}
