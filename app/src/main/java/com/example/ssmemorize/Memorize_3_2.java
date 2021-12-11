package com.example.ssmemorize;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class Memorize_3_2 extends AppCompatActivity implements View.OnClickListener {
    TextView tv_word_type;

    public static int flag_Day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorize32);

        // 체크버튼 바꾸기
        int check=0;
        ImageView imageView1 = findViewById(R.id.img_check1);
        ImageView imageView2 = findViewById(R.id.img_check2);
        ImageView imageView3 = findViewById(R.id.img_check3);
        ImageView imageView4 = findViewById(R.id.img_check4);
        ImageView imageView5 = findViewById(R.id.img_check5);
        ImageView imageView6 = findViewById(R.id.img_check6);
        ImageView imageView7 = findViewById(R.id.img_check7);
        ImageView imageView8 = findViewById(R.id.img_check8);
        ImageView imageView9 = findViewById(R.id.img_check9);
        ImageView imageView10 = findViewById(R.id.img_check10);

        int[] memorize = new int[10]; // Day별 암기 완료 여부
        int k=0;

        // Day 1-10까지 각 20개의 단어의 암기 완료 여부 체크 -> memorize배열에 넣기
        for (int i = 0; i <= 180; i+=20){
            for (int j=0; j<20; j++){
                if (Start_App.complete[j+i]==0)
                    check++;
            }
            if (check==20) {
                memorize[k]=0; // 20개 다 암기완료면 0넣기
                k++;
                check = 0;
            }
            else {
                memorize[k]=1;
                k++;
                check = 0;
            }
        }

        // Day별 암기 완료 여부에 따라 체크 버튼 색 띄우기
        if (memorize[0]==0)
            imageView1.setImageResource(R.drawable.check_blue); // 파란 체크로 변경
        else imageView1.setImageResource(R.drawable.check); // 20이 안되는 경우 회색체크 띄우기

        if (memorize[1]==0)
            imageView2.setImageResource(R.drawable.check_blue); // 파란 체크로 변경
        else imageView2.setImageResource(R.drawable.check); // 20이 안되는 경우 회색체크 띄우기

        if (memorize[2]==0)
            imageView3.setImageResource(R.drawable.check_blue); // 파란 체크로 변경
        else imageView3.setImageResource(R.drawable.check); // 20이 안되는 경우 회색체크 띄우기

        if (memorize[3]==0)
            imageView4.setImageResource(R.drawable.check_blue); // 파란 체크로 변경
        else imageView4.setImageResource(R.drawable.check); // 20이 안되는 경우 회색체크 띄우기

        if (memorize[4]==0)
            imageView5.setImageResource(R.drawable.check_blue); // 파란 체크로 변경
        else imageView5.setImageResource(R.drawable.check); // 20이 안되는 경우 회색체크 띄우기

        if (memorize[5]==0)
            imageView6.setImageResource(R.drawable.check_blue); // 파란 체크로 변경
        else imageView6.setImageResource(R.drawable.check); // 20이 안되는 경우 회색체크 띄우기

        if (memorize[6]==0)
            imageView7.setImageResource(R.drawable.check_blue); // 파란 체크로 변경
        else imageView7.setImageResource(R.drawable.check); // 20이 안되는 경우 회색체크 띄우기

        if (memorize[7]==0)
            imageView8.setImageResource(R.drawable.check_blue); // 파란 체크로 변경
        else imageView8.setImageResource(R.drawable.check); // 20이 안되는 경우 회색체크 띄우기

        if (memorize[8]==0)
            imageView9.setImageResource(R.drawable.check_blue); // 파란 체크로 변경
        else imageView9.setImageResource(R.drawable.check); // 20이 안되는 경우 회색체크 띄우기

        if (memorize[9]==0)
            imageView10.setImageResource(R.drawable.check_blue); // 파란 체크로 변경
        else imageView10.setImageResource(R.drawable.check); // 20이 안되는 경우 회색체크 띄우기


        // 뒤로 가기 버튼
        ImageButton btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // start버튼
        Button btn_start_study1 = findViewById(R.id.btn_start_study1);
        btn_start_study1.setOnClickListener(this);
        Button btn_start_study2 = findViewById(R.id.btn_start_study2);
        btn_start_study2.setOnClickListener(this);
        Button btn_start_study3 = findViewById(R.id.btn_start_study3);
        btn_start_study3.setOnClickListener(this);
        Button btn_start_study4 = findViewById(R.id.btn_start_study4);
        btn_start_study4.setOnClickListener(this);
        Button btn_start_study5 = findViewById(R.id.btn_start_study5);
        btn_start_study5.setOnClickListener(this);
        Button btn_start_study6 = findViewById(R.id.btn_start_study6);
        btn_start_study6.setOnClickListener(this);
        Button btn_start_study7 = findViewById(R.id.btn_start_study7);
        btn_start_study7.setOnClickListener(this);
        Button btn_start_study8 = findViewById(R.id.btn_start_study8);
        btn_start_study8.setOnClickListener(this);
        Button btn_start_study9 = findViewById(R.id.btn_start_study9);
        btn_start_study9.setOnClickListener(this);
        Button btn_start_study10 = findViewById(R.id.btn_start_study10);
        btn_start_study10.setOnClickListener(this);

        // reset버튼
        Button reset1 = findViewById(R.id.reset1);
        reset1.setOnClickListener(this);
        Button reset2 = findViewById(R.id.reset2);
        reset2.setOnClickListener(this);
        Button reset3 = findViewById(R.id.reset3);
        reset3.setOnClickListener(this);
        Button reset4 = findViewById(R.id.reset4);
        reset4.setOnClickListener(this);
        Button reset5 = findViewById(R.id.reset5);
        reset5.setOnClickListener(this);
        Button reset6 = findViewById(R.id.reset6);
        reset6.setOnClickListener(this);
        Button reset7 = findViewById(R.id.reset7);
        reset7.setOnClickListener(this);
        Button reset8 = findViewById(R.id.reset8);
        reset8.setOnClickListener(this);
        Button reset9 = findViewById(R.id.reset9);
        reset9.setOnClickListener(this);
        Button reset10 = findViewById(R.id.reset10);
        reset10.setOnClickListener(this);

        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // 단어 암기 유형 텍스트뷰 띄우기
        tv_word_type = findViewById(R.id.tv_wordtype32);
        switch (Memorize_3_main.flag_wordtype){
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

    int start=0; // start버튼의 flay_에 따라 단어 조회 시작 번호 (flag_Day=2면 start +=20)
    boolean flag_reset=false;
    // start 버튼 클릭 시 Day xx 텍스트뷰  flag 주기, 화면전환
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Memorize_3_3.class);
        switch (view.getId()) {
            case R.id.btn_start_study1:
                flag_Day = 1;
                startActivity(intent);
                break;
            case R.id.btn_start_study2:
                flag_Day = 2;
                start = 20;
                startActivity(intent);
                break;
            case R.id.btn_start_study3:
                flag_Day = 3;
                start = 40;
                startActivity(intent);
                break;
            case R.id.btn_start_study4:
                flag_Day = 4;
                start = 60;
                startActivity(intent);
                break;
            case R.id.btn_start_study5:
                flag_Day = 5;
                start = 80;
                startActivity(intent);
                break;
            case R.id.btn_start_study6:
                flag_Day = 6;
                start = 100;
                startActivity(intent);
                break;
            case R.id.btn_start_study7:
                flag_Day = 7;
                start = 120;
                startActivity(intent);
                break;
            case R.id.btn_start_study8:
                flag_Day = 8;
                start = 140;
                startActivity(intent);
                break;
            case R.id.btn_start_study9:
                flag_Day = 9;
                start = 160;
                startActivity(intent);
                break;
            case R.id.btn_start_study10:
                flag_Day = 10;
                start = 180;
                startActivity(intent);
                break;
            case R.id.reset1:
            case R.id.reset2:
            case R.id.reset3:
            case R.id.reset4:
            case R.id.reset5:
            case R.id.reset6:
            case R.id.reset7:
            case R.id.reset8:
            case R.id.reset9:
            case R.id.reset10:
                flag_reset = true;
                break;
        }
        // reset버튼 누르면 암기 완료 여부 complete 배열 초기와
        if (flag_reset == true)
            for (int i=0; i<200; i++) {
                Start_App.complete[i] = i + 1;
            }
    }
}