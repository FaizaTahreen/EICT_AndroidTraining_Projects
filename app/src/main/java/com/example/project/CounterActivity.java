package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity implements View.OnClickListener
{
    TextView count;
    Button inc,dec,reset;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        count=findViewById(R.id.count);
        inc=findViewById(R.id.inc);
        dec=findViewById(R.id.dec);
        reset=findViewById(R.id.reset);
        inc.setOnClickListener(this);
        dec.setOnClickListener(this);
        reset.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case  R.id.inc:
                counter++;
                count.setText("COUNT : "+counter);
                break;
            case  R.id.dec:
                counter--;
                count.setText("COUNT : "+counter);
                break;
            case  R.id.reset:
                counter=0;
                count.setText("COUNT : "+counter);
                break;

        }

    }
}