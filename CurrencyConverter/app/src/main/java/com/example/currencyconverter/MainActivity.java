package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("DefaultLocale")
    public void convertAmount(View view) {
        Log.i("Info", "Button pressed!");

        // Getting the amount entered by the user.
        EditText amountToConvert = (EditText) findViewById(R.id.editTextNumberDecimal);

        // Converting the amount entered by the user if it isn't empty.
        if (amountToConvert.getText().toString().equals("")) {
            Toast.makeText(this, "Please, enter any amount.", Toast.LENGTH_SHORT).show();
        } else {
            // 1 USD = 105.36 JPY (08/28/2020).
            double usdInJpyRate = 105.36;

            // Converting the string received to a double and doing the necessary calculation.
            double stringToDouble = Double.parseDouble(amountToConvert.getText().toString());
            double convertedValue = stringToDouble * usdInJpyRate;

            // Showing the converted amount to the user.
            Toast.makeText(this, String.format("%.2f USD = %.2f JPY", stringToDouble, convertedValue), Toast.LENGTH_LONG).show();
        }
    }

}