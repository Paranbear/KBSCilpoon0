package com.android.kusitms.kbscilpoon.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.kusitms.kbscilpoon.Chatbot.Activity.ChatbotActivity;
import com.android.kusitms.kbscilpoon.Fragment.Adapter.ListVIewAdpater;
import com.android.kusitms.kbscilpoon.Fragment.Adapter.RecycleListViewAdapter;
import com.android.kusitms.kbscilpoon.Fragment.Model.Contact;
import com.android.kusitms.kbscilpoon.R;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment implements View.OnClickListener {
    ListVIewAdpater adapter;

/*
    private RecyclerView myrecyclerview;
    private List<Contact> lstContact;
*/


    public SecondFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        adapter = new ListVIewAdpater();
        ListView listview = (ListView) view.findViewById(R.id.listview_item);

        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.chatbot1), "Box", "Account Box Black 36dp");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.chatbot2), "Circle", "Account Circle Black 36dp");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.chatbot3), "Ind", "Assignment Ind Black 36dp");
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parent.getItemAtPosition(position);

                switch (position) {
                    case 0:
                        Intent intent = new Intent(getActivity().getApplicationContext(), ChatbotActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity().getApplicationContext(), ChatbotActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity().getApplicationContext(), ChatbotActivity.class);
                        startActivity(intent2);
                        break;

                }

            }
        });
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {

    }


    //클릭 리스너

}