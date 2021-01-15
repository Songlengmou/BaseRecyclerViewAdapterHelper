package com.anningtex.testdata.two;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityTwoBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Song
 * desc:RecyclerView加载多个不同布局
 */
public class TwoActivity extends AppCompatActivity {
    private ActivityTwoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTwoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        TwoAdapter twoAdapter = new TwoAdapter(child());

        View view = getLayoutInflater().inflate(R.layout.head_view_test, binding.recyclerView, false);
        RecyclerView headRecyclerView = view.findViewById(R.id.head_recycler);
        TwoAdapter headAdapter = new TwoAdapter(head());
        headRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        headRecyclerView.setAdapter(headAdapter);
        twoAdapter.addHeaderView(view);

        View footerView = getLayoutInflater().inflate(R.layout.footer_view_test, binding.recyclerView, false);
        RecyclerView footerRecyclerView = footerView.findViewById(R.id.footer_recycler);
        TwoAdapter footerAdapter = new TwoAdapter(footer());
        footerRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        footerRecyclerView.setAdapter(footerAdapter);
        twoAdapter.addFooterView(footerView);

        binding.recyclerView.setAdapter(twoAdapter);
    }

    private List<String> footer() {
        List<String> str = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            str.add("8023");
        }
        return str;
    }

    private List<String> head() {
        List<String> str = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            str.add("521");
        }
        return str;
    }

    private List<String> child() {
        List<String> str = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            str.add("1314");
        }
        return str;
    }
}