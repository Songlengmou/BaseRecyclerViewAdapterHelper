package com.anningtex.multitype.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityTestAllRecycleBinding;
import com.anningtex.multitype.multitypeadapter.CommonAdapter;
import com.anningtex.multitype.multitypeadapter.base.OnItemClickListener;
import com.anningtex.multitype.multitypeadapter.base.ViewHolder;
import com.anningtex.multitype.test.anim.AnimatorActivity;
import com.anningtex.multitype.test.decoration.ItemDecoration;
import com.anningtex.multitype.test.empty.EmptyActivity;
import com.anningtex.multitype.test.group.GroupActivity;
import com.anningtex.multitype.test.headerFoot.MixHeadFootActivity;
import com.anningtex.multitype.test.itemTouch.ItemTouchActivity;
import com.anningtex.multitype.test.manyData.MultiDataActivity;
import com.anningtex.multitype.test.mix.MixActivity;
import com.anningtex.multitype.test.mix.TimeLineActivity;
import com.anningtex.multitype.test.mix.WaterFallActivity;
import com.anningtex.multitype.test.one2many.One2ManyActivity;
import com.anningtex.multitype.test.pull_load.PullLoadActivity;
import com.anningtex.multitype.test.stickheader.StickHeaderActivity;
import com.anningtex.multitype.test.stickheader.Sticky2Activity;
import com.anningtex.multitype.test.stickheader.Sticky3Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Song
 * desc: 多类型 RecyclerAdapter
 * source:
 * https://github.com/LidongWen
 * https://github.com/LidongWen/MultiTypeAdapter/releases
 */
public class TestAllRecycleActivity extends AppCompatActivity {
    private ActivityTestAllRecycleBinding binding;
    private CommonAdapter adapter;
    private List<ItemClass> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestAllRecycleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        adapter = new CommonAdapter<ItemClass>(this, ItemClass.class, R.layout.item_one) {
            @Override
            protected void convert(ViewHolder holder, final ItemClass item, int position) {
                holder.setText(R.id.tv_item01, item.name);
            }
        };
        adapter.setOnItemClickListener(new OnItemClickListener<ItemClass>() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, ItemClass itemClass, int position) {
                Intent intent = new Intent(TestAllRecycleActivity.this, itemClass.classUri);
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, ItemClass itemClass, int position) {
                return false;
            }
        });

        int space = getResources().getDimensionPixelSize(R.dimen.btn_space);
        binding.rlvMultiType.addItemDecoration(new ItemDecoration(space));
        binding.rlvMultiType.setAdapter(adapter);
        itemDatas();
        adapter.setItems(list);
        adapter.notifyDataSetChanged();
    }

    private void itemDatas() {
        list.add(new ItemClass("MultiDataActivity", MultiDataActivity.class));
        list.add(new ItemClass("One2ManyActivity", One2ManyActivity.class));
        list.add(new ItemClass("MixActivity", MixActivity.class));
        list.add(new ItemClass("WaterFallActivity", WaterFallActivity.class));
        list.add(new ItemClass("pull-load", PullLoadActivity.class));
        list.add(new ItemClass("empty", EmptyActivity.class));
        list.add(new ItemClass("itemTouchHelper", ItemTouchActivity.class));
        list.add(new ItemClass("StickHeader", StickHeaderActivity.class));
        list.add(new ItemClass("TimeLine", TimeLineActivity.class));
        list.add(new ItemClass("AnimatorActivity", AnimatorActivity.class));
        list.add(new ItemClass("MixHeadFootActivity", MixHeadFootActivity.class));
        list.add(new ItemClass("GroupActivity", GroupActivity.class));
        list.add(new ItemClass("Sticky2Activity", Sticky2Activity.class));
        list.add(new ItemClass("Sticky3Activity", Sticky3Activity.class));
    }

    public class ItemClass {
        public String name;
        public Class classUri;

        public ItemClass(String name, Class classUri) {
            this.name = name;
            this.classUri = classUri;
        }
    }
}