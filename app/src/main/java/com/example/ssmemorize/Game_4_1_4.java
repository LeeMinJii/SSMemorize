package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Game_4_1_4 extends AppCompatActivity {

    public static int score1;
    TextView tv_game1_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game414);

        tv_game1_score = findViewById(R.id.tv_game1_score);


        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // 게임 종료 버튼
        Button btn_game_end = findViewById(R.id.btn_game1_end);
        btn_game_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        //다시 하기 버튼
        Button btn_game1_re = (Button) findViewById(R.id.btn_game1_re);
        btn_game1_re.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Game_4_1_2.class);
                startActivity(intent);
            }
        });

        show_score();
    }


    //점수 띄우기
    public void show_score(){
        score1 = 20*(Game_4_1_3.check1[1]);

        tv_game1_score.setText("총 점수 : "+score1+"점");
    }
}