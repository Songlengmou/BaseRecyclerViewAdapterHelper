package com.anningtex.baserecyclerviewadapterhelper.act;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.adapter.LoadMoreAdapter;
import com.anningtex.baserecyclerviewadapterhelper.data.DataServer;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityLoadMoreRefreshUseBinding;
import com.anningtex.baserecyclerviewadapterhelper.entity.StatusEntity;
import com.anningtex.baserecyclerviewadapterhelper.loadmore.CustomLoadMoreView;
import com.anningtex.baserecyclerviewadapterhelper.utils.Tips;

import java.util.List;

/**
 * @Author Song
 */
public class LoadMoreRefreshUseActivity extends AppCompatActivity {
    private ActivityLoadMoreRefreshUseBinding binding;

    class PageInfo {
        int page = 0;

        void nextPage() {
            page++;
        }

        void reset() {
            page = 0;
        }

        boolean isFirstPage() {
            return page == 0;
        }
    }

    private static final int PAGE_SIZE = 5;
    private LoadMoreAdapter mAdapter;
    private PageInfo pageInfo = new PageInfo();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoadMoreRefreshUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        setTitle("LoadMore Refresh Use");
        initAdapter();
        addHeadView();
        initRefreshLayout();
        initLoadMore();
        initSwitch();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 进入页面，刷新数据
        binding.swipeLayout.setRefreshing(true);
        refresh();
    }

    private void initAdapter() {
        mAdapter = new LoadMoreAdapter();
        mAdapter.setAnimationEnable(true);
        binding.rvList.setAdapter(mAdapter);
    }

    private void addHeadView() {
        View headView = getLayoutInflater().inflate(R.layout.head_view, (ViewGroup) binding.rvList.getParent(), false);
        headView.findViewById(R.id.iv).setVisibility(View.GONE);
        ((TextView) headView.findViewById(R.id.tv)).setText("Change Custom LoadView");
        headView.setOnClickListener(v -> {
            mAdapter.setList(null);
            mAdapter.getLoadMoreModule().setLoadMoreView(new CustomLoadMoreView());
            binding.rvList.setAdapter(mAdapter);
            Tips.show("Change Complete");
            binding.swipeLayout.setRefreshing(true);
            refresh();
        });
        mAdapter.addHeaderView(headView);
    }

    private void initRefreshLayout() {
        binding.swipeLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        binding.swipeLayout.setOnRefreshListener(() -> refresh());
    }

    /**
     * 初始化加载更多
     */
    private void initLoadMore() {
        mAdapter.getLoadMoreModule().setOnLoadMoreListener(() -> loadMore());
        mAdapter.getLoadMoreModule().setAutoLoadMore(true);
        //当自动加载开启，同时数据不满一屏时，是否继续执行自动加载更多(默认为true)
        mAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
    }

    private void initSwitch() {
        binding.autoLoadMoreSwitch.setChecked(mAdapter.getLoadMoreModule().isAutoLoadMore());
        binding.autoLoadMoreSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            mAdapter.getLoadMoreModule().setAutoLoadMore(isChecked);
            if (isChecked) {
                binding.autoLoadMoreSwitch.setText("自动加载（开）");
            } else {
                binding.autoLoadMoreSwitch.setText("自动加载（关）");
            }
        });
    }

    /**
     * 刷新
     */
    private void refresh() {
        // 这里的作用是防止下拉刷新的时候还可以上拉加载
        mAdapter.getLoadMoreModule().setEnableLoadMore(false);
        // 下拉刷新，需要重置页数
        pageInfo.reset();
        request();
    }

    /**
     * 加载更多
     */
    private void loadMore() {
        request();
    }

    /**
     * 请求数据
     */
    private void request() {
        new Request(pageInfo.page, new RequestCallBack() {
            @Override
            public void success(List<StatusEntity> data) {
                binding.swipeLayout.setRefreshing(false);
                mAdapter.getLoadMoreModule().setEnableLoadMore(true);

                if (pageInfo.isFirstPage()) {
                    //如果是加载的第一页数据，用 setData()
                    mAdapter.setList(data);
                } else {
                    //不是第一页，则用add
                    mAdapter.addData(data);
                }

                if (data.size() < PAGE_SIZE) {
                    //如果不够一页,显示没有更多数据布局
                    mAdapter.getLoadMoreModule().loadMoreEnd();
                    Tips.show("no more data");
                } else {
                    mAdapter.getLoadMoreModule().loadMoreComplete();
                }

                // page加一
                pageInfo.nextPage();
            }

            @Override
            public void fail(Exception e) {
                Tips.show(getResources().getString(R.string.network_err));
                binding.swipeLayout.setRefreshing(false);
                mAdapter.getLoadMoreModule().setEnableLoadMore(true);
                mAdapter.getLoadMoreModule().loadMoreFail();
            }
        }).start();
    }

    /**
     * 模拟加载数据的类，不用特别关注
     */
    static class Request extends Thread {
        private int mPage;
        private RequestCallBack mCallBack;
        private Handler mHandler;

        private static boolean mFirstPageNoMore;
        private static boolean mFirstError = true;

        public Request(int page, RequestCallBack callBack) {
            mPage = page;
            mCallBack = callBack;
            mHandler = new Handler(Looper.getMainLooper());
        }

        @Override
        public void run() {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (mPage == 2 && mFirstError) {
                mFirstError = false;
                mHandler.post(() -> mCallBack.fail(new RuntimeException("fail")));
            } else {
                int size = PAGE_SIZE;
                if (mPage == 1) {
                    if (mFirstPageNoMore) {
                        size = 1;
                    }
                    mFirstPageNoMore = !mFirstPageNoMore;
                    if (!mFirstError) {
                        mFirstError = true;
                    }
                } else if (mPage == 4) {
                    size = 1;
                }

                final int dataSize = size;
                mHandler.post(() -> mCallBack.success(DataServer.getSampleData(dataSize)));
            }
        }
    }

    interface RequestCallBack {
        /**
         * 模拟加载成功
         *
         * @param data 数据
         */
        void success(List<StatusEntity> data);

        /**
         * 模拟加载失败
         *
         * @param e 错误信息
         */
        void fail(Exception e);
    }
}
