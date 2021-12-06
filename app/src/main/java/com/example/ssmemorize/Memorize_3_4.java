package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Memorize_3_4 extends AppCompatActivity {

    TextView show_day; // Day xx

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorize34);

        Button btn_game_end = findViewById(R.id.btn_game_end);
        btn_game_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Memorize_3_2.class);
                startActivity(intent);
            }
        });

        // Day xx 텍스트뷰, 커서 알맞게 초기화
        show_day = findViewById(R.id.show_day);
        switch (Memorize_3_2.flag_Day){
            case 1:
                show_day.setText("Day 01");
                break;
            case 2:
                show_day.setText("Day 02");
                break;
            case 3:
                show_day.setText("Day 03");
                break;
            case 4:
                show_day.setText("Day 04");
                break;
            case 5:
                show_day.setText("Day 05");
                break;
            case 6:
                show_day.setText("Day 06");
                break;
            case 7:
                show_day.setText("Day 07");
                break;
            case 8:
                show_day.setText("Day 08");
                break;
            case 9:
                show_day.setText("Day 09");
                break;
            case 10:
                show_day.setText("Day 10");
                break;
        }

        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }
}