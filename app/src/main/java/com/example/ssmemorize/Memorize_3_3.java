package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Memorize_3_3 extends AppCompatActivity {

    int show_eng_or_kor = 1; // framelayout 영어/한글 화면전환 - 처음 클릭 시 안먹어서 0이아니라 1로.
    int index = 1; // 단어 몇개째 외우고 있나 textview 띄우기 위함
    public static int Wcursor=0; // Day에 따라 리스트의 몇번째 데이터부터 출력할지 정하는 Word Cursor
    public static int[] complete = new int[200]; // 단어 암기 완료/미완료 구분

    TextView tv_word_num; // 몇번째 단어인지
    TextView show_day; // Day xx

    // FrameLayout TextView 선언
    TextView tv_english;
    TextView tv_korean;
    // 암기 여부
    ImageView iv_complete;
    TextView tv_complete;

    public static ArrayList<Word> wordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorize33);

        // 영단어 유형에 따라 DB 불러오기
        wordList = init_Load_ElementaryDB();
        switch (Memorize_3_main.flag_wordtype){
            case 1: // 초등 영단어
                wordList = init_Load_ElementaryDB();
                break;
            case 2: // 중학 영단어
                wordList = init_Load_MiddleDB();
                break;
            case 3: // 수능 영단어
                wordList = init_Load_SAT_DB();
                break;
            case 4: // 토익 영단어
                wordList = init_Load_TOEIC_DB();
                break;
            case 5: // 여행 영단어
                wordList = init_Load_TRAVEL_DB();
                break;
            case 6: // 비지니스 영단어
                wordList = init_Load_BUSINESS_DB();
                break;
        }

        tv_english = findViewById(R.id.tv_word_eng);
        tv_korean = findViewById(R.id.tv_word_kor);
        tv_word_num = findViewById(R.id.word_num);

        tv_word_num.setText(String.valueOf(index)); // 초기값 : 1(현재 단어)/20(전체단어)

        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // Day xx 텍스트뷰, 커서 알맞게 초기화
        show_day = findViewById(R.id.show_day);
        switch (Memorize_3_2.flag_Day){
            case 1:
                show_day.setText("Day 01");
                Wcursor = 0;
                break;
            case 2:
                show_day.setText("Day 02");
                Wcursor = 20;
                break;
            case 3:
                show_day.setText("Day 03");
                Wcursor = 40;
                break;
            case 4:
                show_day.setText("Day 04");
                Wcursor =60;
                break;
            case 5:
                show_day.setText("Day 05");
                Wcursor = 80;
                break;
            case 6:
                show_day.setText("Day 06");
                Wcursor = 100;
                break;
            case 7:
                show_day.setText("Day 07");
                Wcursor = 120;
                break;
            case 8:
                show_day.setText("Day 08");
                Wcursor = 140;
                break;
            case 9:
                show_day.setText("Day 09");
                Wcursor = 160;
                break;
            case 10:
                show_day.setText("Day 10");
                Wcursor = 180;
                break;
        }

        String word_eng = wordList.get(Wcursor).english; // Day xx의 첫번째 단어 띄우기
        tv_english.setText(word_eng);

        String word_kor = wordList.get(Wcursor).korean; // Day xx의 첫번째 단어 띄우기
        tv_korean.setText(word_kor);

        // 첫 화면에 완료/미완료 조정
        changeCompleteView();

        /*
        // 체크박스 내 단어장에 추가
        cb_add_myword = findViewById(R.id.cb_add_myword);

        cb_add_myword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyWord_eng = elementaryList.get(Wcursor).english;
                MyWord_kor = elementaryList.get(Wcursor).korean;

                // 내단어장 배열 myword_num번째에 해당 단어 추가
                myword_elementaryList.get(myword_num).english = MyWord_eng;
                myword_elementaryList.get(myword_num).korean = MyWord_kor;
                myword_num++; // 내 단어장 하나 늘리기
            }
        }); */
    }

    // Load DataBase - elementary word
    private ArrayList<Word> init_Load_ElementaryDB() {
        DBHelper_ELE DBHelper_ELE = new DBHelper_ELE(getApplicationContext());
        DBHelper_ELE.OpenDatabaseFile();

        ArrayList<Word> wordList =  DBHelper_ELE.getTableData();
        Log.e("test", String.valueOf(wordList.size()));

        DBHelper_ELE.close();
        return wordList;
    }

    // Load DataBase - middle word
    private ArrayList<Word> init_Load_MiddleDB() {
        DBHelper_MID DBHelper_MID = new DBHelper_MID(getApplicationContext());
        DBHelper_MID.OpenDatabaseFile();

        ArrayList<Word> wordList =  DBHelper_MID.getTableData();
        Log.e("test", String.valueOf(wordList.size()));

        DBHelper_MID.close();
        return wordList;
    }

    // Load DataBase - sat word
    private ArrayList<Word> init_Load_SAT_DB() {
        DBHelper_SAT DBHelper_SAT = new DBHelper_SAT(getApplicationContext());
        DBHelper_SAT.OpenDatabaseFile();

        ArrayList<Word> wordList =  DBHelper_SAT.getTableData();
        Log.e("test", String.valueOf(wordList.size()));

        DBHelper_SAT.close();
        return wordList;
    }

    // Load DataBase - TOEIC word
    private ArrayList<Word> init_Load_TOEIC_DB() {
        DBHelper_TOEIC DBHelper_TOEIC = new DBHelper_TOEIC(getApplicationContext());
        DBHelper_TOEIC.OpenDatabaseFile();

        ArrayList<Word> wordList =  DBHelper_TOEIC.getTableData();
        Log.e("test", String.valueOf(wordList.size()));

        DBHelper_TOEIC.close();
        return wordList;
    }

    // Load DataBase - TRAVEL word
    private ArrayList<Word> init_Load_TRAVEL_DB() {
        DBHelper_TRAVEL DBHelper_TRAVEL = new DBHelper_TRAVEL(getApplicationContext());
        DBHelper_TRAVEL.OpenDatabaseFile();

        ArrayList<Word> wordList =  DBHelper_TRAVEL.getTableData();
        Log.e("test", String.valueOf(wordList.size()));

        DBHelper_TRAVEL.close();
        return wordList;
    }

    // Load DataBase - BUSINESS word
    private ArrayList<Word> init_Load_BUSINESS_DB() {
        DBHelper_BUSINESS DBHelper_BUSINESS = new DBHelper_BUSINESS(getApplicationContext());
        DBHelper_BUSINESS.OpenDatabaseFile();

        ArrayList<Word> wordList =  DBHelper_BUSINESS.getTableData();
        Log.e("test", String.valueOf(wordList.size()));

        DBHelper_BUSINESS.close();
        return wordList;
    }

    public void onBtnCompleteCliked(View view){
        //Elementary ele = new Elementary();

        switch (view.getId()){
            case R.id.btn_complete:
                // 미완료 -> 완료
                if( Start_App.complete[Wcursor] !=0){ // 현재 암기 미완료 상태이므로 누르면 암기 완료 상태로
                    Start_App.complete[Wcursor] = 0;
                    //DBHelper.DATABASE_VERSION++;
                    changeCompleteView();
                }
                else{ // 완료 -> 미완료
                    Start_App.complete[Wcursor] = Wcursor+1; // 다시 원래 _id값 넣기
                    //DBHelper.DATABASE_VERSION++;
                    //complete[Wcursor] = Wcursor+1;
                    changeCompleteView();
                }
                break;
        }
    }

    // btn_next 클릭 시 다음 단어로 넘어가기
    public void onBtnNextClicked(View view){
        // 현재 단어 개수 증가 2/20, 3/20 ...
        ++index;
        ++Wcursor;

        // 다음 단어 볼 떄 암기 완료/미완료 상태 띄우기
        changeCompleteView();

        // 20개 넘었으면 Day 하나 학습 종료 창으로 넘어가기
        if(index == 21){
            Intent intent = new Intent(getApplicationContext(), Memorize_3_4.class);
            startActivity(intent);
            return; // 현재 액티비티 끝내기
        }

        tv_word_num = findViewById(R.id.word_num);
        tv_word_num.setText(String.valueOf(index));

        // 다음 단어 띄우기
        tv_english = findViewById(R.id.tv_word_eng);
        tv_korean = findViewById(R.id.tv_word_kor);

        // Day xx에 따라 위에서 초기화한 WCursor번째의 데이터 가져오기
        String word_eng = wordList.get(Wcursor).english;
        tv_english.setText(word_eng);

        String word_kor = wordList.get(Wcursor).korean;
        tv_korean.setText(word_kor);
    }
    // btn_prev 클릭 시 이전 단어로 돌아가기
    public void onBtnPrevClicked(View view){
        --index; // 이전 번호
        --Wcursor; // 이전 단어띄우기

        // 다음 단어 볼 떄 암기 완료/미완료 상태 띄우기
        changeCompleteView();

        /*  클릭해야 바뀌니까 클릭안해도 바뀌게해야함
        /*
        // Day별 첫 화면에는 이전 버튼 비활성화
        Button btn_prev = findViewById(R.id.btn_prev);
        if (Wcursor%10 == 0) // 10으로 나눈 나머지가 0이면 이전버튼 비활성화 0 , 20 , 30...
            btn_prev.setVisibility(View.INVISIBLE);
            //btn_prev.setEnabled(false);
        else btn_prev.setVisibility(View.VISIBLE);//btn_prev.setEnabled(true)*/

        // 텍스트뷰 띄우기
        tv_word_num = findViewById(R.id.word_num);
        tv_word_num.setText(String.valueOf(index));

        tv_english = findViewById(R.id.tv_word_eng);
        tv_korean = findViewById(R.id.tv_word_kor);

        // WCursor번째의 데이터 가져오기
        String word_eng = wordList.get(Wcursor).english;
        tv_english.setText(word_eng);

        String word_kor = wordList.get(Wcursor).korean;
        tv_korean.setText(word_kor);
    }

    // (한글/영어 전환)Button 누르면 뷰 전환
    public void onBtnChangeClicked(View view){
        changeView();
    }
    private void changeView(){
        if(show_eng_or_kor == 0){
            tv_english.setVisibility(View.VISIBLE);
            tv_korean.setVisibility(View.INVISIBLE);
            show_eng_or_kor = 1;
        }
        else if(show_eng_or_kor == 1){
            tv_english.setVisibility(View.INVISIBLE);
            tv_korean.setVisibility(View.VISIBLE);
            show_eng_or_kor = 0;
        }
    }
    // 단어 완료/미완료 --> 그냥 id가 0이면 visibility 체크완료버튼으로 바꾸고 0이 아니면 기본버튼 뜨게
    private void changeCompleteView() {
        tv_complete = findViewById(R.id.tv_complete);
        iv_complete = findViewById(R.id.btn_complete);

        if (Start_App.complete[Wcursor] == 0 ) { // 암기 완료
            tv_complete.setText(" 암기 완료");
            iv_complete.setImageResource(R.drawable.ischecked);

        } else { // 암기 미완료
            tv_complete.setText(" 암기 미완료");
            iv_complete.setImageResource(R.drawable.isnotchecked);
        }
    }
}