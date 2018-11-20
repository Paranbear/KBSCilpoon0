package com.android.kusitms.kbscilpoon.Fragment.Model;

public class Contact{

    private String Name;
    private String Phone;
    private int Photo;
    private String time;
    public Contact() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Contact(String name, String phone, int photo) {
        Name = name;
        Phone = phone;
        Photo = photo;
    }

    public Contact(String name, String phone, int photo, String time) {
        Name = name;
        Phone = phone;
        Photo = photo;
        this.time = time;
    }

    public Contact(String name, int photo, String time) {
        Name = name;
        Photo = photo;
        this.time = time;
    }


    //getter

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public int getPhoto() {
        return Photo;
    }

    //setter

    public void setName(String name) {
        Name = name;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
