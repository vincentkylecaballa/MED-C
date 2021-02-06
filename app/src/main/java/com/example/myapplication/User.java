package com.example.myapplication;

import java.util.ArrayList;

public class User extends Register{

    ArrayList<String> listEmail, listPassword;
    String email, pass;

     User(String email, String password){
        this.listEmail.add(email);
        this.listPassword.add(password);
    }

    public void searchUser(){
        email = emailAddress_input.getText().toString().trim();
        pass = password_input.getText().toString().trim();
        for (int i = 0 ; i < listEmail.size() ; i++){
            if (email.equals(listEmail.get(i))){
                email = listEmail.get(i);
                break;
            }
        }
        for (int i = 0 ; i < listPassword.size() ; i++){
            if (pass.equals(listPassword.get(i))){
                pass = listEmail.get(i);
                break;
            }
        }
    }
    public boolean verifyUser(){
        email = emailAddress_input.getText().toString().trim();
        pass = password_input.getText().toString().trim();
        for (int i = 0 ; i < listEmail.size() ; i++){
            if (email.equals(listEmail.get(i))){
                email = listEmail.get(i);
                return true;
            }
        }
        for (int i = 0 ; i < listPassword.size() ; i++){
            if (pass.equals(listPassword.get(i))){
                pass = listEmail.get(i);
                return true;
            }
        }

        return false;
    }
}
