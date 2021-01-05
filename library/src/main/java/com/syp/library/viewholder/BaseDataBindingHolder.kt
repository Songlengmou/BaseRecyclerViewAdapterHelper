package com.syp.library.viewholder

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @author Song
 * @desc:方便 DataBinding 的使用
 * @param BD : ViewDataBinding
 * @property dataBinding BD?
 * @constructor
 */
open class BaseDataBindingHolder<BD : ViewDataBinding>(view: View) : BaseViewHolder(view) {
    val dataBinding = DataBindingUtil.bind<BD>(view)
}