package com.zmm.akira.model;

/**
 * Created by ZMM on 2018/5/4 16:05.
 */

public class MenuEntity {
    private String name;
    private int image;
    private Class activity;

    public MenuEntity(String name, int image, Class activity) {
        this.name = name;
        this.image = image;
        this.activity = activity;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Class getActivity() {
        return activity;
    }

    public void setActivity(Class activity) {
        this.activity = activity;
    }
}
