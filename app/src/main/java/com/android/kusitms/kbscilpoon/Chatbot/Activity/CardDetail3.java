package com.android.kusitms.kbscilpoon.Chatbot.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import com.android.kusitms.kbscilpoon.R;

public class CardDetail3 extends Activity {
    Button btn1, btn2, btn3;
    LinearLayout s1, s2, s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_card_detail3);

        btn1 = findViewById(R.id.b1);
        btn2 = findViewById(R.id.b2);
        btn3 = findViewById(R.id.b3);

        s1 = findViewById(R.id.show1);
        s2 = findViewById(R.id.show2);
        s3 = findViewById(R.id.show3);
    }


    public void b3Clicked(View view) {

        btn3.setBackgroundResource(R.drawable.benefit3_click);
        s3.setVisibility(View.VISIBLE);

        btn1.setBackgroundResource(R.drawable.benefit1);
        btn2.setBackgroundResource(R.drawable.benefit2);
        s1.setVisibility(View.GONE);
        s2.setVisibility(View.GONE);



    }

    public void b2Clicked(View view) {
        btn2.setBackgroundResource(R.drawable.benefit2_click);
        s2.setVisibility(View.VISIBLE);

        btn1.setBackgroundResource(R.drawable.benefit1);
        btn3.setBackgroundResource(R.drawable.benefit3);
        s1.setVisibility(View.GONE);
        s3.setVisibility(View.GONE);

    }

    public void b1Clicked(View view) {
        btn1.setBackgroundResource(R.drawable.benefit1_click);
        s1.setVisibility(View.VISIBLE);

        btn2.setBackgroundResource(R.drawable.benefit2);
        btn3.setBackgroundResource(R.drawable.benefit3);
        s2.setVisibility(View.GONE);
        s3.setVisibility(View.GONE);

    }
}
