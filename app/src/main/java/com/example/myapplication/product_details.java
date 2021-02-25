package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class product_details extends AppCompatActivity implements View.OnClickListener {
    TextView tvProdName,tvProdPrice,tvProdDes;
    ImageView ivPlus,ivMinus, ivProductPic;
    EditText etProdQuan;
    Button btnProdDesBuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        btnProdDesBuy = (Button)findViewById(R.id.btnProdDesBuy);
        tvProdName = (TextView)findViewById(R.id.tvProdName);
        tvProdPrice = (TextView)findViewById(R.id.tvProdPrice);
        tvProdDes = (TextView)findViewById(R.id.tvProdDes);
        ivPlus = (ImageView)findViewById(R.id.ivPlus);
        ivMinus = (ImageView)findViewById(R.id.ivMinus);
        ivProductPic = (ImageView)findViewById(R.id.ivProductPic);
        etProdQuan = (EditText)findViewById(R.id.etProdQuan);


        prodPicUpdate(ivProductPic);
        prodNameUpdate(tvProdName);
        prodPriceUpdate(tvProdPrice);
        prodDesUpdate(tvProdDes);
    }

    @Override
    public void onClick(View v) {
        String strQuan = etProdQuan.toString().trim();
        int intQuan = Integer.parseInt(strQuan);
        switch (v.getId()){
            case R.id.ivPlus:
                try {
                    intQuan++;
                    strQuan = Integer.toString(intQuan);
                    this.etProdQuan.setText(strQuan);
                }catch (Exception e){
                }
                break;
            case R.id.ivMinus:
                try {
                    if (intQuan <= 1){
                        intQuan = 1;
                        strQuan = Integer.toString(intQuan);
                        this.etProdQuan.setText(strQuan);
                    }else{
                        intQuan--;
                    }
                }catch (Exception e){
                }
                break;
            case R.id.btnProdDesBuy:
                Intent intent =new Intent(product_details.this, Shipping.class);
                startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
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
        String strProdPrice = getIntent().getStringExtra("productName");
        tvProdPrice.setText(strProdPrice);
    }
    public void prodDesUpdate(TextView tvProdDes) {
        String strProdDes = getIntent().getStringExtra("productPrice");
        tvProdDes.setText(strProdDes);
    }
}