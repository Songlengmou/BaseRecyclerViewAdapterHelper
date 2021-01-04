package com.anningtex.baserecyclerviewadapterhelper.adapter;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.entity.MySectionEntity;
import com.anningtex.baserecyclerviewadapterhelper.entity.VideoEntity;
import com.syp.library.BaseSectionQuickAdapter;
import com.syp.library.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author Song
 */
public class SectionQuickAdapter extends BaseSectionQuickAdapter<MySectionEntity, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param sectionHeadResId The section head layout id for each item
     * @param layoutResId      The layout resource id of each item.
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SectionQuickAdapter(int layoutResId, int sectionHeadResId, List<MySectionEntity> data) {
        super(sectionHeadResId, data);
        setNormalLayout(layoutResId);

        addChildClickViewIds(R.id.more);
    }

    @Override
    protected void convertHeader(@NotNull BaseViewHolder helper, @NotNull MySectionEntity item) {
        if (item.getObject() instanceof String) {
            helper.setText(R.id.header, (String) item.getObject());
        }
    }

    @Override
    protected void convert(@NotNull BaseViewHolder helper, @NotNull MySectionEntity item) {
        VideoEntity video = (VideoEntity) item.getObject();
        switch (helper.getLayoutPosition() % 2) {
            case 0:
                helper.setImageResource(R.id.iv, R.mipmap.m_img1);
                break;
            case 1:
                helper.setImageResource(R.id.iv, R.mipmap.m_img2);
                break;
            default:
                break;
        }
        helper.setText(R.id.tv, video.getName());
    }
}
