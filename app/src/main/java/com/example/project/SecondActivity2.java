package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity2 extends AppCompatActivity implements View.OnClickListener {
    TextView message;
    Button hide;
    boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        message=findViewById(R.id.msg);
        hide=findViewById(R.id.hnds);
        hide.setOnClickListener(this);

    }
    public void onClick(View view) {
        if(!flag) {
            flag = true;
            message.setVisibility(View.VISIBLE);
            hide.setText("HIDE MESSAGE");
        }
        else
        {
            flag=false;
            message.setVisibility(View.INVISIBLE);
            hide.setText("SHOW MESSAGE");

        }

    }



}