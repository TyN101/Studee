package com.waxyhexagon.studeea;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfilePage extends AppCompatActivity{

    String[] dataReceived;
    ArrayList<String> str;

    TextView name;
    TextView phoneNumber;
    TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        str = getIntent().getStringArrayListExtra("NAME");

        name = (TextView) findViewById(R.id.nameTextView);
        phoneNumber = (TextView) findViewById(R.id.phoneNumberTextView);
        email = (TextView) findViewById(R.id.emailTextView);

        FillForm populateMatches = new FillForm();
        populateMatches.execute();

    }

    public class FillForm extends AsyncTask<Void, Void, Boolean> {

        FillForm(){}

        @Override
        protected Boolean doInBackground(Void... params) {

            dataReceived = Comms.viewProfile(str.get(0));

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            Log.i("success", "success");
            name.setText(dataReceived[0]);
            phoneNumber.setText(dataReceived[1]);
            email.setText(dataReceived[2]);
        }
    }
}
