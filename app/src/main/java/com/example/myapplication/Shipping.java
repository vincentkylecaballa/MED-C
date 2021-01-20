package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Shipping extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        bottomNavigationView.postDelayed(() -> {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.home) {
                startActivity(new Intent(this, Homepage.class));
            } else if (itemId == R.id.addtoCart) {
                startActivity(new Intent(this, AddToCart.class));
            } else if (itemId == R.id.shipping) {
                startActivity(new Intent(this, Shipping.class));
            }
            finish();
        }, 300);
        return true;
    }
}