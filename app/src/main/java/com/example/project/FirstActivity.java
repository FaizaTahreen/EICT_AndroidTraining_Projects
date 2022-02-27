package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    TextView txtDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toast.makeText(getBaseContext(), "Welcome", Toast.LENGTH_SHORT).show();
        init();
    }

    private void init() {
        txtDisplay = findViewById(R.id.txtDisplay);
        appendDatainTextView("onCreate");
    }

    private void appendDatainTextView(String state) {
        txtDisplay.append(state + "\n");
    }

    @Override
    protected void onStart() {
        super.onStart();
        appendDatainTextView("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        appendDatainTextView("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        appendDatainTextView("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        appendDatainTextView("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        appendDatainTextView("onRestart");
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(getBaseContext(),"Bye-Bye",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

}


