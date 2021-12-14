package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class Game_4_4 extends AppCompatActivity{

    static int[] score2 = new int[1];  //주관식 게임 점수 저장
    int score22;
    TextView tv_game2_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game44);

        tv_game2_score = findViewById(R.id.tv_game2_score);

        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // 게임 종료 버튼
        Button btn_game2_end = (Button)findViewById(R.id.btn_game2_end);
        btn_game2_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Game_4_1.class);
                startActivity(intent);
            }
        });

        //다시 하기 버튼
        Button btn_game2_re = (Button)findViewById(R.id.btn_game2_end);
        btn_game2_re.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                    Intent intent2 = new Intent(getApplicationContext(), Game_4_2_2.class);
                    startActivity(intent2);
            }

        });


        show_score2();
        game2_high_score();
    }

    //점수 띄우기
    public void show_score2(){
        score2[0] = 10*(Game_4_2_3.check2[1]);
        score22=score2[0];

        tv_game2_score.setText("총 점수 : "+score22+"점");
    }

    //최고 점수 갱신
    public void game2_high_score(){
        if(Game_4_main.game_high_score[1]<score2[0]){
            Game_4_main.game_high_score[1]=score2[0];
        }
    }
}