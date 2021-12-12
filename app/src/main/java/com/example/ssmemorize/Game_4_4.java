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

    public static int score2;
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
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        //다시 하기 버튼
        Button btn_game2_re = (Button)findViewById(R.id.btn_game2_re);
        btn_game2_re.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), Game_4_2_2.class);
                    startActivity(intent);
            }

        });


        show_score2();
    }

    //점수 띄우기
    public void show_score2(){
        score2 = 10*(Game_4_2_3.check2[1]);

        tv_game2_score.setText("총 점수 : "+score2+"점");
    }
}