package edu.gatech.ds26.controllers;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import edu.gatech.ds26.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        //making it so that it looks like a password is being entered
        EditText pw = findViewById(R.id.password_input);
        pw.setTypeface(Typeface.DEFAULT);
        pw.setTransformationMethod(new PasswordTransformationMethod());
    }

    /**
     * Button handler for the login
     * @param view the button
     */
    public void onSecondLoginPressed(View view) {
        Log.d("Login Screen", "Login");
        //TODO implement auth logic
        EditText user = findViewById(R.id.username_input);
        EditText pw = findViewById(R.id.password_input);
        if (user.getText().toString().equals("admin") && pw.getText().toString().equals("2340")) {
            Intent intent = new Intent(this, MainActivity.class);
            view.getContext().startActivity(intent);
            finish();
        } else {
            TextView txt = findViewById(R.id.txtInvalid);
            txt.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Button handler for cancel
     *
     * @param view the button pressed
     */
    public void onCancelPressed(View view) {
        Log.d("Login Screen", "Cancel");
        Intent intent = new Intent(this, WelcomeActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
}
