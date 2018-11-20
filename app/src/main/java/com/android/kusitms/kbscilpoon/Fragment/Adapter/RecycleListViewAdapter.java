package com.android.kusitms.kbscilpoon.Fragment.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.kusitms.kbscilpoon.Fragment.Model.Contact;
import com.android.kusitms.kbscilpoon.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleListViewAdapter extends RecyclerView.Adapter<RecycleListViewAdapter.MyViewHolder> {

    Context mContext;
    List<Contact> mData;


    public RecycleListViewAdapter(Context mContext, List<Contact> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_contact, viewGroup, false);
        MyViewHolder vHoder = new MyViewHolder(v);
        return vHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {



        myViewHolder.tv_Name.setText(mData.get(position).getName());
        myViewHolder.tv_phone.setText(mData.get(position).getPhone());
        myViewHolder.img.setImageResource(mData.get(position).getPhoto());


    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            // 레이아웃 객체화 findViewById
        }
    }

    @Override
    public int getItemCount() {


        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        private TextView tv_Name;
        private TextView tv_phone;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_Name = (TextView) itemView.findViewById(R.id.name_contact);
            tv_phone = (TextView) itemView.findViewById(R.id.phone_contact);
            img = (ImageView) itemView.findViewById(R.id.img_contact);


        }
    }


}