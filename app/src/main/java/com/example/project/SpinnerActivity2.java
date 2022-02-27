package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerActivity2 extends AppCompatActivity implements View.OnClickListener {
    TextView txtFst;
    Button btnPress;
    String color[] = {"DEFAULT", "RED", "GREEN", "BLUE", "YELLOW", "GRAY"};
    Spinner spinTxt;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner2);
        txtFst = findViewById(R.id.txtFst);
        btnPress = findViewById(R.id.btnPress);
        btnPress.setOnClickListener(this);
        spinTxt = findViewById(R.id.spinTxtSize);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, color);
        spinTxt.setAdapter(adapter);
        spinTxt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        txtFst.setTextColor(Color.WHITE);
                        break;
                    case 1:
                        txtFst.setTextColor(Color.RED);
                        break;
                    case 2:
                        txtFst.setTextColor(Color.GREEN);
                        break;
                    case 3:
                        txtFst.setTextColor(Color.BLUE);
                        break;
                    case 4:
                        txtFst.setTextColor(Color.YELLOW);
                        break;
                }
                Toast.makeText(getBaseContext(),txtFst+"",Toast.LENGTH_SHORT).show();
                        }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void callText(View view) {
        txtFst.setText("Hi I am changed");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnPress) {
            callText(view);
        }
    }
}
