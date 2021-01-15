package com.anningtex.multitype.test.stickheader;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityStickyBinding;
import com.bumptech.glide.Glide;

/**
 * @author Song
 */
public class Sticky2Activity extends AppCompatActivity {
    private ActivityStickyBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStickyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Glide.with(getApplicationContext())
                .load("http://upload-images.jianshu.io/upload_images/1599843-90dec187459c3612.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240")
//                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
//                .error(R.mipmap.cheese) // will be displayed if the image cannot be loaded
                .centerCrop()
                .into(binding.ivSticky);

        if (!Sticky2Activity.this.isFinishing()) {
            new Handler().postDelayed(() -> {
                Log.e("开始替换图片", "开始");
                Glide.with(getApplicationContext())
                        .load("http://upload-images.jianshu.io/upload_images/1599843-6bccd8b6bf4a90b7.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240")
//                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
//                .error(R.mipmap.cheese) // will be displayed if the image cannot be loaded
                        .centerCrop()
                        .into(binding.ivSticky);
            }, 2000);
        }
    }
}
