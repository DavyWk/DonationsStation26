package edu.gatech.ds26;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivityScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    /**
     * Button handler for the login
     *
     * @param view the button
     */
    public void onLogoutPressed(View view) {
        Log.d("Main Screen", "Logout");
        finish();
    }
}
