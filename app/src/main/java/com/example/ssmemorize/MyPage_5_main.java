package com.example.ssmemorize;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyPage_5_main extends Fragment implements View.OnClickListener{

    private View view;
    Button mypage_check;
    Button mypage_myword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.activity_my_page5_main,container,false);

        mypage_check=view.findViewById(R.id.mypage_check);
        mypage_check.setOnClickListener(this);

        mypage_myword=view.findViewById(R.id.mypage_myword);
        mypage_myword.setOnClickListener(this);

        return view;
    }

    // 출석체크, 내 단어장 버튼 클릭시 이동
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mypage_check:
                getActivity().startActivity(new Intent(getActivity(), MyPage_5_1_1.class));
                break;
            case R.id.mypage_myword:
                getActivity().startActivity(new Intent(getActivity(), MyPage_5_2_1.class));
                break;
        }
    }
}