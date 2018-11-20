package com.android.kusitms.kbscilpoon.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.android.kusitms.kbscilpoon.Fragment.Activity.MateActivity;
import com.android.kusitms.kbscilpoon.Fragment.Adapter.ListVIewAdpater;
import com.android.kusitms.kbscilpoon.Fragment.Model.ListViewItem;
import com.android.kusitms.kbscilpoon.R;

import java.util.ArrayList;

public class FirstFragment extends Fragment implements View.OnClickListener {

    ListVIewAdpater adapter;

    public FirstFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
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
                        Intent intent = new Intent(getActivity().getApplicationContext(), MateActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
        return view;
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


    }

    public void addItem(Drawable icon, String title, String desc) {
        adapter.addItem(icon, title, desc);
    }


    @Override
    public void onClick(View v) {


    }
}