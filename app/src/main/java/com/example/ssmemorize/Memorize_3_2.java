package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Memorize_3_2 extends AppCompatActivity {
    TextView tv_word_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorize32);

        ImageButton Button32 =  findViewById(R.id.btn32);
        Button32.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Memorize_3_main.class);
                startActivity(intent);
            }
        });

        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // 단어 암기 유형 텍스트뷰 띄우기
        tv_word_type = findViewById(R.id.tv_wordtype32);
        switch (Memorize_3_main.sig_wordtype){
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
}