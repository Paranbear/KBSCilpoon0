package com.android.kusitms.kbscilpoon.Chatbot.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.kusitms.kbscilpoon.Chatbot.Model.Chat;
import com.android.kusitms.kbscilpoon.Chatbot.Model.SectionDataModel;
import com.android.kusitms.kbscilpoon.Chatbot.Model.SingleItemModel;
import com.android.kusitms.kbscilpoon.R;

import java.util.ArrayList;

import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.ACTION_BUTTON_IMAGE;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.ACTION_CHECK;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.ACTION_DEFAULT;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.ACTION_JUST_IMAGE;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.ACTION_MENU;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.ACTION_TEXT;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.APPLY_CARD;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.BENEFIT_1;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.BENEFIT_2;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.BENEFIT_3;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.DATE_LINE;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.POP_CARD;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.RECOMMEND_CARD;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.SHOW_CARD1;

public class ChatMessageAdapter extends RecyclerView.Adapter<ChatMessageViewHolder> {



    private static final int RIGHT = 0, LEFT =1;

    private ArrayList<Chat> chats;


    public ChatMessageAdapter(ArrayList<Chat> chats) {
        this.chats = chats;
    }

    @Override
    public int getItemViewType(int position) {
        //오른쪽은 내 메시지, 왼쪽은 상대 메시지

        if (chats.get(position).isIs_me())
            return RIGHT;
        else
            return LEFT;
    }


    @NonNull
    @Override
    public ChatMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch(viewType) {

            case RIGHT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_right, parent, false);
                break;
            case LEFT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_left, parent, false);
        }
        return new ChatMessageViewHolder(view);


    }

    @Override
    public void onBindViewHolder(ChatMessageViewHolder holder, int position) {
        Chat chat = chats.get(position);
        holder.bind(chat);
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

}

class ChatMessageViewHolder extends RecyclerView.ViewHolder {

    TextView tv_user_real_name;//한글로 메시지를 보낸 사람의 이름을 쓰는 텍스트뷰
    TextView txtMessage;//텍스트 메시지 내용을 보여주는 텍스트뷰
    TextView txtTime;//텍스트 메시지를 보낸 시간을 보여주는 텍스트뷰
    LinearLayout container_txt;//텍스트 메시지의 레이아웃
    TextView dateLine;//날짜 변경선을 보여주는 텍스트뷰
    Context context;
    RecyclerView rv_choice_card;
    ImageView imagePop;
    ImageView profile;

    public ChatMessageViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();


        txtMessage = (TextView) itemView.findViewById(R.id.txtMessage);

        txtTime = (TextView) itemView.findViewById(R.id.timestamp);

        container_txt = (LinearLayout) itemView.findViewById(R.id.msg_container);
        dateLine = (TextView) itemView.findViewById(R.id.dateLine);
        tv_user_real_name = (TextView) itemView.findViewById(R.id.txtUserName);
        rv_choice_card = (RecyclerView)itemView.findViewById(R.id.rv_choice_card);

        imagePop = (ImageView)itemView.findViewById(R.id.imagePop);

