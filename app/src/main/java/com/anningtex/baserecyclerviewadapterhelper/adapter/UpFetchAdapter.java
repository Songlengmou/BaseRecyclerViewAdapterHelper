package com.anningtex.baserecyclerviewadapterhelper.adapter;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.entity.MovieEntity;
import com.syp.library.BaseQuickAdapter;
import com.syp.library.module.UpFetchModule;
import com.syp.library.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

/**
 * @author Song
 */
public class UpFetchAdapter extends BaseQuickAdapter<MovieEntity, BaseViewHolder> implements UpFetchModule {

    public UpFetchAdapter() {
        super(R.layout.item_header_and_footer);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder helper, @NotNull MovieEntity item) {
        switch (helper.getLayoutPosition() % 3) {
            case 0:
                helper.setImageResource(R.id.iv, R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.iv, R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.iv, R.mipmap.animation_img3);
                break;
            default:
                break;
        }
    }
}
