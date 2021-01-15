package com.anningtex.multitype.test.one2many.adapter;

import androidx.annotation.NonNull;

import com.anningtex.multitype.multitypeadapter.base.MultiItemView;
import com.anningtex.multitype.multitypeadapter.base.ViewHolder;
import com.anningtex.multitype.test.one2many.Bean04;

/**
 * @author Song
 */
public class ItemView06 extends MultiItemView<Bean04> {

    public ItemView06() {
        super();
        addChildeItemView(new ItemView04());
        addChildeItemView(new ItemView05());
        addChildeItemView(new ItemView07());
    }

    @NonNull
    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Bean04 item, int position) {
//        holder.setText(R.id.tv_item05, item.title);
    }

    @Override
    public boolean isForViewType(Bean04 item, int position) {
        if (Bean04.TYPE_TWO.equals(item.type)) {
            return true;
        }
        return false;
    }
}
