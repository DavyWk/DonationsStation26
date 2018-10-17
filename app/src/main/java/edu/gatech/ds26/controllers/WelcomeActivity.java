package edu.gatech.ds26.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import edu.gatech.ds26.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

    /**
     * Button handler for the login button
     * @param view the button
     */
    public void onFirstLoginPressed(View view) {
        Log.d("Welcome Screen", "Login");
        Intent intent = new Intent(this, LoginActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }

    /**
     * Button handler for the register button
     *
     * @param view the button pressed
     */
    public void onFirstRegisterPressed(View view) {
        Log.d("Welcome Screen", "Register");
        Intent intent = new Intent(this, RegisterActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
}