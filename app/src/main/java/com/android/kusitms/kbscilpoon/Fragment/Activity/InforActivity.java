package com.android.kusitms.kbscilpoon.Fragment.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.kusitms.kbscilpoon.R;

public class InforActivity extends AppCompatActivity  {

    String[] card_list  = {"KB 국민카드", "신한 카드","kt super DC& KB국민비씨카드" };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inforcard);


    }
}
