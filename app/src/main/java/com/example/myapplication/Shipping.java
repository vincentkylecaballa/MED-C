package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

public class Shipping extends AppCompatActivity implements View.OnClickListener {

    private TextView tvShipProdTitle, tvShipPrice, tvShipQuan, tvShipTotal;
    private Button btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);


        tvShipProdTitle = (TextView) findViewById(R.id.tvShipProdTitle);
        tvShipPrice = (TextView) findViewById(R.id.tvShipPrice);
        tvShipQuan = (TextView) findViewById(R.id.tvShipQuan);
        tvShipTotal = (TextView) findViewById(R.id.tvShipTotal);
        btnProceed = (Button) findViewById(R.id.btnProceed);

        setTvShipPrice(tvShipPrice);
        setTvShipProdTitle(tvShipProdTitle);
        setTvShipQuan(tvShipQuan);
        setTvShipTotal(tvShipTotal);


        btnProceed.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnProceed:
                Intent intent = new Intent(getApplicationContext(), AddToCart.class);
                startActivity(intent);
                break;
        }
    }

    public void setTvShipPrice(TextView tvShipPrice) {
        String strTvShipPrice = getIntent().getStringExtra("prodShipPrice");
        tvShipPrice.setText(strTvShipPrice);

    }

    public void setTvShipQuan(TextView tvShipQuan) {
        String strTvShipQuan = getIntent().getStringExtra("prodShipQuan");
        tvShipQuan.setText(strTvShipQuan);
    }

    public void setTvShipProdTitle(TextView tvShipProdTitle) {
        String strTvShipProdTitle = getIntent().getStringExtra("prodShipProdName");
        tvShipProdTitle.setText(strTvShipProdTitle);
    }

    @SuppressLint("SetTextI18n")
    public void setTvShipTotal(TextView tvShipTotal) {
        String strTvShipTotal = this.tvShipPrice.getText().toString().substring(1);
        double doubleTvShipPrice= Double.parseDouble(strTvShipTotal);
        double doubleTvQuan = Double.parseDouble(this.tvShipQuan.getText().toString().trim());
        double doubleTvTotal = doubleTvShipPrice * doubleTvQuan;
        tvShipTotal.setText("₱" + doubleTvTotal);
    }


}