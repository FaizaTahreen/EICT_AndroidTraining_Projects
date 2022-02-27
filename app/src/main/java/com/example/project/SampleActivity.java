package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SampleActivity extends AppCompatActivity {
    EditText text;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        text=findViewById(R.id.text);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(text.getText())) {
                    startSecond();
                } else {
                    text.setError("Please Enter Some details");
                }
            }
           });
       }
 private void startSecond() {
        Intent intent=new Intent(this,AnotherActivity.class);
        intent.putExtra(Constant.INTENT_ID,text.getText().toString());
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);
    }
}