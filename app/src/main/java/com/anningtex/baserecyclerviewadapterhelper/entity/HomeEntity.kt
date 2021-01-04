package com.anningtex.baserecyclerviewadapterhelper.entity

import com.syp.library.entity.SectionEntity

/**
 * @author: Song
 */
data class HomeEntity(
    val name: String = "",
    val activity: Class<*>? = null,
    val imageResource: Int = 0,
    val headerTitle: String = ""
) : SectionEntity {
    override val isHeader: Boolean
        get() = headerTitle.isNotBlank()
}