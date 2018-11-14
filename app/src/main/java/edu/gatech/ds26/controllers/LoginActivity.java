package edu.gatech.ds26.controllers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
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
        EditText loginId = findViewById(R.id.loginId_input);
        EditText password = findViewById(R.id.password_input);
        TextView text = findViewById(R.id.txtInvalid);

        Editable loginIdText = loginId.getText();
        String loginIdToString = loginIdText.toString();

        Editable passwordText = password.getText();
        String passwordToString = passwordText.toString();

        if (loginIdToString.matches("") || passwordToString.matches("") ||
                !userList.authenticateUser(loginIdToString, passwordToString)) {
            text.setVisibility(View.VISIBLE);
        } else {
            Intent intent = new Intent(this, MainActivity.class);

            Context viewContext = view.getContext();
            viewContext.startActivity(intent);

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

        Context viewContext = view.getContext();
        viewContext.startActivity(intent);

        finish();
    }

    /**
     * Button handler for cancel
     * @param view the button pressed
     */
    public void onCancelPressed(View view) {
        Log.d("Login Screen", "Cancel");
        Intent intent = new Intent(this, WelcomeActivity.class);

        Context viewContext = view.getContext();
        viewContext.startActivity(intent);

        finish();
    }
}
