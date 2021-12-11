package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Game_4_3_3 extends AppCompatActivity {

    //TextView english_card;
    //TextView tv_english;

    public static ArrayList<Word> wordList;

    public static int temp1 = -1;
    public static int temp2 = -1;
    public static int temp3 = -1;

    public static int count = 0;
    public static int select = 0;

    public static int btn_num = 0;
    public static int first_btn_num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game433);

        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // 영단어 유형에 따라 DB 불러오기
        wordList = init_Load_ElementaryDB();
        switch (Game_4_1.flag_wordtype_game){
            case 1: // 초등 영단어
                wordList = init_Load_ElementaryDB();
                break;
            case 2: // 중학 영단어
                wordList = init_Load_MiddleDB();
                break;
            case 3: // 수능 영단어
                wordList = init_Load_SAT_DB();
                break;
            case 4: // 토익 영단어
                wordList = init_Load_TOEIC_DB();
                break;
            case 5: // 여행 영단어
                wordList = init_Load_TRAVEL_DB();
                break;
            case 6: // 비지니스 영단어
                wordList = init_Load_BUSINESS_DB();
                break;
        }

        //랜덤 함수 커서에 집어넣기(8번)
        //1
        Random rd = new Random();
        Memorize_3_3.Wcursor = rd.nextInt(200);

        findViewById(R.id.tv_card_eng1).setOnClickListener(btnClickListener);
        findViewById(R.id.tv_card_kor7).setOnClickListener(btnClickListener);

        Button english_card = findViewById(R.id.tv_card_eng1);
        Button korean_card = findViewById(R.id.tv_card_kor7);

        String word_eng = wordList.get(Memorize_3_3.Wcursor).english;
        english_card.setText(word_eng);

        String word_kor = wordList.get(Memorize_3_3.Wcursor).korean;
        korean_card.setText(word_kor);


        //2
        Memorize_3_3.Wcursor = rd.nextInt(200);

        findViewById(R.id.tv_card_eng2).setOnClickListener(btnClickListener);
        findViewById(R.id.tv_card_kor5).setOnClickListener(btnClickListener);

        english_card = findViewById(R.id.tv_card_eng2);
        korean_card = findViewById(R.id.tv_card_kor5);

        word_eng = wordList.get(Memorize_3_3.Wcursor).english;
        english_card.setText(word_eng);

        word_kor = wordList.get(Memorize_3_3.Wcursor).korean;
        korean_card.setText(word_kor);


        //3
        Memorize_3_3.Wcursor = rd.nextInt(200);

        findViewById(R.id.tv_card_eng3).setOnClickListener(btnClickListener);
        findViewById(R.id.tv_card_kor1).setOnClickListener(btnClickListener);

        english_card = findViewById(R.id.tv_card_eng3);
        korean_card = findViewById(R.id.tv_card_kor1);

        word_eng = wordList.get(Memorize_3_3.Wcursor).english;
        english_card.setText(word_eng);

        word_kor = wordList.get(Memorize_3_3.Wcursor).korean;
        korean_card.setText(word_kor);


        //4
        Memorize_3_3.Wcursor = rd.nextInt(200);

        findViewById(R.id.tv_card_eng4).setOnClickListener(btnClickListener);
        findViewById(R.id.tv_card_kor8).setOnClickListener(btnClickListener);

        english_card = findViewById(R.id.tv_card_eng4);
        korean_card = findViewById(R.id.tv_card_kor8);

        word_eng = wordList.get(Memorize_3_3.Wcursor).english;
        english_card.setText(word_eng);

        word_kor = wordList.get(Memorize_3_3.Wcursor).korean;
        korean_card.setText(word_kor);


        //5
        Memorize_3_3.Wcursor = rd.nextInt(200);

        findViewById(R.id.tv_card_eng5).setOnClickListener(btnClickListener);
        findViewById(R.id.tv_card_kor2).setOnClickListener(btnClickListener);

        english_card = findViewById(R.id.tv_card_eng5);
        korean_card = findViewById(R.id.tv_card_kor2);

        word_eng = wordList.get(Memorize_3_3.Wcursor).english;
        english_card.setText(word_eng);

        word_kor = wordList.get(Memorize_3_3.Wcursor).korean;
        korean_card.setText(word_kor);


        //6
        Memorize_3_3.Wcursor = rd.nextInt(200);

        findViewById(R.id.tv_card_eng6).setOnClickListener(btnClickListener);
        findViewById(R.id.tv_card_kor4).setOnClickListener(btnClickListener);

        english_card = findViewById(R.id.tv_card_eng6);
        korean_card = findViewById(R.id.tv_card_kor4);

        word_eng = wordList.get(Memorize_3_3.Wcursor).english;
        english_card.setText(word_eng);

        word_kor = wordList.get(Memorize_3_3.Wcursor).korean;
        korean_card.setText(word_kor);


        //7
        Memorize_3_3.Wcursor = rd.nextInt(200);

        findViewById(R.id.tv_card_eng7).setOnClickListener(btnClickListener);
        findViewById(R.id.tv_card_kor3).setOnClickListener(btnClickListener);

        english_card = findViewById(R.id.tv_card_eng7);
        korean_card = findViewById(R.id.tv_card_kor3);

        word_eng = wordList.get(Memorize_3_3.Wcursor).english;
        english_card.setText(word_eng);

        word_kor = wordList.get(Memorize_3_3.Wcursor).korean;
        korean_card.setText(word_kor);


        //8
        Memorize_3_3.Wcursor = rd.nextInt(200);

        findViewById(R.id.tv_card_eng8).setOnClickListener(btnClickListener);
        findViewById(R.id.tv_card_kor6).setOnClickListener(btnClickListener);

        english_card = findViewById(R.id.tv_card_eng8);
        korean_card = findViewById(R.id.tv_card_kor6);

        word_eng = wordList.get(Memorize_3_3.Wcursor).english;
        english_card.setText(word_eng);

        word_kor = wordList.get(Memorize_3_3.Wcursor).korean;
        korean_card.setText(word_kor);

    }

        //버튼 없애기
        //findViewById(R.id.tv_card_eng2).setVisibility(View.INVISIBLE);


        //첫번째 선택
        private Button.OnClickListener btnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tv_card_eng1:
                        temp1 = 1;
                        temp3 = 1;
                        btn_num = 1;
                        findViewById(R.id.tv_card_eng1).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tv_card_kor7:
                        temp2 = 1;
                        temp3 = 1;
                        btn_num = 11;
                        findViewById(R.id.tv_card_kor7).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tv_card_eng2:
                        temp1 = 2;
                        temp3 = 2;
                        btn_num = 2;
                        findViewById(R.id.tv_card_eng2).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tv_card_kor5:
                        temp2 = 2;
                        temp3 = 2;
                        btn_num = 21;
                        findViewById(R.id.tv_card_kor5).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tv_card_eng3:
                        temp1 = 3;
                        temp3 = 3;
                        btn_num = 3;
                        findViewById(R.id.tv_card_eng3).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tv_card_kor1:
                        temp2 = 3;
                        temp3 = 3;
                        btn_num = 31;
                        findViewById(R.id.tv_card_kor1).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tv_card_eng4:
                        temp1 = 4;
                        temp3 = 4;
                        btn_num = 4;
                        findViewById(R.id.tv_card_eng4).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tv_card_kor8:
                        temp2 = 4;
                        temp3 = 4;
                        btn_num = 41;
                        findViewById(R.id.tv_card_kor8).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tv_card_eng5:
                        temp1 = 5;
                        temp3 = 5;
                        btn_num = 5;
                        findViewById(R.id.tv_card_eng5).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tv_card_kor2:
                        temp2 = 5;
                        temp3 = 5;
                        btn_num = 51;
                        findViewById(R.id.tv_card_kor2).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tv_card_eng6:
                        temp1 = 6;
                        temp3 = 6;
                        btn_num = 6;
                        findViewById(R.id.tv_card_eng6).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tv_card_kor4:
                        temp2 = 6;
                        temp3 = 6;
                        btn_num = 61;
                        findViewById(R.id.tv_card_kor4).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tv_card_eng7:
                        temp1 = 7;
                        temp3 = 7;
                        btn_num = 7;
                        findViewById(R.id.tv_card_eng7).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tv_card_kor3:
                        temp2 = 7;
                        temp3 = 7;
                        btn_num = 71;
                        findViewById(R.id.tv_card_kor3).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tv_card_eng8:
                        temp1 = 8;
                        temp3 = 8;
                        btn_num = 8;
                        findViewById(R.id.tv_card_eng8).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tv_card_kor6:
                        temp2 = 8;
                        temp3 = 8;
                        btn_num = 81;
                        findViewById(R.id.tv_card_kor6).setVisibility(View.INVISIBLE);
                        break;
                }
                if((select == 1 && temp1 != -1 && temp1 != temp2 && temp1 != temp3 && temp2 == temp3)||(select == 1 && temp2 != -1 && temp1 == temp3 && temp1 != temp2 && temp2 != temp3)){
                    Toast.makeText(Game_4_3_3.this, "다시 선택해주세요.", Toast.LENGTH_LONG).show();
                    select--;

                    switch (first_btn_num) {
                        case 1:
                            findViewById(R.id.tv_card_eng1).setVisibility(View.VISIBLE);
                        case 11:
                            findViewById(R.id.tv_card_kor7).setVisibility(View.VISIBLE);
                        case 2:
                            findViewById(R.id.tv_card_eng2).setVisibility(View.VISIBLE);
                        case 21:
                            findViewById(R.id.tv_card_kor5).setVisibility(View.VISIBLE);
                        case 3:
                            findViewById(R.id.tv_card_eng3).setVisibility(View.VISIBLE);
                        case 31:
                            findViewById(R.id.tv_card_kor1).setVisibility(View.VISIBLE);
                        case 4:
                            findViewById(R.id.tv_card_eng4).setVisibility(View.VISIBLE);
                        case 41:
                            findViewById(R.id.tv_card_kor8).setVisibility(View.VISIBLE);
                        case 5:
                            findViewById(R.id.tv_card_eng5).setVisibility(View.VISIBLE);
                        case 51:
                            findViewById(R.id.tv_card_kor2).setVisibility(View.VISIBLE);
                        case 6:
                            findViewById(R.id.tv_card_eng6).setVisibility(View.VISIBLE);
                        case 61:
                            findViewById(R.id.tv_card_kor4).setVisibility(View.VISIBLE);
                        case 7:
                            findViewById(R.id.tv_card_eng7).setVisibility(View.VISIBLE);
                        case 71:
                            findViewById(R.id.tv_card_kor3).setVisibility(View.VISIBLE);
                        case 8:
                            findViewById(R.id.tv_card_eng8).setVisibility(View.VISIBLE);
                        case 81:
                            findViewById(R.id.tv_card_kor6).setVisibility(View.VISIBLE);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    switch (btn_num) {
                        case 1:
                            findViewById(R.id.tv_card_eng1).setVisibility(View.VISIBLE);
                            break;
                        case 11:
                            findViewById(R.id.tv_card_kor7).setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            findViewById(R.id.tv_card_eng2).setVisibility(View.VISIBLE);
                            break;
                        case 21:
                            findViewById(R.id.tv_card_kor5).setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            findViewById(R.id.tv_card_eng3).setVisibility(View.VISIBLE);
                            break;
                        case 31:
                            findViewById(R.id.tv_card_kor1).setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            findViewById(R.id.tv_card_eng4).setVisibility(View.VISIBLE);
                            break;
                        case 41:
                            findViewById(R.id.tv_card_kor8).setVisibility(View.VISIBLE);
                            break;
                        case 5:
                            findViewById(R.id.tv_card_eng5).setVisibility(View.VISIBLE);
                            break;
                        case 51:
                            findViewById(R.id.tv_card_kor2).setVisibility(View.VISIBLE);
                            break;
                        case 6:
                            findViewById(R.id.tv_card_eng6).setVisibility(View.VISIBLE);
                            break;
                        case 61:
                            findViewById(R.id.tv_card_kor4).setVisibility(View.VISIBLE);
                            break;
                        case 7:
                            findViewById(R.id.tv_card_eng7).setVisibility(View.VISIBLE);
                            break;
                        case 71:
                            findViewById(R.id.tv_card_kor3).setVisibility(View.VISIBLE);
                            break;
                        case 8:
                            findViewById(R.id.tv_card_eng8).setVisibility(View.VISIBLE);
                            break;
                        case 81:
                            findViewById(R.id.tv_card_kor6).setVisibility(View.VISIBLE);
                            break;
                    }


                }
                else if ((temp1 == temp3 && temp1 != temp2 && temp2 != temp3)||(temp2 == temp3 && temp1 != temp2 && temp1 != temp3)){
                    Toast.makeText(Game_4_3_3.this, "한장 더 선택해주세요.", Toast.LENGTH_SHORT).show();
                    select++;
                    first_btn_num = btn_num;
                }

                else if(temp1 == temp3 && temp2 == temp3){
                    Toast.makeText(Game_4_3_3.this, "정답 !", Toast.LENGTH_SHORT).show();
                    select --;
                    count++;
                }

                if(count == 8){
                    count = 0;
                    Intent intent = new Intent(getApplicationContext(), Game_4_3_4.class);
                    startActivity(intent);
                }
            }
        };


    // Load DataBase
    private ArrayList<Word> init_Load_ElementaryDB() {
        DBHelper_ELE DBHelper_ELE = new DBHelper_ELE(getApplicationContext());
        DBHelper_ELE.OpenDatabaseFile();

        ArrayList<Word> wordList =  DBHelper_ELE.getTableData();
        Log.e("test", String.valueOf(wordList.size()));

        DBHelper_ELE.close();
        return wordList;
    }

    // Load DataBase - middle word
    private ArrayList<Word> init_Load_MiddleDB() {
        DBHelper_MID DBHelper_MID = new DBHelper_MID(getApplicationContext());
        DBHelper_MID.OpenDatabaseFile();

        ArrayList<Word> wordList =  DBHelper_MID.getTableData();
        Log.e("test", String.valueOf(wordList.size()));

        DBHelper_MID.close();
        return wordList;
    }

    // Load DataBase - sat word
    private ArrayList<Word> init_Load_SAT_DB() {
        DBHelper_SAT DBHelper_SAT = new DBHelper_SAT(getApplicationContext());
        DBHelper_SAT.OpenDatabaseFile();

        ArrayList<Word> wordList =  DBHelper_SAT.getTableData();
        Log.e("test", String.valueOf(wordList.size()));

        DBHelper_SAT.close();
        return wordList;
    }

    // Load DataBase - TOEIC word
    private ArrayList<Word> init_Load_TOEIC_DB() {
        DBHelper_TOEIC DBHelper_TOEIC = new DBHelper_TOEIC(getApplicationContext());
        DBHelper_TOEIC.OpenDatabaseFile();

        ArrayList<Word> wordList =  DBHelper_TOEIC.getTableData();
        Log.e("test", String.valueOf(wordList.size()));

        DBHelper_TOEIC.close();
        return wordList;
    }

    // Load DataBase - TRAVEL word
    private ArrayList<Word> init_Load_TRAVEL_DB() {
        DBHelper_TRAVEL DBHelper_TRAVEL = new DBHelper_TRAVEL(getApplicationContext());
        DBHelper_TRAVEL.OpenDatabaseFile();

        ArrayList<Word> wordList =  DBHelper_TRAVEL.getTableData();
        Log.e("test", String.valueOf(wordList.size()));

        DBHelper_TRAVEL.close();
        return wordList;
    }

    // Load DataBase - BUSINESS word
    private ArrayList<Word> init_Load_BUSINESS_DB() {
        DBHelper_BUSINESS DBHelper_BUSINESS = new DBHelper_BUSINESS(getApplicationContext());
        DBHelper_BUSINESS.OpenDatabaseFile();

        ArrayList<Word> wordList =  DBHelper_BUSINESS.getTableData();
        Log.e("test", String.valueOf(wordList.size()));

        DBHelper_BUSINESS.close();
        return wordList;
    }
}