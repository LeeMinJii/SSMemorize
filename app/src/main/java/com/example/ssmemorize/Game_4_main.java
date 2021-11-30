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

public class Game_4_main extends Fragment implements View.OnClickListener{

    public static int sig_gametype;

    private View view;
    Button btn_game1;
    Button btn_game2;
    Button btn_game3;

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
}