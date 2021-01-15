package com.anningtex.testdata.two;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.syp.library.BaseQuickAdapter;
import com.syp.library.viewholder.BaseViewHolder;

import java.util.List;

/**
 * @Author: Song
 */
public class TwoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public TwoAdapter(List<String> list) {
        super(R.layout.item_child, list);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item_tv_child, item);
    }
}