        profile = (ImageView)itemView.findViewById(R.id.profileView);



    }


    /**
     * 들어오는 메시지의 종류마다 어떻게 화면에 출력할 지 정한다.
     * 1. 텍스트
     * 2. 이미지
     * 3. 내이미지
     * 4. 맵
     * 5. 날짜선
     */

    public void bind(final Chat chat) { //입력값에 따른 답변 텍스트의 형태 지정



        switch(chat.getAction()) {

            case ACTION_MENU:
                profile.setImageResource(R.drawable.chatbot1);
                container_txt.setVisibility(View.VISIBLE);
                txtMessage.setVisibility(View.VISIBLE);
                txtTime.setVisibility(View.VISIBLE);
                txtMessage.setText(chat.getMessage());
                txtTime.setText(chat.getTimestamp());
                dateLine.setVisibility(View.GONE);

                rv_choice_card.setVisibility(View.VISIBLE);
                imagePop.setVisibility(View.VISIBLE);


                ArrayList<SectionDataModel> array_action_start = new ArrayList<SectionDataModel>();
                ArrayList<SingleItemModel> singleItem_start = new ArrayList<>();
                SectionDataModel dm_start = new SectionDataModel();



                singleItem_start.add(new SingleItemModel("인기카드 추천", POP_CARD));
                singleItem_start.add(new SingleItemModel("내게 맞는 추천", RECOMMEND_CARD));
                singleItem_start.add(new SingleItemModel("바로신청", APPLY_CARD));

                dm_start.setAllItemInSection(singleItem_start);
                array_action_start.add(dm_start);

                rv_choice_card.setHasFixedSize(true);
                RecyclerViewAdapter adapter_start = new RecyclerViewAdapter(context, array_action_start);
                rv_choice_card.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                rv_choice_card.setAdapter(adapter_start);
                break;

            case POP_CARD:
                profile.setImageResource(R.drawable.chatbot1);
                container_txt.setVisibility(View.VISIBLE);
                //           txtCheck.setVisibility(View.VISIBLE);
                txtMessage.setVisibility(View.VISIBLE);
                txtTime.setVisibility(View.VISIBLE);
                txtMessage.setText(chat.getMessage());
                txtTime.setText(chat.getTimestamp());
                dateLine.setVisibility(View.GONE);


                rv_choice_card.setVisibility(View.VISIBLE);

                ArrayList<SectionDataModel> array_action_popcard = new ArrayList<SectionDataModel>();
                ArrayList<SingleItemModel> singleItem_popcard = new ArrayList<SingleItemModel>();
                SectionDataModel dm_popcard = new SectionDataModel();


                singleItem_popcard.add(new SingleItemModel("<상세 보기1>", R.drawable.card1, BENEFIT_1));
                singleItem_popcard.add(new SingleItemModel("<상세 보기2>", R.drawable.card2, BENEFIT_2 ));
                singleItem_popcard.add(new SingleItemModel("<상세 보기3>", R.drawable.card3, BENEFIT_3 ));


                dm_popcard.setAllItemInSection(singleItem_popcard);
                array_action_popcard.add(dm_popcard);

                rv_choice_card.setHasFixedSize(true);
                RecyclerViewAdapter adapter_popcard = new RecyclerViewAdapter(context, array_action_popcard);
                rv_choice_card.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                rv_choice_card.setAdapter(adapter_popcard);

                break;

            case RECOMMEND_CARD:
                profile.setImageResource(R.drawable.chatbot1);
                container_txt.setVisibility(View.VISIBLE);
                //           txtCheck.setVisibility(View.VISIBLE);
                txtMessage.setVisibility(View.VISIBLE);
                txtTime.setVisibility(View.VISIBLE);
                txtMessage.setText(chat.getMessage());
                txtTime.setText(chat.getTimestamp());
                dateLine.setVisibility(View.GONE);


                rv_choice_card.setVisibility(View.VISIBLE);

                ArrayList<SectionDataModel> array_action_recommendcard = new ArrayList<SectionDataModel>();
                ArrayList<SingleItemModel> singleItem_recommendcard = new ArrayList<SingleItemModel>();
                SectionDataModel dm_recommendcard = new SectionDataModel();



                singleItem_recommendcard.add(new SingleItemModel("대중교통/통신", R.drawable.recommenttest, ACTION_MENU ));
                singleItem_recommendcard.add(new SingleItemModel("커피/외식/편의점", R.drawable.recommenttest, ACTION_MENU ));
                singleItem_recommendcard.add(new SingleItemModel("해외직구/마트/백화점", R.drawable.recommenttest, ACTION_MENU ));
                singleItem_recommendcard.add(new SingleItemModel("주유/적립", R.drawable.recommenttest, ACTION_MENU ));
                singleItem_recommendcard.add(new SingleItemModel("교육/의료/문화/레저", R.drawable.recommenttest, ACTION_MENU ));
                dm_recommendcard.setAllItemInSection(singleItem_recommendcard);
                array_action_recommendcard.add(dm_recommendcard);

                rv_choice_card.setHasFixedSize(true);
                RecyclerViewAdapter adapter_recommendcard = new RecyclerViewAdapter(context, array_action_recommendcard);
                rv_choice_card.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                rv_choice_card.setAdapter(adapter_recommendcard);
                break;

            case SHOW_CARD1:
                profile.setImageResource(R.drawable.chatbot1);
                container_txt.setVisibility(View.VISIBLE);
                //           txtCheck.setVisibility(View.VISIBLE);
                txtMessage.setVisibility(View.VISIBLE);
                txtTime.setVisibility(View.VISIBLE);
                txtMessage.setText(chat.getMessage());
                txtTime.setText(chat.getTimestamp());
                dateLine.setVisibility(View.GONE);


                rv_choice_card.setVisibility(View.VISIBLE);

                ArrayList<SectionDataModel> array_action_showcard = new ArrayList<SectionDataModel>();
                ArrayList<SingleItemModel> singleItem_showcard = new ArrayList<SingleItemModel>();
                SectionDataModel dm_showcard = new SectionDataModel();



                singleItem_showcard.add(new SingleItemModel("노리카드", R.drawable.cardtest, SHOW_CARD1));
                singleItem_showcard.add(new SingleItemModel("노리카드", R.drawable.cardtest, SHOW_CARD1));
                singleItem_showcard.add(new SingleItemModel("노리카드", R.drawable.cardtest, SHOW_CARD1));

                dm_showcard.setAllItemInSection(singleItem_showcard);
                array_action_showcard.add(dm_showcard);

                rv_choice_card.setHasFixedSize(true);
                RecyclerViewAdapter adapter_showcard = new RecyclerViewAdapter(context, array_action_showcard);
                rv_choice_card.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                rv_choice_card.setAdapter(adapter_showcard);
                break;





            case ACTION_TEXT:
                //profile.setImageResource(R.drawable.chatbot1);
                container_txt.setVisibility(View.VISIBLE);
                //           txtCheck.setVisibility(View.VISIBLE);
                txtMessage.setVisibility(View.VISIBLE);
                txtTime.setVisibility(View.VISIBLE);
                txtMessage.setText(chat.getMessage());
                txtTime.setText(chat.getTimestamp());
                dateLine.setVisibility(View.GONE);

                rv_choice_card.setVisibility(View.GONE);

                break;

            case ACTION_JUST_IMAGE:
                profile.setImageResource(R.drawable.chatbot1);
                container_txt.setVisibility(View.VISIBLE);
                imagePop.setVisibility(View.VISIBLE);
                //           txtCheck.setVisibility(View.VISIBLE);
                txtMessage.setVisibility(View.VISIBLE);
                txtTime.setVisibility(View.VISIBLE);
                txtMessage.setText(chat.getMessage());
                txtTime.setText(chat.getTimestamp());
                dateLine.setVisibility(View.GONE);

                rv_choice_card.setVisibility(View.GONE);
                break;

            case ACTION_CHECK:
                profile.setImageResource(R.drawable.chatbot1);
                container_txt.setVisibility(View.VISIBLE);
                txtMessage.setVisibility(View.VISIBLE);
                txtTime.setVisibility(View.VISIBLE);
                txtMessage.setText(chat.getMessage());
                txtTime.setText(chat.getTimestamp());
                dateLine.setVisibility(View.GONE);
                rv_choice_card.setVisibility(View.VISIBLE);

                ArrayList<SectionDataModel> array_action_yn = new ArrayList<SectionDataModel>();
                ArrayList<SingleItemModel> singleItem_yn = new ArrayList<SingleItemModel>();
                SectionDataModel dm_yn = new SectionDataModel();


                singleItem_yn.add(new SingleItemModel("응", ACTION_MENU )); //수정 필요!
                singleItem_yn.add(new SingleItemModel("아니", ACTION_MENU)); //수정 필요!




                dm_yn.setAllItemInSection(singleItem_yn);
                array_action_yn.add(dm_yn);

                rv_choice_card.setHasFixedSize(true);
                RecyclerViewAdapter adapter_done = new RecyclerViewAdapter(context, array_action_yn);
                rv_choice_card.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                rv_choice_card.setAdapter(adapter_done);

                break;

            case ACTION_DEFAULT:
                profile.setImageResource(R.drawable.chatbot1);
                container_txt.setVisibility(View.VISIBLE);
                txtMessage.setVisibility(View.VISIBLE);
                txtTime.setVisibility(View.VISIBLE);
                txtMessage.setText(chat.getMessage());
                txtTime.setText(chat.getTimestamp());
                dateLine.setVisibility(View.GONE);
                rv_choice_card.setVisibility(View.VISIBLE);

                ArrayList<SectionDataModel> array_action_default = new ArrayList<SectionDataModel>();
                ArrayList<SingleItemModel> singleItem_default= new ArrayList<SingleItemModel>();
                SectionDataModel dm_default = new SectionDataModel();


                singleItem_default.add(new SingleItemModel("응", ACTION_MENU )); //수정 필요!
                singleItem_default.add(new SingleItemModel("아니", ACTION_MENU)); //수정 필요!




                dm_default.setAllItemInSection(singleItem_default);
                array_action_default.add(dm_default);

                rv_choice_card.setHasFixedSize(true);
                RecyclerViewAdapter adapter_default = new RecyclerViewAdapter(context, array_action_default);
                rv_choice_card.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                rv_choice_card.setAdapter(adapter_default);




            case ACTION_BUTTON_IMAGE:
                profile.setImageResource(R.drawable.chatbot1);
                container_txt.setVisibility(View.VISIBLE);
                //           txtCheck.setVisibility(View.VISIBLE);
                txtMessage.setVisibility(View.VISIBLE);
                txtTime.setVisibility(View.VISIBLE);
                txtMessage.setText(chat.getMessage());
                txtTime.setText(chat.getTimestamp());
                dateLine.setVisibility(View.GONE);


                rv_choice_card.setVisibility(View.VISIBLE);

                ArrayList<SectionDataModel> array_action_image = new ArrayList<SectionDataModel>();
                ArrayList<SingleItemModel> singleItem_image = new ArrayList<SingleItemModel>();
                SectionDataModel dm_image = new SectionDataModel();


                singleItem_image.add(new SingleItemModel("응", R.drawable.test, ACTION_MENU )); //수정 필요!

                dm_image.setAllItemInSection(singleItem_image);
                array_action_image.add(dm_image);

                rv_choice_card.setHasFixedSize(true);
                RecyclerViewAdapter adapter_image = new RecyclerViewAdapter(context, array_action_image);
                rv_choice_card.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                rv_choice_card.setAdapter(adapter_image);

                break;


            case DATE_LINE:

                //      container_img.setVisibility(View.GONE);
                container_txt.setVisibility(View.GONE);
                //         txtCheck.setVisibility(View.GONE);
                txtMessage.setVisibility(View.GONE);
                txtTime.setVisibility(View.GONE);
                dateLine.setVisibility(View.VISIBLE);
                dateLine.setText(chat.getMessage());
                break;

        }
    }

}
