package com.example.myfirsttutorialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        // Getting the username and password entered by the user.
        EditText usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        ImageView loginImageView = (ImageView) findViewById(R.id.loginImageView);

        // Confirming that the button was pressed.
        Log.i("Info", "Button clicked!");

        // Logging the user's username if it isn't empty.
        if (!usernameEditText.getText().toString().equals("")) {
            if (!passwordEditText.getText().toString().equals("")) {
                Toast.makeText(this, "Welcome back, " + usernameEditText.getText().toString() + "!", Toast.LENGTH_SHORT).show();

                // Setting the image view to the "successful login" one.
                loginImageView.setImageResource(R.drawable.sao_login_tech_circle);
            } else {
                Toast.makeText(this, "Please, enter your password.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please, enter your username.", Toast.LENGTH_SHORT).show();
        }
    }

}