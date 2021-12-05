package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Memorize_3_3 extends AppCompatActivity {

    int show_eng_or_kor = 1; // framelayout 화면전환 - 처음 클릭 시 안먹어서 0이아니라 1로.
    int index = 1; // 단어 몇개째 외우고 있나 textview 띄우기 위함
    int Wcursor=0; // Day에 따라 리스트의 몇번째 데이터부터 출력할지 정하는 Word Cursor

    TextView tv_word_num; // 몇번째 단어인지
    TextView show_day; // Day xx

    // FrameLayout TextView 선언
    TextView tv_english;
    TextView tv_korean;

    ArrayList<Elementary> elementaryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorize33);

        // DB 불러오기
        elementaryList = init_Load_ElementaryDB();

        tv_english = findViewById(R.id.tv_word_eng);
        tv_korean = findViewById(R.id.tv_word_kor);
        tv_word_num = findViewById(R.id.word_num);

        tv_word_num.setText(String.valueOf(index)); // 초기값 : 1(현재 단어)/20(전체단어)

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

        // Day xx 텍스트뷰, 커서 알맞게 초기화
        show_day = findViewById(R.id.show_day);
        switch (Memorize_3_2.flag_Day){
            case 1:
                show_day.setText("Day 01");
                Wcursor = 0;
                break;
            case 2:
                show_day.setText("Day 02");
                Wcursor = 20;
                break;
            case 3:
                show_day.setText("Day 03");
                Wcursor = 40;
                break;
            case 4:
                show_day.setText("Day 04");
                Wcursor =60;
                break;
            case 5:
                show_day.setText("Day 05");
                Wcursor = 80;
                break;
            case 6:
                show_day.setText("Day 06");
                Wcursor = 100;
                break;
            case 7:
                show_day.setText("Day 07");
                Wcursor = 120;
                break;
            case 8:
                show_day.setText("Day 08");
                Wcursor = 140;
                break;
            case 9:
                show_day.setText("Day 09");
                Wcursor = 160;
                break;
            case 10:
                show_day.setText("Day 10");
                Wcursor = 180;
                break;
        }

        String word_eng = elementaryList.get(Wcursor).english; // Day xx의 첫번째 단어 띄우기
        tv_english.setText(word_eng);

        String word_kor = elementaryList.get(Wcursor).korean; // Day xx의 첫번째 단어 띄우기
        tv_korean.setText(word_kor);
    }

    // Load DataBase
    private ArrayList<Elementary> init_Load_ElementaryDB() {
        DBHelper DBHelper = new DBHelper(getApplicationContext());
        DBHelper.OpenDatabaseFile();

        ArrayList<Elementary> elementaryList =  DBHelper.getTableData();
        Log.e("test", String.valueOf(elementaryList.size()));

        DBHelper.close();
        return elementaryList;
    }

    // Day 1 - btn_next 클릭 시 다음 단어로 넘어가기
    public void onBtnNextClicked(View view){
        // 현재 단어 개수 증가 2/20, 3/20 ...
        index += 1;
        Wcursor +=1;

        // 20개 넘었으면 Day 하나 학습 종료 창으로 넘어가기
        if(index == 21){
            Intent intent = new Intent(getApplicationContext(), Memorize_3_4.class);
            startActivity(intent);
            return; // 현재 액티비티 끝내기
        }

        tv_word_num = findViewById(R.id.word_num);
        tv_word_num.setText(String.valueOf(index));

        // 다음 단어 띄우기
        tv_english = findViewById(R.id.tv_word_eng);
        tv_korean = findViewById(R.id.tv_word_kor);

        // Day xx에 따라 위에서 초기화한 WCursor번째의 데이터 가져오기
        String word_eng = elementaryList.get(Wcursor).english;
        tv_english.setText(word_eng);

        String word_kor = elementaryList.get(Wcursor).korean;
        tv_korean.setText(word_kor);
    }

    // (한글/영어 전환)Button 누르면 뷰 전환
    public void onBtnChangeClicked(View view){
        changeView();
    }
    private void changeView(){
        if(show_eng_or_kor == 0){
            tv_english.setVisibility(View.VISIBLE);
            tv_korean.setVisibility(View.INVISIBLE);
            show_eng_or_kor = 1;
        }
        else if(show_eng_or_kor == 1){
            tv_english.setVisibility(View.INVISIBLE);
            tv_korean.setVisibility(View.VISIBLE);
            show_eng_or_kor = 0;
        }
    }
}