package com.anningtex.baserecyclerviewadapterhelper.manger;

import android.app.Application;

import com.anningtex.baserecyclerviewadapterhelper.utils.Utils;

/**
 * @Author Song
 */
public class MyApplication extends Application {
    private static MyApplication appContext;

    public static MyApplication getInstance() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        Utils.init(this);
    }
}
