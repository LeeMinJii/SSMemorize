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

    int show_eng_or_kor = 0;
    int index = 1;

    TextView tv_word_num; // 몇번째 단어인지

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

        String word_eng = elementaryList.get(0).english;
        tv_english.setText(word_eng);

        String word_kor = elementaryList.get(0).korean;
        tv_korean.setText(word_kor);


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

    // btn_next 클릭 시 다음 단어로 넘어가기
    public void onBtnNextClicked(View view){
        // 현재 단어 개수 증가 2/20, 3/20 ...
        index += 1;

        // 20개 넘었으면 Day 하나 학습 종료 창으로 넘어가기
        if(index ==21){
            Intent intent = new Intent(getApplicationContext(), Memorize_3_4.class);
            startActivity(intent);
            return;
        }

        tv_word_num = findViewById(R.id.word_num);
        tv_word_num.setText(String.valueOf(index));

        // 다음 단어 띄우기
        tv_english = findViewById(R.id.tv_word_eng);
        tv_korean = findViewById(R.id.tv_word_kor);

        String word_eng = elementaryList.get(index-1).english; // index-1 번째의 데이터 가져오기
        tv_english.setText(word_eng);

        String word_kor = elementaryList.get(index-1).korean;
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