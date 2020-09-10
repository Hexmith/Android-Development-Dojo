package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int chosenNumber = -1;
    private boolean isGuessCorrect = false;

    public Random rand = new Random();
    public int min = 0, max = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        // Generating the number to be guessed.
        if (chosenNumber == -1) {
            chosenNumber = rand.nextInt((max - min) + 1) + min;
        }

        // Getting the guess input from the user.
        EditText editText = (EditText) findViewById(R.id.editTextGuess);

        // Checking if the user guessed the correct number.
        checkGuess(Integer.parseInt(editText.getText().toString()));

        // "Resetting" the app by changing the number to be guessed.
        if (isGuessCorrect) {
            chosenNumber = -1;
            isGuessCorrect = false;
        }
    }

    /*
     * Checks whether the user has guessed the correct number or not.
     */
    public void checkGuess(int guess) {
        if (guess == chosenNumber) {
            // The player guessed the correct number!
            isGuessCorrect = true;

            Toast.makeText(this, "You guessed!", Toast.LENGTH_LONG).show();
        } else if (guess > chosenNumber) {
            // The player guessed a higher number than the chosen one.
            Toast.makeText(this, "Nope, try going lower.", Toast.LENGTH_SHORT).show();
        } else {
            // The player guessed a lower number than the chosen one.
            Toast.makeText(this, "Nope, try going higher.", Toast.LENGTH_SHORT).show();
        }
    }

}