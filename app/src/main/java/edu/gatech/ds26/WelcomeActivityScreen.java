package edu.gatech.ds26;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class WelcomeActivityScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

    /**
     * Button handler for the login
     * @param view the button
     */
    public void onFirstLoginPressed(View view) {
        Log.d("Welcome Screen", "Login");
        finish();
    }

    /**
     * Button handler for cancel
     *
     * @param view the button pressed
     */
    public void onRegisterPressed(View view) {
        Log.d("Welcome Screen", "Login");
        finish();
    }
}