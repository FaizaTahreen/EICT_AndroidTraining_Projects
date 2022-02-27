package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class GreetingActivity extends AppCompatActivity implements View.OnClickListener {
    TextView message;
    EditText fn;
    Button greet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        message = findViewById(R.id.message);
        fn = findViewById(R.id.fn);
        greet = findViewById(R.id.greeting);

    }


    @Override
    public void onClick(View v) {

        // get a reference to the TextView on the UI
        TextView textMessage = (TextView) findViewById(R.id.textMessage);

        //get a reference to the EditText so that we can read in the value typed
        // by the user
        EditText editFriendName = (EditText) findViewById(R.id.editFriendName);

        // get the name of the friend typed in by the user in the EditText field
        String friendName = editFriendName.getText().toString();

        //Get the time of day
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        //Set greeting
        String greeting = null;
        if (hour >= 6 && hour < 12) {
            greeting = "Good Morning";
        } else if (hour >= 12 && hour < 17) {
            greeting = "Good Afternoon";
        } else if (hour >= 17 && hour < 21) {
            greeting = "Good Evening";
        } else if (hour >= 21 && hour < 24) {
            greeting = "Good Night";
        }

        //Change string displayed by TextView
        switch (v.getId()) {

            case R.id.greetButton:

                //set the string being displayed by the TextView to the greeting
                //message for the friend
                textMessage.setText(greeting + " " + friendName + "!");

                break;

            default:
                break;
        }

    }
}
