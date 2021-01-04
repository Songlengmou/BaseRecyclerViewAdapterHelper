package com.anningtex.baserecyclerviewadapterhelper.act.multi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anningtex.baserecyclerviewadapterhelper.adapter.multi.ProviderMultiAdapter;
import com.anningtex.baserecyclerviewadapterhelper.data.DataServer;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityMultiItemProviderUseBinding;
import com.anningtex.baserecyclerviewadapterhelper.entity.ProviderMultiEntity;

import java.util.List;

/**
 * @author Song
 */
public class MultiItemProviderUseActivity extends AppCompatActivity {
    private ActivityMultiItemProviderUseBinding binding;
    private ProviderMultiAdapter adapter = new ProviderMultiAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMultiItemProviderUseBinding.inflate(getLayoutInflater());
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
        final List<ProviderMultiEntity> data = DataServer.getProviderMultiItemData();
        adapter.setList(data);
    }
}