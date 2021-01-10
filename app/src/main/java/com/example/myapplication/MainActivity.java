package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000;
    private Button regbutton;
    private Button loginbutton;
    private SpeechRecognizer speechRecognizer;
    private EditText searchBar;
    private ImageView voiceBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                login();
            }
        });

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
        != PackageManager.PERMISSION_GRANTED) {
            checkPermission();
        }

        searchBar = findViewById(R.id.text);
        voiceBtn = findViewById(R.id.voiceBtn);

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);

        final Intent speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

    }

    private void register() {
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
    }

    private void login() { //temporary class for login
        Intent intent = new Intent(MainActivity.this, Homepage.class);
        startActivity(intent);
    }

    private void checkPermission() {

    }

    public void onResults(Bundle bundle) {
        voiceBtn.setImageResource(R.drawable.ic_mic);
        ArrayList<String> data = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        searchBar.setText(0);
    }

    public void onBeginningOfSpeech() {
        searchBar.setText("");
        searchBar.setHint("Listening...");
    }

    

}







