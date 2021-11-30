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

    public static int sig_wordtype =0;

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

        return view;
    }

    // 학습하기 버튼 클릭 시 하루에 몇 개 외울건지로 이동 (3_1로 이동)
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_study1:
                sig_wordtype =1;
                getActivity().startActivity(new Intent(getActivity(),Memorize_3_1.class)); // 화면전환
                break;
            case R.id.btn_study2:
                sig_wordtype =2;
                getActivity().startActivity(new Intent(getActivity(),Memorize_3_1.class));
                break;
            case R.id.btn_study3:
                sig_wordtype =3;
                getActivity().startActivity(new Intent(getActivity(),Memorize_3_1.class));
                break;
            case R.id.btn_study4:
                sig_wordtype =4;
                getActivity().startActivity(new Intent(getActivity(),Memorize_3_1.class));
                break;
            case R.id.btn_study5:
                sig_wordtype =5;
                getActivity().startActivity(new Intent(getActivity(),Memorize_3_1.class));
                break;
            case R.id.btn_study6:
                sig_wordtype =6;
                getActivity().startActivity(new Intent(getActivity(),Memorize_3_1.class));
                break;
        }
    }
}