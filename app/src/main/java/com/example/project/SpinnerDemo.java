package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerDemo extends AppCompatActivity implements View.OnClickListener {
    TextView txtFst;

    Integer[]  txtSize  =  new Integer[]{17,24,30,48};

    Button btnPress;

    Spinner spinTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);
        txtFst = findViewById(R.id.txtFst);
        btnPress = findViewById(R.id.btnPress);

        btnPress.setOnClickListener(this);

        spinTxt = findViewById(R.id.spinTxtSize);

        spinTxt.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,txtSize));
          spinTxt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("TAG", "onItemSelected: "+i);
                int txsize = txtSize[i];
                txtFst.setTextSize(txsize);
                Toast.makeText(getBaseContext(),txsize+"",Toast.LENGTH_SHORT).show();
               }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
 }
     public void callText(View view){
        txtFst.setText("Hi I am changed");
    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.btnPress){
            callText(view);
        }
    }
}


