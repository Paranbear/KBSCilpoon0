package com.android.kusitms.kbscilpoon.Chatbot.Model;

public class SingleItemModel {
    private String name;
    private String url;
    private int image;

    public SingleItemModel() {

    }
    public SingleItemModel(String name, int image, String url) {
        this.name = name;
        this.image = image;
        this.url = url;
    }
    public SingleItemModel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
