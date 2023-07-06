package com.vu.assessment_4669025_4669026;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAddCar,btnCheckCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddCar = (Button) findViewById(R.id.button);
        btnCheckCar = (Button) findViewById(R.id.button2);

        btnAddCar.setOnClickListener(this);
        btnCheckCar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button){
            goToAddCar();
        }
        if (id == R.id.button2){
            goToCheckCar();
        }
    }

    private void goToCheckCar() {
        Intent intent = new Intent(this,CheckCarActivity.class);
        startActivity(intent);
    }

    private void goToAddCar() {
        Intent intent = new Intent(this,AddCarActivity.class);
        startActivity(intent);
    }
}