package com.anningtex.multitype.test.manyData.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.multitype.multitypeadapter.base.MultiItemView;
import com.anningtex.multitype.multitypeadapter.base.ViewHolder;
import com.anningtex.multitype.multitypeadapter.utils.WrapperUtils;
import com.anningtex.multitype.test.manyData.bean.Bean03;
import com.bumptech.glide.Glide;

/**
 * @author Song
 */
public class ItemView03 extends MultiItemView<Bean03> {

    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.item_three;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Bean03 item, int position) {
        holder.setText(R.id.tv_item03, item.title);
        ImageView iv = holder.getView(R.id.iv_item03);
        Glide.with(iv.getContext())
                .load(item.imgUrl)
//                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
//                .error(R.mipmap.cheese) // will be displayed if the image cannot be loaded
                .centerCrop()
                .into(iv);
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        WrapperUtils.setFullSpan(viewHolder);
    }
}
