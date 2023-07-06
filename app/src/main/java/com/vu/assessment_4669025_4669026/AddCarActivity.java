package com.vu.assessment_4669025_4669026;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vu.assessment_4669025_4669026.data.DBHelper;

public class AddCarActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAddCar,btnBack;
    EditText etCarBrand,etCarModel,etCarPrice;

    DBHelper databasehelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcar);

        btnAddCar= (Button) findViewById(R.id.btnAddCar);
        btnBack= (Button) findViewById(R.id.btnBack);

        etCarBrand= findViewById(R.id.etCarBrand);
        etCarModel= findViewById(R.id.etCarModel);
        etCarPrice= findViewById(R.id.etCarPrice);

        btnAddCar.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        databasehelper = new DBHelper(this);
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
        String brand = etCarBrand.getText().toString();
        String model = etCarModel.getText().toString();
        String price = etCarPrice.getText().toString();

        if(brand.isEmpty() || model.isEmpty() || price.isEmpty()) {
            Toast.makeText(AddCarActivity.this, "Enter values to all inputs", Toast.LENGTH_LONG).show();
        } else {
            boolean isInserted = databasehelper.addCar(brand, model, Integer.parseInt(price));

            if(isInserted) {
                Toast.makeText(AddCarActivity.this, "Data inserted successfully", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(AddCarActivity.this, "Data insert failed", Toast.LENGTH_LONG).show();
            }
        }

      /* boolean isInserted = databasehelper.addCar(brand,model,Integer.parseInt(price));
        if (isInserted){
            Toast.makeText(AddCarActivity.this,"Your Data Inserted Successfully",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(AddCarActivity.this,"Your Data Insertion Failed",Toast.LENGTH_LONG).show();
        }*/
    }
}
