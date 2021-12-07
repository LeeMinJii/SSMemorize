package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Memorize_3_2 extends AppCompatActivity implements View.OnClickListener {
    TextView tv_word_type;

    public static int flag_Day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorize32);

        // 뒤로 가기 버튼
        ImageButton btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // start버튼
        Button btn_start_study1 = findViewById(R.id.btn_start_study1);
        btn_start_study1.setOnClickListener(this);
        Button btn_start_study2 = findViewById(R.id.btn_start_study2);
        btn_start_study2.setOnClickListener(this);
        Button btn_start_study3 = findViewById(R.id.btn_start_study3);
        btn_start_study3.setOnClickListener(this);
        Button btn_start_study4 = findViewById(R.id.btn_start_study4);
        btn_start_study4.setOnClickListener(this);
        Button btn_start_study5 = findViewById(R.id.btn_start_study5);
        btn_start_study5.setOnClickListener(this);
        Button btn_start_study6 = findViewById(R.id.btn_start_study6);
        btn_start_study6.setOnClickListener(this);
        Button btn_start_study7 = findViewById(R.id.btn_start_study7);
        btn_start_study7.setOnClickListener(this);
        Button btn_start_study8 = findViewById(R.id.btn_start_study8);
        btn_start_study8.setOnClickListener(this);
        Button btn_start_study9 = findViewById(R.id.btn_start_study9);
        btn_start_study9.setOnClickListener(this);
        Button btn_start_study10 = findViewById(R.id.btn_start_study10);
        btn_start_study10.setOnClickListener(this);
        

        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // 단어 암기 유형 텍스트뷰 띄우기
        tv_word_type = findViewById(R.id.tv_wordtype32);
        switch (Memorize_3_main.flag_wordtype){
            case 1:
                tv_word_type.setText("초등 영단어");
                break;
            case 2:
                tv_word_type.setText("중등 영단어");
                break;
            case 3:
                tv_word_type.setText("수능 영단어");
                break;
            case 4:
                tv_word_type.setText("토익 영단어");
                break;
            case 5:
                tv_word_type.setText("여행 회화");
                break;
            case 6:
                tv_word_type.setText("비지니스 회화");
                break;
        }
    }

    int start=0; // start버튼의 flay_에 따라 단어 조회 시작 번호 (flag_Day=2면 start +=20)
    // start 버튼 클릭 시 Day xx 텍스트뷰  flag 주기, 화면전환
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Memorize_3_3.class);
        switch (view.getId()) {
            case R.id.btn_start_study1:
                flag_Day = 1;
                startActivity(intent);
                break;
            case R.id.btn_start_study2:
                flag_Day = 2;
                start = 20;
                startActivity(intent);
                break;
            case R.id.btn_start_study3:
                flag_Day = 3;
                start = 40;
                startActivity(intent);
                break;
            case R.id.btn_start_study4:
                flag_Day = 4;
                start = 60;
                startActivity(intent);
                break;
            case R.id.btn_start_study5:
                flag_Day = 5;
                start = 80;
                startActivity(intent);
                break;
            case R.id.btn_start_study6:
                flag_Day = 6;
                start = 100;
                startActivity(intent);
                break;
            case R.id.btn_start_study7:
                flag_Day = 7;
                start = 120;
                startActivity(intent);
                break;
            case R.id.btn_start_study8:
                flag_Day = 8;
                start = 140;
                startActivity(intent);
                break;
            case R.id.btn_start_study9:
                flag_Day = 9;
                start = 160;
                startActivity(intent);
                break;
            case R.id.btn_start_study10:
                flag_Day = 10;
                start = 180;
                startActivity(intent);
                break;
        }
/*
        int check=0;
        ImageView imageView = findViewById(R.id.img_check);

        // Day 하나 전체 암기 완료 시 체크버튼 바꾸기
        for( int i=start ; i < 20; i++) { // 단어 20개씩 보여주므로 20번 확인
            if (Memorize_3_3.elementaryList.get(start)._id == 0){
                ++check;
            }
        }
        if(check==20){
            imageView.setImageResource(R.drawable.check_blue); // 파란 체크로 변경
        }
        else imageView.setImageResource(R.drawable.check_blue); // 20이 안되는 경우 모두 회색체크 띄우기*/
    }
}