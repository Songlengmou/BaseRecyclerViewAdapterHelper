package com.anningtex.testdata.four;

import com.syp.library.entity.MultiItemEntity;

/**
 * @Author Song
 */
public class FourBean implements MultiItemEntity {
    private String name;
    private String title;
    private int itemType;

    public FourBean() {
    }

    public FourBean(String name, String title, int itemType) {
        this.name = name;
        this.title = title;
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
