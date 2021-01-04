package com.anningtex.baserecyclerviewadapterhelper.act;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.baserecyclerviewadapterhelper.act.multi.BinderUseActivity;
import com.anningtex.baserecyclerviewadapterhelper.act.multi.MultiItemDelegateUseActivity;
import com.anningtex.baserecyclerviewadapterhelper.act.multi.MultiItemProviderUseActivity;
import com.anningtex.baserecyclerviewadapterhelper.act.multi.MultiItemQuickUseActivity;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityChooseMultipleItemUseTypeBinding;

/**
 * @Author Song
 */
public class ChooseMultipleItemUseTypeActivity extends AppCompatActivity {
    private ActivityChooseMultipleItemUseTypeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChooseMultipleItemUseTypeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        setTitle("MultipleItem Use");
        binding.cardView0.setOnClickListener(v -> startActivity(new Intent(ChooseMultipleItemUseTypeActivity.this, BinderUseActivity.class)));
        binding.cardView1.setOnClickListener(v -> startActivity(new Intent(ChooseMultipleItemUseTypeActivity.this, MultiItemQuickUseActivity.class)));
        binding.cardView2.setOnClickListener(v -> startActivity(new Intent(ChooseMultipleItemUseTypeActivity.this, MultiItemDelegateUseActivity.class)));
        binding.cardView3.setOnClickListener(v -> startActivity(new Intent(ChooseMultipleItemUseTypeActivity.this, MultiItemProviderUseActivity.class)));
    }
}
