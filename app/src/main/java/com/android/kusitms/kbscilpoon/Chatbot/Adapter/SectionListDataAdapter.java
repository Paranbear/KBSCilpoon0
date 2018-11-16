package com.android.kusitms.kbscilpoon.Chatbot.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.kusitms.kbscilpoon.Chatbot.Activity.ChatbotActivity;
import com.android.kusitms.kbscilpoon.Chatbot.Model.Chat;
import com.android.kusitms.kbscilpoon.Chatbot.Model.SingleItemModel;
import com.android.kusitms.kbscilpoon.Chatbot.Utils.DateFormat;
import com.android.kusitms.kbscilpoon.R;

import java.util.ArrayList;
import static com.android.kusitms.kbscilpoon.Chatbot.Activity.ChatbotActivity.chats;
import static com.android.kusitms.kbscilpoon.Chatbot.Activity.ChatbotActivity.current_name;
import static com.android.kusitms.kbscilpoon.Chatbot.Activity.ChatbotActivity.current_room_no;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.POP_CARD;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder>  {

    private ArrayList<SingleItemModel> itemList;
    private Context mContext;
    Chat chat;

    public SectionListDataAdapter(Context context, ArrayList<SingleItemModel> itemList){
        this.itemList = itemList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public SectionListDataAdapter.SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_single, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int position) {

        SingleItemModel singleItem = itemList.get(position);

        holder.itemImage.setImageResource(singleItem.getImage());
        holder.tvTitle.setText(singleItem.getName());
        holder.tvCode.setText(singleItem.getUrl());

        //Chat chat = chats.get(position);
        //holder.bind(chat);


    }




    @Override
    public int getItemCount() {
        return (null != itemList ? itemList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle,tvCode;
        protected ImageView itemImage;



        public SingleItemRowHolder(View view) {
            super(view);
            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.tvCode= (TextView) view.findViewById(R.id.tvCode);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //2 넘어오는 데이터 파악
                    Toast.makeText(v.getContext(), tvTitle.getText().toString() + tvCode.getText().toString(), Toast.LENGTH_SHORT).show();

                    //3 case 생성 [.equals랑 ==쓰는거 조심]
                    if (tvCode.getText().toString().equals("1")) {

                        //4 필요한 객체 생성 & 더하기
//                        chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), "인기 카드 보여줘!", true, ACTION_TEXT);
//                        chats.add(chat);
                        chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), "좌우 방향으로 카드를 넘겨볼 수 있어요", false, POP_CARD);
                        chats.add(chat);

                        //5 리스트 리프레시
                        ChatbotActivity chatbotActivity = new ChatbotActivity();
                        chatbotActivity.scroll_to_bottom();


                    }



                    }


//
//                        switch(chat.getAction()){
//                    case ACTION_CHECK:
//                        switch (getLayoutPosition()) {
//                            case 0:
//                                Toast.makeText(v.getContext(), "응", Toast.LENGTH_SHORT).show();
//                                break;
//
//                            case 1:
//                                Toast.makeText(v.getContext(), "아니", Toast.LENGTH_SHORT).show();
//                                break;
//                            default:
//                                Toast.makeText(v.getContext(), "없음", Toast.LENGTH_SHORT).show();
//                        }
//                        break;
//                    default:
//                        Toast.makeText(v.getContext(), "없음", Toast.LENGTH_SHORT).show();
//
//                }
//
//            }
                  });










        }
    }
}


