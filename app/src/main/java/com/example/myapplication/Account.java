package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Account extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        bottomNavigationView.postDelayed(() -> {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.home) {
                startActivity(new Intent(this, Homepage.class));
                overridePendingTransition(0, 0);
            } else if (itemId == R.id.orders) {
                startActivity(new Intent(this, Orders.class));
                overridePendingTransition(0, 0);
            } else if (itemId == R.id.account) {
                startActivity(new Intent(this, Account.class));
                overridePendingTransition(0, 0);
            }
            finish();
        }, 300);
        return true;
    }
}