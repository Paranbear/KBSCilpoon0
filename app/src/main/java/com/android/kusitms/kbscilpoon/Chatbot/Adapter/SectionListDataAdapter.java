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

import com.android.kusitms.kbscilpoon.Chatbot.Model.Chat;
import com.android.kusitms.kbscilpoon.Chatbot.Model.SingleItemModel;
import com.android.kusitms.kbscilpoon.Chatbot.Utils.DateFormat;
import com.android.kusitms.kbscilpoon.R;

import java.util.ArrayList;

import static com.android.kusitms.kbscilpoon.Chatbot.Activity.ChatbotActivity.current_room_no;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.ACTION_CHECK;
import static com.android.kusitms.kbscilpoon.Chatbot.Utils.Constant.ACTION_TEXT;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder>  {

    private ArrayList<SingleItemModel> itemList;
    private Context mContext;
    private ArrayList<Chat> chats;
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


                    if(tvCode.getText() == ACTION_CHECK) {
                        switch (getLayoutPosition()) {
                            case 0:
                                Toast.makeText(v.getContext(), "응", Toast.LENGTH_SHORT).show();
                                break;

                            case 1:
                                Toast.makeText(v.getContext(), "아니", Toast.LENGTH_SHORT).show();
                                break;
                        }
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




                    //Toast.makeText(v.getContext(), tvCode.getText(), Toast.LENGTH_SHORT).show();

                    Chat chat_mine = new Chat("11", current_room_no, DateFormat.date_apm(), tvTitle.getText().toString(), true, ACTION_TEXT);
                    //mWebSocketClient.send(ChatUtils.chat_to_json_text(chat_mine));
                    Chat chat = new Chat("11", current_room_no, DateFormat.date_apm(), tvTitle.getText().toString(), true, tvCode.getText().toString());
                    //mWebSocketClient.send(ChatUtils.chat_to_json_text(chat));

                    // messages_adapter.notifyDataSetChanged();





        }
    }
}


