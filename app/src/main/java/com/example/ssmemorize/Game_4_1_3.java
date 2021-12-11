package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Game_4_1_3 extends AppCompatActivity {

    public static ArrayList<Word> wordList;

    public static int Wcursor1;   //출력할 단어 번호
    public static int answer;   //정답 선택지 번호

    int[] question1 = new int[20];   //랜덤으로 뽑은 문제 단어 번호
    int[] content = new int[3];  //랜덤으로 뽑은 선택지 단어 번호
    static int[] check1 = new int[2];  //count, correct 저장
    
    public static String word_question1;
    public static String content1;
    public static String content2;
    public static String content3;
    public static String content4;

    TextView tv_game1_word;
    Button btn_game1_content1;
    Button btn_game1_content2;
    Button btn_game1_content3;
    Button btn_game1_content4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game413);

        tv_game1_word = findViewById(R.id.tv_game1_word);
        btn_game1_content1 = findViewById(R.id.btn_game1_content1);
        btn_game1_content2 = findViewById(R.id.btn_game1_content2);
        btn_game1_content3 = findViewById(R.id.btn_game1_content3);
        btn_game1_content4 = findViewById(R.id.btn_game1_content4);

        check1[0] = 0;
        check1[1] = 0;
        Wcursor1=-1;

        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // 뒤로 가기 버튼
        ImageButton btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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

        //랜덤으로 문제 20개 뽑아서 배열에 저장
        Random rand1 = new Random();
        for(int i=0; i<20; i++){
            question1[i] = rand1.nextInt(200);
            for(int j=0; j<i;j++){
                if(question1[j]==question1[i]){
                    i--;
                    break;
                }
            }
        }

        //첫 번째 문제 띄우기
        newQuestion1();

        //선택지 고르면 다음 문제
        btn_game1_content1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                check1[0]=check1[0]+1;
                if(answer==0) {
                    check1[1]=check1[1]+1;
                    Toast.makeText(Game_4_1_3.this,"정답입니다.", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Game_4_1_3.this,"오답입니다.", Toast.LENGTH_SHORT).show();
                newQuestion1();
            }
        });
        btn_game1_content2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                check1[0]=check1[0]+1;
                if(answer==1) {
                    check1[1]=check1[1]+1;
                    Toast.makeText(Game_4_1_3.this,"정답입니다.", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Game_4_1_3.this,"오답입니다.", Toast.LENGTH_SHORT).show();
                newQuestion1();
            }
        });
        btn_game1_content3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                check1[0]=check1[0]+1;
                if(answer==2) {
                    check1[1]=check1[1]+1;
                    Toast.makeText(Game_4_1_3.this,"정답입니다.", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Game_4_1_3.this,"오답입니다.", Toast.LENGTH_SHORT).show();
                newQuestion1();
            }
        });
        btn_game1_content4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                check1[0]=check1[0]+1;
                if(answer==3) {
                    check1[1]=check1[1]+1;
                    Toast.makeText(Game_4_1_3.this,"정답입니다.", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Game_4_1_3.this,"오답입니다.", Toast.LENGTH_SHORT).show();
                newQuestion1();
            }
        });

    }

    //Load DataBase
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

//    새 문제 설정
    public void newQuestion1(){
        //20문제 다 풀면 점수 화면으로
        if(check1[0]==3){
            Intent intent = new Intent(getApplicationContext(), Game_4_1_4.class);
            startActivity(intent);
        }

        //문제(한글) 띄우기
        Wcursor1 = question1[check1[0]];
        word_question1 = wordList.get(Wcursor1).korean;
        tv_game1_word.setText(word_question1);

        //정답 선택지 번호 결정
        Random rand2 = new Random();
        answer = rand2.nextInt(4);

        //틀린 선택지 3개 랜덤으로 뽑기
        for(int j=0; j<3;j++){
            Random rand3 = new Random();
            content[j] = rand3.nextInt(200);
            if(content[j]!=question1[check1[0]]){
                for(int k=0; k<j;k++){
                    if(content[j]==content[k]){
                        j--;
                        break;
                    }
                }
            }
            else
                j--;
        }

        //선택지 띄우기
        if(answer==0){
            content1 = wordList.get(Wcursor1).english;
            content2 = wordList.get(content[0]).english;
            content3 = wordList.get(content[1]).english;
            content4 = wordList.get(content[2]).english;

            btn_game1_content1.setText(content1);
            btn_game1_content2.setText(content2);
            btn_game1_content3.setText(content3);
            btn_game1_content4.setText(content4);

        }
        else if(answer==1){
            content1 = wordList.get(content[0]).english;
            content2 = wordList.get(Wcursor1).english;
            content3 = wordList.get(content[1]).english;
            content4 = wordList.get(content[2]).english;

            btn_game1_content1.setText(content1);
            btn_game1_content2.setText(content2);
            btn_game1_content3.setText(content3);
            btn_game1_content4.setText(content4);
        }
        else if(answer==2){
            content1 = wordList.get(content[0]).english;
            content2 = wordList.get(content[1]).english;
            content3 = wordList.get(Wcursor1).english;
            content4 = wordList.get(content[2]).english;

            btn_game1_content1.setText(content1);
            btn_game1_content2.setText(content2);
            btn_game1_content3.setText(content3);
            btn_game1_content4.setText(content4);
        }
        else if(answer==3){
            content1 = wordList.get(content[0]).english;
            content2 = wordList.get(content[1]).english;
            content3 = wordList.get(content[2]).english;
            content4 = wordList.get(Wcursor1).english;

            btn_game1_content1.setText(content1);
            btn_game1_content2.setText(content2);
            btn_game1_content3.setText(content3);
            btn_game1_content4.setText(content4);
        }
    }
}