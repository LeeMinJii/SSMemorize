package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Game_4_3_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game434);

        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //게임 종료 버튼
        Button end_card_game = (Button)findViewById(R.id.end_card_game);
        end_card_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Game_4_1.class);
                startActivity(intent);
            }
        });

        //다시 하기 버튼
        Button re_card_game = (Button)findViewById(R.id.re_card_game);
        re_card_game.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Game_4_3_2.class);
                startActivity(intent);
            }
        });

    }
}
