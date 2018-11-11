package com.android.kusitms.kbscilpoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IntroduceActivity extends AppCompatActivity {

    ImageView chatbot1;
    ImageView chatbot2;
    ImageView chatbot3;
    TextView tv_talk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);

        chatbot1 = findViewById(R.id.iv_chatbot1);
        chatbot2 = findViewById(R.id.iv_chatbot2);
        chatbot3 = findViewById(R.id.iv_chatbot3);
        tv_talk = findViewById(R.id.tv_talk);

    }

    public void onChatbot1Clicked(View view) {
        changechatbot(1);
    }
    public void onChatbot2Clicked(View view) {
        changechatbot(2);
    }
    public void onChatbot3Clicked(View view) {
        changechatbot(3);    }


    public void onSkipClicked(View view) {
        Intent intent = new Intent(IntroduceActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void changechatbot(int no){

        tv_talk.setText("나는 "+no+"번이얌");
        //캐릭터 확대,크기변경 + 다른 캐릭터 페이드아웃 애니메이션
        //
        //말풍선 추가하고 거기에 텍스트 입력
        //뒤로가기 버튼생성

    }
}

