package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {
   EditText text2;
   TextView tt;
   Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        text2=findViewById(R.id.text2);
        tt=findViewById(R.id.tt);
        String msg=getIntent().getStringExtra(Constant.INTENT_ID);
        tt.setText(msg);
        btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goFirst();

            }
        });
    }

    private void goFirst() {
        Intent i=new Intent(this,SampleActivity.class);
        startActivity(getIntent());
    }
}