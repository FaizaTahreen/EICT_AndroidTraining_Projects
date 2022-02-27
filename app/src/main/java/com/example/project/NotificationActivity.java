package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {
    NotificationManager nm;
    PendingIntent pendingIntent;
    NotificationChannel nc;
    Button notification;
    NotificationCompat.Builder nb;
    static final String CHANNEL_ID="myapp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        notification=findViewById(R.id.nm);
        nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notification.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        nb=new NotificationCompat.Builder(this,CHANNEL_ID);
        nb.setContentTitle("MISSED CALL")
                .setContentText("You Have Missed Call from 7903770969")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSmallIcon(android.R.drawable.sym_call_missed)
                .setAutoCancel(true);
        createNotification();
        Intent intent=new Intent(this,FirstActivity.class);
        pendingIntent=PendingIntent.getActivity(this,1000,intent,pendingIntent.FLAG_UPDATE_CURRENT);
        nb.setContentIntent(pendingIntent);
        nm.notify(1000,nb.build());
    }
    private void createNotification() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name=getString(R.string.channel_name);
            String desc=getString(R.string.channel_desc);
            int imp=NotificationManager.IMPORTANCE_DEFAULT;
            nc=new NotificationChannel(CHANNEL_ID,name,imp);
            nc.setDescription(desc);
            nm.createNotificationChannel(nc);
        }
    }
}