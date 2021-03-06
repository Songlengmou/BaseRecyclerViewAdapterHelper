package com.anningtex.multitype.multitypeadapter.sticky;

import android.content.Context;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.anningtex.multitype.multitypeadapter.base.ViewHolder;

import java.lang.reflect.Field;

/**
 * @author Song
 */
public abstract class StickyAnyAdapter extends StickyAdapter {

    public StickyAnyAdapter(Context context, RecyclerView.Adapter mAdapter) {
        super(context, mAdapter);
    }

    @Override
    public void onBindHeaderViewHolder(final ViewHolder viewholder, final int position) {
        onBindViewHolder(viewholder, position);
    }

    @Override
    public ViewHolder onCreateHeaderViewHolder(ViewGroup parent, int position) {
        int itemType = getItemViewType(position);
        ViewHolder holder = (ViewHolder) onCreateViewHolder(parent, getItemViewType(position));
        setField(RecyclerView.ViewHolder.class, holder, "mItemViewType", itemType);
        return holder;
    }

    private void setField(Class<?> clazz, Object owner, String fieldName, Object value) {
        Class<?> ownerClass = clazz;
        Field field;
        try {
            Field[] fields = ownerClass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                field = fields[i];
                if (field.getName().equals(fieldName)) {
                    field.setAccessible(true);
                    field.set(owner, value);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
