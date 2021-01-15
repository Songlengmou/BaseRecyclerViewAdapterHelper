package com.anningtex.multitype.test.manyData.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.multitype.multitypeadapter.base.MultiItemView;
import com.anningtex.multitype.multitypeadapter.base.ViewHolder;
import com.anningtex.multitype.test.manyData.bean.Bean02;
import com.bumptech.glide.Glide;

/**
 * @author Song
 */
public class ItemView02 extends MultiItemView<Bean02> {
    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.item_two;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Bean02 item, int position) {
        holder.setText(R.id.tv_item02, item.title);
        ImageView iv = holder.getView(R.id.iv_item02);
        Glide.with(iv.getContext())
                .load(item.imgUrl)
//                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
//                .error(R.mipmap.cheese) // will be displayed if the image cannot be loaded
                .centerCrop()
                .into(iv);
    }
}
