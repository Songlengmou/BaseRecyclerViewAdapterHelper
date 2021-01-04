package com.anningtex.baserecyclerviewadapterhelper.adapter.multi;

import com.anningtex.baserecyclerviewadapterhelper.adapter.multi.provider.ImgItemProvider;
import com.anningtex.baserecyclerviewadapterhelper.adapter.multi.provider.TextImgItemProvider;
import com.anningtex.baserecyclerviewadapterhelper.adapter.multi.provider.TextItemProvider;
import com.anningtex.baserecyclerviewadapterhelper.entity.ProviderMultiEntity;
import com.syp.library.BaseProviderMultiAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author Song
 */
public class ProviderMultiAdapter extends BaseProviderMultiAdapter<ProviderMultiEntity> {

    public ProviderMultiAdapter() {
        super();
        addItemProvider(new ImgItemProvider());
        addItemProvider(new TextImgItemProvider());
        addItemProvider(new TextItemProvider());
    }

    /**
     * 自行根据数据、位置等内容，返回 item 类型
     *
     * @param data
     * @param position
     * @return
     */
    @Override
    protected int getItemType(@NotNull List<? extends ProviderMultiEntity> data, int position) {
        switch (position % 3) {
            case 0:
                return ProviderMultiEntity.IMG;
            case 1:
                return ProviderMultiEntity.TEXT;
            case 2:
                return ProviderMultiEntity.IMG_TEXT;
            default:
                break;
        }
        return 0;
    }
}
