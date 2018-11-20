package com.android.kusitms.kbscilpoon.Chatbot.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.android.kusitms.kbscilpoon.R;

public class MakeCardActivity extends AppCompatActivity {
    ImageView selectCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_card);

        selectCard = findViewById(R.id.select_card_show);
        int pos = getIntent().getIntExtra("pos",1);

        if(pos == 1) {
            selectCard.setImageResource(R.drawable.card2_2);
        }
        if(pos ==2) {
            selectCard.setImageResource(R.drawable.card1_2);

        }
        if(pos ==3) {
            selectCard.setImageResource(R.drawable.card3_2);
        }
    }


}
