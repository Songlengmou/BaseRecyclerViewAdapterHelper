package com.anningtex.baserecyclerviewadapterhelper.adapter.node.section.provider;

import android.view.View;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.entity.node.section.RootFooterNode;
import com.anningtex.baserecyclerviewadapterhelper.utils.Tips;
import com.syp.library.entity.node.BaseNode;
import com.syp.library.provider.BaseNodeProvider;
import com.syp.library.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Song
 */
public class RootFooterNodeProvider extends BaseNodeProvider {

    public RootFooterNodeProvider() {
        addChildClickViewIds(R.id.footerTv);
    }

    @Override
    public int getItemViewType() {
        return 2;
    }

    @Override
    public int getLayoutId() {
        return R.layout.node_footer;
    }

    @Override
    public void convert(@NotNull BaseViewHolder helper, @Nullable BaseNode data) {
        RootFooterNode entity = (RootFooterNode) data;
        helper.setText(R.id.footerTv, entity.getTitle());
    }

    @Override
    public void onChildClick(@NotNull BaseViewHolder helper, @NotNull View view, BaseNode data, int position) {
        if (view.getId() == R.id.footerTv) {
            Tips.show("Footer Node Click : " + position);
        }
    }
}
