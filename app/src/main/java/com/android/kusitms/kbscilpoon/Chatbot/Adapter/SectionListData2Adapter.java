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

import com.android.kusitms.kbscilpoon.Chatbot.Activity.Chatbot2Activity;
import com.android.kusitms.kbscilpoon.Chatbot.Model.Chat;
import com.android.kusitms.kbscilpoon.Chatbot.Model.SingleItemModel;
import com.android.kusitms.kbscilpoon.Chatbot.Utils.DateFormat;
import com.android.kusitms.kbscilpoon.R;

import java.util.ArrayList;

import static com.android.kusitms.kbscilpoon.Chatbot.Activity.Chatbot2Activity.current_name;
import static com.android.kusitms.kbscilpoon.Chatbot.Activity.Chatbot2Activity.chats;
import static com.android.kusitms.kbscilpoon.Chatbot.Activity.Chatbot2Activity.current_room_no;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.BENEFIT;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.EXPENSE;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.GOALS;

public class SectionListData2Adapter extends RecyclerView.Adapter<SectionListData2Adapter.SingleItemRowHolder>  {

    private ArrayList<SingleItemModel> itemList;
    private Context mContext;
    Chat chat;

    public SectionListData2Adapter(Context context, ArrayList<SingleItemModel> itemList){
        this.itemList = itemList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_single, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    public static void bind(final Chat chat) {


    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int position) {

        SingleItemModel singleItem = itemList.get(position);

        holder.itemImage.setImageResource(singleItem.getImage());
        holder.tvTitle.setText(singleItem.getName());
        holder.tvCode.setText(singleItem.getUrl());



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


            bind(chat);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //2 넘어오는 데이터 파악
            //        Toast.makeText(v.getContext(), tvCode.getText().toString(), Toast.LENGTH_SHORT).show();

                    //3 case 생성 [.equals랑 ==쓰는거 조심]
                    if (tvCode.getText().toString().equals("1")) {
                    chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), " 지출이 보고 싶구나", false, EXPENSE);
                    chats.add(chat);
                    Toast.makeText(v.getContext(),chat.toString(), Toast.LENGTH_SHORT).show();

                    //5 리스트 리프레시
                    Chatbot2Activity chatbot2Activity = new Chatbot2Activity();
                    chatbot2Activity.scroll_to_bottom();


                    }
                    if (tvCode.getText().toString().equals("2")) {

                        //4 필요한 객체 생성 & 더하기

                        chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), " 수입이 보고 싶구나 ", false, BENEFIT);
                        chats.add(chat);

//                        //5 리스트 리프레시
                        Chatbot2Activity chatbot2Activity = new Chatbot2Activity();
                        chatbot2Activity.scroll_to_bottom();


                    }
                    if (tvCode.getText().toString().equals("3")) {

                        //4 필요한 객체 생성 & 더하기
                        chat = new Chat(current_name, current_room_no, DateFormat.date_apm(), "고마워! 이번달남은예산은OOOOO 원이야! 앞으로하루에OOO원이하로쓴다면예산을초과하지않을거야! ", false, GOALS);
                        chats.add(chat);
//
//                        //5 리스트 리프레시
                        Chatbot2Activity chatbot2Activity = new Chatbot2Activity();
                        chatbot2Activity.scroll_to_bottom();


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


