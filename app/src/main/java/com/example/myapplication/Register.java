package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity  implements View.OnClickListener{
    EditText fullName_reg, emailAddress_reg, password_reg, confirmPassword_reg;
    EditText fullName_input, emailAddress_input, password_input, confirmPassword_input;
    TextView hasAccount;
    Button btnRegister;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        fullName_input = findViewById(R.id.fullName_input);
        emailAddress_input = findViewById(R.id.emailAddress_input);
        password_input = findViewById(R.id.password_input);
        confirmPassword_input = findViewById(R.id.confirmPassword_input);

        hasAccount = findViewById(R.id.hasAccount);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(this);

        hasAccount.setOnClickListener(this);
    }


    private boolean registration() {
        String fullName = fullName_input.getText().toString().trim();
        String emailAddress = emailAddress_input.getText().toString().trim();
        String password = password_input.getText().toString().trim();
        String confirmPassword = confirmPassword_input.getText().toString().trim();
        if (!fullName_input.hasFocusable() || emailAddress_input.hasFocusable()
                || password_input.hasFocusable()|| confirmPassword_input.hasFocusable()) {
            return true;
        }else {
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
            if (Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
                emailAddress_input.setError("Please provide valid email");
                emailAddress_input.requestFocus();
                return false;
            }
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
            return false;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.hasAccount:
                startActivity(new Intent(Register.this, MainActivity.class));
                break;
            case  R.id.btnRegister:
                String fullName = fullName_input.getText().toString().trim();
                String emailAddress = emailAddress_input.getText().toString().trim();
                String password = password_input.getText().toString().trim();
                String confirmPassword = confirmPassword_input.getText().toString().trim();

                if (fullName.equals("") || emailAddress.equals("") || password.equals("")
                        || confirmPassword.equals("")) {
                }else{
                    if (password.equals(confirmPassword) && registration()){
                        Boolean checkUser = db.checkUsername(emailAddress);
                        if (checkUser == false){
                            Boolean insertData =  db.insertUser(emailAddress, fullName ,password);
                            if (insertData == true){
                                Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Register.this, Homepage.class));
                            }else{
                                Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_SHORT).show();

                            }
                        }else{
                            Toast.makeText(Register.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Register.this, "Password does not matched", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
}
