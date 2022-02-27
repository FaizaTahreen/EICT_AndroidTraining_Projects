package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity2 extends AppCompatActivity {
    EditText email,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        email=findViewById(R.id.emailid);
        pass=findViewById(R.id.password);


    }
    public void login(View view)
    {
        Toast.makeText(this, "Login Invoked", Toast.LENGTH_SHORT).show();
        String emailid=email.getText().toString();
        String password=pass.getText().toString();
        Intent intent=new Intent(LoginActivity2.this,ResultActivity.class);
        intent.putExtra("email",emailid);
        intent.putExtra("pass",password);
        startActivity(intent);

    }
}