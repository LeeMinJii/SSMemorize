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

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_game4_main,container,false);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.game1:
                getActivity().startActivity(new Intent(getActivity(), Game_4_1.class));
                break;
            case R.id.game2:
                getActivity().startActivity(new Intent(getActivity(), Game_4_1.class));
                break;
            case R.id.game3:
                getActivity().startActivity(new Intent(getActivity(), Game_4_1.class));
                break;
        }
    }
}