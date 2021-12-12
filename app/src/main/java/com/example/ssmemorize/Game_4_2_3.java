package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Game_4_2_3 extends AppCompatActivity {
    public static ArrayList<Word> wordList;

    public static int Wcursor2;    //출력할 단어 번호

    int[] question2 = new int[11];   //랜덤으로 뽑은 문제 단어 번호
    static int[] check2 = new int[2];  //count, correct 저장

    public static String word_question2;
    public static String answer2;   //입력한 답

    TextView tv_game2_word;
    Button btn_answer_end;
    EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game423);

        tv_game2_word = findViewById(R.id.tv_game2_word);
        btn_answer_end = findViewById(R.id.btn_answer_end);
        editText = (EditText) findViewById(R.id.game2_answer);

        check2[0] = 0;
        check2[1] = 0;
        Wcursor2=-1;

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

        //랜덤으로 문제 10개 뽑아서 배열에 저장
        Random rand1 = new Random();
        for(int i=0; i<11; i++){
            question2[i] = rand1.nextInt(200);
            for(int j=0; j<i;j++){
                if(question2[j]==question2[i]){
                    i--;
                    break;
                }
            }
        }

        //첫 번째 문제 띄우기
        newQuestion2();

        //입력 완료 버튼 클릭 시
        btn_answer_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                check2[0]=check2[0]+1;
                answer2 = editText.getText().toString();
//                answer2 = ((EditText)findViewById(R.id.game2_answer)).getText().toString();

                if(answer2.equals(wordList.get(Wcursor2).english)){
                    check2[1]=check2[1]+1;
                    Toast.makeText(Game_4_2_3.this,"정답입니다.", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Game_4_2_3.this,"오답입니다.", Toast.LENGTH_SHORT).show();
                newQuestion2();
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

    //새 문제 설정
    public void newQuestion2(){
        //10문제 다 풀면 점수 화면으로
        if(check2[0]==10){
            Intent intent = new Intent(getApplicationContext(), Game_4_4.class);
            startActivity(intent);
        }

        editText.setText(null);

        //문제(한글) 띄우기
        Wcursor2 = question2[check2[0]];
        word_question2 = wordList.get(Wcursor2).korean;
        tv_game2_word.setText(word_question2);
    }
}