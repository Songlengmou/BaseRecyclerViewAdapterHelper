package com.anningtex.baserecyclerviewadapterhelper.entity;

import android.view.View;

import com.anningtex.baserecyclerviewadapterhelper.utils.Tips;

/**
 * @author Song
 */
public class MoviePresenter {
    public void buyTicket(View view, MovieEntity movie) {
        Tips.show("buy ticket: " + movie.name);
    }
}
