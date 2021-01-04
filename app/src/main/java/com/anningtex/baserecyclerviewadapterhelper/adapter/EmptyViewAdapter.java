package com.anningtex.baserecyclerviewadapterhelper.adapter;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.entity.StatusEntity;
import com.syp.library.BaseQuickAdapter;
import com.syp.library.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

/**
 * @Author Song
 */
public class EmptyViewAdapter extends BaseQuickAdapter<StatusEntity, BaseViewHolder> {

    public EmptyViewAdapter() {
        super(R.layout.layout_animation);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder helper, @NotNull StatusEntity item) {
        switch (helper.getLayoutPosition() % 3) {
            case 0:
                helper.setImageResource(R.id.img, R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.img, R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.img, R.mipmap.animation_img3);
                break;
            default:
                break;
        }
        helper.setText(R.id.tweetName, "Hoteis in Rio de Janeiro");
        helper.setText(R.id.tweetText, "O ever youthful,O ever weeping");
    }
}
