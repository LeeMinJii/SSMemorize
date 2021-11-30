package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Memorize_3_1 extends AppCompatActivity {

    Spinner spinner;
    TextView tv_word_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorize31);

        spinner = findViewById(R.id.spinner);

        ArrayAdapter monthAdapter = ArrayAdapter.createFromResource(this, R.array.word_number, android.R.layout.simple_spinner_dropdown_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(monthAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }


        });

        Button btn31_check = (Button) findViewById(R.id.btn31_check);
        btn31_check.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Memorize_3_2.class);
                startActivity(intent);
            }
        });

        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // 단어 암기 유형 텍스트뷰 띄우기
        tv_word_type = findViewById(R.id.tv_wordtype31);
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

        // 뒤로 가기 버튼
        ImageButton btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}