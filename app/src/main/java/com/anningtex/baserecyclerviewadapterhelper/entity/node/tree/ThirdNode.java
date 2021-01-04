package com.anningtex.baserecyclerviewadapterhelper.entity.node.tree;

import com.syp.library.entity.node.BaseNode;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author Song
 */
public class ThirdNode extends BaseNode {
    private String title;

    public ThirdNode(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return null;
    }
}
