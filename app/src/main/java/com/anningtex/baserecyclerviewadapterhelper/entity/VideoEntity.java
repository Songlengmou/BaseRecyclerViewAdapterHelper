package com.anningtex.baserecyclerviewadapterhelper.entity;

/**
 * @author Song
 */
public class VideoEntity {
    private String img;
    private String name;
    private int id;

    public VideoEntity(String img, String name) {
        this.img = img;
        this.name = name;
    }

    public VideoEntity(int id, String img, String name) {
        this.id = id;
        this.img = img;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
