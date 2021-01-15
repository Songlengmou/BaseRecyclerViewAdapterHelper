package com.anningtex.testdata.four;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityFourBinding;

import java.util.ArrayList;

/**
 * @author Song
 */
public class FourActivity extends AppCompatActivity {
    private ActivityFourBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFourBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        ArrayList<FourBean> list = new ArrayList<>();
//        list.add(new FourBean("我的", "16个", 1));
//        list.add(new FourBean("全部客户16个", "更新时间2010/01/01", 1));
//        list.add(new FourBean("龙图腾", "最近联系", 2));
//        list.add(new FourBean("测试人", "最近联系", 2));
//        list.add(new FourBean("欧阳震华", "最近联系", 2));
//        list.add(new FourBean("刘女士", "最近联系", 2));
//        list.add(new FourBean("张先生", "最近联系", 2));

        FourBean bean1 = new FourBean();
        bean1.setItemType(1);
        for (int i = 0; i < 5; i++) {
            bean1.setName("我的" + i);
            bean1.setTitle("16个" + i);
            list.add(bean1);
        }

        FourBean bean2 = new FourBean();
        bean2.setItemType(2);
        for (int i = 0; i < 5; i++) {
            bean2.setName("全部客户" + i);
            bean2.setTitle("更新时间2010/0/26" + i);
            list.add(bean2);
        }

        FourAdapter adapter = new FourAdapter(list);
        binding.recycler.setAdapter(adapter);
    }
}