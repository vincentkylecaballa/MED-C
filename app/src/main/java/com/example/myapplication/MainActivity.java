package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout etEmail, etPass;
    private EditText etEmail_LogIn, etPass_LogIn;
    private Button regbutton;
    private Button loginbutton;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);

        etEmail_LogIn = findViewById(R.id.etEmail_LogIn);
        etPass_LogIn = findViewById(R.id.etPass_LogIn);

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);

        regbutton = findViewById(R.id.registerBtn);
        regbutton.setOnClickListener(this);


        loginbutton = findViewById(R.id.loginBtn);
        loginbutton.setOnClickListener(this);

    }
//
//    public boolean verifyLogIn() {
//        String email = etEmail_LogIn.getText().toString().trim();
//        String pass = etPass_LogIn.getText().toString().trim();
//        if (!etEmail_LogIn.hasFocusable() && etPass_LogIn.hasFocusable()) {
//            if (email.isEmpty()) {
//                etEmail_LogIn.setError("Please enter your email");
//                etEmail_LogIn.requestFocus();
//                return false;
//            }
////        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
////            etEmail_LogIn.setError("Please provide valid email");
////            etEmail_LogIn.requestFocus();
//
////        }
//
//            if (pass.isEmpty()) {
//                etPass_LogIn.setError("Please enter your password");
//                etPass_LogIn.requestFocus();
//                return false;
//            }
//
//            return false;
//        } else {
//            return false;
//        }
//
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerBtn:
                startActivity(new Intent(MainActivity.this, Register.class));
                break;
            case R.id.loginBtn:

                String email = etEmail_LogIn.getText().toString().trim();
                String pass = etPass_LogIn.getText().toString().trim();
                if (email.equals("") || pass.equals("")) {
                    if (email.isEmpty()) {
                        etEmail.setError("Please enter your email");
                        etEmail.setErrorEnabled(true);
                    }
                    if (pass.isEmpty()) {
                        etPass.setError("Please enter your password");
                        etEmail.setErrorEnabled(true);
                    }
                    if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        etEmail.setError("Please provide valid email");
                        etEmail.setErrorEnabled(true);
                    }
                } else {
                    Boolean checkUserPass = db.checkUsernamePassword(email, pass);
                    if (checkUserPass == true) {
                        Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Homepage.class));
                    } else {
                       etPass.setError("Invalid Email or Password");
                       etEmail.setError("");
                       etEmail.setErrorEnabled(true);
                    }

                }
                break;
        }
    }
}







