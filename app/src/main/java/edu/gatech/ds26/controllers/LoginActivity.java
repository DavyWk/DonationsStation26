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
import edu.gatech.ds26.model.UserList;

/**
 * This class is the place where user's go to enter their account's information to gain access.
 */
public class LoginActivity extends AppCompatActivity {

    EditText loginId;
    EditText password;
    TextView text;

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
        UserList userList = UserList.getInstance();

        //TODO implement auth logic
        loginId = findViewById(R.id.loginId_input);
        password = findViewById(R.id.password_input);
        text = findViewById(R.id.txtInvalid);

        if (loginId.getText().toString().matches("") || password.getText().toString().matches("") || !userList.authenticateUser(loginId.getText().toString(), password.getText().toString())) {
            text.setVisibility(View.VISIBLE);
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            view.getContext().startActivity(intent);
            finish();
        }
    }
    /**
     * Button handler for the register button
     * @param view the button pressed
     */
    public void onFirstRegisterPressed(View view) {
        Log.d("Welcome Screen", "Register");
        Intent intent = new Intent(this, RegisterActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }

    /**
     * Button handler for cancel
     * @param view the button pressed
     */
    public void onCancelPressed(View view) {
        Log.d("Login Screen", "Cancel");
        Intent intent = new Intent(this, WelcomeActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
}
