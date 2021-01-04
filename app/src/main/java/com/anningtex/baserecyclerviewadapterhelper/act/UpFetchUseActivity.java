package com.anningtex.baserecyclerviewadapterhelper.act;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.anningtex.baserecyclerviewadapterhelper.adapter.UpFetchAdapter;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityUpFetchUseBinding;
import com.anningtex.baserecyclerviewadapterhelper.entity.MovieEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author Song
 */
public class UpFetchUseActivity extends AppCompatActivity {
    private ActivityUpFetchUseBinding binding;
    private UpFetchAdapter mAdapter;
    private int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpFetchUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        setTitle("UpFetch Use");
        mAdapter = new UpFetchAdapter();
        binding.rv.setAdapter(mAdapter);
        mAdapter.getUpFetchModule().setOnUpFetchListener(() -> requestUoFetch());
        mAdapter.getUpFetchModule().setUpFetchEnable(true);
        mAdapter.setList(genData());
    }

    @Override
    protected void onStart() {
        super.onStart();
        scrollToBottom();
    }

    private void requestUoFetch() {
        count++;
        // set fetching on when start network request.
        // 当开始网络请求数据的时候，设置状态为加载中
        mAdapter.getUpFetchModule().setUpFetching(true);
        // get data from internet.
        binding.rv.postDelayed(() -> {
            mAdapter.addData(0, genData());
            //set fetching off when network request ends.
            //取消状态加载中的状态
            mAdapter.getUpFetchModule().setUpFetching(false);
            if (count > 5) {
                // set fetch enable false when you don't need anymore.
                // 不需要功能后，将其关闭
                mAdapter.getUpFetchModule().setUpFetchEnable(false);
            }
        }, 300);
    }

    /**
     * 滚动到底部（不带动画）
     */
    private void scrollToBottom() {
        LinearLayoutManager ll = (LinearLayoutManager) binding.rv.getLayoutManager();
        ll.scrollToPositionWithOffset(getBottomDataPosition(), 0);
    }

    /**
     * 滚动到底部（带动画）
     */
    private void smoothScrollToBottom() {
        if (mAdapter.getData().isEmpty()) {
            return;
        }
        binding.rv.post(() -> binding.rv.smoothScrollToPosition(getBottomDataPosition()));
    }

    private int getBottomDataPosition() {
        return mAdapter.getHeaderLayoutCount() + mAdapter.getData().size() - 1;
    }

    private List<MovieEntity> genData() {
        ArrayList<MovieEntity> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = "Chad";
            int price = random.nextInt(10) + 10;
            int len = random.nextInt(80) + 60;
            MovieEntity movie = new MovieEntity(name, len, price, "He was one of Australia's most distinguished artistes");
            list.add(movie);
        }
        return list;
    }
}
