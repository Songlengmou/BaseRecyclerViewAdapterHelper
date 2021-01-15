package com.anningtex.multitype.test.stickheader.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Song
 */
public class GroupSingleBean implements Serializable {
    private String title;
    private List<String> childs;

    public GroupSingleBean(String title, List<String> childs) {
        this.title = title;
        this.childs = childs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getChilds() {
        return childs;
    }

    public void setChilds(List<String> childs) {
        this.childs = childs;
    }
}
