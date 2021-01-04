package com.anningtex.baserecyclerviewadapterhelper.act;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.adapter.diff.DiffDemoCallback;
import com.anningtex.baserecyclerviewadapterhelper.adapter.diff.DiffUtilAdapter;
import com.anningtex.baserecyclerviewadapterhelper.data.DataServer;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityDiffUtilBinding;
import com.anningtex.baserecyclerviewadapterhelper.entity.DiffUtilDemoEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Song
 */
public class DiffUtilActivity extends AppCompatActivity {
    private ActivityDiffUtilBinding binding;
    private DiffUtilAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDiffUtilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initClick();
    }

    private void initView() {
        mAdapter = new DiffUtilAdapter(DataServer.getDiffUtilDemoEntities());
        binding.diffRv.setAdapter(mAdapter);

        View view = getLayoutInflater().inflate(R.layout.head_view, binding.diffRv, false);
        view.findViewById(R.id.iv).setVisibility(View.GONE);
        mAdapter.addHeaderView(view);

        // 必须设置Diff Callback
        mAdapter.setDiffCallback(new DiffDemoCallback());
    }

    private void initClick() {
        binding.itemChangeBtn.setOnClickListener(v -> {
            List<DiffUtilDemoEntity> newData = getNewList();
            mAdapter.setDiffNewData(newData);
        });
        binding.notifyChangeBtn.setOnClickListener(v -> {
            // change item 0
            mAdapter.getData().set(0, new DiffUtilDemoEntity(
                    1,
                    "😊😊Item " + 0,
                    "Item " + 0 + " content have change (notifyItemChanged)",
                    "06-12"));
            mAdapter.notifyItemChanged(0 + mAdapter.getHeaderLayoutCount(), DiffUtilAdapter.ITEM_0_PAYLOAD);
        });
    }

    /**
     * get new data
     */
    private List<DiffUtilDemoEntity> getNewList() {
        List<DiffUtilDemoEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //Simulate deletion of data No. 1 and No. 3
            //模拟删除1号和3号数据
            if (i == 1 || i == 3) {
                continue;
            }
            //Simulate modification title of data No. 0
            //模拟修改0号数据的title
            if (i == 0) {
                list.add(new DiffUtilDemoEntity(
                        i,
                        "😊Item " + i,
                        "This item " + i + " content",
                        "06-12")
                );
                continue;
            }
            //Simulate modification content of data No. 4
            //模拟修改4号数据的content发生变化
            if (i == 4) {
                list.add(new DiffUtilDemoEntity(
                        i,
                        "Item " + i,
                        "Oh~~~~~~, Item " + i + " content have change",
                        "06-12")
                );
                continue;
            }
            list.add(new DiffUtilDemoEntity(
                    i,
                    "Item " + i,
                    "This item " + i + " content",
                    "06-12")
            );
        }
        return list;
    }
}
