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

//    public static int score;
//    TextView tv_game_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game44);

//        tv_game_score = findViewById(R.id.tv_game_score);

        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // 게임 종료 버튼
        Button btn_game_end = (Button)findViewById(R.id.btn_game_end);
        btn_game_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Game_4_1.class);
                startActivity(intent);
            }
        });

        //다시 하기 버튼
        Button btn_game_re = (Button)findViewById(R.id.btn_game_re);
        btn_game_re.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                    Intent intent2 = new Intent(getApplicationContext(), Game_4_2_2.class);
                    startActivity(intent2);
            }

//            @Override
//            public void onClick(View v) {
//                if(Game_4_main.sig_gametype==1) {
//                    Intent intent1 = new Intent(getApplicationContext(), Game_4_1_2.class);
//                    startActivity(intent1);
//                }
//                else if(Game_4_main.sig_gametype==2){
//                    Intent intent2 = new Intent(getApplicationContext(), Game_4_2_2.class);
//                    startActivity(intent2);
//                }
//            }
        });


//        if(Game_4_1_3.test2==33333)
//            tv_game_score.setText("2");
//        else if(Game_4_1_3.test2==20)
//            tv_game_score.setText("20");
//        else
//            tv_game_score.setText("45");
//        tv_game_score.setText("총 점수 : "+String.valueOf(Game_4_1_3.count));

//        show_score();
    }

    //점수 띄우기
//    public void show_score(){
//        score = 20*(Game_4_1_3.count);

//        tv_game_score.setText("총 점수 : "+score+"점");
//    }
}