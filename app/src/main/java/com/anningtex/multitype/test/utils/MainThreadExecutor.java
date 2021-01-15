package com.anningtex.multitype.test.utils;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.IntRange;

import java.util.concurrent.Executor;

/**
 * @author Song
 */
public class MainThreadExecutor implements Executor {
    long delayMillis = 0;
    private final Handler handler = new Handler(Looper.getMainLooper());

    public MainThreadExecutor() {
    }

    public MainThreadExecutor(@IntRange(from = 0) long delayMillis) {
        this.delayMillis = delayMillis;
    }

    @Override
    public void execute(Runnable r) {
        handler.postDelayed(r, delayMillis);
    }
}