package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etEmail, etPass;
    private EditText etEmail_LogIn, etPass_LogIn;
    private Button regbutton;
    private Button loginbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etEmail_LogIn = findViewById(R.id.etEmail_LogIn);
        etPass_LogIn = findViewById(R.id.etPass_LogIn);

        regbutton = findViewById(R.id.registerBtn);
        regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });


        loginbutton = findViewById(R.id.loginBtn);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true) {
                    login();
                }
            }
        });

    }

    public boolean verifyLogIn() {
        String email = etEmail_LogIn.getText().toString().trim();
        String pass = etPass_LogIn.getText().toString().trim();
        if (!etEmail_LogIn.hasFocusable() && etPass_LogIn.hasFocusable()) {
            if (email.isEmpty()) {
                etEmail_LogIn.setError("Please enter your email");
                etEmail_LogIn.requestFocus();
                return false;
            }
//        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            etEmail_LogIn.setError("Please provide valid email");
//            etEmail_LogIn.requestFocus();
//            return false;
//        }

            if (pass.isEmpty()) {
                etPass_LogIn.setError("Please enter your password");
                etPass_LogIn.requestFocus();
                return false;
            }
            if (new User(email, pass).verifyUser()) {
                return true;
            }
            return false;
        }else{
            return false;
        }

    }

    private void register() {
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
    }

    private void login() { //temporary class for login
        Intent intent = new Intent(MainActivity.this, Homepage.class);
        startActivity(intent);
    }


}







