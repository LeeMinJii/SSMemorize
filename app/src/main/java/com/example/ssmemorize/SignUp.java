package com.example.ssmemorize;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ssmemorize.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.sign_up_check).setOnClickListener(onClickListener);
        findViewById(R.id.duplication).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sign_up_check:
                    user_signUp();
                    break;
                case R.id.duplication:
                    duplication_check();
                    break;
            }
        }
    };



    private void duplication_check() {
        String email = ((EditText) findViewById(R.id.user_email)).getText().toString();

        String e_mailPattern = "^[a-zA-Z0-9]+@[a-zA-Z0-9.]+$"; // 이메일 형식 패턴
        if (!Pattern.matches(e_mailPattern, email)) {
            Toast.makeText(SignUp.this, "이메일 형식을 확인해주세요", Toast.LENGTH_LONG).show();
            return;
        }



    }


    private void user_signUp() {
        String name = ((EditText) findViewById(R.id.user_name)).getText().toString();
        String email = ((EditText) findViewById(R.id.user_email)).getText().toString();
        String password = ((EditText) findViewById(R.id.user_password)).getText().toString();
        String passwordCheck = ((EditText) findViewById(R.id.user_password_check)).getText().toString();


        if (password.length() < 8 || passwordCheck.length() < 8) { // 최소 비밀번호 사이즈를 맞추기 위해서
            Toast.makeText(this, "비밀번호는 최소 8자리 이상입니다", Toast.LENGTH_SHORT).show();
            return;
        }


        if (name.length() > 0 && email.length() > 0 && password.length() > 0 && passwordCheck.length() > 0) {
            if (password.equals(passwordCheck)) {


                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "회원가입 성공 !", Toast.LENGTH_SHORT).show();
                        } else {
                            if (task.getException().toString() != null) {
                                Toast.makeText(SignUp.this, "이미 가입된 이메일입니다. 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            } else {
                Toast.makeText(SignUp.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(SignUp.this, "이메일과 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
        }
    }

    /*
    // 타이틀바 없애기
    ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


    // 뒤로 가기 버튼
    ImageButton btn_back = findViewById(R.id.btn_back);
    btn_back.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View view){
            finish();
        }
    });

     */
}