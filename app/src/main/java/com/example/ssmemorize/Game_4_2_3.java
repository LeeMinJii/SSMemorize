package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Game_4_2_3 extends AppCompatActivity {
    public static ArrayList<Elementary> elementaryList;

    public static int Wcursor2;    //출력할 단어 번호

    int[] question2 = new int[10];   //랜덤으로 뽑은 문제 단어 번호
    static int[] check2 = new int[2];  //count, correct 저장

    public static String word_question2;
    public static String answer2;   //입력한 답

    TextView tv_game2_word;
    Button btn_answer_end;
    EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game423);

        tv_game2_word = findViewById(R.id.tv_game2_word);
        btn_answer_end = findViewById(R.id.btn_answer_end);
        editText = (EditText) findViewById(R.id.game2_answer);

        check2[0] = 0;
        check2[1] = 0;
        Wcursor2=-1;

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

        //랜덤으로 문제 10개 뽑아서 배열에 저장
        Random rand1 = new Random();
        for(int i=0; i<10; i++){
            question2[i] = rand1.nextInt(200);
            for(int j=0; j<i;j++){
                if(question2[j]==question2[i]){
                    i--;
                    break;
                }
            }
        }

        //첫 번째 문제 띄우기
        newQuestion2();

        //입력 완료 버튼 클릭 시
        btn_answer_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                check2[0]=check2[0]+1;
                answer2 = editText.getText().toString();
//                answer2 = ((EditText)findViewById(R.id.game2_answer)).getText().toString();

                if(answer2.equals(elementaryList.get(Wcursor2).english)){
                    check2[1]=check2[1]+1;
                    Toast.makeText(Game_4_2_3.this,"정답입니다.", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Game_4_2_3.this,"오답입니다.", Toast.LENGTH_SHORT).show();
                newQuestion2();
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
    public void newQuestion2(){
        //10문제 다 풀면 점수 화면으로
        if(check2[0]==2){
            Intent intent = new Intent(getApplicationContext(), Game_4_4.class);
            startActivity(intent);
        }

        editText.setText(null);

        //문제(한글) 띄우기
        Wcursor2 = question2[check2[0]];
        word_question2 = elementaryList.get(Wcursor2).korean;
        tv_game2_word.setText(word_question2);
    }
}