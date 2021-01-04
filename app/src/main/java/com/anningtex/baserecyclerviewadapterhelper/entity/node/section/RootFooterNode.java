package com.anningtex.baserecyclerviewadapterhelper.entity.node.section;

import com.syp.library.entity.node.BaseNode;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author Song
 */
public class RootFooterNode extends BaseNode {

    private String title;

    public RootFooterNode(String title) {
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
