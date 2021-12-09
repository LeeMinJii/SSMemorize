package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Game_4_4 extends AppCompatActivity {

    public static int score;
    TextView tv_game_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game44);

        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // 게임 종료 버튼
        Button btn_game_end = findViewById(R.id.btn_game_end);
        btn_game_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Game_4_main.class);
                startActivity(intent);
            }
        });

//        show_score();
    }

    //점수 띄우기
//    public void show_score(){
//        tv_game_score = findViewById(R.id.tv_game_score);
//
//        score = 20*Game_4_1_3.correct;
//
//        tv_game_score.setText(score);
//    }
}