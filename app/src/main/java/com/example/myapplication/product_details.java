package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class product_details extends AppCompatActivity implements View.OnClickListener {
    TextView tvProdName, tvProdPrice, tvProdDes, tvProdQuantity;
    ImageView ivPlus, ivMinus, ivProductPic;
    EditText etProdQuan;
    Button btnProdDesBuy;
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        btnProdDesBuy = (Button) findViewById(R.id.btnProdDesBuy);
        tvProdName = (TextView) findViewById(R.id.tvProdName);
        tvProdPrice = (TextView) findViewById(R.id.tvProdPrice);
        tvProdDes = (TextView) findViewById(R.id.tvProdDes);
        tvProdQuantity = (TextView) findViewById(R.id.tvProdQuantity);
        ivPlus = (ImageView) findViewById(R.id.ivPlus);
        ivMinus = (ImageView) findViewById(R.id.ivMinus);
        ivProductPic = (ImageView) findViewById(R.id.ivProductPic);
        etProdQuan = (EditText) findViewById(R.id.etProdQuan);

        prodPicUpdate(ivProductPic);
        prodNameUpdate(tvProdName);
        prodPriceUpdate(tvProdPrice);
        prodDesUpdate(tvProdDes);

        btnProdDesBuy.setOnClickListener(this);
        ivPlus.setOnClickListener(this);
        ivMinus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivPlus:
                quantity++;
                displayQuan();
                break;
            case R.id.ivMinus:
                if (quantity < 1) {
                    Toast.makeText(product_details.this, "Can't decrease less than 1", Toast.LENGTH_SHORT).show();
                } else {
                   --quantity;
                    displayQuan();
                }
                break;
            case R.id.btnProdDesBuy:
                Intent intent = new Intent(this, Shipping.class);
                Bundle bundle = getIntent().getExtras();
                int res_image = bundle.getInt("productPic");
                intent.putExtra("prodShipPic", res_image);
                intent.putExtra("prodShipPrice", tvProdPrice.getText().toString());
                intent.putExtra("prodShipQuan", tvProdQuantity.getText().toString());
                intent.putExtra("prodShipProdName", tvProdName.getText().toString().trim());
                startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }

    private void displayQuan() {
        tvProdQuantity.setText(String.valueOf(quantity));
    }

    public void prodPicUpdate(ImageView ivProductPic) {
        Bundle bundle = getIntent().getExtras();
        int res_image = bundle.getInt("productPic");
        ivProductPic.setImageResource(res_image);
    }

    public void prodNameUpdate(TextView tvProdName) {
        String strProdName = getIntent().getStringExtra("productName");
        tvProdName.setText(strProdName);
    }

    public void prodPriceUpdate(TextView tvProdPrice) {
        String strProdPrice = getIntent().getStringExtra("productPrice");
        tvProdPrice.setText(strProdPrice);
    }

    public void prodDesUpdate(TextView tvProdDes) {
        String strProdDes = getIntent().getStringExtra("description");
        tvProdDes.setText(strProdDes);
    }
}