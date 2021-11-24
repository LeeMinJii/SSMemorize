package com.example.ssmemorize;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;

public class Start_App extends AppCompatActivity {

    Button btn_l = findViewById(R.id.btn_Login);
    Button btn_S = findViewById(R.id.btn_SignUp);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app);

    }
}