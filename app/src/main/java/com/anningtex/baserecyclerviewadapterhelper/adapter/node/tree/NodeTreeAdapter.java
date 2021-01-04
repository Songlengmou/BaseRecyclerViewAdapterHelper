package com.anningtex.baserecyclerviewadapterhelper.adapter.node.tree;

import com.anningtex.baserecyclerviewadapterhelper.adapter.node.tree.provider.FirstProvider;
import com.anningtex.baserecyclerviewadapterhelper.adapter.node.tree.provider.SecondProvider;
import com.anningtex.baserecyclerviewadapterhelper.adapter.node.tree.provider.ThirdProvider;
import com.anningtex.baserecyclerviewadapterhelper.entity.node.tree.FirstNode;
import com.anningtex.baserecyclerviewadapterhelper.entity.node.tree.SecondNode;
import com.anningtex.baserecyclerviewadapterhelper.entity.node.tree.ThirdNode;
import com.syp.library.BaseNodeAdapter;
import com.syp.library.entity.node.BaseNode;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author Song
 */
public class NodeTreeAdapter extends BaseNodeAdapter {

    public NodeTreeAdapter() {
        super();
        addNodeProvider(new FirstProvider());
        addNodeProvider(new SecondProvider());
        addNodeProvider(new ThirdProvider());
    }

    @Override
    protected int getItemType(@NotNull List<? extends BaseNode> data, int position) {
        BaseNode node = data.get(position);
        if (node instanceof FirstNode) {
            return 1;
        } else if (node instanceof SecondNode) {
            return 2;
        } else if (node instanceof ThirdNode) {
            return 3;
        }
        return -1;
    }

    public static final int EXPAND_COLLAPSE_PAYLOAD = 110;
}
