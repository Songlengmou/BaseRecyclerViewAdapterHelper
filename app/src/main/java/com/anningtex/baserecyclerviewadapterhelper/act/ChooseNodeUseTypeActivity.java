package com.anningtex.baserecyclerviewadapterhelper.act;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.act.node.NodeSectionUseActivity;
import com.anningtex.baserecyclerviewadapterhelper.act.node.NodeTreeUseActivity;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityChooseNodeUseTypeBinding;

/**
 * @Author Song
 */
public class ChooseNodeUseTypeActivity extends AppCompatActivity {
    private ActivityChooseNodeUseTypeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChooseNodeUseTypeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        setTitle("Node Use");
        findViewById(R.id.card_view1).setOnClickListener(v -> startActivity(new Intent(ChooseNodeUseTypeActivity.this, NodeSectionUseActivity.class)));
        findViewById(R.id.card_view2).setOnClickListener(v -> startActivity(new Intent(ChooseNodeUseTypeActivity.this, NodeTreeUseActivity.class)));
    }
}
