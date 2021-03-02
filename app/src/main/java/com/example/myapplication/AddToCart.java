package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.helperClasses.homeAdapter.OrderAdapter;
import com.example.myapplication.helperClasses.homeAdapter.OrderModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class AddToCart extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener  {

    private BottomNavigationView bottomNavigationView;
    ArrayList<OrderModel> listOfOrders;
    RecyclerView ordersView;
    RecyclerView.Adapter ordersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        listOfOrders = new ArrayList<>(); // declaration of arraylist

        ordersView = findViewById(R.id.orderView);

        ordersView.setHasFixedSize(true);
        ordersView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        listOfOrders.add(new OrderModel(R.drawable.hengde_faceshield2, "Heng De Face Shield", "100",
                "10"));
        listOfOrders.add(new OrderModel(R.drawable.hengde_faceshield2, "Heng De Face Shield", "100",
                "10"));
        listOfOrders.add(new OrderModel(R.drawable.hengde_faceshield2, "Heng De Face Shield", "100",
                "10"));
        listOfOrders.add(new OrderModel(R.drawable.hengde_faceshield2, "Heng De Face Shield", "100",
                "10"));

        ordersAdapter = new OrderAdapter(listOfOrders);
        ordersView.setAdapter(ordersAdapter);
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
                overridePendingTransition(0, 0 );
            } else if (itemId == R.id.shipping) {
                startActivity(new Intent(this, Account.class));
                overridePendingTransition(0, 0);
            }
            finish();
        }, 300);
        return true;
    }
}