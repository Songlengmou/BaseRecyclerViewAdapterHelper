package com.anningtex.baserecyclerviewadapterhelper.adapter;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ItemMovieBinding;
import com.anningtex.baserecyclerviewadapterhelper.entity.MovieEntity;
import com.anningtex.baserecyclerviewadapterhelper.entity.MoviePresenter;
import com.syp.library.BaseQuickAdapter;
import com.syp.library.viewholder.BaseDataBindingHolder;

import org.jetbrains.annotations.NotNull;

/**
 * @author Song
 */
public class DataBindingAdapter extends BaseQuickAdapter<MovieEntity, BaseDataBindingHolder<ItemMovieBinding>> {
    private MoviePresenter mPresenter = new MoviePresenter();

    public DataBindingAdapter() {
        super(R.layout.item_movie);
    }

    @Override
    protected void convert(@NotNull BaseDataBindingHolder<ItemMovieBinding> holder, MovieEntity item) {
        // 获取 Binding
        ItemMovieBinding binding = holder.getDataBinding();
        if (binding != null) {
            binding.setMovie(item);
            binding.setPresenter(mPresenter);
            binding.executePendingBindings();
        }
    }
}
