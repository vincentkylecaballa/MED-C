package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

public class Shipping extends AppCompatActivity implements View.OnClickListener {

    private TextView tvShipProdTitle, tvShipPrice, tvShipQuan, tvShipTotal,
            tvBuyersName, tvBuyersEmail;
    private Button btnProceed;
    private DatabaseHelper orders_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);
        orders_db = new DatabaseHelper(this);

        tvShipProdTitle = (TextView) findViewById(R.id.tvShipProdTitle);
        tvShipPrice = (TextView) findViewById(R.id.tvShipPrice);
        tvShipQuan = (TextView) findViewById(R.id.tvShipQuan);
        tvShipTotal = (TextView) findViewById(R.id.tvShipTotal);
        tvBuyersName = (TextView) findViewById(R.id.tvBuyersName);
        tvBuyersEmail = (TextView) findViewById(R.id.tvBuyersEmail);
        btnProceed = (Button) findViewById(R.id.btnProceed);

        setTvBuyersName(tvBuyersName);
        setTvBuyersEmail(tvBuyersEmail);

        setTvShipPrice(tvShipPrice);
        setTvShipProdTitle(tvShipProdTitle);
        setTvShipQuan(tvShipQuan);
        setTvShipTotal(tvShipTotal);


        btnProceed.setOnClickListener(this);

    }

    private void setTvBuyersName(TextView tvBuyersName) {
        Cursor cursor = orders_db.getFullNameAndEmail();
        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                tvBuyersName.setText(cursor.getString(1));
            }
        }

    }

    private void setTvBuyersEmail(TextView tvBuyersEmail) {
        Cursor cursor = orders_db.getFullNameAndEmail();
        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                tvBuyersEmail.setText(cursor.getString(0));
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnProceed:
//                String strBuyersName = tvBuyersName.getText().toString().trim();
//                String strProdName = tvShipProdTitle.getText().toString().trim();
//                Bundle bundle = getIntent().getExtras();
//                int res_image = bundle.getInt("productPic");
//                double prodTotalPrice = Double.parseDouble(this.tvShipTotal.getText().toString().substring(1));
//                int prodQuan = Integer.parseInt(tvShipQuan.getText().toString().trim());
//                boolean ifInserted = orders_db.insertOrder(strBuyersName, strProdName, res_image, prodTotalPrice, prodQuan);
//                if (ifInserted){
//                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
//                }
                Intent intent = new Intent(getApplicationContext(), AddToCart.class);
//                intent.putExtra("buyersName", strBuyersName);
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
        double doubleTvShipPrice = Double.parseDouble(strTvShipTotal);
        double doubleTvQuan = Double.parseDouble(this.tvShipQuan.getText().toString().trim());
        double doubleTvTotal = doubleTvShipPrice * doubleTvQuan;
        tvShipTotal.setText("₱" + doubleTvTotal);
    }


}