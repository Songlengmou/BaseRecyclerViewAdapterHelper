package com.anningtex.testdata.three;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @Author Song
 */
public class ThreeAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int FIRST = 1;
    public static final int SECOND = 2;

    public ThreeAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(FIRST, R.layout.item_three_one);
        addItemType(SECOND, R.layout.item_three_two);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case FIRST:
                ThreeBean.DataBean dataBean = (ThreeBean.DataBean) item;
                helper.setText(R.id.tv_transitNo, dataBean.getTransitNo());
                helper.setText(R.id.tv_transitDate, dataBean.getTransitDate());
                helper.setText(R.id.tv_warehouseName_from, "From: " + dataBean.getWarehouseNameEn_From());
                helper.setVisible(R.id.tv_warehouseName_to, false);
                helper.setVisible(R.id.tv_warehouseName_from, true);
                break;
            case SECOND:
                ThreeBean.SecondLevel secondLevel = (ThreeBean.SecondLevel) item;
                ThreeBean.DataBean.FlowerListBean flowerListBean = secondLevel.getFlowerListBean();
                if (flowerListBean != null) {
                    helper.setText(R.id.texName_en, flowerListBean.getTexName_EN());
                    helper.setText(R.id.name, flowerListBean.getOrderNo());
                    helper.setText(R.id.qBales, flowerListBean.getQBales() + " Bales");
                    helper.setText(R.id.metersPerBale, flowerListBean.getMetersPerBale() + " " + flowerListBean.getMetersPerBaleUnitName());
                }
                break;
            default:
                break;
        }
    }
}
