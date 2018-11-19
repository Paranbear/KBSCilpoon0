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

import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.ACTION_MENU;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.BENEFIT;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.EXPENSE;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.EXPENSE_DETAIL;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.EXPENSE_IMAGE;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.GOALS;

public class ChatMessage2Adapter extends RecyclerView.Adapter<ChatMessage2ViewHolder> {



    private static final int RIGHT = 0, LEFT =1;

    private ArrayList<Chat> chats;


    public ChatMessage2Adapter(ArrayList<Chat> chats) {
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
    public ChatMessage2ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch(viewType) {

            case RIGHT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_right, parent, false);
                break;
            case LEFT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_left, parent, false);
        }
        return new ChatMessage2ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ChatMessage2ViewHolder holder, int position) {
        Chat chat = chats.get(position);
        holder.bind(chat);
    }



    @Override
    public int getItemCount() {
        return chats.size();
    }

}

class ChatMessage2ViewHolder extends RecyclerView.ViewHolder {

    TextView tv_user_real_name;//한글로 메시지를 보낸 사람의 이름을 쓰는 텍스트뷰
    TextView txtMessage;//텍스트 메시지 내용을 보여주는 텍스트뷰
    TextView txtTime;//텍스트 메시지를 보낸 시간을 보여주는 텍스트뷰
    LinearLayout container_txt;//텍스트 메시지의 레이아웃
    TextView dateLine;//날짜 변경선을 보여주는 텍스트뷰
    Context context;
    RecyclerView rv_choice_card;
    ImageView imagePop;
    ImageView profile;

    public ChatMessage2ViewHolder(View itemView) {
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

            case ACTION_MENU: //메뉴액션

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


                singleItem_start.add(new SingleItemModel("지출 내역 보기", EXPENSE));
                singleItem_start.add(new SingleItemModel("수입 내역 보기", BENEFIT));
                singleItem_start.add(new SingleItemModel("남은 예산 보기", GOALS));


                dm_start.setAllItemInSection(singleItem_start);
                array_action_start.add(dm_start);

                rv_choice_card.setHasFixedSize(true);
                RecyclerView2Adapter adapter_start = new RecyclerView2Adapter(context, array_action_start);
                rv_choice_card.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                rv_choice_card.setAdapter(adapter_start);
                break;


            case EXPENSE: // 지출내역 액션

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


                singleItem_popcard.add(new SingleItemModel("<상세 보기1>", R.drawable.card1, EXPENSE_IMAGE));
                singleItem_popcard.add(new SingleItemModel("<상세 보기2>", R.drawable.card2, EXPENSE_DETAIL ));


                dm_popcard.setAllItemInSection(singleItem_popcard);
                array_action_popcard.add(dm_popcard);

                rv_choice_card.setHasFixedSize(true);
                RecyclerViewAdapter adapter_popcard = new RecyclerViewAdapter(context, array_action_popcard);
                rv_choice_card.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                rv_choice_card.setAdapter(adapter_popcard);


                break;

            case BENEFIT: //수익내역 액션

                break;

            case GOALS: //예산 목표 액션


                break;

        }


    }


}
