package com.anningtex.multitype.test.stickheader;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityMultidataBinding;
import com.anningtex.multitype.multitypeadapter.MultiTypeAdapter;
import com.anningtex.multitype.multitypeadapter.base.OnItemClickListener;
import com.anningtex.multitype.multitypeadapter.sticky.StickyControl;
import com.anningtex.multitype.test.decoration.ItemDecoration;
import com.anningtex.multitype.test.manyData.adapter.ItemView01;
import com.anningtex.multitype.test.manyData.adapter.ItemView02;
import com.anningtex.multitype.test.manyData.adapter.ItemView03;
import com.anningtex.multitype.test.manyData.adapter.ItemViewNormal;
import com.anningtex.multitype.test.manyData.bean.Bean01;
import com.anningtex.multitype.test.manyData.bean.Bean02;
import com.anningtex.multitype.test.manyData.bean.Bean03;
import com.anningtex.multitype.test.one2many.Bean04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Song
 */
public class Sticky4Activity extends AppCompatActivity {
    private ActivityMultidataBinding binding;
    private static final int SPAN_COUNT = 4;
    private MultiTypeAdapter adapter;
    private List<Object> items;
    private StickySigleTwoAdapter stickyTestAdapter;

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

        stickyTestAdapter = new StickySigleTwoAdapter(this, adapter);
        binding.rlvMultiData.setAdapter(stickyTestAdapter);
        StickyControl.anyHeader2()
                .adapter(stickyTestAdapter)
                .setRecyclerView(binding.rlvMultiData)
//                .immersion()
                .togo();
//        recyclerView.addItemDecoration(new StickyAnyDecoration2(stickyTestAdapter)
        initData();

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                Log.e("position:", position + "");
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                return false;
            }
        });
    }

    private void initData() {
        items = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 8; i++) {
                items.add(new Bean01("bean01_" + i));
            }
            for (int i = 0; i < 2; i++) {
                items.add(new Bean02("bean02_" + i));
            }
        }
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
        stickyTestAdapter.notifyDataSetChanged();
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
        binding.rlvMultiData.setLayoutManager(layoutManager);
    }
}
