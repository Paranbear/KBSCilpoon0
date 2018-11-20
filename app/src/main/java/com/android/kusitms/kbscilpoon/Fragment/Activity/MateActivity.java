package com.android.kusitms.kbscilpoon.Fragment.Activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.android.kusitms.kbscilpoon.R;

public class MateActivity extends AppCompatActivity {
    TextView text;
    Button btnback;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mate_setting);
        text = findViewById(R.id.text11);
        btnback = findViewById(R.id.btnback);



    }
}