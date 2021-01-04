package com.anningtex.baserecyclerviewadapterhelper.act;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.adapter.AnimationAdapter;
import com.anningtex.baserecyclerviewadapterhelper.animator.CustomAnimation1;
import com.anningtex.baserecyclerviewadapterhelper.animator.CustomAnimation2;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityAnimationUseBinding;
import com.anningtex.baserecyclerviewadapterhelper.entity.StatusEntity;
import com.anningtex.baserecyclerviewadapterhelper.utils.Tips;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.kyleduo.switchbutton.SwitchButton;
import com.syp.library.BaseQuickAdapter;

/**
 * @Author Song
 */
public class AnimationUseActivity extends AppCompatActivity {
    private ActivityAnimationUseBinding binding;
    private AnimationAdapter mAnimationAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnimationUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initAdapter();
        initMenu();
    }

    private void initView() {
        binding.rvList.setHasFixedSize(true);
        binding.imgBack.setOnClickListener(view -> finish());
    }

    private void initAdapter() {
        mAnimationAdapter = new AnimationAdapter();
        mAnimationAdapter.setAnimationEnable(true);
        mAnimationAdapter.addChildClickViewIds(R.id.img, R.id.tweetName, R.id.tweetText);
        mAnimationAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            String content = null;
            StatusEntity status = (StatusEntity) adapter.getItem(position);
            switch (view.getId()) {
                case R.id.img:
                    content = "img:" + status.getUserAvatar();
                    break;
                case R.id.tweetName:
                    content = "name:" + status.getUserName();
                    break;
                case R.id.tweetText:
                    content = "tweetText:" + status.getUserName();
                    break;
                default:
                    break;
            }
            Tips.show(content);
        });
        binding.rvList.setAdapter(mAnimationAdapter);
    }

    private void initMenu() {
        MaterialSpinner spinner = findViewById(R.id.spinner);
        spinner.setItems("AlphaIn", "ScaleIn", "SlideInBottom", "SlideInLeft", "SlideInRight", "Custom1", "Custom2");
        spinner.setOnItemSelectedListener((MaterialSpinner.OnItemSelectedListener<String>) (view, position, id, item) -> {
            switch (position) {
                case 0:
                    mAnimationAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.AlphaIn);
                    break;
                case 1:
                    mAnimationAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn);
                    break;
                case 2:
                    mAnimationAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.SlideInBottom);
                    break;
                case 3:
                    mAnimationAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.SlideInLeft);
                    break;
                case 4:
                    mAnimationAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.SlideInRight);
                    break;
                case 5:
                    mAnimationAdapter.setAdapterAnimation(new CustomAnimation1());
                    break;
                case 6:
                    mAnimationAdapter.setAdapterAnimation(new CustomAnimation2());
                    break;
                default:
                    break;
            }
            binding.rvList.setAdapter(mAnimationAdapter);
        });
        //init firstOnly state
        mAnimationAdapter.setAnimationFirstOnly(false);
        SwitchButton switchButton = findViewById(R.id.switch_button);
        switchButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                mAnimationAdapter.setAnimationFirstOnly(true);
            } else {
                mAnimationAdapter.setAnimationFirstOnly(false);
            }
            mAnimationAdapter.notifyDataSetChanged();
        });
    }
}
