package com.anningtex.multitype.test.itemTouch;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Song
 */
public interface StartDragListener {
    /**
     * 该接口用于需要主动回调拖拽效果的
     */
    public void onStartDrag(RecyclerView.ViewHolder viewHolder);
}
