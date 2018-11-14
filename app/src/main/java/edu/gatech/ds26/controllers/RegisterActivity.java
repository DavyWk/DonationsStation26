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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import edu.gatech.ds26.R;
import edu.gatech.ds26.model.AccountType;
import edu.gatech.ds26.model.Facade;
import edu.gatech.ds26.model.User;
import edu.gatech.ds26.model.UserList;

/**
 * In this class newcomers can register to create their accounts.
 */
public class RegisterActivity extends AppCompatActivity {

    //TODO: rename unclear elements
    private EditText name;
    private EditText loginId;
    private EditText password;
    private Spinner typeSpinner;
    private TextView text1;
    private TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        name = findViewById(R.id.username_input);
        loginId = findViewById(R.id.id_input);
        password = findViewById(R.id.password_input);
        typeSpinner = findViewById(R.id.spinner);
        text1 = findViewById(R.id.txtInvalid);
        text2 = findViewById(R.id.txtInvalid2);

        //making it so that it looks like a password is being entered
        password.setTypeface(Typeface.DEFAULT);
        password.setTransformationMethod(new PasswordTransformationMethod());

        /*
          Set up the adapter to display the allowable account types in the spinner
         */
        //problem here due to how types are translated
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, AccountType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);

        typeSpinner.setSelection(AccountType.USER.ordinal());
    }

    /**
     * Button handler for register
     * @param view the button
     */
    public void onSecondRegisterPressed(View view) {
        Log.d("Register Screen", "Register");
        UserList userList = UserList.getInstance();

        Editable nameText = name.getText();
        String nameToString = nameText.toString();

        Editable loginIdText = loginId.getText();
        String loginIdToString = loginIdText.toString();

        Editable passwordText = password.getText();
        String passwordToString = passwordText.toString();

        if (nameToString.matches("") || loginIdToString.matches("") ||
                passwordToString.matches("")) {
            text1.setVisibility(View.VISIBLE);
            text2.setVisibility(View.INVISIBLE);
        } else {
            if (userList.verifyUser(loginIdToString)) {
                text2.setVisibility(View.VISIBLE);
                text1.setVisibility(View.INVISIBLE);
            } else {
                userList.addUser(new User(nameToString, loginIdToString, passwordToString,
                        (AccountType) typeSpinner.getSelectedItem()));

                //no need to reload data since it's in the current instance of UserList
                Facade.saveUserList(this);

                Intent intent = new Intent(this, LoginActivity.class);

                Context viewContext = view.getContext();
                viewContext.startActivity(intent);

                finish();
            }
        }
    }

    /**
     * Button handler for cancel
     * @param view the button pressed
     */
    public void onCancelPressed(View view) {
        Log.d("Register Screen", "Cancel");
        Intent intent = new Intent(this, WelcomeActivity.class);

        Context viewContext = view.getContext();
        viewContext.startActivity(intent);

        finish();
    }
}
