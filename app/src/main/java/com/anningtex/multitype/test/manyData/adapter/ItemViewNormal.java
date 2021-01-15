package com.anningtex.multitype.test.manyData.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.multitype.multitypeadapter.base.MultiItemView;
import com.anningtex.multitype.multitypeadapter.base.ViewHolder;

/**
 * @author Song
 */
public class ItemViewNormal extends MultiItemView<String> {
    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.item_go;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull String item, int position) {
        holder.setText(R.id.tv, item);
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams params = viewHolder.itemView.getLayoutParams();
        if (params != null && params instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) params;
            layoutParams.setFullSpan(true);
        }
    }
}
