package com.anningtex.baserecyclerviewadapterhelper.act;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.adapter.DataBindingAdapter;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityDataBindingUseBinding;
import com.anningtex.baserecyclerviewadapterhelper.entity.MovieEntity;
import com.anningtex.baserecyclerviewadapterhelper.utils.Tips;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author Song
 */
public class DataBindingUseActivity extends AppCompatActivity {
    private ActivityDataBindingUseBinding binding;
    private DataBindingAdapter adapter = new DataBindingAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataBindingUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        setTitle("DataBinding Use");
        binding.rv.setAdapter(adapter);

        //demo 添加的 Header
        //Header 是自行添加进去的 View，所以 Adapter 不管理 Header 的 DataBinding。
        //请在外部自行完成数据的绑定
        View view = getLayoutInflater().inflate(R.layout.head_view, null, false);
        view.findViewById(R.id.iv).setVisibility(View.GONE);
        adapter.addHeaderView(view);
        //item 点击事件
        adapter.setOnItemClickListener((adapter, view1, position) -> Tips.show("onItemClick: " + position));
        //设置数据
        adapter.setList(genData());
    }

    private List<MovieEntity> genData() {
        ArrayList<MovieEntity> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = "Chad " + i;
            int price = random.nextInt(10) + 10;
            int len = random.nextInt(80) + 60;
            MovieEntity movie = new MovieEntity(name, len, price, "He was one of Australia's most distinguished artistes");
            list.add(movie);
        }
        return list;
    }
}
