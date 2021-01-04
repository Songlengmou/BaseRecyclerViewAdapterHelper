package com.anningtex.baserecyclerviewadapterhelper.adapter;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.syp.library.BaseQuickAdapter;
import com.syp.library.module.DraggableModule;
import com.syp.library.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author Song
 */
public class DragAndSwipeAdapter extends BaseQuickAdapter<String, BaseViewHolder> implements DraggableModule {

    public DragAndSwipeAdapter(List<String> data) {
        super(R.layout.item_draggable_view, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder helper, @NotNull String item) {
        switch (helper.getLayoutPosition() % 3) {
            case 0:
                helper.setImageResource(R.id.iv_head, R.mipmap.head_img0);
                break;
            case 1:
                helper.setImageResource(R.id.iv_head, R.mipmap.head_img1);
                break;
            case 2:
                helper.setImageResource(R.id.iv_head, R.mipmap.head_img2);
                break;
            default:
                break;
        }
        helper.setText(R.id.tv, item);
    }
}
