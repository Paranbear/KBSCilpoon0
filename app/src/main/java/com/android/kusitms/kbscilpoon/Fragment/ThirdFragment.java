package com.android.kusitms.kbscilpoon.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.kusitms.kbscilpoon.Fragment.Activity.MateActivity;
import com.android.kusitms.kbscilpoon.R;

import java.util.List;

public class ThirdFragment extends Fragment{
    private Context context;
    List<String> list;
    Button backbtn;
    View v;


    String[] list_menu = {"챗봇친구 설정", "내 정보", "개인 설정", "카테고리 추기/수정", "보안센터", "고객 센터"};


    public ThirdFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        ListView listview = (ListView) view.findViewById(R.id.listview1);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list_menu);
        listview.setAdapter(listViewAdapter);
        context = container.getContext();


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parent.getItemAtPosition(position);

                switch (position) {
                    case 0:
                        Intent intent = new Intent(getActivity().getApplicationContext(), MateActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(getContext(),
                                "서비스 준비 중 입니다.", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(getContext(),
                                "서비스 준비 중 입니다.", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(getContext(),
                                "서비스 준비 중 입니다.", Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Toast.makeText(getContext(),
                                "서비스 준비 중 입니다.", Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Toast.makeText(getContext(),
                                "서비스 준비 중 입니다.", Toast.LENGTH_LONG).show();
                        break;
                    case 6:
                        Toast.makeText(getContext(),
                                "서비스 준비 중 입니다.", Toast.LENGTH_LONG).show();
                        break;
                    case 7:
                        Toast.makeText(getContext(),
                                "서비스 준비 중 입니다.", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        return view;
    }//End onCreateView


}
