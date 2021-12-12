package com.example.ssmemorize;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

public class Game_4_main extends Fragment implements View.OnClickListener{

    public static int sig_gametype;
    public static int[] game_high_score = new int[2];  //게임 최고 점수 저장

    private View view;
    Button btn_game1;
    Button btn_game2;
    Button btn_game3;

    TextView game1_high_score;
    TextView game2_high_score;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_game4_main,container,false);

        btn_game1 = view.findViewById(R.id.game1);
        btn_game1.setOnClickListener(this);

        btn_game2 = view.findViewById(R.id.game2);
        btn_game2.setOnClickListener(this);

        btn_game3 = view.findViewById(R.id.game3);
        btn_game3.setOnClickListener(this);

        game1_high_score=view.findViewById(R.id.game1_high_score);
        game2_high_score=view.findViewById(R.id.game2_high_score);

        show_high_score();
        return view;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.game1:
                sig_gametype=1;
                getActivity().startActivity(new Intent(getActivity(), Game_4_1.class));
                break;
            case R.id.game2:
                sig_gametype=2;
                getActivity().startActivity(new Intent(getActivity(), Game_4_1.class));
                break;
            case R.id.game3:
                sig_gametype=3;
                getActivity().startActivity(new Intent(getActivity(), Game_4_1.class));
                break;
        }
    }

    //최고 점수 띄우기
    public void show_high_score(){
        int high_score1 = game_high_score[0];
        int high_score2 = game_high_score[1];

        game1_high_score.setText(" 최고기록 : "+high_score1);
        game2_high_score.setText(" 최고기록 : "+high_score2);
    }
}