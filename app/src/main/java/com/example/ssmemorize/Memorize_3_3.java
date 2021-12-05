package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Memorize_3_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorize33);

        ArrayList<Elementary> elementaryList = init_Load_ElementaryDB();

        TextView tv_english = findViewById(R.id.tv_word);
        String word = elementaryList.get(0).english;
        tv_english.setText(word);

        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // 뒤로 가기 버튼
        ImageButton btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    // Load DataBase
    private ArrayList<Elementary> init_Load_ElementaryDB() {
        DBHelper DBHelper = new DBHelper(getApplicationContext());
        DBHelper.OpenDatabaseFile();

        ArrayList<Elementary> elementaryList =  DBHelper.getTableData();
        Log.e("test", String.valueOf(elementaryList.size()));

        DBHelper.close();
        return elementaryList;

    }
}