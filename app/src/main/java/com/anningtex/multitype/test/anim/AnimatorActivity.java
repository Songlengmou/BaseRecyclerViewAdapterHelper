package com.anningtex.multitype.test.anim;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityAnimatorBinding;
import com.anningtex.multitype.multitypeadapter.CommonAdapter;
import com.anningtex.multitype.multitypeadapter.base.ViewHolder;
import com.anningtex.multitype.test.decoration.ItemBottomDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Song
 */
public class AnimatorActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityAnimatorBinding binding;
    private List<String> mData = new ArrayList<>();
    private boolean isFirst = true;
    private CommonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnimatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        adapterData();
    }

    private void initView() {
        binding.btnAdd.setOnClickListener(this);
        binding.btnRemove.setOnClickListener(this);
        binding.btnUpdate.setOnClickListener(this);
    }

    private void adapterData() {
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        binding.rvActivityAnimator.setItemAnimator(new FadeItemAnimator());
                        break;
                    case 1:
                        binding.rvActivityAnimator.setItemAnimator(new SlideItemAnimator());
                        break;
                    case 2:
                        binding.rvActivityAnimator.setItemAnimator(new RotateItemAnimator());
                        break;
                    case 3:
                        binding.rvActivityAnimator.setItemAnimator(new ScaleItemAnimator());
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.rvActivityAnimator.addItemDecoration(new ItemBottomDecoration(15));
        adapter = new CommonAdapter<String>(this, String.class, R.layout.header_one) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.tv_header, s);
            }
        };
        binding.rvActivityAnimator.setAdapter(adapter);

        for (int i = 0; i < 50; i++) {
            mData.add("我是" + i);
        }
        adapter.setItems(mData);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                if (isFirst) {
                    mData.add(1, "我是添加的");
                    adapter.notifyItemInserted(1);
                } else {
                    mData.add(1, "我是添加的");
                    mData.add(2, "i am add");
                    adapter.notifyItemRangeInserted(1, 2);
                }
                break;
            case R.id.btn_remove:
                if (isFirst) {
                    mData.remove(1);
                    adapter.notifyItemRemoved(1);
                } else {
                    mData.remove(1);
                    mData.remove(1);
                    adapter.notifyItemRangeRemoved(1, 2);
                }
                break;
            case R.id.btn_update:
                if (isFirst) {
                    mData.set(1, "我是更新的");
                    adapter.notifyItemChanged(1);
                } else {
                    mData.set(1, "我是更新的");
                    mData.set(2, "我是更新的2");
                    adapter.notifyItemRangeChanged(1, 2);
                }
                break;
            default:
                break;
        }
    }
}
