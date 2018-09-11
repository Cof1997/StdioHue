package com.cof.stdio_hue.demonotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.app.PendingIntent.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void NEXT(View view){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
    public void NOTIFICATION(View view){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 1, intent,0);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder notifyBuilder = new Notification.Builder(this);

        notifyBuilder.setContentTitle("Notification");
        notifyBuilder.setContentText("Send By Main_Activity");
        notifyBuilder.setSmallIcon(R.drawable.notification);
        notifyBuilder.setAutoCancel(true);
        notifyBuilder.setContentIntent(pIntent);
        notificationManager.notify(1, notifyBuilder.build());
    }

}
