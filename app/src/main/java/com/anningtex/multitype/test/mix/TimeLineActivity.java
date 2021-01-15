package com.anningtex.multitype.test.mix;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityMultidataBinding;
import com.anningtex.multitype.multitypeadapter.MultiTypeAdapter;
import com.anningtex.multitype.test.decoration.TimeLineDecoration;
import com.anningtex.multitype.test.manyData.adapter.ItemView01;
import com.anningtex.multitype.test.manyData.adapter.ItemView02;
import com.anningtex.multitype.test.manyData.adapter.ItemView03;
import com.anningtex.multitype.test.manyData.adapter.ItemViewNormal;
import com.anningtex.multitype.test.manyData.bean.Bean01;
import com.anningtex.multitype.test.manyData.bean.Bean02;
import com.anningtex.multitype.test.manyData.bean.Bean03;
import com.anningtex.multitype.test.one2many.Bean04;
import com.anningtex.multitype.test.one2many.adapter.ItemView06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Song
 */
public class TimeLineActivity extends AppCompatActivity {
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
        initRegister();
        setLayoutManager();
        int space = getResources().getDimensionPixelSize(R.dimen.normal_space);
        binding.rlvMultiData.addItemDecoration(new TimeLineDecoration(this, getResources().getDimensionPixelOffset(R.dimen.timeLine_space)));
        binding.rlvMultiData.setAdapter(adapter);
        initData();
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }

    private void initRegister() {
        adapter.register(String.class, new ItemViewNormal());
        adapter.register(Bean01.class, new ItemView01());
        adapter.register(Bean02.class, new ItemView02());
        adapter.register(Bean03.class, new ItemView03());
        adapter.register(Bean04.class, new ItemView06());
    }

    private void setLayoutManager() {
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Object item = items.get(position);
                if (item instanceof Bean01) {
                    return 1;
                }
                if (item instanceof Bean02) {
                    return 1;
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
                return 1;
            }
        };
        binding.rlvMultiData.setLayoutManager(layoutManager);
    }

    private void initData() {
        items = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
//            items.add("混合式 瀑布流 \n 多数据 -> 多类型  单数据 -> 多类型");
//            for (int i = 0; i < 1; i++) {
//                items.add(new Bean02("bean02_" + i));
//            }
            for (int i = 0; i < 2; i++) {
                items.add(new Bean02("bean01_" + i));
            }
//            for (int i = 0; i < 1; i++) {
//                items.add(new Bean02("bean02_" + i));
//            }
//            for (int i = 0; i < 2; i++) {
//                items.add(new Bean01("bean01_" + i));
//            }
//            for (int i = 0; i < 3; i++) {
//                Bean04 bean04 = new Bean04("bean04_" + i);
//                if (i % 1 == 0) {
//                    bean04.setType(Bean04.TYPE_ONE);
//                }
//                if (i % 2 == 0) {
//                    bean04.setType(Bean04.TYPE_TWO);
//                }
//                if (i % 3 == 0) {
//                    bean04.setType(Bean04.TYPE_THREE);
//                }
//                items.add(bean04);
//            }
//            for (int i = 0; i < 1; i++) {
//                items.add(new Bean03("bean03_" + i));
//            }
        }
    }
}
