package com.vu.assessment_4669025_4669026;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vu.assessment_4669025_4669026.data.DBHelper;

public class CheckCarActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCheckPrice,btnBack;

    EditText etBrand,etModel,etPrice;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkcar);

        etBrand=(EditText) findViewById(R.id.etCarBrand);
        etModel=(EditText) findViewById(R.id.etCarModel);
        etPrice=(EditText) findViewById(R.id.etCarPrice);

        btnCheckPrice= (Button) findViewById(R.id.button3);
        btnBack= (Button) findViewById(R.id.btnBack);

        btnCheckPrice.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        if (id==R.id.button3){
            viewPrice();
        }
        if (id==R.id.btnBack){
            goIntoMainPage();
        }
    }

    private void goIntoMainPage() {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void viewPrice() {
        String brand = etBrand.getText().toString().trim();
        String model = etModel.getText().toString().trim();

        if(brand.isEmpty() || model.isEmpty()){
            Toast.makeText(this,"Enter Both Brand & Price",Toast.LENGTH_LONG).show();
            return;
        }
        DBHelper dbHelper = new DBHelper(this);
        int price = dbHelper.checkPrice(brand,model);

        if(price == -1) {
            Toast.makeText(this, "Car not found", Toast.LENGTH_SHORT).show();
            etPrice.setText("");
        } else {
            etPrice.setText(String.valueOf(price));
        }
    }
}
