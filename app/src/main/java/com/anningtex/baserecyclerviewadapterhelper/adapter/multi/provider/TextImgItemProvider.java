package com.anningtex.baserecyclerviewadapterhelper.adapter.multi.provider;

import android.view.View;

import androidx.annotation.NonNull;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.entity.ProviderMultiEntity;
import com.anningtex.baserecyclerviewadapterhelper.utils.Tips;
import com.syp.library.provider.BaseItemProvider;
import com.syp.library.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Song
 */
public class TextImgItemProvider extends BaseItemProvider<ProviderMultiEntity> {

    public TextImgItemProvider() {
        addChildClickViewIds(R.id.tv);
    }

    @Override
    public int getItemViewType() {
        return ProviderMultiEntity.IMG_TEXT;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_img_text_view;
    }

    @Override
    public void convert(@NotNull BaseViewHolder helper, @Nullable ProviderMultiEntity data) {
        helper.setText(R.id.tv, "CymChad " + helper.getAdapterPosition());
        if (helper.getAdapterPosition() % 2 == 0) {
            helper.setImageResource(R.id.iv, R.mipmap.animation_img1);
        } else {
            helper.setImageResource(R.id.iv, R.mipmap.animation_img2);
        }
    }

    /**
     * item 点击
     *
     * @param helper
     * @param data
     * @param position
     */
    @Override
    public void onClick(@NonNull BaseViewHolder helper, @NotNull View view, ProviderMultiEntity data, int position) {
        Tips.show("Click: " + position);
    }

    @Override
    public boolean onLongClick(@NotNull BaseViewHolder helper, @NotNull View view, ProviderMultiEntity data, int position) {
        Tips.show("Long Click: " + position);
        return true;
    }

    /**
     * 子控件点击
     *
     * @param helper
     * @param view
     * @param data
     * @param position
     */
    @Override
    public void onChildClick(@NotNull BaseViewHolder helper, @NotNull View view, ProviderMultiEntity data, int position) {
        if (view.getId() == R.id.tv) {
            Tips.show("TextView Click: " + position);
        }
    }
}
