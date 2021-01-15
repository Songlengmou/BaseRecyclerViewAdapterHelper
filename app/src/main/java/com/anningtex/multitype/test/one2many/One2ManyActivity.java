package com.anningtex.multitype.test.one2many;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityMultidataBinding;
import com.anningtex.multitype.multitypeadapter.MultiTypeAdapter;
import com.anningtex.multitype.test.decoration.ItemDecoration;
import com.anningtex.multitype.test.manyData.adapter.ItemViewNormal;
import com.anningtex.multitype.test.one2many.adapter.ItemView06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Song
 */
public class One2ManyActivity extends AppCompatActivity {
    private ActivityMultidataBinding binding;
    private MultiTypeAdapter adapter;
    private List<Object> items;
    private int SPAN_COUNT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMultidataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new MultiTypeAdapter();
        adapter.register(Bean04.class, new ItemView06());
        adapter.register(String.class, new ItemViewNormal());

        final GridLayoutManager layoutManager = new GridLayoutManager(this, SPAN_COUNT);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Object item = items.get(position);
                if (item instanceof Bean04) {
                    return SPAN_COUNT;
                }
                if (item instanceof String) {
                    return SPAN_COUNT;
                }
                return 1;
            }
        };

        layoutManager.setSpanSizeLookup(spanSizeLookup);
        binding.rlvMultiData.setLayoutManager(layoutManager);
        int space = getResources().getDimensionPixelSize(R.dimen.normal_space);
        binding.rlvMultiData.addItemDecoration(new ItemDecoration(space));
        binding.rlvMultiData.setAdapter(adapter);

        items = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            items.add(" 单数据 -> 多类型  ");
            for (int i = 0; i < 6; i++) {
                Bean04 bean04 = new Bean04("bean04_" + i);
                if (i % 1 == 0) {
                    bean04.setType(Bean04.TYPE_ONE);
                }
                if (i % 2 == 0) {
                    bean04.setType(Bean04.TYPE_TWO);
                }
                if (i % 3 == 0) {
                    bean04.setType(Bean04.TYPE_THREE);
                }
                items.add(bean04);
            }
        }

        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }
}
