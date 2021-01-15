package com.anningtex.multitype.test.one2many.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.multitype.multitypeadapter.base.MultiItemView;
import com.anningtex.multitype.multitypeadapter.base.ViewHolder;
import com.anningtex.multitype.multitypeadapter.utils.WrapperUtils;
import com.anningtex.multitype.test.one2many.Bean04;
import com.bumptech.glide.Glide;

/**
 * @author Song
 */
public class ItemView07 extends MultiItemView<Bean04> {

    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.item_seven;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Bean04 item, int position) {
        ImageView iv = holder.getView(R.id.iv);
        Glide.with(iv.getContext())
                .load(item.imgUrl)
//                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
//                .error(R.mipmap.cheese) // will be displayed if the image cannot be loaded
                .centerCrop()
                .into(iv);
    }

    @Override
    public boolean isForViewType(Bean04 item, int position) {
        if (Bean04.TYPE_THREE.equals(item.type)) {
            return true;
        }
        return false;
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        WrapperUtils.setFullSpan(viewHolder);
    }
}
