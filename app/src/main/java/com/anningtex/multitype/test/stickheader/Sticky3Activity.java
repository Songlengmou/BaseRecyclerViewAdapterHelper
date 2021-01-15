package com.anningtex.multitype.test.stickheader;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityStickyThreeBinding;
import com.anningtex.multitype.multitypeadapter.MultiTypeAdapter;
import com.anningtex.multitype.test.manyData.adapter.ItemView01;
import com.anningtex.multitype.test.manyData.adapter.ItemView02;
import com.anningtex.multitype.test.manyData.adapter.ItemView03;
import com.anningtex.multitype.test.manyData.adapter.ItemViewNormal;
import com.anningtex.multitype.test.manyData.bean.Bean01;
import com.anningtex.multitype.test.manyData.bean.Bean02;
import com.anningtex.multitype.test.manyData.bean.Bean03;
import com.anningtex.multitype.test.one2many.Bean04;

import java.util.ArrayList;

/**
 * @author Song
 */
public class Sticky3Activity extends AppCompatActivity {
    private ActivityStickyThreeBinding binding;
    private MultiTypeAdapter adapter;
    private ArrayList<Object> items;
    private int SPAN_COUNT = 4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStickyThreeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rlvMultiType.setNestedScrollingEnabled(false);
        setLayoutManager();
        adapter = new MultiTypeAdapter();
        adapter.register(String.class, new ItemViewNormal());
        adapter.register(Bean01.class, new ItemView01());
        adapter.register(Bean02.class, new ItemView02());
        adapter.register(Bean03.class, new ItemView03());
        binding.rlvMultiType.setAdapter(adapter);
        initData();
    }

    private void initData() {
        items = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 8; i++) {
                items.add(new Bean01("bean01_" + i));
                items.add(j + "");
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
                    return 1;
                }
                if (item instanceof Bean02) {
                    return 2;
                }
                if (item instanceof Bean03) {
                    return SPAN_COUNT;
                }
                if (item instanceof Bean04) {
                    return SPAN_COUNT;
                }
                if (item instanceof String) {
                    return SPAN_COUNT;
                }
                return SPAN_COUNT;
            }
        };
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        binding.rlvMultiType.setLayoutManager(layoutManager);
    }
}
