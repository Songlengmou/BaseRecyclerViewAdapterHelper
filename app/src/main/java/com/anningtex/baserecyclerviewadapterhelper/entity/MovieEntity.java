package com.anningtex.baserecyclerviewadapterhelper.entity;

/**
 * @author Song
 */
public class MovieEntity {
    public String name;
    public int length;
    public int price;
    public String content;

    public MovieEntity(String name, int length, int price, String content) {
        this.length = length;
        this.name = name;
        this.price = price;
        this.content = content;
    }
}
