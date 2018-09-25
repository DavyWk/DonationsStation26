package edu.gatech.ds26;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivityScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        //making it so that it looks like a password is being entered
        EditText pw = (EditText)findViewById(R.id.password_input);
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
        EditText user = (EditText) findViewById(R.id.username_input);
        EditText pw = (EditText)findViewById(R.id.password_input);
        if (user.getText().toString().equals("admin") && pw.getText().toString().equals("2340")) {
            Intent intent = new Intent(this, MainActivityScreen.class);
            view.getContext().startActivity(intent);
            finish();
        } else {
            TextView txt = (TextView) findViewById(R.id.txtInvalid);
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
        Intent intent = new Intent(this, WelcomeActivityScreen.class);
        view.getContext().startActivity(intent);
        finish();
    }
}
