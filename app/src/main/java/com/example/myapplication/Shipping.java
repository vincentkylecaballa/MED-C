package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Shipping extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private DrawerLayout drawerLayout;
    private ImageView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        menu = findViewById(R.id.navImage);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationMenu();
    }

    private void navigationMenu() {
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.openDrawer(GravityCompat.START);
                } else {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        bottomNavigationView.postDelayed(() -> {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.home) {
                startActivity(new Intent(this, Homepage.class));
                overridePendingTransition(0, 0);
            } else if (itemId == R.id.addtoCart) {
                startActivity(new Intent(this, AddToCart.class));
                overridePendingTransition(0, 0);
            } else if (itemId == R.id.shipping) {
                startActivity(new Intent(this, Shipping.class));
                overridePendingTransition(0, 0);
            }
            finish();
        }, 300);
        return true;
    }
}