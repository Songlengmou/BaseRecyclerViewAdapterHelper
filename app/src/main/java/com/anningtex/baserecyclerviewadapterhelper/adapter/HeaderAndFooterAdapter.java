package com.anningtex.baserecyclerviewadapterhelper.adapter;

import androidx.annotation.NonNull;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.data.DataServer;
import com.anningtex.baserecyclerviewadapterhelper.entity.StatusEntity;
import com.syp.library.BaseQuickAdapter;
import com.syp.library.viewholder.BaseViewHolder;

/**
 * @Author Song
 */
public class HeaderAndFooterAdapter extends BaseQuickAdapter<StatusEntity, BaseViewHolder> {

    public HeaderAndFooterAdapter(int dataSize) {
        super(R.layout.item_header_and_footer, DataServer.getSampleData(dataSize));
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, StatusEntity item) {
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
