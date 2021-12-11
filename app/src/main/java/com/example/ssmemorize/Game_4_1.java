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

    public static int flag_wordtype_game;
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
                flag_wordtype_game = 1;  // 다음 화면에 띄울 단어 유형
                if(Game_4_main.sig_gametype==1) {
                    Intent intent1 = new Intent(getApplicationContext(), Game_4_1_2.class);
                    startActivity(intent1);
                }
                else if(Game_4_main.sig_gametype==2){
                    Intent intent2 = new Intent(getApplicationContext(), Game_4_2_2.class);
                    startActivity(intent2);
                }
                else if(Game_4_main.sig_gametype==3){
                    Intent intent3 = new Intent(getApplicationContext(), Game_4_3_2.class);
                    startActivity(intent3);
                }
            }
        });

        //중등 영단어 게임
        Button middle_game = (Button)findViewById(R.id.middle_game);
        middle_game.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                flag_wordtype_game = 2;  // 다음 화면에 띄울 단어 유형
                if(Game_4_main.sig_gametype==1) {
                    Intent intent1 = new Intent(getApplicationContext(), Game_4_1_2.class);
                    startActivity(intent1);
                }
                else if(Game_4_main.sig_gametype==2){
                    Intent intent2 = new Intent(getApplicationContext(), Game_4_2_2.class);
                    startActivity(intent2);
                }
                else if(Game_4_main.sig_gametype==3){
                    Intent intent3 = new Intent(getApplicationContext(), Game_4_3_2.class);
                    startActivity(intent3);
                }
            }
        });

        //수능 영단어 게임
        Button sat_game = (Button)findViewById(R.id.college_exam_game);
        sat_game.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                flag_wordtype_game = 3;  // 다음 화면에 띄울 단어 유형
                if(Game_4_main.sig_gametype==1) {
                    Intent intent1 = new Intent(getApplicationContext(), Game_4_1_2.class);
                    startActivity(intent1);
                }
                else if(Game_4_main.sig_gametype==2){
                    Intent intent2 = new Intent(getApplicationContext(), Game_4_2_2.class);
                    startActivity(intent2);
                }
                else if(Game_4_main.sig_gametype==3){
                    Intent intent3 = new Intent(getApplicationContext(), Game_4_3_2.class);
                    startActivity(intent3);
                }
            }
        });
        //토익 영단어 게임
        Button toeic_game = (Button)findViewById(R.id.toeic_game);
        toeic_game.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                flag_wordtype_game = 4;  // 다음 화면에 띄울 단어 유형
                if(Game_4_main.sig_gametype==1) {
                    Intent intent1 = new Intent(getApplicationContext(), Game_4_1_2.class);
                    startActivity(intent1);
                }
                else if(Game_4_main.sig_gametype==2){
                    Intent intent2 = new Intent(getApplicationContext(), Game_4_2_2.class);
                    startActivity(intent2);
                }
                else if(Game_4_main.sig_gametype==3){
                    Intent intent3 = new Intent(getApplicationContext(), Game_4_3_2.class);
                    startActivity(intent3);
                }
            }
        });
        //여행 영단어 게임
        Button travel_game = (Button)findViewById(R.id.travel_game);
        travel_game.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                flag_wordtype_game = 5;  // 다음 화면에 띄울 단어 유형
                if(Game_4_main.sig_gametype==1) {
                    Intent intent1 = new Intent(getApplicationContext(), Game_4_1_2.class);
                    startActivity(intent1);
                }
                else if(Game_4_main.sig_gametype==2){
                    Intent intent2 = new Intent(getApplicationContext(), Game_4_2_2.class);
                    startActivity(intent2);
                }
                else if(Game_4_main.sig_gametype==3){
                    Intent intent3 = new Intent(getApplicationContext(), Game_4_3_2.class);
                    startActivity(intent3);
                }
            }
        });
        //비지니스 영단어 게임
        Button business_game = (Button)findViewById(R.id.business_game);
        business_game.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                flag_wordtype_game = 6;  // 다음 화면에 띄울 단어 유형
                if(Game_4_main.sig_gametype==1) {
                    Intent intent1 = new Intent(getApplicationContext(), Game_4_1_2.class);
                    startActivity(intent1);
                }
                else if(Game_4_main.sig_gametype==2){
                    Intent intent2 = new Intent(getApplicationContext(), Game_4_2_2.class);
                    startActivity(intent2);
                }
                else if(Game_4_main.sig_gametype==3){
                    Intent intent3 = new Intent(getApplicationContext(), Game_4_3_2.class);
                    startActivity(intent3);
                }
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