package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start_App extends AppCompatActivity {

    public static int[] complete = new int[200]; // 단어 암기 완료/미완료 구분

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app);

        // complete배열[0-199]에 1-200넣기
        for (int i=0; i<200; i++){
            complete[i]=i+1;
        }

        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //로그인 버튼 클릭 시 로그인 화면으로 이동
        Button btn_login = findViewById(R.id.btn_Login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        //회원가입 버튼 클릭 시 회원가입 화면으로 이동
        Button btn_signup = findViewById(R.id.btn_SignUp);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });
    }
}