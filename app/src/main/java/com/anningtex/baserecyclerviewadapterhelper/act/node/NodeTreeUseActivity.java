package com.anningtex.baserecyclerviewadapterhelper.act.node;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.anningtex.baserecyclerviewadapterhelper.adapter.node.tree.NodeTreeAdapter;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityNodeTreeUseBinding;
import com.anningtex.baserecyclerviewadapterhelper.entity.node.tree.FirstNode;
import com.anningtex.baserecyclerviewadapterhelper.entity.node.tree.SecondNode;
import com.anningtex.baserecyclerviewadapterhelper.entity.node.tree.ThirdNode;
import com.anningtex.baserecyclerviewadapterhelper.utils.Tips;
import com.syp.library.entity.node.BaseNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Song
 */
public class NodeTreeUseActivity extends AppCompatActivity {
    private ActivityNodeTreeUseBinding binding;
    private NodeTreeAdapter adapter = new NodeTreeAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNodeTreeUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        setTitle("Node Use (Tree)");
        binding.rvList.setAdapter(adapter);
        adapter.setList(getEntity());
        // 模拟新增node
        binding.rvList.postDelayed(() -> {
            SecondNode seNode = new SecondNode(new ArrayList<>(), "Second Node(This is added)");
            SecondNode seNode2 = new SecondNode(new ArrayList<>(), "Second Node(This is added)");
            List<SecondNode> nodes = new ArrayList<>();
            nodes.add(seNode);
            nodes.add(seNode2);
            //第一个夫node，位置为子node的3号位置
            adapter.nodeAddData(adapter.getData().get(0), 2, nodes);
//            adapter.nodeSetData(adapter.getData().get(0), 2, seNode2);
//            adapter.nodeReplaceChildData(adapter.getData().get(0), nodes);
            Tips.show("新插入了两个node", Toast.LENGTH_LONG);
        }, 2000);
    }

    private List<BaseNode> getEntity() {
        List<BaseNode> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            List<BaseNode> secondNodeList = new ArrayList<>();
            for (int n = 0; n <= 5; n++) {
                List<BaseNode> thirdNodeList = new ArrayList<>();
                for (int t = 0; t <= 3; t++) {
                    ThirdNode node = new ThirdNode("Third Node " + t);
                    thirdNodeList.add(node);
                }
                SecondNode seNode = new SecondNode(thirdNodeList, "Second Node " + n);
                secondNodeList.add(seNode);
            }
            FirstNode entity = new FirstNode(secondNodeList, "First Node " + i);
            // 模拟 默认第0个是展开的
            entity.setExpanded(i == 0);
            list.add(entity);
        }
        return list;
    }
}