package com.anningtex.baserecyclerviewadapterhelper.entity.node.tree;

import com.syp.library.entity.node.BaseExpandNode;
import com.syp.library.entity.node.BaseNode;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author Song
 */
public class SecondNode extends BaseExpandNode {
    private List<BaseNode> childNode;
    private String title;

    public SecondNode(List<BaseNode> childNode, String title) {
        this.childNode = childNode;
        this.title = title;

        setExpanded(false);
    }

    public String getTitle() {
        return title;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return childNode;
    }
}
