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
import com.android.kusitms.kbscilpoon.FoldingCell;
import com.android.kusitms.kbscilpoon.R;

public class FirstFragment extends Fragment implements View.OnClickListener {
    FoldingCell fc;
    View v;

    public FirstFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_second, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        view.findViewById(R.id.toggle_btn).setOnClickListener(this);
        view.findViewById(R.id.toggle_instant_btn).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toggle_btn:
                fc.toggle(false);
                break;
        }
        switch (v.getId()) {
            case R.id.toggle_instant_btn:
                fc.toggle(false);
                break;
        }

    }
}