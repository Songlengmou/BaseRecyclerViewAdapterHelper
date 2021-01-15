package com.anningtex.testdata.three;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityThreeBinding;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Song
 */
public class ThreeActivity extends AppCompatActivity {
    private ActivityThreeBinding binding;
    private ThreeAdapter adapter;
    private List<MultiItemEntity> entities;
    private ThreeBean threeBean;
    private String json = "{\"code\":1,\"msg\":\"Success\",\"data\":[{\"ID\":\"2\",\"TransitDate\":\"2019-10-22\",\"CountryID_From\":\"6\",\"CityID_From\":\"1\",\"WarehouseID_From\":\"1\",\"CountryID_To\":\"6\",\"CityID_To\":\"2\",\"WarehouseID_To\":\"2\",\"TransitNo\":\"TN000000002\",\"flower_list\":[{\"ID\":\"2284\",\"TNID\":\"2\",\"OrderNo\":\"AFX190102A\",\"QBales\":40,\"MetersPerBale\":600,\"MetersPerBaleUnitID\":\"1\",\"MetersPerBaleUnitName\":\"y\",\"TexName_EN\":\"\"},{\"ID\":\"2285\",\"TNID\":\"2\",\"OrderNo\":\"AFX190516A\",\"QBales\":23,\"MetersPerBale\":600,\"MetersPerBaleUnitID\":\"1\",\"MetersPerBaleUnitName\":\"y\",\"TexName_EN\":\"\"},{\"ID\":\"2286\",\"TNID\":\"2\",\"OrderNo\":\"SF190405A\",\"QBales\":21,\"MetersPerBale\":600,\"MetersPerBaleUnitID\":\"1\",\"MetersPerBaleUnitName\":\"y\",\"TexName_EN\":\"\"},{\"ID\":\"2287\",\"TNID\":\"2\",\"OrderNo\":\"SP190505A\",\"QBales\":13,\"MetersPerBale\":600,\"MetersPerBaleUnitID\":\"1\",\"MetersPerBaleUnitName\":\"y\",\"TexName_EN\":\"\"},{\"ID\":\"2288\",\"TNID\":\"2\",\"OrderNo\":\"SP190507A\",\"QBales\":24,\"MetersPerBale\":600,\"MetersPerBaleUnitID\":\"1\",\"MetersPerBaleUnitName\":\"y\",\"TexName_EN\":\"\"},{\"ID\":\"2289\",\"TNID\":\"2\",\"OrderNo\":\"SP190515A\",\"QBales\":24,\"MetersPerBale\":600,\"MetersPerBaleUnitID\":\"1\",\"MetersPerBaleUnitName\":\"y\",\"TexName_EN\":\"\"},{\"ID\":\"2290\",\"TNID\":\"2\",\"OrderNo\":\"SP190523A\",\"QBales\":27,\"MetersPerBale\":600,\"MetersPerBaleUnitID\":\"1\",\"MetersPerBaleUnitName\":\"y\",\"TexName_EN\":\"\"}],\"color_list\":[],\"baiHuo_list\":[],\"WarehouseNameEn_From\":\"Goma Warehouse\",\"WarehouseNameEn_To\":\"Bukavu Warehouse\",\"CountryNameEn_From\":\"Congo\",\"CountryNameEn_To\":\"Congo\"},{\"ID\":\"7\",\"TransitDate\":\"2019-11-18\",\"CountryID_From\":\"6\",\"CityID_From\":\"1\",\"WarehouseID_From\":\"1\",\"CountryID_To\":\"6\",\"CityID_To\":\"2\",\"WarehouseID_To\":\"2\",\"TransitNo\":\"TN000000007\",\"flower_list\":[{\"ID\":\"2745\",\"TNID\":\"7\",\"OrderNo\":\"SW180201A\",\"QBales\":5,\"MetersPerBale\":600,\"MetersPerBaleUnitID\":\"1\",\"MetersPerBaleUnitName\":\"y\",\"TexName_EN\":\"\"},{\"ID\":\"2746\",\"TNID\":\"7\",\"OrderNo\":\"SW180721A\",\"QBales\":1,\"MetersPerBale\":600,\"MetersPerBaleUnitID\":\"1\",\"MetersPerBaleUnitName\":\"y\",\"TexName_EN\":\"\"},{\"ID\":\"2747\",\"TNID\":\"7\",\"OrderNo\":\"SW181128A\",\"QBales\":2,\"MetersPerBale\":600,\"MetersPerBaleUnitID\":\"1\",\"MetersPerBaleUnitName\":\"y\",\"TexName_EN\":\"\"}],\"color_list\":[],\"baiHuo_list\":[],\"WarehouseNameEn_From\":\"Goma Warehouse\",\"WarehouseNameEn_To\":\"Bukavu Warehouse\",\"CountryNameEn_From\":\"Congo\",\"CountryNameEn_To\":\"Congo\"},{\"ID\":\"19\",\"TransitDate\":\"2020-02-27\",\"CountryID_From\":\"6\",\"CityID_From\":\"1\",\"WarehouseID_From\":\"1\",\"CountryID_To\":\"6\",\"CityID_To\":\"2\",\"WarehouseID_To\":\"2\",\"TransitNo\":\"TN000000019\",\"flower_list\":[{\"ID\":\"4700\",\"TNID\":\"19\",\"OrderNo\":\"DJ190603A\",\"QBales\":20,\"MetersPerBale\":600,\"MetersPerBaleUnitID\":\"1\",\"MetersPerBaleUnitName\":\"y\",\"TexName_EN\":\"\"}],\"color_list\":[],\"baiHuo_list\":[],\"WarehouseNameEn_From\":\"Goma Warehouse\",\"WarehouseNameEn_To\":\"Bukavu Warehouse\",\"CountryNameEn_From\":\"Congo\",\"CountryNameEn_To\":\"Congo\"},{\"ID\":\"22\",\"TransitDate\":\"2020-04-22\",\"CountryID_From\":\"6\",\"CityID_From\":\"1\",\"WarehouseID_From\":\"1\",\"CountryID_To\":\"6\",\"CityID_To\":\"2\",\"WarehouseID_To\":\"2\",\"TransitNo\":\"TN000000022\",\"flower_list\":[],\"color_list\":[],\"baiHuo_list\":[],\"WarehouseNameEn_From\":\"Goma Warehouse\",\"WarehouseNameEn_To\":\"Bukavu Warehouse\",\"CountryNameEn_From\":\"Congo\",\"CountryNameEn_To\":\"Congo\"},{\"ID\":\"30\",\"TransitDate\":\"2020-04-22\",\"CountryID_From\":\"6\",\"CityID_From\":\"1\",\"WarehouseID_From\":\"1\",\"CountryID_To\":\"6\",\"CityID_To\":\"2\",\"WarehouseID_To\":\"2\",\"TransitNo\":\"TN000000030\",\"flower_list\":[{\"ID\":\"4750\",\"TNID\":\"30\",\"OrderNo\":\"SF190904A\",\"QBales\":2,\"MetersPerBale\":600,\"MetersPerBaleUnitID\":\"1\",\"MetersPerBaleUnitName\":\"y\",\"TexName_EN\":\"\"}],\"color_list\":[],\"baiHuo_list\":[],\"WarehouseNameEn_From\":\"Goma Warehouse\",\"WarehouseNameEn_To\":\"Bukavu Warehouse\",\"CountryNameEn_From\":\"Congo\",\"CountryNameEn_To\":\"Congo\"},{\"ID\":\"31\",\"TransitDate\":\"2020-04-22\",\"CountryID_From\":\"6\",\"CityID_From\":\"1\",\"WarehouseID_From\":\"1\",\"CountryID_To\":\"6\",\"CityID_To\":\"2\",\"WarehouseID_To\":\"2\",\"TransitNo\":\"TN000000031\",\"flower_list\":[{\"ID\":\"4751\",\"TNID\":\"31\",\"OrderNo\":\"SS190306A\",\"QBales\":1,\"MetersPerBale\":600,\"MetersPerBaleUnitID\":\"1\",\"MetersPerBaleUnitName\":\"y\",\"TexName_EN\":\"\"}],\"color_list\":[],\"baiHuo_list\":[],\"WarehouseNameEn_From\":\"Goma Warehouse\",\"WarehouseNameEn_To\":\"Bukavu Warehouse\",\"CountryNameEn_From\":\"Congo\",\"CountryNameEn_To\":\"Congo\"},{\"ID\":\"32\",\"TransitDate\":\"2020-04-23\",\"CountryID_From\":\"6\",\"CityID_From\":\"1\",\"WarehouseID_From\":\"1\",\"CountryID_To\":\"6\",\"CityID_To\":\"2\",\"WarehouseID_To\":\"2\",\"TransitNo\":\"TN000000032\",\"flower_list\":[{\"ID\":\"4752\",\"TNID\":\"32\",\"OrderNo\":\"MFJ180820A\",\"QBales\":1,\"MetersPerBale\":600,\"MetersPerBaleUnitID\":\"1\",\"MetersPerBaleUnitName\":\"y\",\"TexName_EN\":\"\"}],\"color_list\":[{\"ID\":\"26910\",\"TexID_01\":\"8\",\"ColorName\":\"MIX\",\"QBales\":2,\"MetersPerBale\":20,\"MetersPerBaleUnitID\":\"3\",\"TNID\":\"32\",\"MetersPerBaleUnitName\":\"r\",\"TexName_EN\":\"TC45\"}],\"baiHuo_list\":[{\"ID\":\"1711\",\"TexID_01\":\"516\",\"TNID\":\"32\",\"BrandID\":\"7\",\"ItemName\":\"4T101903187\",\"ColorName\":\"f2b56c156052442005893ef9969c533b\",\"QBales\":1,\"MetersPerBale\":24,\"MetersPerBaleUnitID\":\"5\",\"MetersPerBaleUnitName\":\"pcs\",\"TexName_EN\":\"LB\"}],\"WarehouseNameEn_From\":\"Goma Warehouse\",\"WarehouseNameEn_To\":\"Bukavu Warehouse\",\"CountryNameEn_From\":\"Congo\",\"CountryNameEn_To\":\"Congo\"}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThreeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        threeBean = new Gson().fromJson(json, ThreeBean.class);
        List<ThreeBean.DataBean> list = threeBean.getData();
        if (list != null && list.size() > 0) {
            entities = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                ThreeBean.DataBean dataBean = list.get(i);
                List<ThreeBean.DataBean.FlowerListBean> flowerList = dataBean.getFlower_list();
                if (flowerList != null) {
                    for (ThreeBean.DataBean.FlowerListBean flowerListBean : flowerList) {
                        ThreeBean.SecondLevel secondLevel = new ThreeBean.SecondLevel(flowerListBean);
                        flowerListBean.setTexName_EN(flowerListBean.getTexName_EN());
                        flowerListBean.setOrderNo(flowerListBean.getOrderNo());
                        flowerListBean.setQBales(flowerListBean.getQBales());
                        flowerListBean.setMetersPerBale(flowerListBean.getMetersPerBale());
                        flowerListBean.setMetersPerBaleUnitName(flowerListBean.getMetersPerBaleUnitName());
                        dataBean.addSubItem(secondLevel);
                    }
                }
                entities.add((MultiItemEntity) dataBean);
            }
            adapter = new ThreeAdapter(entities);
            binding.recycler.setAdapter(adapter);
            adapter.expandAll();
        }
    }
}