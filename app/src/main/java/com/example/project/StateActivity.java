package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StateActivity extends AppCompatActivity {
    ListView lv;
    String name[] = {"Kerala", "Maharastra", "Delhi", "Jharkhand", "Bihar", "Punjab", "Karnataka", "Tamil Nadu", "Gujarat"};
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);
        lv = findViewById(R.id.statelist);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo,int position,long id) {
        super.onCreateContextMenu(menu, v, menuInfo);

        try {
            String s = "com.example.project." + name[position];
            Class c = Class.forName(s);
            Intent intent = new Intent(StateActivity.this, c);
            startActivity(intent);
        } catch (Exception e) {
            Log.e("Error", "Error is" + e.getMessage());
        }
    }
}