package com.anningtex.baserecyclerviewadapterhelper.act.multi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityBinderUseBinding;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ItemImgTextViewBinding;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ItemMovieBinding;
import com.anningtex.baserecyclerviewadapterhelper.entity.ContentEntity;
import com.anningtex.baserecyclerviewadapterhelper.entity.ImageEntity;
import com.anningtex.baserecyclerviewadapterhelper.entity.MovieEntity;
import com.anningtex.baserecyclerviewadapterhelper.entity.MoviePresenter;
import com.anningtex.baserecyclerviewadapterhelper.entity.VideoEntity;
import com.anningtex.baserecyclerviewadapterhelper.utils.Tips;
import com.syp.library.BaseBinderAdapter;
import com.syp.library.binder.BaseItemBinder;
import com.syp.library.binder.QuickDataBindingItemBinder;
import com.syp.library.binder.QuickItemBinder;
import com.syp.library.binder.QuickViewBindingItemBinder;
import com.syp.library.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Song
 */
public class BinderUseActivity extends AppCompatActivity {
    private ActivityBinderUseBinding binding;
    /**
     * 可以直接快速使用，也可以继承BaseBinderAdapter类，重写自己的相关方法
     */
    private BaseBinderAdapter adapter = new BaseBinderAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBinderUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initRv();
    }

    private void initView() {
        setTitle("BaseMultiItemQuickAdapter");
    }

    private void initRv() {
        // 添加 itemBinder, 各种创建方式如下
        adapter
                // QuickItemBinder
                .addItemBinder(ImageEntity.class, new ImageItemBinder())
                // QuickViewBindingItemBinder, 并且注册了 Diff
                .addItemBinder(VideoEntity.class, new ImageTextItemBinder(), new ImageTextItemBinder.Differ())
                // QuickDataBindingItemBinder
                .addItemBinder(MovieEntity.class, new MovieItemBinder())
                // BaseItemBinder
                .addItemBinder(ContentEntity.class, new ContentItemBinder());

        View headView = getLayoutInflater().inflate(R.layout.head_view, null, false);
        headView.findViewById(R.id.iv).setVisibility(View.GONE);
        headView.setOnClickListener(v -> Tips.show("HeaderView"));
        adapter.setHeaderView(headView);

        binding.rvList.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Random random = new Random();
        // 模拟设置数据，数据顺序随意组合
        List<Object> data = new ArrayList<>();
        data.add(new ImageEntity());
        data.add(new ImageEntity());
        data.add(new VideoEntity(1, "", "Video 1"));
        data.add(new VideoEntity(2, "", "Video 2"));
        data.add(new MovieEntity("Chad 1", 0, random.nextInt(5) + 10, "He was one of Australia's most distinguished artistes"));
        data.add(new ImageEntity());
        data.add(new MovieEntity("Chad 2", 0, random.nextInt(5) + 10, "This movie is exciting"));
        data.add(new ImageEntity());
        data.add(new VideoEntity(3, "", "Video 3"));
        data.add(new VideoEntity(4, "", "Video 4"));
        data.add(new ContentEntity("Content 1"));
        data.add(new ContentEntity("Content 2"));
        // 设置新数据
        adapter.setList(data);
        // 延迟3秒以后执行，模拟Diff刷新数据
        binding.rvList.postDelayed(() -> {
            // 模拟需要 Diff 的新数据
            // 先拷贝出数据
            List<Object> data1 = new ArrayList<>(adapter.getData());
            // 修改数据
            data1.add(0, new ImageEntity());
            data1.add(2, new VideoEntity(8, "", "new Video 1.1"));
            data1.add(new ImageEntity());
            // 使用 diif 刷新数据
            adapter.setDiffNewData(data1);
        }, 3000);
    }

    /**
     * 使用 layout，快速创建Binder
     */
    private final static class ImageItemBinder extends QuickItemBinder<ImageEntity> {

        @Override
        public int getLayoutId() {
            return R.layout.item_image_view;
        }

        @Override
        public void convert(@NotNull BaseViewHolder holder, ImageEntity data) {
        }

        @Override
        public void onClick(@NotNull BaseViewHolder holder, @NotNull View view, ImageEntity data, int position) {
            Toast.makeText(getContext(), "click index: " + position, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 使用 ViewBinding，快速创建Binder
     */
    private final static class ImageTextItemBinder extends QuickViewBindingItemBinder<VideoEntity, ItemImgTextViewBinding> {

        @NotNull
        @Override
        public ItemImgTextViewBinding onCreateViewBinding(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup parent, int viewType) {
            return ItemImgTextViewBinding.inflate(layoutInflater, parent, false);
        }

        @Override
        public void convert(@NotNull BinderVBHolder<ItemImgTextViewBinding> holder, VideoEntity data) {
            holder.getViewBinding().tv.setText("(ViewBinding) " + data.getName());
        }

        /**
         * 如果需要 Diff，可以自行实现如下内容
         */
        public static class Differ extends DiffUtil.ItemCallback<VideoEntity> {
            @Override
            public boolean areItemsTheSame(@NonNull VideoEntity oldItem, @NonNull VideoEntity newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull VideoEntity oldItem, @NonNull VideoEntity newItem) {
                return oldItem.getName().equals(newItem.getName());
            }
        }
    }

    /**
     * 使用 DataBinding，快速创建Binder
     */
    private final static class MovieItemBinder extends QuickDataBindingItemBinder<MovieEntity, ItemMovieBinding> {

        private MoviePresenter mPresenter = new MoviePresenter();

        @NotNull
        @Override
        public ItemMovieBinding onCreateDataBinding(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup parent, int viewType) {
            return ItemMovieBinding.inflate(layoutInflater, parent, false);
        }

        @Override
        public void convert(@NotNull BinderDataBindingHolder<ItemMovieBinding> holder, MovieEntity data) {
            ItemMovieBinding binding = holder.getDataBinding();
            binding.setMovie(data);
            binding.setPresenter(mPresenter);
            binding.executePendingBindings();
        }
    }

    /**
     * 使用最基础的 BaseItemBinder 创建 Binder
     */
    private static class ContentItemBinder extends BaseItemBinder<ContentEntity, BaseViewHolder> {
        @NotNull
        @Override
        public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text_view, parent, false);
            return new BaseViewHolder(view);
        }

        @Override
        public void convert(@NotNull BaseViewHolder holder, ContentEntity data) {
            holder.setText(R.id.tv, data.getContent());
        }
    }
}