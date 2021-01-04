package com.anningtex.baserecyclerviewadapterhelper.act;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.adapter.HeaderAndFooterAdapter;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityHeaderAndFooterUseBinding;
import com.anningtex.baserecyclerviewadapterhelper.utils.Tips;

/**
 * @Author Song
 */
public class HeaderAndFooterUseActivity extends AppCompatActivity {
    private ActivityHeaderAndFooterUseBinding binding;
    private HeaderAndFooterAdapter adapter;
    private static final int PAGE_SIZE = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHeaderAndFooterUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        setTitle("HeaderAndFooter Use");
        initAdapter();
        //头部
        View headerView = getHeaderView(0, v -> adapter.addHeaderView(getHeaderView(1, getRemoveHeaderListener()), 0));
        adapter.addHeaderView(headerView);
        //脚部
        View footerView = getFooterView(0, v -> adapter.addFooterView(getFooterView(1, getRemoveFooterListener()), 0));
        adapter.addFooterView(footerView, 0);
        binding.rv.setAdapter(adapter);
    }

    private void initAdapter() {
        adapter = new HeaderAndFooterAdapter(PAGE_SIZE);
        adapter.setAnimationEnable(true);
        adapter.setOnItemClickListener((adapter, view, position) -> Tips.show(String.valueOf(position)));
    }

    private View getHeaderView(int type, View.OnClickListener listener) {
        View view = getLayoutInflater().inflate(R.layout.head_view, binding.rv, false);
        if (type == 1) {
            ImageView imageView = view.findViewById(R.id.iv);
            imageView.setImageResource(R.mipmap.rm_icon);
        }
        view.setOnClickListener(listener);
        return view;
    }

    private View getFooterView(int type, View.OnClickListener listener) {
        View view = getLayoutInflater().inflate(R.layout.footer_view, binding.rv, false);
        if (type == 1) {
            ImageView imageView = view.findViewById(R.id.iv);
            imageView.setImageResource(R.mipmap.rm_icon);
        }
        view.setOnClickListener(listener);
        return view;
    }

    private View.OnClickListener getRemoveHeaderListener() {
        return v -> adapter.removeHeaderView(v);
    }

    private View.OnClickListener getRemoveFooterListener() {
        return v -> adapter.removeFooterView(v);
    }
}
