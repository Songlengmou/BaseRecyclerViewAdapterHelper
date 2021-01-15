package com.anningtex.multitype.test.manyData.adapter;

import androidx.annotation.NonNull;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.multitype.multitypeadapter.base.MultiItemView;
import com.anningtex.multitype.multitypeadapter.base.ViewHolder;
import com.anningtex.multitype.test.manyData.bean.Bean01;

/**
 * @author Song
 */
public class ItemView01 extends MultiItemView<Bean01> {

    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.item_one;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Bean01 item, int position) {
        holder.setText(R.id.tv_item01, item.title);
        if (position == 0 || position == 8 || position == 15 || position == 21 || position == 28) {
            holder.setBackgroundColor(R.id.tv_item01, 0xFF48F745);
        } else {
            holder.setBackgroundColor(R.id.tv_item01, 0xFFFF4081);
        }
    }
}