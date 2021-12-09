package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Game_4_1_3 extends AppCompatActivity {

    public static ArrayList<Elementary> elementaryList;

    public static int count = 0; //몇 번째 문제인지
    public static int correct = 0;  //맞은 문제 개수
    public static int Wcursor = -1;    //출력할 단어 번호
    public static int answer;   //정답 선택지 번호

    int[] question = new int[20];   //랜덤으로 뽑은 문제 단어 번호
    int[] content = new int[3];  //랜덤으로 뽑은 선택지 단어 번호

    TextView tv_game1_word = findViewById(R.id.tv_game1_word);
    Button btn_game1_content1 = findViewById(R.id.btn_game1_content1);
    Button btn_game1_content2 = findViewById(R.id.btn_game1_content2);
    Button btn_game1_content3 = findViewById(R.id.btn_game1_content3);
    Button btn_game1_content4 = findViewById(R.id.btn_game1_content4);

    String word_question;
    String content1;
    String content2;
    String content3;
    String content4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game413);

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

        //DB 불러오기
        elementaryList = init_Load_ElementaryDB();

        //랜덤으로 문제 20개 뽑아서 배열에 저장
        Random rand1 = new Random();
        for(int i=0; i<20; i++){
            question[i] = rand1.nextInt(199);
            for(int j=0; j<i;j++){
                if(question[j]==question[j]){
                    i--;
                    break;
                }
            }
        }

        //첫 번째 문제 띄우기
        newQuestion();

        //선택지 고르면 다음 문제
        btn_game1_content1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                count++;
                if(answer==1){
                    //여기부터 다시 짜기
                }
            }
        });

    }

    //Load DataBase
    private ArrayList<Elementary> init_Load_ElementaryDB() {
        DBHelper DBHelper = new DBHelper(getApplicationContext());
        DBHelper.OpenDatabaseFile();

        ArrayList<Elementary> elementaryList =  DBHelper.getTableData();
        Log.e("test", String.valueOf(elementaryList.size()));

        DBHelper.close();
        return elementaryList;
    }

    //새 문제 설정
    private void newQuestion(){
        //문제(한글) 띄우기
        Wcursor = question[count];
        word_question = elementaryList.get(Wcursor).korean;
        tv_game1_word.setText(word_question);

        //정답 선택지 번호 결정
        Random rand2 = new Random();
        answer = rand2.nextInt(3);

        //틀린 선택지 3개 랜덤으로 뽑기
        for(int j=0; j<3;j++){
            Random rand3 = new Random();
            content[j] = rand3.nextInt(199);
            if(content[j]!=question[count]){
                for(int k=0; k<j;k++){
                    if(content[j]==content[k]){
                        j--;
                        break;
                    }
                }
            }
            else
                j--;
        }

        //선택지 띄우기
        if(answer==1){
            content1 = elementaryList.get(Wcursor).english;
            content2 = elementaryList.get(content[0]).english;
            content3 = elementaryList.get(content[1]).english;
            content4 = elementaryList.get(content[2]).english;

        }
        else if(answer==2){
            content1 = elementaryList.get(content[0]).english;
            content2 = elementaryList.get(Wcursor).english;
            content3 = elementaryList.get(content[1]).english;
            content4 = elementaryList.get(content[2]).english;
        }
        else if(answer==3){
            content1 = elementaryList.get(content[0]).english;
            content2 = elementaryList.get(content[1]).english;
            content3 = elementaryList.get(Wcursor).english;
            content4 = elementaryList.get(content[2]).english;
        }
        else if(answer==4){
            content1 = elementaryList.get(content[0]).english;
            content2 = elementaryList.get(content[1]).english;
            content3 = elementaryList.get(content[2]).english;
            content4 = elementaryList.get(Wcursor).english;
        }
    }
}