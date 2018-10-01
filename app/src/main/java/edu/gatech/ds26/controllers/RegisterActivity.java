package edu.gatech.ds26.controllers;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.AccountType;
import edu.gatech.ds26.model.User;
import edu.gatech.ds26.model.UserList;

public class RegisterActivity extends AppCompatActivity {

    private User _user;
    EditText name;
    EditText loginId;
    EditText password;
    Spinner typeSpinner;
    TextView text1;
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        //making it so that it looks like a password is being entered
        EditText pw = findViewById(R.id.password_input);
        pw.setTypeface(Typeface.DEFAULT);
        pw.setTransformationMethod(new PasswordTransformationMethod());

        //TODO implement auth logic
        name = findViewById(R.id.username_input);
        loginId = findViewById(R.id.id_input);
        password = findViewById(R.id.password_input);
        typeSpinner = (Spinner) findViewById(R.id.spinner);
        text1 = findViewById(R.id.txtInvalid);
        text2 = findViewById(R.id.txtInvalid2);

        /*
          Set up the adapter to display the allowable account types in the spinner
         */
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, AccountType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);

        _user = new User();
        typeSpinner.setSelection(_user.getType().ordinal());
    }

    /**
     * Button handler for register
     *
     * @param view the button
     */
    public void onSecondRegisterPressed(View view) {
        Log.d("Register Screen", "Register");
        UserList userList = UserList.getInstance();

        _user.setName(name.getText().toString());
        _user.setLoginId(loginId.getText().toString());
        _user.setPassword(password.getText().toString());
        _user.setType((AccountType) typeSpinner.getSelectedItem());

        if (name.getText().toString().matches(  "") || loginId.getText().toString().matches("") || password.getText().toString().matches("")) {
            text1.setVisibility(View.VISIBLE);
            text2.setVisibility(View.INVISIBLE);
        } else {

            if (userList.verifyUser(loginId.getText().toString())) {
                text2.setVisibility(View.VISIBLE);
                text1.setVisibility(View.INVISIBLE);
            } else {
                userList.addUser(new User(name.getText().toString(), loginId.getText().toString(), password.getText().toString(), (AccountType) typeSpinner.getSelectedItem()));
                Intent intent = new Intent(this, LoginActivity.class);
                view.getContext().startActivity(intent);
                finish();
            }
        }
    }

    /**
     * Button handler for cancel
     *
     * @param view the button pressed
     */
    public void onCancelPressed(View view) {
        Log.d("Register Screen", "Cancel");
        Intent intent = new Intent(this, WelcomeActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }
}
