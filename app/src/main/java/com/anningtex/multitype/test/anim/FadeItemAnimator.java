package com.anningtex.multitype.test.anim;

import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Song
 */
public class FadeItemAnimator extends BaseItemAnimator {
    /**
     * 执行移除动画
     *
     * @param holder   被移除的RecyclerView.ViewHolder
     * @param animator 被移动的RecyclerView.ViewHolder对应动画对象
     */
    @Override
    public void setRemoveAnimation(RecyclerView.ViewHolder holder, ViewPropertyAnimatorCompat animator) {
        animator.alpha(0);
    }

    /**
     * 执行移除动画结束，执行还原，因为该RecyclerView.ViewHolder会被复用
     *
     * @param view 被移除的RecyclerView.ViewHolder
     */
    @Override
    public void removeAnimationEnd(RecyclerView.ViewHolder view) {
        ViewCompat.setAlpha(view.itemView, 1);
    }

    /**
     * 执行添加动画初始化 这里设置透明为0添加时就会有渐变效果当然你可以在执行动画代码之前执行
     *
     * @param holder 添加的RecyclerView.ViewHolder
     */
    @Override
    public void addAnimationInit(RecyclerView.ViewHolder holder) {
        ViewCompat.setAlpha(holder.itemView, 0);
    }

    /**
     * 执行添加动画
     *
     * @param holder   添加的RecyclerView.ViewHolder
     * @param animator 添加的RecyclerView.ViewHolder对应动画对象
     */
    @Override
    public void setAddAnimation(RecyclerView.ViewHolder holder, ViewPropertyAnimatorCompat animator) {
        animator.alpha(1);
    }

    /**
     * 取消添加还原状态以复用
     *
     * @param holder 添加的RecyclerView.ViewHolder
     */
    @Override
    public void addAnimationCancel(RecyclerView.ViewHolder holder) {
        ViewCompat.setAlpha(holder.itemView, 1);
    }

    /**
     * 更新时旧的RecyclerView.ViewHolder动画
     *
     * @param holder   旧的RecyclerView.ViewHolder
     * @param animator RecyclerView.ViewHolder对应动画对象
     */
    @Override
    public void setOldChangeAnimation(RecyclerView.ViewHolder holder, ViewPropertyAnimatorCompat animator) {
        animator.alpha(0);
    }

    /**
     * 更新时旧的RecyclerView.ViewHolder动画结束，执行还原
     *
     * @param holder
     */
    @Override
    public void oldChangeAnimationEnd(RecyclerView.ViewHolder holder) {
        ViewCompat.setAlpha(holder.itemView, 1);
    }

    /**
     * 更新时新的RecyclerView.ViewHolder初始化
     *
     * @param holder 更新时新的RecyclerView.ViewHolder
     */
    @Override
    public void newChangeAnimationInit(RecyclerView.ViewHolder holder) {
        ViewCompat.setAlpha(holder.itemView, 0);
    }

    /**
     * 更新时新的RecyclerView.ViewHolder动画
     *
     * @param holder   新的RecyclerView.ViewHolder
     * @param animator RecyclerView.ViewHolder对应动画对象
     */
    @Override
    public void setNewChangeAnimation(RecyclerView.ViewHolder holder, ViewPropertyAnimatorCompat animator) {
        animator.alpha(1);
    }

    /**
     * 更新时新的RecyclerView.ViewHolder动画结束，执行还原
     *
     * @param holder
     */
    @Override
    public void newChangeAnimationEnd(RecyclerView.ViewHolder holder) {
        ViewCompat.setAlpha(holder.itemView, 1);
    }
}
