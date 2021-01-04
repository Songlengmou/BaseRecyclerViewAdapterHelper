package com.anningtex.baserecyclerviewadapterhelper.act.multi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anningtex.baserecyclerviewadapterhelper.adapter.multi.DelegateMultiAdapter;
import com.anningtex.baserecyclerviewadapterhelper.data.DataServer;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityMultiItemDelegateUseBinding;
import com.anningtex.baserecyclerviewadapterhelper.entity.DelegateMultiEntity;

import java.util.List;

/**
 * @author Song
 */
public class MultiItemDelegateUseActivity extends AppCompatActivity {
    private ActivityMultiItemDelegateUseBinding binding;
    private DelegateMultiAdapter adapter = new DelegateMultiAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMultiItemDelegateUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        setTitle("BaseMultiItemQuickAdapter");
        binding.rvList.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        final List<DelegateMultiEntity> data = DataServer.getDelegateMultiItemData();
        adapter.setList(data);
    }
}