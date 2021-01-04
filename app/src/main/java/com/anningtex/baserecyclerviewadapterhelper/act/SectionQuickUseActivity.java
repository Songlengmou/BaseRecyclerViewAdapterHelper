package com.anningtex.baserecyclerviewadapterhelper.act;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.adapter.SectionQuickAdapter;
import com.anningtex.baserecyclerviewadapterhelper.data.DataServer;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivitySectionQuickUseBinding;
import com.anningtex.baserecyclerviewadapterhelper.decoration.GridSectionAverageGapItemDecoration;
import com.anningtex.baserecyclerviewadapterhelper.entity.MySectionEntity;
import com.anningtex.baserecyclerviewadapterhelper.entity.VideoEntity;
import com.anningtex.baserecyclerviewadapterhelper.utils.Tips;

import java.util.List;

/**
 * @Author Song
 */
public class SectionQuickUseActivity extends AppCompatActivity {
    private ActivitySectionQuickUseBinding binding;
    private List<MySectionEntity> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySectionQuickUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        setTitle("Quick Section Use");
        binding.rvList.setLayoutManager(new GridLayoutManager(this, 3));
        binding.rvList.addItemDecoration(new GridSectionAverageGapItemDecoration(10, 10, 20, 15));

        mData = DataServer.getSectionData();
        SectionQuickAdapter adapter = new SectionQuickAdapter(R.layout.item_section_content,
                R.layout.def_section_head, mData);

        adapter.setOnItemClickListener((adapter1, view, position) -> {
            MySectionEntity mySection = mData.get(position);
            if (mySection.isHeader()) {
                Tips.show((String) mySection.getObject());
            } else {
                VideoEntity video = (VideoEntity) mySection.getObject();
                Tips.show(video.getName());
            }
        });
        adapter.setOnItemChildClickListener((adapter12, view, position) -> Tips.show("onItemChildClick: " + position));
        binding.rvList.setAdapter(adapter);
    }
}
