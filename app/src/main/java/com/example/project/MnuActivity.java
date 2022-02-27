package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MnuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lv;
    String my_activity[] = {"GreetingActivity","StateActivity", "FirstActivity", "WifiActivity", "LoginActivity2", "SpinnerDemo", "NotificationActivity",
            "SpinnerActivity2", "CounterActivity", "SampleActivity"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mnu);
        lv = findViewById(R.id.mymenulist);
        adapter = new ArrayAdapter<String>(MnuActivity.this, R.layout.list_cus_design, R.id.resultdata, my_activity);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try {
            String s = "com.example.project." + my_activity[position];
            Class c = Class.forName(s);
            Intent intent = new Intent(MnuActivity.this, c);
            startActivity(intent);
        } catch (Exception e) {
            Log.e("Error", "Error is" + e.getMessage());
        }
    }

    private boolean checkedPermission() {
        int wifi_access = ContextCompat.checkSelfPermission(this, Manifest.permission.CHANGE_WIFI_STATE);
        int wifi_change = ContextCompat.checkSelfPermission(this, Manifest.permission.CHANGE_WIFI_STATE);
        int loc_access = ContextCompat.checkSelfPermission(this, Manifest.permission.CHANGE_WIFI_STATE);
        List<String> permissionlist = new ArrayList();
        if(wifi_access!= PackageManager.PERMISSION_GRANTED)
        {
            permissionlist.add(Manifest.permission.ACCESS_WIFI_STATE);

        }
        if(wifi_change!= PackageManager.PERMISSION_GRANTED)
        {
            permissionlist.add(Manifest.permission.CHANGE_WIFI_STATE);

        }
        if(loc_access!= PackageManager.PERMISSION_GRANTED)
        {
            permissionlist.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (!permissionlist.isEmpty())
        {
            ActivityCompat.requestPermissions(this,permissionlist.toArray(new String[permissionlist.size()]),10111);
            return false;
        }
        return true;
    }
    }
