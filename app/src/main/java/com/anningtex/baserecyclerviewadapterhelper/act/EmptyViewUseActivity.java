package com.anningtex.baserecyclerviewadapterhelper.act;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.adapter.EmptyViewAdapter;
import com.anningtex.baserecyclerviewadapterhelper.data.DataServer;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityEmptyViewUseBinding;

/**
 * @Author Song
 */
public class EmptyViewUseActivity extends AppCompatActivity {
    private ActivityEmptyViewUseBinding binding;
    private EmptyViewAdapter mAdapter = new EmptyViewAdapter();
    private boolean mError = true;
    private boolean mNoData = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmptyViewUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        setTitle("EmptyView Use");
        binding.btnReset.setOnClickListener(v -> reset());
        binding.rvList.setAdapter(mAdapter);
    }

    private void reset() {
        mError = true;
        mNoData = true;
        mAdapter.setList(null);
        onRefresh();
    }

    @Override
    protected void onStart() {
        super.onStart();
        onRefresh();
    }

    private View getEmptyDataView() {
        View notDataView = getLayoutInflater().inflate(R.layout.empty_view, binding.rvList, false);
        notDataView.setOnClickListener(v -> onRefresh());
        return notDataView;
    }

    private View getErrorView() {
        View errorView = getLayoutInflater().inflate(R.layout.error_view, binding.rvList, false);
        errorView.setOnClickListener(v -> onRefresh());
        return errorView;
    }

    private void onRefresh() {
        // 方式一：直接传入 layout id
        mAdapter.setEmptyView(R.layout.loading_view);
        binding.rvList.postDelayed(() -> {
            if (mError) {
                // 方式二：传入View
                mAdapter.setEmptyView(getErrorView());
                mError = false;
            } else {
                if (mNoData) {
                    mAdapter.setEmptyView(getEmptyDataView());
                    mNoData = false;
                } else {
                    mAdapter.setList(DataServer.getSampleData(10));
                }
            }
        }, 1000);
    }
}
