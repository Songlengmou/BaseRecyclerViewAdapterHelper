package com.anningtex.multitype.test.itemTouch;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityMultidataBinding;
import com.anningtex.multitype.multitypeadapter.MultiTypeAdapter;
import com.anningtex.multitype.test.decoration.ItemDecoration;
import com.anningtex.multitype.test.manyData.adapter.ItemView01;
import com.anningtex.multitype.test.manyData.adapter.ItemView02;
import com.anningtex.multitype.test.manyData.adapter.ItemView03;
import com.anningtex.multitype.test.manyData.adapter.ItemViewNormal;
import com.anningtex.multitype.test.manyData.bean.Bean01;
import com.anningtex.multitype.test.manyData.bean.Bean02;
import com.anningtex.multitype.test.manyData.bean.Bean03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Song
 */
public class ItemTouchActivity extends AppCompatActivity implements ItemTouchMoveListener, StartDragListener {
    private ActivityMultidataBinding binding;
    private static final int SPAN_COUNT = 4;
    private MultiTypeAdapter adapter;
    private List<Object> items;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMultidataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new MultiTypeAdapter();
        adapter.register(String.class, new ItemViewNormal());
        adapter.register(Bean01.class, new ItemView01());
        adapter.register(Bean02.class, new ItemView02());
        adapter.register(Bean03.class, new ItemView03());

        setLayoutManager();
        int space = getResources().getDimensionPixelSize(R.dimen.normal_space);
        binding.rlvMultiData.addItemDecoration(new ItemDecoration(space));
        binding.rlvMultiData.setAdapter(adapter);
        initData();
        //条目触摸帮助类
        ItemTouchHelper.Callback callback = new MyItemTouchHelperCallback(this);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(binding.rlvMultiData);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        // 1.数据交换；2.刷新
        Collections.swap(items, fromPosition, toPosition);
        adapter.notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public boolean onItemRemove(int position) {
        items.remove(position);
        adapter.notifyItemRemoved(position);
        return true;
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
    }

    private void initData() {
        items = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            items.add(" 多数据 -> 多类型  ");
            for (int i = 0; i < 6; i++) {
                items.add(new Bean01("bean01_" + i));
            }
            for (int i = 0; i < 2; i++) {
                items.add(new Bean02("bean02_" + i));
            }
        }
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }

    private void setLayoutManager() {
        final GridLayoutManager layoutManager = new GridLayoutManager(this, SPAN_COUNT);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Object item = items.get(position);
                if (item instanceof Bean01) {
                    return 2;
                }
                if (item instanceof Bean02) {
                    return 2;
                }
                if (item instanceof Bean03) {
                    return SPAN_COUNT;
                }
                if (item instanceof String) {
                    return SPAN_COUNT;
                }
                return SPAN_COUNT;
            }
        };
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        binding.rlvMultiData.setLayoutManager(layoutManager);
    }
}
