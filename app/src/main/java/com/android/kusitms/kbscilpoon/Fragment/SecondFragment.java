package com.android.kusitms.kbscilpoon.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.kusitms.kbscilpoon.Chatbot.Activity.Chatbot2Activity;
import com.android.kusitms.kbscilpoon.Chatbot.Activity.ChatbotActivity;
import com.android.kusitms.kbscilpoon.R;

public class SecondFragment extends Fragment implements View.OnClickListener {
    View v;
/*
    private RecyclerView myrecyclerview;
    private List<Contact> lstContact;
*/


    public SecondFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_second, container, false);
/*        myrecyclerview = (RecyclerView) v.findViewById(R.id.contact_recylceview);
        RecycleListViewAdapter recycleAdapter = new RecycleListViewAdapter(getContext(), lstContact);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recycleAdapter);*/
        return v;
    }
//recycleview
    /*@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstContact = new ArrayList<>();
        lstContact.add(new Contact("캐릭터1", "상담할려면 대화를 걸어줘 ", R.drawable.chatbot1));
        lstContact.add(new Contact("캐릭터2", "상담할려면 대화를 걸어줘", R.drawable.chatbot2));
        lstContact.add(new Contact("캐릭터3", "상담할려면 대화를 걸어줘", R.drawable.chatbot3));

    }*/


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
   
        view.findViewById(R.id.layout1).setOnClickListener(this);
        view.findViewById(R.id.layout2).setOnClickListener(this);
        view.findViewById(R.id.layout3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout1:
                Intent intent = new Intent(this.getContext(), ChatbotActivity.class);
                startActivity(intent);
                break;

        }
        switch (v.getId()) {
            case R.id.layout2:
                Intent intent = new Intent(this.getContext(), ChatbotActivity.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()) {
            case R.id.layout3:
                Intent intent = new Intent(this.getContext(), Chatbot2Activity.class);
                startActivity(intent);

                break;
        }

    }

    //클릭 리스너

}