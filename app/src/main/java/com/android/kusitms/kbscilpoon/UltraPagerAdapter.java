package com.android.kusitms.kbscilpoon;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class UltraPagerAdapter extends PagerAdapter {
    private boolean isMultiScr;

    public UltraPagerAdapter(boolean isMultiScr) {
        this.isMultiScr = isMultiScr;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(container.getContext()).inflate(R.layout.layout_child, null);
        //new LinearLayout(container.getContext());
        ImageView iv =  linearLayout.findViewById(R.id.iv_char);
        linearLayout.setId(R.id.item_id);
        switch (position) {
            case 0:
               // linearLayout.setBackgroundColor(Color.parseColor("#2196F3"));
                iv.setImageResource(R.drawable.chatbot1);
                break;
            case 1:
               // linearLayout.setBackgroundColor(Color.parseColor("#673AB7"));
                iv.setImageResource(R.drawable.chatbot2);
                break;
            case 2:
               // linearLayout.setBackgroundColor(Color.parseColor("#009688"));
                iv.setImageResource(R.drawable.chatbot3);
                break;

        }
        container.addView(linearLayout);
//        linearLayout.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, container.getContext().getResources().getDisplayMetrics());
//        linearLayout.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400, container.getContext().getResources().getDisplayMetrics());
        return linearLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        LinearLayout view = (LinearLayout) object;
        container.removeView(view);
    }
}