package com.android.kusitms.kbscilpoon.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.kusitms.kbscilpoon.Chatbot.Activity.ChatbotActivity;
import com.android.kusitms.kbscilpoon.R;

public class SecondFragment extends Fragment implements View.OnClickListener {
    public SecondFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.dummy).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dummy :
                Intent intent = new Intent(this.getContext(), ChatbotActivity.class);
                startActivity(intent);
                break;
        }
    }
}
