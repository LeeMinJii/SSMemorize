package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.ArrayList;

public class Game_4_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game41);


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

        //초등 영단어 게임
        Button elementary_game = (Button)findViewById(R.id.elementary_game);
        elementary_game.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Game_4_3_2.class);
                startActivity(intent);
            }
        });

        /*
        //중등 영단어 게임
        Button middle_game = (Button)findViewById(R.id.middle_game);
        middle_game.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Game_4_3_3.class);
                startActivity(intent);
            }
        });

        //수능 영단어 게임
        Button college_exam_game = (Button)findViewById(R.id.college_exam_game);
        college_exam_game.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Game_4_3_3.class);
                startActivity(intent);
            }
        });

        //토익 영단어 게임
        Button toeic_game = (Button)findViewById(R.id.toeic_game);
        toeic_game.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Game_4_3_3.class);
                startActivity(intent);
            }
        });

        //여행 영단어 게임
        Button travel_game = (Button)findViewById(R.id.travel_game);
        travel_game.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Game_4_3_3.class);
                startActivity(intent);
            }
        });

        //비지니스 영단어 게임
        Button business_game = (Button)findViewById(R.id.business_game);
        business_game.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Game_4_3_3.class);
                startActivity(intent);
            }
        });

         */
    }


}