package com.vu.assessment_4669025_4669026;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddCarActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAddCar,btnBack;
    EditText edCarBrand,edCarModel,edCarPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcar);

        btnAddCar= (Button) findViewById(R.id.btnAddCar);
        btnBack= (Button) findViewById(R.id.btnBack);

        edCarBrand=(EditText) findViewById(edCarBrand)
        edCarModel=(EditText) findViewById(edCarModel)
        edCarPrice=(EditText) findViewById(edCarPrice)

        btnAddCar.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        if (id==R.id.btnAddCar){
            addCar();
        }
        if (id==R.id.btnBack){
            goIntoMainPage();
        }
    }

    private void goIntoMainPage() {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void addCar() {
        String brand = edCarBrand.getText().toString();
        String model = edCarModel.getText().toString();
        String price = edCarPrice.getText().toString();

        boolean
    }
}
