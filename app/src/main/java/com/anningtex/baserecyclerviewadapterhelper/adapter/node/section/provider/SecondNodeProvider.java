package com.anningtex.baserecyclerviewadapterhelper.adapter.node.section.provider;

import android.view.View;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.entity.node.section.ItemNode;
import com.syp.library.entity.node.BaseNode;
import com.syp.library.provider.BaseNodeProvider;
import com.syp.library.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Song
 */
public class SecondNodeProvider extends BaseNodeProvider {

    @Override
    public int getItemViewType() {
        return 1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_section_content;
    }

    @Override
    public void convert(@NotNull BaseViewHolder helper, @Nullable BaseNode data) {
        if (data == null) {
            return;
        }
        ItemNode entity = (ItemNode) data;
        helper.setImageResource(R.id.iv, entity.getImg());
        helper.setText(R.id.tv, entity.getName());
    }

    @Override
    public void onClick(@NotNull BaseViewHolder helper, @NotNull View view, BaseNode data, int position) {
    }
}
