package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.project.util.WifiBroadCast;

public class WifiActivity extends AppCompatActivity {
    Switch s;
    WifiManager wm;
    WifiBroadCast wbc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        s=findViewById(R.id.switch1);
        wm=(WifiManager)(getApplicationContext().getSystemService(WIFI_SERVICE));
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    if (!wm.isWifiEnabled())
                    {
                        wm.setWifiEnabled(true);
                    }
                    wm.startScan();
                }
                else{
                    if(wm.isWifiEnabled())
                    {
                        wm.setWifiEnabled(false);
                    }
                }

            }
        });
        wm.startScan();
        wbc=new WifiBroadCast();
        IntentFilter ifr=new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        registerReceiver(wbc,ifr);
    }

    @Override
    protected void onResume() {
        super.onResume();
        wm.startScan();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wbc);
    }
}
