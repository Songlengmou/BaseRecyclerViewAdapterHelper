package com.anningtex.baserecyclerviewadapterhelper.act.node;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.adapter.node.section.NodeSectionAdapter;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityNodeSectionUseBinding;
import com.anningtex.baserecyclerviewadapterhelper.entity.node.section.ItemNode;
import com.anningtex.baserecyclerviewadapterhelper.entity.node.section.RootNode;
import com.syp.library.entity.node.BaseNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Song
 */
public class NodeSectionUseActivity extends AppCompatActivity {
    private ActivityNodeSectionUseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNodeSectionUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        setTitle("Node Use (Section)");
        binding.rvList.setLayoutManager(new GridLayoutManager(this, 3));
//        binding.rvList.addItemDecoration(new GridSectionAverageGapItemDecoration(10, 10, 20, 15));
        final NodeSectionAdapter nodeAdapter = new NodeSectionAdapter();
        // 顶部header
        View view = getLayoutInflater().inflate(R.layout.head_view, binding.rvList, false);
        view.findViewById(R.id.iv).setVisibility(View.GONE);
        nodeAdapter.addHeaderView(view);

        binding.rvList.setAdapter(nodeAdapter);

        nodeAdapter.setList(getEntity());
        binding.rvList.scheduleLayoutAnimation();
    }

    private List<BaseNode> getEntity() {
        List<BaseNode> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            //Item Node
            ItemNode itemEntity1 = new ItemNode(R.mipmap.click_head_img_0, "Root " + i + " - SecondNode 0");
            ItemNode itemEntity2 = new ItemNode(R.mipmap.click_head_img_0, "Root " + i + " - SecondNode 1");
            ItemNode itemEntity3 = new ItemNode(R.mipmap.click_head_img_0, "Root " + i + " - SecondNode 2");
            ItemNode itemEntity4 = new ItemNode(R.mipmap.click_head_img_0, "Root " + i + " - SecondNode 3");
            ItemNode itemEntity5 = new ItemNode(R.mipmap.click_head_img_0, "Root " + i + " - SecondNode 4");
            List<BaseNode> items = new ArrayList<>();
            items.add(itemEntity1);
            items.add(itemEntity2);
            items.add(itemEntity3);
            items.add(itemEntity4);
            items.add(itemEntity5);
            // Root Node
            RootNode entity = new RootNode(items, "Root Node " + i);
            if (i == 1) {
                // 第1号数据默认不展开
                entity.setExpanded(false);
            }
            list.add(entity);
        }
        return list;
    }
}