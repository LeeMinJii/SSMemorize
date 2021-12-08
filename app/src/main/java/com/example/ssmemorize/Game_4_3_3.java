package com.example.ssmemorize;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Game_4_3_3 extends Fragment implements View.OnClickListener {

    public static ArrayList<Elementary> elementaryList;

    public static int flag_wordtype = 0;

    private View view;

    public int eng_temp = -1;
    public int kor_temp = -1;

    Button tv_card_eng1;
    Button tv_card_eng2;
    Button tv_card_kor7;
    Button tv_card_kor5;
    //Button btn_study5;
    //Button btn_study6;

    String word_eng;
    String word_kor;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_game433, container, false);

        // DB 불러오기
        elementaryList = init_Load_ElementaryDB();

        //랜덤 함수 커서에 집어넣기(8번)
        //1
        Random rd = new Random();
        Memorize_3_3.Wcursor = rd.nextInt(200);

        tv_card_eng1 = view.findViewById(R.id.tv_card_eng1);
        //tv_card_eng1.setOnClickListener(this);
        tv_card_kor7 = view.findViewById(R.id.tv_card_kor7);
        //tv_card_kor7.setOnClickListener(this);

        word_eng = elementaryList.get(Memorize_3_3.Wcursor).english;
        tv_card_eng1.setText(word_eng);

        word_kor = elementaryList.get(Memorize_3_3.Wcursor).korean;
        tv_card_kor7.setText(word_kor);


        //2
        Memorize_3_3.Wcursor = rd.nextInt(200);

        tv_card_eng2 = view.findViewById(R.id.tv_card_eng2);
        //tv_card_eng2.setOnClickListener(this);
        tv_card_kor5 = view.findViewById(R.id.tv_card_kor5);
        //tv_card_kor5.setOnClickListener(this);

        word_eng = elementaryList.get(Memorize_3_3.Wcursor).english;
        tv_card_eng2.setText(word_eng);

        word_kor = elementaryList.get(Memorize_3_3.Wcursor).korean;
        tv_card_kor5.setText(word_kor);

        return view;
    }

        /*
        //3
        Memorize_3_3.Wcursor = rd.nextInt(200);

        english_card = view.findViewById(R.id.tv_card_eng3);
        korean_card = view.findViewById(R.id.tv_card_kor1);

        word_eng = elementaryList.get(Memorize_3_3.Wcursor).english;
        english_card.setText(word_eng);

        word_kor = elementaryList.get(Memorize_3_3.Wcursor).korean;
        korean_card.setText(word_kor);


        //4
        Memorize_3_3.Wcursor = rd.nextInt(200);

        english_card = view.findViewById(R.id.tv_card_eng4);
        korean_card = view.findViewById(R.id.tv_card_kor8);

        word_eng = elementaryList.get(Memorize_3_3.Wcursor).english;
        english_card.setText(word_eng);

        word_kor = elementaryList.get(Memorize_3_3.Wcursor).korean;
        korean_card.setText(word_kor);


        //5
        Memorize_3_3.Wcursor = rd.nextInt(200);

        english_card = view.findViewById(R.id.tv_card_eng5);
        korean_card = view.findViewById(R.id.tv_card_kor2);

        word_eng = elementaryList.get(Memorize_3_3.Wcursor).english;
        english_card.setText(word_eng);

        word_kor = elementaryList.get(Memorize_3_3.Wcursor).korean;
        korean_card.setText(word_kor);


        //6
        Memorize_3_3.Wcursor = rd.nextInt(200);

        english_card = view.findViewById(R.id.tv_card_eng6);
        korean_card = view.findViewById(R.id.tv_card_kor4);

        word_eng = elementaryList.get(Memorize_3_3.Wcursor).english;
        english_card.setText(word_eng);

        word_kor = elementaryList.get(Memorize_3_3.Wcursor).korean;
        korean_card.setText(word_kor);


        //7
        Memorize_3_3.Wcursor = rd.nextInt(200);

        english_card = view.findViewById(R.id.tv_card_eng7);
        korean_card = view.findViewById(R.id.tv_card_kor3);

        word_eng = elementaryList.get(Memorize_3_3.Wcursor).english;
        english_card.setText(word_eng);

        word_kor = elementaryList.get(Memorize_3_3.Wcursor).korean;
        korean_card.setText(word_kor);


        //8
        Memorize_3_3.Wcursor = rd.nextInt(200);

        english_card = view.findViewById(R.id.tv_card_eng8);
        korean_card = view.findViewById(R.id.tv_card_kor6);

        word_eng = elementaryList.get(Memorize_3_3.Wcursor).english;
        english_card.setText(word_eng);

        word_kor = elementaryList.get(Memorize_3_3.Wcursor).korean;
        korean_card.setText(word_kor);



        //버튼 없애기
        //findViewById(R.id.tv_card_eng2).setVisibility(View.INVISIBLE);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button english_card = view.findViewById(R.id.tv_card_eng1);
            }

        };
        */


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tv_card_eng1:
                flag_wordtype = 1;
                Toast.makeText(getActivity(), "버튼1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_card_eng2:
                flag_wordtype = 2;
                Toast.makeText(getActivity(), "버튼2", Toast.LENGTH_SHORT).show();
                break;
        }
    }

/*


                View.OnClickListener clickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (view.getId() == R.id.tv_card_eng1) {
                            eng_temp = 0;
                        } else if (view.getId() == R.id.tv_card_kor7) {
                            kor_temp = 7;
                        }
                    }

                };






        Button card = (Button)findViewById(R.id.tv_card_eng1);
        card.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                card.setVisibility(View.flase);
            }
        });

        */



    // Load DataBase
    private ArrayList<Elementary> init_Load_ElementaryDB() {
        DBHelper DBHelper = new DBHelper(getActivity().getApplicationContext());
        DBHelper.OpenDatabaseFile();

        ArrayList<Elementary> elementaryList = DBHelper.getTableData();
        Log.e("test", String.valueOf(elementaryList.size()));

        DBHelper.close();
        return elementaryList;
    }



}


