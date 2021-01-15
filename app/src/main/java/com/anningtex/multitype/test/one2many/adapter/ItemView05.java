package com.anningtex.multitype.test.one2many.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.multitype.multitypeadapter.base.MultiItemView;
import com.anningtex.multitype.multitypeadapter.base.ViewHolder;
import com.anningtex.multitype.multitypeadapter.utils.WrapperUtils;
import com.anningtex.multitype.test.one2many.Bean04;

/**
 * @author Song
 */
public class ItemView05 extends MultiItemView<Bean04> {

    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.item_five;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Bean04 item, int position) {
        holder.setText(R.id.tv_item05, item.title);
    }

    @Override
    public boolean isForViewType(Bean04 item, int position) {
        if (Bean04.TYPE_TWO.equals(item.type)) {
            return true;
        }
        return false;
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        WrapperUtils.setFullSpan(viewHolder);
    }
}
