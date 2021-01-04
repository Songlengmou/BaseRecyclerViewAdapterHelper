package com.anningtex.baserecyclerviewadapterhelper.adapter

import com.anningtex.baserecyclerviewadapterhelper.R
import com.anningtex.baserecyclerviewadapterhelper.entity.HomeEntity
import com.syp.library.BaseSectionQuickAdapter
import com.syp.library.viewholder.BaseViewHolder

/**
 * @author Song
 */
class HomeAdapter(data: MutableList<HomeEntity>) :
    BaseSectionQuickAdapter<HomeEntity, BaseViewHolder>(
        R.layout.def_section_head,
        R.layout.home_item_view,
        data
    ) {

    override fun convert(helper: BaseViewHolder, item: HomeEntity) {
        helper.setText(R.id.text, item.name)
        helper.setImageResource(R.id.icon, item.imageResource)
    }

    override fun convertHeader(helper: BaseViewHolder, item: HomeEntity) {
        helper.setGone(R.id.more, true)
        helper.setText(R.id.header, item.headerTitle)
    }
}