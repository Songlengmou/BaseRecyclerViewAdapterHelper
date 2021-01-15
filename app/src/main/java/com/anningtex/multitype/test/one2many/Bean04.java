package com.anningtex.multitype.test.one2many;

import androidx.annotation.DrawableRes;

import java.io.Serializable;

/**
 * @author Song
 */
public class Bean04 implements Serializable {
    public static final String TYPE_ONE = "TYPE_ONE";
    public static final String TYPE_TWO = "TYPE_TWO";
    public static final String TYPE_THREE = "TYPE_THREE";

    public String title;
    public @DrawableRes
    int imgRes;
    public String imgUrl = "http://upload-images.jianshu.io/upload_images/she.png";
    public String type = TYPE_ONE;

    public Bean04(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }
}
