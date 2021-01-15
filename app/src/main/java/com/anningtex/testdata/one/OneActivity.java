package com.anningtex.testdata.one;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anningtex.baserecyclerviewadapterhelper.R;
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityOneBinding;
import com.google.gson.Gson;
import com.syp.library.BaseRecycleAdapter;

import java.util.List;

/**
 * @author Song
 */
public class OneActivity extends AppCompatActivity {
    private ActivityOneBinding binding;
    private final Context context = OneActivity.this;
    private BaseRecycleAdapter oneAdapter, twoAdapter, threeAdapter, fourAdapter;
    private String json = "{\"code\":1,\"msg\":\"Success\",\"data\":{\"ID\":\"170\",\"PIID\":\"170\",\"BvCode\":\"BV2019264082\",\"LoadDate\":\"2020-09-23\",\"FromPort\":\"Kampala\",\"ToCountryID\":\"1\",\"ToPort\":\"Ishasha\",\"ClearBorder\":\"Ishasha\",\"DeliveryNo\":\"AOCG20191102-1\",\"PlateNo\":\"123456\",\"Driver\":\"two\",\"PhoneNo\":\"123456789\",\"Notes\":\"\",\"VolumeTotal\":\"1.091\",\"WeightTotal\":\"335.5\",\"QBalesTotal\":\"6\",\"GoodsList\":[{\"TexType\":\"IsFlower\",\"Container\":[{\"ContainerNo\":\"CAIU2884371\",\"ContainerList\":[{\"PIGLID\":4131,\"PIID\":\"170\",\"BGLID\":\"1728\",\"QBales\":1,\"InDate\":\"2020-09-24\",\"BLNo\":\"NGNT01732800\",\"ContainerNo\":\"CAIU2884371\",\"OrderNo\":\"SJ200529Z\",\"VolumeUnit\":\"0.1220\",\"WeightUnit\":\"104.0000\",\"MetersPerBale\":\"600.0000\",\"MetersPerBaleUnitID\":\"1\",\"TexID_01\":\"535\",\"TexType\":\"IsFlower\",\"TexName_Show\":\"SJZ\",\"UnitName\":\"码\",\"UnitNameEN\":\"y\"},{\"PIGLID\":4132,\"PIID\":\"170\",\"BGLID\":\"1729\",\"QBales\":1,\"InDate\":\"2020-09-24\",\"BLNo\":\"NGNT01732800\",\"ContainerNo\":\"CAIU2884371\",\"OrderNo\":\"SJ200606Z\",\"VolumeUnit\":\"0.1220\",\"WeightUnit\":\"104.0000\",\"MetersPerBale\":\"600.0000\",\"MetersPerBaleUnitID\":\"1\",\"TexID_01\":\"535\",\"TexType\":\"IsFlower\",\"TexName_Show\":\"SJZ\",\"UnitName\":\"码\",\"UnitNameEN\":\"y\"}]}]},{\"TexType\":\"IsColor\",\"Container\":[{\"ContainerNo\":\"PCIU9266352\",\"ContainerList\":[{\"PIGLID\":4125,\"PIID\":\"171\",\"BGLID\":\"1355\",\"QBales\":2,\"InDate\":\"2020-07-15\",\"BLNo\":\"NGNT01710900\",\"ContainerNo\":\"PCIU9266352\",\"OrderNo\":\"FX200224A\",\"VolumeUnit\":\"0.0563\",\"WeightUnit\":\"14.8000\",\"MetersPerBale\":\"120.0000\",\"MetersPerBaleUnitID\":\"5\",\"TexID_01\":\"446\",\"TexType\":\"IsColor\",\"TexName_Show\":\"Thread 3000y\",\"UnitName\":\"个\",\"UnitNameEN\":\"pcs\"},{\"PIGLID\":4126,\"PIID\":\"171\",\"BGLID\":\"1353\",\"QBales\":2,\"InDate\":\"2020-07-15\",\"BLNo\":\"NGNT01710900\",\"ContainerNo\":\"PCIU9266352\",\"OrderNo\":\"TC200108K\",\"VolumeUnit\":\"0.1275\",\"WeightUnit\":\"64.0000\",\"MetersPerBale\":\"600.0000\",\"MetersPerBaleUnitID\":\"1\",\"TexID_01\":\"8\",\"TexType\":\"IsColor\",\"TexName_Show\":\"TC45\",\"UnitName\":\"码\",\"UnitNameEN\":\"y\"}]},{\"ContainerNo\":\"PCIU0120897\",\"ContainerList\":[{\"PIGLID\":4122,\"PIID\":\"171\",\"BGLID\":\"1339\",\"QBales\":2,\"InDate\":\"2020-07-13\",\"BLNo\":\"NGNT01710600\",\"ContainerNo\":\"PCIU0120897\",\"OrderNo\":\"TR200211Z\",\"VolumeUnit\":\"0.1120\",\"WeightUnit\":\"80.0000\",\"MetersPerBale\":\"300.0000\",\"MetersPerBaleUnitID\":\"1\",\"TexID_01\":\"4\",\"TexType\":\"IsColor\",\"TexName_Show\":\"TR\",\"UnitName\":\"码\",\"UnitNameEN\":\"y\",\"spec\":[{\"color_name\":\"G30\",\"bales\":1,\"meters_per_bale\":300,\"qsum\":300}]}]}]},{\"TexType\":\"IsItem\",\"Container\":[{\"ContainerNo\":\"PCIU9266352\",\"ContainerList\":[{\"PIGLID\":4128,\"PIID\":\"170\",\"BGLID\":\"1356\",\"QBales\":1,\"InDate\":\"2020-07-15\",\"BLNo\":\"NGNT01710900\",\"ContainerNo\":\"PCIU9266352\",\"OrderNo\":\"BG200309A\",\"VolumeUnit\":\"0.2200\",\"WeightUnit\":\"33.5000\",\"MetersPerBale\":\"30.0000\",\"MetersPerBaleUnitID\":\"5\",\"TexID_01\":\"505\",\"TexType\":\"IsItem\",\"TexName_Show\":\"BG\",\"UnitName\":\"个\",\"UnitNameEN\":\"pcs\"}]},{\"ContainerNo\":\"PCIU9207750\",\"ContainerList\":[{\"PIGLID\":4129,\"PIID\":\"170\",\"BGLID\":\"1678\",\"QBales\":2,\"InDate\":\"2020-09-24\",\"BLNo\":\"NGNT01733600\",\"ContainerNo\":\"PCIU9207750\",\"OrderNo\":\"BG200306A\",\"VolumeUnit\":\"0.2200\",\"WeightUnit\":\"30.0000\",\"MetersPerBale\":\"30.0000\",\"MetersPerBaleUnitID\":\"5\",\"TexID_01\":\"505\",\"TexType\":\"IsItem\",\"TexName_Show\":\"BG\",\"UnitName\":\"个\",\"UnitNameEN\":\"pcs\"}]},{\"ContainerNo\":\"HASU4997582\",\"ContainerList\":[{\"PIGLID\":4130,\"PIID\":\"170\",\"BGLID\":\"1697\",\"QBales\":1,\"InDate\":\"2020-09-24\",\"BLNo\":\"584305652\",\"ContainerNo\":\"HASU4997582\",\"OrderNo\":\"BG190821A\",\"VolumeUnit\":\"0.1870\",\"WeightUnit\":\"34.0000\",\"MetersPerBale\":\"30.0000\",\"MetersPerBaleUnitID\":\"5\",\"TexID_01\":\"505\",\"TexType\":\"IsItem\",\"TexName_Show\":\"BG\",\"UnitName\":\"个\",\"UnitNameEN\":\"pcs\",\"spec\":[{\"brand_name\":\"PONASOO\",\"color_name\":\"BLACK:21(pcs);BLUE:3(pcs);COFFEE:3(pcs);RED:3(pcs)\",\"item_name\":\"7901#\",\"bales\":1,\"meters_per_bale\":30,\"qsum\":30},{\"brand_name\":\"PONASOO\",\"color_name\":\"BLACK:21(pcs);BLUE:3(pcs);COFFEE:3(pcs);RED:3(pcs)\",\"item_name\":\"7911#\",\"bales\":1,\"meters_per_bale\":30,\"qsum\":30}]}]}]}]}}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getRecycleData();
    }

    private void getRecycleData() {
        OneBean oneBean = new Gson().fromJson(json, OneBean.class);
        final OneBean.DataBean data = oneBean.getData();
        List<OneBean.DataBean.GoodsListBean> goodsList = data.getGoodsList();
        if (goodsList != null) {
            oneAdapter = new BaseRecycleAdapter(R.layout.item_one_test, goodsList);
            binding.recycler.setAdapter(oneAdapter);
            oneAdapter.setOnDataToViewListener((helper, item, position) -> {
                OneBean.DataBean.GoodsListBean goodsListBean = (OneBean.DataBean.GoodsListBean) item;
                final String texType = goodsListBean.getTexType();
                helper.setText(R.id.tv_item01, texType);
                RecyclerView recyclerData = helper.getView(R.id.recyclerData);
                List<OneBean.DataBean.GoodsListBean.ContainerBean> container = goodsListBean.getContainer();
                recyclerData.setLayoutManager(new LinearLayoutManager(context));
                twoAdapter = new BaseRecycleAdapter(R.layout.item_one_test, container);
                recyclerData.setAdapter(twoAdapter);
                twoAdapter.setOnDataToViewListener((helper12, item12, position12) -> {
                    OneBean.DataBean.GoodsListBean.ContainerBean containerBean = (OneBean.DataBean.GoodsListBean.ContainerBean) item12;
                    helper12.setText(R.id.tv_item01, "ContainerNo: " + containerBean.getContainerNo());
                    helper12.setTextColor(R.id.tv_item01, getResources().getColor(R.color.green));
                    RecyclerView recyclerDataTwo = helper12.getView(R.id.recyclerData);
                    List<OneBean.DataBean.GoodsListBean.ContainerBean.ContainerListBean> containerList = containerBean.getContainerList();
                    recyclerDataTwo.setLayoutManager(new LinearLayoutManager(context));
                    threeAdapter = new BaseRecycleAdapter(R.layout.item_two_test, containerList);
                    recyclerDataTwo.setAdapter(threeAdapter);
                    threeAdapter.setOnDataToViewListener((helper1, item1, position1) -> {
                        OneBean.DataBean.GoodsListBean.ContainerBean.ContainerListBean containerListBean = (OneBean.DataBean.GoodsListBean.ContainerBean.ContainerListBean) item1;
                        helper1.setText(R.id.tv_item01, "orderNo: " + containerListBean.getOrderNo());
                        helper1.setText(R.id.tv_item02, "name_show: " + containerListBean.getTexName_Show());
                        helper1.setText(R.id.tv_item03, containerListBean.getQBales() + "");
                        helper1.setText(R.id.tv_item04, "name: " + containerListBean.getUnitName());
                        RecyclerView recyclerDataItem = helper1.getView(R.id.recyclerData_item);
                        if (containerListBean != null) {
                            List<OneBean.DataBean.GoodsListBean.ContainerBean.ContainerListBean.SpecBean> specBean = containerListBean.getSpecBean();
                            if (specBean != null && specBean.size() > 0) {
                                Log.e("666", "specBean: " + specBean.size());
                                recyclerDataItem.setLayoutManager(new LinearLayoutManager(context));
                                fourAdapter = new BaseRecycleAdapter(R.layout.item_three, specBean);
                                recyclerDataItem.setAdapter(fourAdapter);
                                fourAdapter.setOnDataToViewListener((helper11, item11, position11) -> {
                                    OneBean.DataBean.GoodsListBean.ContainerBean.ContainerListBean.SpecBean bean = (OneBean.DataBean.GoodsListBean.ContainerBean.ContainerListBean.SpecBean) item11;
                                    helper11.setText(R.id.tv_item05, "ItemName: " + bean.getItem_name());
                                    helper11.setText(R.id.tv_item06, "ColorName: " + bean.getColor_name());
                                    helper11.setText(R.id.tv_item07, "Bales2: " + bean.getBales() + "");
                                    helper11.setText(R.id.tv_item08, "Meters: " + bean.getMeters_per_bale() + "");
                                });
                            }
                        }
                    });
                });
            });
        }
    }
}
