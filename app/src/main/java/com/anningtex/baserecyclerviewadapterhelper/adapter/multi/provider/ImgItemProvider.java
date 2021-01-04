package com.anningtex.baserecyclerviewadapterhelper.adapter.multi.provider;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.entity.ProviderMultiEntity;
import com.anningtex.baserecyclerviewadapterhelper.utils.Tips;
import com.syp.library.provider.BaseItemProvider;
import com.syp.library.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

/**
 * @author Song
 */
public class ImgItemProvider extends BaseItemProvider<ProviderMultiEntity> {

    @Override
    public int getItemViewType() {
        return ProviderMultiEntity.IMG;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_image_view;
    }

    @Override
    public void convert(@NonNull BaseViewHolder helper, @Nullable ProviderMultiEntity data) {
        if (helper.getAdapterPosition() % 2 == 0) {
            helper.setImageResource(R.id.iv, R.mipmap.animation_img1);
        } else {
            helper.setImageResource(R.id.iv, R.mipmap.animation_img2);
        }
    }

    @Override
    public void onClick(@NonNull BaseViewHolder helper, @NotNull View view, ProviderMultiEntity data, int position) {
        Tips.show("Click: " + position);
    }

    @Override
    public boolean onLongClick(@NotNull BaseViewHolder helper, @NotNull View view, ProviderMultiEntity data, int position) {
        Tips.show("Long Click: " + position);
        return true;
    }
}
