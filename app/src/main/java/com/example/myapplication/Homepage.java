package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.helperClasses.homeAdapter.FeaturedAdapter;
import com.example.myapplication.helperClasses.homeAdapter.FeaturedHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class Homepage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final int REQUEST_CODE_SPEECH_INPUT = 1;
    private EditText searchProduct;
    private CircleImageView profilePic;
    RecyclerView ProductsView;
    RecyclerView.Adapter adapter;
    private ImageView menu;
    private DrawerLayout drawerLayout;
    private BottomNavigationView bottomNavigationView;

    @SuppressLint("CutPasteId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        searchProduct = findViewById(R.id.searchBar);
        ImageView voiceAst = findViewById(R.id.micButton);

        voiceAst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });

        ProductsView = findViewById(R.id.productsView);
        ProductsView();

        menu = findViewById(R.id.navImage);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationMenu();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem menuItem) {
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


    private void ProductsView() {

        ProductsView.setHasFixedSize(true);
        ProductsView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<FeaturedHelper> featuredLocation = new ArrayList<>();

        featuredLocation.add(new FeaturedHelper(R.drawable.hengde_faceshield2, R.drawable.ic_baseline_add_shopping_cart,
                "Heng De Face Shield", "Comes with individual box packaging. Plastic film for the acetate is " +
                "included to prevent scratches. ", "₱10.00"));
        featuredLocation.add(new FeaturedHelper(R.drawable.hengde_faceshield2, R.drawable.ic_baseline_add_shopping_cart,
                "Heng De Face Shield", "Comes with individual box packaging. Plastic film for the acetate is " +
                "included to prevent scratches. ", "₱10.00"));
        featuredLocation.add(new FeaturedHelper(R.drawable.hengde_faceshield2, R.drawable.ic_baseline_add_shopping_cart,
                "Heng De Face Shield", "Comes with individual box packaging. Plastic film for the acetate is " +
                "included to prevent scratches. ", "₱10.00"));

        adapter = new FeaturedAdapter(featuredLocation);
        ProductsView.setAdapter(adapter);

    }

    private void speak() {
        //intent to show speak dialog
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi, speak something");

        //start intent
        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if (requestCode == REQUEST_CODE_SPEECH_INPUT) {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    searchProduct.setText(result.get(0));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
