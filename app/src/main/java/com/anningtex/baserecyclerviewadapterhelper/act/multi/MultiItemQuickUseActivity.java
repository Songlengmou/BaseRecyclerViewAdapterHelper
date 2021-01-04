package com.anningtex.baserecyclerviewadapterhelper.act.multi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.anningtex.baserecyclerviewadapterhelper.adapter.multi.MultipleItemQuickAdapter;
import com.anningtex.baserecyclerviewadapterhelper.data.DataServer;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityMultiItemQuickUseBinding;
import com.anningtex.baserecyclerviewadapterhelper.entity.QuickMultipleEntity;

import java.util.List;

/**
 * @author Song
 */
public class MultiItemQuickUseActivity extends AppCompatActivity {
    private ActivityMultiItemQuickUseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMultiItemQuickUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        setTitle("BaseMultiItemQuickAdapter");
        final List<QuickMultipleEntity> data = DataServer.getMultipleItemData();
        final MultipleItemQuickAdapter multipleItemAdapter = new MultipleItemQuickAdapter(data);
        final GridLayoutManager manager = new GridLayoutManager(this, 4);
        binding.rvList.setLayoutManager(manager);
        multipleItemAdapter.setGridSpanSizeLookup((gridLayoutManager, viewType, position) -> data.get(position).getSpanSize());
        binding.rvList.setAdapter(multipleItemAdapter);
    }
}