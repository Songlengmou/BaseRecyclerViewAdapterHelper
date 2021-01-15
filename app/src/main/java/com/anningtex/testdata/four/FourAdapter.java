package com.anningtex.testdata.four;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.syp.library.BaseMultiItemQuickAdapter;
import com.syp.library.viewholder.BaseViewHolder;

import java.util.List;

/**
 * @Author Song
 */
public class FourAdapter extends BaseMultiItemQuickAdapter<FourBean, BaseViewHolder> {
    public static final int FIRST = 1;
    public static final int SECOND = 2;

    public FourAdapter(List<FourBean> data) {
        super(data);
        addItemType(FIRST, R.layout.item_four_one);
        addItemType(SECOND, R.layout.item_four_two);
    }

    @Override
    protected void convert(BaseViewHolder helper, FourBean item) {
        switch (helper.getItemViewType()) {
            case FIRST:
                helper.setText(R.id.mName1, item.getName());
                helper.setText(R.id.mTitle1, item.getTitle());
                break;
            case SECOND:
                helper.setText(R.id.mName2, item.getName());
                helper.setText(R.id.mTitle2, item.getTitle());
                break;
            default:
                break;
        }
    }
}
