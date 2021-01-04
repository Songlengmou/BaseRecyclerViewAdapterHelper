package com.anningtex.baserecyclerviewadapterhelper.adapter;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.data.DataServer;
import com.anningtex.baserecyclerviewadapterhelper.entity.StatusEntity;
import com.anningtex.baserecyclerviewadapterhelper.utils.ClickableMovementMethod;
import com.anningtex.baserecyclerviewadapterhelper.utils.SpannableStringUtils;
import com.anningtex.baserecyclerviewadapterhelper.utils.Tips;
import com.syp.library.BaseQuickAdapter;
import com.syp.library.viewholder.BaseViewHolder;

/**
 * @Author Song
 */
public class AnimationAdapter extends BaseQuickAdapter<StatusEntity, BaseViewHolder> {
    public AnimationAdapter() {
        super(R.layout.layout_animation, DataServer.getSampleData(100));
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, StatusEntity item) {
        switch (helper.getLayoutPosition() % 3) {
            case 0:
                helper.setImageResource(R.id.img, R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.img, R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.img, R.mipmap.animation_img3);
                break;
            default:
                break;
        }
        helper.setText(R.id.tweetName, "Hoteis in Rio de Janeiro");
        String msg = "\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
        ((TextView) helper.getView(R.id.tweetText)).setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
        ((TextView) helper.getView(R.id.tweetText)).setMovementMethod(ClickableMovementMethod.getInstance());
        helper.getView(R.id.tweetText).setFocusable(false);
        helper.getView(R.id.tweetText).setClickable(false);
        helper.getView(R.id.tweetText).setLongClickable(false);
    }

    private ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(@NonNull View widget) {
            Tips.show("事件触发了 landscapes and nedes");
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(getContext().getResources().getColor(R.color.teal_200));
            ds.setUnderlineText(true);
        }
    };
}
