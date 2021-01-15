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
import com.anningtex.multitype.multitypeadapter.sticky.StickyHeaderAdapter;
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
public class StickHeaderActivity extends AppCompatActivity {
    private ActivityMultidataBinding binding;
    private int SPAN_COUNT = 4;
    private StickySigleTwoAdapter adapter;
    private List<Object> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMultidataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new StickySigleTwoAdapter();
        binding.rlvMultiData.setNestedScrollingEnabled(false);
        adapter.register(String.class, new ItemViewNormal());
        adapter.register(Bean01.class, new ItemView01());
        adapter.register(Bean02.class, new ItemView02());
        adapter.register(Bean03.class, new ItemView03());

        setLayoutManager();
        int space = getResources().getDimensionPixelSize(R.dimen.normal_space);
        binding.rlvMultiData.addItemDecoration(new ItemDecoration(space));
        binding.rlvMultiData.setAdapter(adapter);
        StickyControl.anyHeader2()
                .adapter(adapter)
                .setRecyclerView(binding.rlvMultiData)
//                .immersion()
                .togo();
//          binding.rlvMultiData.addItemDecoration(new StickyAnyDecoration2(stickyTestAdapter)
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
//            for (int i = 0; i < 1; i++) {
//                items.add(new Bean03("bean03_" + j + "_" + i));
//            }
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
        binding.rlvMultiData.setLayoutManager(layoutManager);
//          binding.rlvMultiData.setLayoutManager(new LinearLayoutManager(this));
    }

    class StickySigleTwoAdapter extends MultiTypeAdapter implements StickyHeaderAdapter {

        @Override
        public boolean isHeader(int position) {
            if (position == 0 || position == 8 || position == 15 || position == 21 || position == 28) {
                return true;
            } else {
                return false;
            }
        }
    }
}
