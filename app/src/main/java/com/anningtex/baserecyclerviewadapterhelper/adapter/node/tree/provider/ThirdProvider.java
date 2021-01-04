package com.anningtex.baserecyclerviewadapterhelper.adapter.node.tree.provider;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.entity.node.tree.ThirdNode;
import com.syp.library.entity.node.BaseNode;
import com.syp.library.provider.BaseNodeProvider;
import com.syp.library.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

/**
 * @author Song
 */
public class ThirdProvider extends BaseNodeProvider {

    @Override
    public int getItemViewType() {
        return 3;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_node_third;
    }

    @Override
    public void convert(@NotNull BaseViewHolder helper, @NotNull BaseNode data) {
        ThirdNode entity = (ThirdNode) data;
        helper.setText(R.id.title, entity.getTitle());
    }
}
