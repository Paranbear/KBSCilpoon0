
package com.android.kusitms.kbscilpoon.Chatbot.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.android.kusitms.kbscilpoon.Chatbot.Adapter.ChatMessageAdapter;
import com.android.kusitms.kbscilpoon.Chatbot.Model.Chat;
import com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant;
import com.android.kusitms.kbscilpoon.Chatbot.Utils.DateFormat;
import com.android.kusitms.kbscilpoon.IntroduceActivity;
import com.android.kusitms.kbscilpoon.R;

import java.util.ArrayList;

import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.ACTION_BUTTON_IMAGE;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.ACTION_CHECK;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.ACTION_DONE;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.ACTION_JUST_IMAGE;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.ACTION_MENU;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.ACTION_TEXT;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.APPLY_CARD;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.DATE_LINE;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.POP_CARD;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.RECOMMEND_CARD;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.SHOW_CARD1;

public class ChatbotActivity extends AppCompatActivity {

    public static ArrayList<Chat> chats = new ArrayList<Chat>();


    public static String current_name = "100";//현재방에서 내 아이디
    public static String current_room_no;//현재방 아이디
    public static String current_counter_name; //현재방에서 상대방 아이디

    Button btn_send_message;
    EditText edit_message;
    RecyclerView rv_chat_message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        init_layout();
        init_system();

        Chat chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), " 안녕! 나는 너에게 맞는 체크카드를 추천해주고 발급을 도와주는 OO이야~ 궁금한 게 있으면 언제든 나를 찾아줘!", false, ACTION_MENU);
        chats.add(chat);


    }
    private void init_layout() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        edit_message = (EditText) findViewById(R.id.edit_message);
        btn_send_message = (Button) findViewById(R.id.btn_send_message);
        rv_chat_message = (RecyclerView) findViewById(R.id.rv_chat_message);

        rv_chat_message.setLayoutManager(new LinearLayoutManager(this));
        rv_chat_message.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.HORIZONTAL));
        rv_chat_message.setAdapter(new ChatMessageAdapter(chats));

    }

    private void init_system() {

        //겟 인텐트 액션: 내이름, 상대 이름, 방이름
        current_name = getIntent().getStringExtra(Constant.TAG_USER_NO);
        current_room_no = getIntent().getStringExtra(Constant.TAG_ROOM_NO);
        current_counter_name = getIntent().getStringExtra("guideName");



        chats.clear();


        //날짜선긋기
        insert_date_line();



        //툴바 헤더 이름을 현재 상대방이름이로 정한다
        setTitle(current_counter_name);
        scroll_to_bottom();

    }

    public void onSendClicked(View view) {

        Chat chat;
        if (!TextUtils.isEmpty(getMessage())) {
            try {

                chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), getMessage(), true, ACTION_TEXT);
                //mWebSocketClient.send(ChatUtils.chat_to_json_text(chat));
                chats.add(chat);


                if (getMessage().contains(ACTION_MENU)) {
                    chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), "안녕하세요. 챗봇1입니다 더 궁금하신 점이 있나요?", false, ACTION_MENU);
                    chats.add(chat); //10.23 추가사항

                }

                if (getMessage().contains(ACTION_DONE)) {
                    chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), "당신 안녕", false, ACTION_TEXT);
                    //mWebSocketClient.send(ChatUtils.chat_to_json_text(chat));
                    chats.add(chat);

                }
                if (getMessage().contains(POP_CARD)) { //텍스트 값과 정확히 일치할 때
                    chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), "좌우 방향으로 카드를 넘겨볼 수 있어요", false, POP_CARD);
                    //mWebSocketClient.send(ChatUtils.chat_to_json_text(chat));
                    chats.add(chat);
                }
                if (getMessage().contains(RECOMMEND_CARD)) {  //텍스트 값을 포함할 때
                    chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), " 이중에서너가제일원하는것을골라줘!", false, RECOMMEND_CARD);
                    //mWebSocketClient.send(ChatUtils.chat_to_json_text(chat));
                    chats.add(chat);

                }
                if(getMessage().contains(APPLY_CARD)) {
                    chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), " 생각해둔카드가있는거야?있다면말해줘!", false, ACTION_TEXT);
                    //mWebSocketClient.send(ChatUtils.chat_to_json_text(chat));
                    chats.add(chat);

                }
                if(getMessage().contains("노리")) {
                    chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), "이거 맞아??", false, SHOW_CARD1);
                    chats.add(chat);
                    //mWebSocketClient.send(ChatUtils.chat_to_json_text(chat));
                }
//                if(getMessage().contains("5")) {
//                    chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), " 추가로받고싶은혜택하나만더골라봐~", false, RECOMMEND_CARD);
//                    //mWebSocketClient.send(ChatUtils.chat_to_json_text(chat));
//                    chats.add(chat);
//                }
                if (getMessage().contains("그만")||getMessage().contains("안")) {
                    chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), "정말 그만두시겠습니까?", false, ACTION_CHECK);
                    //mWebSocketClient.send(ChatUtils.chat_to_json_text(chat));
                    chats.add(chat);

                }
                if (getMessage().contains("re")) {
                    chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), "감정을 재기록하시겠어요?", false, ACTION_MENU);
                    chats.add(chat);
                }
                if(getMessage().contains("image")) {
                    chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), "이미지 보여주기", false, ACTION_BUTTON_IMAGE);
                    chats.add(chat); //10.23 추가사항
                }
                if(getMessage().equals("move")){
                    Intent intent = new Intent(getApplicationContext(),IntroduceActivity.class);
                    startActivityForResult(intent, 50);
                }
                if(getMessage().equals("image2")) {
                    chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), "이미지 상단에 보여주기", false, ACTION_JUST_IMAGE);
                    chats.add(chat);
                }




            } catch (Exception e) {//네트워크 연결이 끊겼을때는 에러처리 스낵바를 띄운다
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                /*Snackbar.make(getWindow().getDecorView().getRootView(), "네트워크 연결상태를 확인해주세요", Snackbar.LENGTH_LONG).setAction("닫기", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();*/
            }

            scroll_to_bottom();
            edit_message.setText("");

        }
    }

    public void onWriteClicked(View view) {
        scroll_to_bottom();
    }

    //db_helper_chat.update_badge_to_zero(current_room_no);


    private void insert_date_line() {
        //if(!DateFormat.date_month_and_day().equals(db_helper_chat.get_last_date(current_room_no)))
        Chat chat = new Chat(current_name, current_room_no, DateFormat.date_month_day_time(), "----" + DateFormat.date_month() + "월" + DateFormat.date_day() + "일 ----", true, DATE_LINE);
        //dbhelper
        chats.add(chat);

    }

    private void scroll_to_bottom() {
        rv_chat_message.scrollToPosition(chats.size() - 1);
    }

    private String getMessage() {
        return edit_message.getText().toString().trim();

    }




}








