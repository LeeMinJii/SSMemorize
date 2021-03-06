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

public class Memorize_3_main extends Fragment implements View.OnClickListener {

    public static int flag_wordtype = 0;

    private View view;
    Button btn_study1;
    Button btn_study2;
    Button btn_study3;
    Button btn_study4;
    Button btn_study5;
    Button btn_study6;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_memorize3_main,container,false);

        btn_study1 = view.findViewById(R.id.btn_study1);
        btn_study1.setOnClickListener(this);

        btn_study2 = view.findViewById(R.id.btn_study2);
        btn_study2.setOnClickListener(this);

        btn_study3 = view.findViewById(R.id.btn_study3);
        btn_study3.setOnClickListener(this);

        btn_study4 = view.findViewById(R.id.btn_study4);
        btn_study4.setOnClickListener(this);

        btn_study5 = view.findViewById(R.id.btn_study5);
        btn_study5.setOnClickListener(this);

        btn_study6 = view.findViewById(R.id.btn_study6);
        btn_study6.setOnClickListener(this);
/*
// 학습률
        int check=0;
        int[] memorize = new int[10]; // Day별 암기 완료 여부
        int k=0;
        // Day 1-10까지 각 20개의 단어의 암기 완료 여부 체크 -> memorize배열에 넣기
        for (int i = 0; i <= 180; i+=20){
            for (int j=0; j<20; j++){
                if (Start_App.complete[j+i]==0)
                    check++;
            }
            if (check==20) {
                memorize[k]=0; // 20개 다 암기완료면 0넣기
                k++;
                check = 0;
            }
            else {
                memorize[k]=1;
                k++;
                check = 0;
            }
        }
*/
        return view;
    }

    // 학습하기 버튼 클릭 시 하루에 몇 개 외울건지로 이동 (3_1로 이동)
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_study1:
                flag_wordtype =1;
                getActivity().startActivity(new Intent(getActivity(),Memorize_3_1.class)); // 화면전환
                break;
            case R.id.btn_study2:
                flag_wordtype =2;
                getActivity().startActivity(new Intent(getActivity(),Memorize_3_1.class));
                break;
            case R.id.btn_study3:
                flag_wordtype =3;
                getActivity().startActivity(new Intent(getActivity(),Memorize_3_1.class));
                break;
            case R.id.btn_study4:
                flag_wordtype =4;
                getActivity().startActivity(new Intent(getActivity(),Memorize_3_1.class));
                break;
            case R.id.btn_study5:
                flag_wordtype =5;
                getActivity().startActivity(new Intent(getActivity(),Memorize_3_1.class));
                break;
            case R.id.btn_study6:
                flag_wordtype =6;
                getActivity().startActivity(new Intent(getActivity(),Memorize_3_1.class));
                break;
        }
    }
}