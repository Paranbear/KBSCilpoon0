package com.android.kusitms.kbscilpoon;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.ultraviewpager.transformer.UltraScaleTransformer;


public class IntroduceActivity extends AppCompatActivity {


    ImageView chatbot1;
    ImageView chatbot2;
    ImageView chatbot3;
    TextView tv_talk;
    LinearLayout chatbotlayout;
    UltraViewPager ultraViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);

//        chatbot1 = findViewById(R.id.iv_chatbot1);
//        chatbot2 = findViewById(R.id.iv_chatbot2);
//        chatbot3 = findViewById(R.id.iv_chatbot3);
//        chatbotlayout =findViewById(R.id.layout_chatbot1);
        tv_talk = findViewById(R.id.tv_talk);
        tv_talk.setText("안녕 나는 1번 챗봇이고 너한테 카드추천을 해줄꼬야");

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


         ultraViewPager = (UltraViewPager)findViewById(R.id.ultra_viewpager);
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        ultraViewPager.setPageTransformer(false, new UltraScaleTransformer());

//initialize UltraPagerAdapter，and add child view to UltraViewPager
        PagerAdapter adapter = new UltraPagerAdapter(false);
        ultraViewPager.setAdapter(adapter);



        //initialize built-in indicator
        ultraViewPager.initIndicator();
        //set style of indicators
        ultraViewPager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(Color.YELLOW)
                .setNormalColor(Color.BLACK)
                .setRadius((int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, getResources().getDisplayMetrics()));
        //set the alignment
        ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        //construct built-in indicator, and add it to  UltraViewPager
        ultraViewPager.getIndicator().build();

        ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                int a = ultraViewPager.getCurrentItem();

                if (a==0){
                    tv_talk.setText("안녕 나는 1번 챗봇이고 너한테 카드추천을 해줄꼬야");
                }
                else if(a==1){
                    tv_talk.setText("안녕 나는 2번 챗봇이고 너한테 잔소리를 쥰내게 해줄꼬야");
                }
                else if(a==2){
                    tv_talk.setText("안녕 나는 3번 챗봇이고 혜택을 꼬박꼬박 알려줄꼬야");

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }

        };

        ultraViewPager.setOnPageChangeListener(mPageChangeListener);


    }

    public void onChatbot1Clicked(View view) {
        final int screenWidth = chatbotlayout.getWidth();
        final int screenHeight = chatbotlayout.getHeight();
        final int viewWidth = view.getWidth();
        final int viewheight = view.getHeight();

        ValueAnimator widthAnimator = ValueAnimator.ofInt(viewWidth, screenWidth);
        ValueAnimator heightAnimator = ValueAnimator.ofInt(viewheight, screenHeight);


        widthAnimator.setDuration(500);
        heightAnimator.setDuration(500);


        widthAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                chatbot1.getLayoutParams().width = (int) animation.getAnimatedValue();
                chatbot1.requestLayout();
            }
        });


        heightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                chatbot1.getLayoutParams().height = (int) animation.getAnimatedValue();
                chatbot1.requestLayout();
            }
        });


        widthAnimator.start();
        heightAnimator.start();

        chatbot2.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());

        chatbot3.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        chatbot2.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        chatbot3.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());

        chatbot2.requestLayout();
        chatbot3.requestLayout();

        tv_talk.setText("안녕 나는 1번 챗봇이고 너한테 카드추천을 해줄꼬얌");

    }
    public void onChatbot2Clicked(View view) {
        final int screenWidth = chatbotlayout.getWidth();
        final int screenHeight = chatbotlayout.getHeight();
        final int viewWidth = view.getWidth();
        final int viewheight = view.getHeight();

        ValueAnimator widthAnimator = ValueAnimator.ofInt(viewWidth, screenWidth);
        ValueAnimator heightAnimator = ValueAnimator.ofInt(viewheight, screenHeight);


        widthAnimator.setDuration(500);
        heightAnimator.setDuration(500);


        widthAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                chatbot2.getLayoutParams().width = (int) animation.getAnimatedValue();
                chatbot2.requestLayout();
            }
        });


        heightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                chatbot2.getLayoutParams().height = (int) animation.getAnimatedValue();
                chatbot2.requestLayout();
            }
        });


        widthAnimator.start();
        heightAnimator.start();

        chatbot1.getLayoutParams().width =  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        chatbot3.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        chatbot1.getLayoutParams().height =  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        chatbot3.getLayoutParams().height =  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());

        chatbot1.requestLayout();
        chatbot2.requestLayout();

        tv_talk.setText("안녕 나는 2번 챗봇이고 너한테 잔소리를 해줄꼬얌");


    }
    public void onChatbot3Clicked(View view) {
        final int screenWidth = chatbotlayout.getWidth();
        final int screenHeight = chatbotlayout.getHeight();
        final int viewWidth = view.getWidth();
        final int viewheight = view.getHeight();

        ValueAnimator widthAnimator = ValueAnimator.ofInt(viewWidth, screenWidth);
        ValueAnimator heightAnimator = ValueAnimator.ofInt(viewheight, screenHeight);


        widthAnimator.setDuration(500);
        heightAnimator.setDuration(500);


        widthAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                chatbot3.getLayoutParams().width = (int) animation.getAnimatedValue();
                chatbot3.requestLayout();
            }
        });


        heightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                chatbot3.getLayoutParams().height = (int) animation.getAnimatedValue();
                chatbot3.requestLayout();
            }
        });


        widthAnimator.start();
        heightAnimator.start();

        chatbot1.getLayoutParams().width =  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        chatbot2.getLayoutParams().width =  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        chatbot1.getLayoutParams().height =  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        chatbot2.getLayoutParams().height =  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());

        chatbot1.requestLayout();
        chatbot2.requestLayout();

        tv_talk.setText("안녕 나는 3번 챗봇이고 너한테 혜택들을 알려줄꼬얌");

    }



    public void onSkipClicked(View view) {
        Intent intent = new Intent(IntroduceActivity.this, MainActivity.class);
        startActivity(intent);
    }





}

