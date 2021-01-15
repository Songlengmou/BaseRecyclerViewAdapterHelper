package com.anningtex.multitype.test.group;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityMultidataBinding;
import com.anningtex.multitype.multitypeadapter.base.OnItemClickListener;
import com.anningtex.multitype.multitypeadapter.base.ViewHolder;
import com.anningtex.multitype.multitypeadapter.bean.GroupStructure;
import com.anningtex.multitype.multitypeadapter.wrapper.GroupWrapper;
import com.anningtex.multitype.test.decoration.ItemDecoration;
import com.anningtex.multitype.test.manyData.adapter.ItemView01;
import com.anningtex.multitype.test.manyData.adapter.ItemView02;
import com.anningtex.multitype.test.manyData.adapter.ItemView03;
import com.anningtex.multitype.test.manyData.adapter.ItemViewNormal;
import com.anningtex.multitype.test.manyData.bean.Bean01;
import com.anningtex.multitype.test.manyData.bean.Bean02;
import com.anningtex.multitype.test.manyData.bean.Bean03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Song
 */
public class GroupActivity extends AppCompatActivity {
    private ActivityMultidataBinding binding;
    private static final int SPAN_COUNT = 4;
    private GroupWrapper groupWrapper;
    private List<GroupStructure> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMultidataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        groupWrapper = new GroupWrapper(binding.rlvMultiData);
        groupWrapper.register(String.class, new ItemViewNormal());
        groupWrapper.register(Bean01.class, new ItemView01());
        groupWrapper.register(Bean02.class, new ItemView02());
        groupWrapper.register(Bean03.class, new ItemView03());

        final GridLayoutManager layoutManager = new GridLayoutManager(this, SPAN_COUNT);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Object item = groupWrapper.getHelper().adapterList.get(position);
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
        binding.rlvMultiData.setAdapter(groupWrapper);
        initData();
    }

    private void initData() {
        items = new ArrayList<>();
        GroupStructure groupStructure1 = new GroupStructure();
        String title1 = "title1";
        List<Object> children1 = new ArrayList<>();
        children1.add(new Bean01("bean01_" + title1));
        children1.add(new Bean02("bean02_" + title1));
        children1.add(new Bean02("bean02_" + title1));
        groupStructure1.parent = title1;
        groupStructure1.children = children1;

        GroupStructure groupStructure2 = new GroupStructure();
        String title2 = "title2";
        List<Object> children2 = new ArrayList<>();
        children2.add(new Bean01("bean01_" + title2));
        children2.add(new Bean02("bean02_" + title2));
        children2.add(new Bean03("bean03_" + title2));

        groupStructure2.parent = title2;
        groupStructure2.children = children2;

        items.add(groupStructure1);
        items.add(groupStructure2);

        groupWrapper.setGroupList(items);
        groupWrapper.setListener(new GroupWrapper.IExpandListener() {
            @Override
            public void onExpand(RecyclerView.ViewHolder holder, Object o, int position) {
                if (holder != null) {
                    ((ViewHolder) holder).setImageResource(R.id.imageView, R.mipmap.less);
                }
            }

            @Override
            public void onShrink(RecyclerView.ViewHolder holder, Object o, int position) {
                if (holder != null) {
                    ((ViewHolder) holder).setImageResource(R.id.imageView, R.mipmap.more_unfold);
                }
            }
        });
        groupWrapper.expandOrShrikGroup(0);
        groupWrapper.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {

            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                return false;
            }
        });
        groupWrapper.getHelper().isAnimtor = false;
//        groupWrapper.notifyDataSetChanged();
    }
}
