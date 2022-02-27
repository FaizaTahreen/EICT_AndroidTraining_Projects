package com.example.project.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.widget.Toast;

import java.util.List;

public class WifiBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        WifiManager wm=(WifiManager)(context.getSystemService(context.WIFI_SERVICE));
        List<ScanResult> wi=wm.getScanResults();
        for(ScanResult s:wi)
        {
            String data="SSID : "+s.SSID+"\nBSSID : "+s.BSSID+" RSSI : "+s.level;
            Toast.makeText(context, ""+data, Toast.LENGTH_SHORT).show();
        }
    }
}
