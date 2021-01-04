package com.anningtex.baserecyclerviewadapterhelper.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.entity.ClickEntity;
import com.anningtex.baserecyclerviewadapterhelper.utils.Tips;
import com.syp.library.BaseMultiItemQuickAdapter;
import com.syp.library.BaseQuickAdapter;
import com.syp.library.listener.OnItemChildClickListener;
import com.syp.library.listener.OnItemClickListener;
import com.syp.library.viewholder.BaseViewHolder;

import java.util.List;

/**
 * @author Song
 */
public class ItemClickAdapter extends BaseMultiItemQuickAdapter<ClickEntity, BaseViewHolder> implements
        OnItemClickListener, OnItemChildClickListener {

    public ItemClickAdapter(List<ClickEntity> data) {
        super(data);
        addItemType(ClickEntity.CLICK_ITEM_VIEW, R.layout.item_click_view);
        addItemType(ClickEntity.CLICK_ITEM_CHILD_VIEW, R.layout.item_click_childview);
        addItemType(ClickEntity.LONG_CLICK_ITEM_VIEW, R.layout.item_long_click_view);
        addItemType(ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW, R.layout.item_long_click_childview);
        addItemType(ClickEntity.NEST_CLICK_ITEM_CHILD_VIEW, R.layout.item_nest_click);

        addChildClickViewIds(R.id.btn,
                R.id.iv_num_reduce, R.id.iv_num_add,
                R.id.item_click);

        addChildLongClickViewIds(R.id.iv_num_reduce, R.id.iv_num_add,
                R.id.btn);
    }

    @Override
    protected void convert(@NonNull final BaseViewHolder helper, final ClickEntity item) {
        switch (helper.getItemViewType()) {
            case ClickEntity.CLICK_ITEM_VIEW:
                break;
            case ClickEntity.CLICK_ITEM_CHILD_VIEW:
                // set img data
                break;
            case ClickEntity.LONG_CLICK_ITEM_VIEW:
                break;
            case ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW:
                break;
            case ClickEntity.NEST_CLICK_ITEM_CHILD_VIEW:
                // u can set nestView id
                RecyclerView recyclerView = helper.getView(R.id.nest_list);
                recyclerView.setHasFixedSize(true);
                if (recyclerView.getLayoutManager() == null) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                }
                if (recyclerView.getAdapter() == null) {
                    NestAdapter nestAdapter = new NestAdapter();
                    nestAdapter.setOnItemClickListener(this);
                    nestAdapter.setOnItemChildClickListener(this);
                    recyclerView.setAdapter(nestAdapter);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        Tips.show("childView click");
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Tips.show("嵌套RecycleView item 收到: " + "点击了第 " + position + " 一次");
    }
}
