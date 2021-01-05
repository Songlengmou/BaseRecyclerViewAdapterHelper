package com.anningtex.baserecyclerviewadapterhelper.act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityUseLibraryDataBinding;
import com.syp.library.BaseRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Song
 * desc:使用Library里的适配器
 */
public class UseLibraryDataActivity extends AppCompatActivity {
    private ActivityUseLibraryDataBinding binding;
    private BaseRecycleAdapter adapter;
    private String strAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUseLibraryDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        setTitle("UseLibrary");
        List<String> data = new ArrayList<>();
        for (int i = 0; data.size() < 40; i++) {
            data.add(i + "");
        }
        Box<String> name = new Box<>("SL");
        adapter = new BaseRecycleAdapter(R.layout.item_use_library, data);
        binding.rvCache.setAdapter(adapter);
        adapter.setOnDataToViewListener((helper, item, position) -> {
            int positions = helper.getLayoutPosition();
            TextView tvNum = helper.getView(R.id.tv_num);
            TextView tvClient = helper.getView(R.id.tv_client);
            TextView tvMoney = helper.getView(R.id.tv_money);
            TextView tvPurchasePrice = helper.getView(R.id.tv_purchase_price);
            for (int i = 0; i < data.size(); i++) {
                strAmount = data.set(i, "12,456.00");
            }
            tvNum.setText(++positions + "");
            tvClient.setText(name.clientName);
            tvMoney.setText("88,886,666.886");
            tvPurchasePrice.setText(strAmount);
        });
    }

    class Box<T> {
        private String clientName;

        public Box(String clientName) {
            this.clientName = clientName;
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }
    }
}