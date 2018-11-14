package com.android.kusitms.kbscilpoon.Chatbot.Model;

import android.view.View;

public class MenuItem {
    private final String name;
    private final int resource;
    private View.OnClickListener onClickListener;

    public MenuItem(String name, int resource, View.OnClickListener onClickListener) {
        this.name= name;
        this.resource = resource;
        this.onClickListener = onClickListener;
    }

    public MenuItem(String name, int resource) {
        this.name = name;
        this.resource = resource;
    }
    public String getName() {
        return name;
    }
    public int getResource() {
        return resource;
    }
    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }
}

