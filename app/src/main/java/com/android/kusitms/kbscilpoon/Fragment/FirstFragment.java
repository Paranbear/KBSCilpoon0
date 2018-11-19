package com.android.kusitms.kbscilpoon.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.kusitms.kbscilpoon.FoldingCell;
import com.android.kusitms.kbscilpoon.R;

public class FirstFragment extends Fragment implements View.OnClickListener {
    FoldingCell fc;
    View v;

    public FirstFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_first, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        view.findViewById(R.id.title_view).setOnClickListener(this);
        view.findViewById(R.id.toggle_instant_btn).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
<<<<<<< HEAD
            case R.id.title_view:
                Toast.makeText(getContext(),
                        "Button is clicked", Toast.LENGTH_LONG).show();

                break;


=======
            case R.id.toggle_btn:
                fc.toggle(true);
                break;

>>>>>>> d957c8bfbfcae95a2cf0405253d4a4408f8057e3
            case R.id.toggle_instant_btn:
                fc.toggle(true);
                break;
        }

    }
}