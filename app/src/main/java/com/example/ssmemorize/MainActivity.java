package com.example.ssmemorize;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TabHost;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Memorize_3_main memorize_main;
    private Game_4_main game_main;
    private MyPage_5_main mypage_main;

    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 타이틀바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        NavigationBarView navigationView = findViewById(R.id.navigationView);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.word_study:
                        setFrag(0);
                        break;
                    case R.id.word_game:
                        setFrag(1);
                        break;
                    case R.id.mypage:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });

    }

    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.frameLayout,memorize_main);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.frameLayout,game_main);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.frameLayout,mypage_main);
                ft.commit();
                break;
        }
    }
}