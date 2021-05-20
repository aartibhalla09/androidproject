package com.example.abhapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickCalculate(View arg0)
    {
        EditText usd= (EditText)findViewById(R.id.usdInput);
        EditText inr= (EditText)findViewById(R.id.inrInput);
        DecimalFormat df = new DecimalFormat("###.##");

        if(!inr.getText().toString().trim().isEmpty() && !usd.getText().toString().trim().isEmpty()){
            usd.setText("Please enter one value");
            inr.setText("Please enter only one value");
        }

        if(!usd.getText().toString().trim().isEmpty() && inr.getText().toString().trim().isEmpty()) {
            String usdIn = usd.getText().toString();
            Double usdDouble = Double.parseDouble(usdIn);
            Double usdToInr = usdDouble * 73;
            inr.setText(df.format(usdToInr));
        }

        if(!inr.getText().toString().trim().isEmpty() && usd.getText().toString().trim().isEmpty()) {
            String inrIn = inr.getText().toString();
            Double inrDouble = Double.parseDouble(inrIn);
            Double inrToUsd = inrDouble * 0.014;
            usd.setText(df.format(inrToUsd));
        }

    }
}