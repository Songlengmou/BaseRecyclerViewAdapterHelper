package com.anningtex.multitype.test.pull_load;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityMultidataBinding;
import com.anningtex.multitype.multitypeadapter.MultiTypeAdapter;
import com.anningtex.multitype.multitypeadapter.wrapper.LoadMoreWrapper2;
import com.anningtex.multitype.test.decoration.ItemDecoration;
import com.anningtex.multitype.test.manyData.adapter.ItemView01;
import com.anningtex.multitype.test.manyData.adapter.ItemView02;
import com.anningtex.multitype.test.manyData.adapter.ItemView03;
import com.anningtex.multitype.test.manyData.adapter.ItemViewNormal;
import com.anningtex.multitype.test.manyData.bean.Bean01;
import com.anningtex.multitype.test.manyData.bean.Bean02;
import com.anningtex.multitype.test.manyData.bean.Bean03;
import com.anningtex.multitype.test.utils.MainThreadExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Song
 */
public class PullLoadActivity extends AppCompatActivity {
    private ActivityMultidataBinding binding;
    private static final int SPAN_COUNT = 4;
    private LoadMoreWrapper2 loadMoreWrapper2;
    private MultiTypeAdapter adapter;
    private List<Object> items;

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
                return SPAN_COUNT;
            }
        };
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        binding.rlvMultiData.setLayoutManager(layoutManager);
        int space = getResources().getDimensionPixelSize(R.dimen.normal_space);
        binding.rlvMultiData.addItemDecoration(new ItemDecoration(space));

        loadMoreWrapper2 = new LoadMoreWrapper2(adapter);
        loadMoreWrapper2.setLoadMoreView(LayoutInflater.from(this).inflate(R.layout.default_loading, binding.rlvMultiData, false));
        binding.rlvMultiData.setAdapter(loadMoreWrapper2);
        initData();
        loadMoreWrapper2.setOnLoadMoreListener(() -> addPage());
    }

    private void initData() {
        items = new ArrayList<>();
        items.add(" 加载三次数据 关闭加载功能 ");
        for (int i = 0; i < 8; i++) {
            items.add(new Bean01("bean01_" + i));
        }
        for (int i = 0; i < 6; i++) {
            items.add(new Bean02("bean02_" + i));
        }
        for (int i = 0; i < 1; i++) {
            items.add(new Bean03("bean03_" + i));
        }
        adapter.setItems(items);
//        adapter.notifyDataSetChanged();
        loadMoreWrapper2.notifyDataSetChanged();
    }

    int count = 0;

    private void addPage() {
        if (count > 1) {
            new MainThreadExecutor(2000).execute(() -> noMore()
            );
            return;
        }
        count++;
        new MainThreadExecutor(1500).execute(() -> {
            items.add(" 加载第 " + count + "次");
            for (int i = 0; i < 8; i++) {
                items.add(new Bean01("bean01_" + i));
            }
            for (int i = 0; i < 6; i++) {
                items.add(new Bean02("bean02_" + i));
            }
            for (int i = 0; i < 1; i++) {
                items.add(new Bean03("bean03_" + i));
            }
            loadMoreWrapper2.loadingComplete();
            loadMoreWrapper2.notifyDataSetChanged();
        });
    }

    public void noMore() {
        loadMoreWrapper2.setLoadMore(false);
    }
}
