package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {
    EditText fullName_reg, emailAddress_reg, password_reg, confirmPassword_reg;
    EditText fullName_input, emailAddress_input, password_input, confirmPassword_input;
    TextView hasAccount;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullName_input = findViewById(R.id.fullName_input);
        emailAddress_input = findViewById(R.id.emailAddress_input);
        password_input = findViewById(R.id.password_input);
        confirmPassword_input = findViewById(R.id.confirmPassword_input);

        hasAccount = findViewById(R.id.hasAccount);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true) {
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        hasAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private boolean registration() {
        String fullName = fullName_input.getText().toString().trim();
        String emailAddress = emailAddress_input.getText().toString().trim();
        String password = password_input.getText().toString().trim();
        String confirmPassword = confirmPassword_input.getText().toString().trim();
        if (!fullName_input.hasFocusable() && emailAddress_input.hasFocusable()
                && password_input.hasFocusable()&& confirmPassword_input.hasFocusable()) {

            if (fullName.isEmpty()) {
                fullName_input.setError("Full name is required");
                fullName_input.requestFocus();
                return false;
            }

            if (emailAddress.isEmpty()) {
                emailAddress_input.setError("Email is required");
                emailAddress_input.requestFocus();
                return false;
            }
//        if (Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()){
//            emailAddress_input.setError("Please provide valid email");
//            emailAddress_input.requestFocus();
//            return false;
//        }
            if (password.isEmpty()) {
                password_input.setError("Password is required");
                password_input.requestFocus();
                return false;
            }

            if (password.length() < 6) {
                password_input.setError("Min password length should be 6 characters");
                password_input.requestFocus();
                return false;

            }
            if (confirmPassword.isEmpty()) {
                confirmPassword_input.setError("Please confirm your password");
                confirmPassword_input.requestFocus();
                return false;
            }
            if (!password.equals(confirmPassword)) {
                confirmPassword_input.setError("Your password doesn't match");
                confirmPassword_input.requestFocus();
                return false;
            }


            User user = new User(emailAddress, confirmPassword);
            return true;

        }else {
            return false;
        }

    }

}
