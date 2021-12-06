package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class MyPage_5_2_1 extends AppCompatActivity {

    private ListView listView;
    private Adapter_listview adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page521);
/*
        adapter = new Adapter_listview(); // 어뎁터 생성
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        // 내 단어장에 들어있는 단어 개수 : myword_num 이므로 그만큼 리스트뷰에 띄우기
        for (int i=0; i<Memorize_3_3.myword_num; i++){
            adapter.addItem(Memorize_3_3.myword_elementaryList.get(0).english,Memorize_3_3.myword_elementaryList.get(0).korean);

            adapter.notifyDataSetChanged();
        }
*/

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
}