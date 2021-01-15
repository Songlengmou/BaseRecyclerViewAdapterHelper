package com.anningtex.multitype.test.manyData.bean;

import androidx.annotation.DrawableRes;

import java.io.Serializable;

/**
 * @author Song
 */
public class Bean03 implements Serializable {
    public String title;
    public @DrawableRes
    int imgRes;
    public String imgUrl = "http://upload-images.jianshu.io/upload_images/1599843-6bccd8b6bf4a90b7.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240";

    public Bean03(String title) {
        this.title = title;
    }
}
