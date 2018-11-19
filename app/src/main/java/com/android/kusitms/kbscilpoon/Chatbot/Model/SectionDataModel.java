package com.android.kusitms.kbscilpoon.Chatbot.Model;

import java.util.ArrayList;

public class SectionDataModel {
    private String headerChat;
    private ArrayList<SingleItemModel>allItemInSection;


    public SectionDataModel() {

    }
    public SectionDataModel(String headerChat, ArrayList<SingleItemModel> allItemInSection) {
        this.headerChat = headerChat;
        this.allItemInSection = allItemInSection;
    }


    public String getHeaderChat() {
        return headerChat;
    }

    public void setHeaderChat(String headerChat) {
        this.headerChat = headerChat;
    }

    public ArrayList<SingleItemModel> getAllItemInSection() {
        return allItemInSection;
    }

    public void setAllItemInSection(ArrayList<SingleItemModel> allItemInSection) {
        this.allItemInSection = allItemInSection;
    }
}
