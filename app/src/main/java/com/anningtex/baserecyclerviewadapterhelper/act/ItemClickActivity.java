package com.anningtex.baserecyclerviewadapterhelper.act;

import android.os.Bundle;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.baserecyclerviewadapterhelper.adapter.ItemClickAdapter;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityItemClickBinding;
import com.anningtex.baserecyclerviewadapterhelper.entity.ClickEntity;
import com.anningtex.baserecyclerviewadapterhelper.utils.Tips;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Song
 */
public class ItemClickActivity extends AppCompatActivity {
    private ActivityItemClickBinding binding;
    private ItemClickAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityItemClickBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        setTitle("ItemClickActivity Activity");
        initAdapter();
        clickListenerAll();
    }

    private void initAdapter() {
        List<ClickEntity> data = new ArrayList<>();
        data.add(new ClickEntity(ClickEntity.CLICK_ITEM_VIEW));
        data.add(new ClickEntity(ClickEntity.CLICK_ITEM_CHILD_VIEW));
        data.add(new ClickEntity(ClickEntity.LONG_CLICK_ITEM_VIEW));
        data.add(new ClickEntity(ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW));
        data.add(new ClickEntity(ClickEntity.NEST_CLICK_ITEM_CHILD_VIEW));
        adapter = new ItemClickAdapter(data);
        adapter.setAnimationEnable(true);
        binding.rv.setAdapter(adapter);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    private void clickListenerAll() {
        adapter.setOnItemClickListener((adapter, view, position) -> Tips.show("onItemClick " + position));
        adapter.setOnItemLongClickListener((adapter, view, position) -> {
            Tips.show("onItemLongClick " + position);
            return true;
        });
        adapter.setOnItemChildClickListener((adapter, view, position) -> Tips.show("onItemChildClick " + position));
        adapter.setOnItemChildLongClickListener((adapter, view, position) -> {
            Tips.show("onItemChildLongClick " + position);
            return true;
        });
    }
}
