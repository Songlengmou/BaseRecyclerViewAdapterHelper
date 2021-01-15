package com.anningtex.multitype.test.one2many.adapter;

import androidx.annotation.NonNull;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.multitype.multitypeadapter.base.MultiItemView;
import com.anningtex.multitype.multitypeadapter.base.ViewHolder;
import com.anningtex.multitype.test.one2many.Bean04;

/**
 * @author Song
 */
public class ItemView04 extends MultiItemView<Bean04> {
    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.item_four;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Bean04 item, int position) {
        holder.setText(R.id.tv_item04, item.title);
    }

    @Override
    public boolean isForViewType(Bean04 item, int position) {
        if (Bean04.TYPE_ONE.equals(item.type)) {
            return true;
        }
        return false;
    }
}
