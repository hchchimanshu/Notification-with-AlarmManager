package com.kotlin.alarmmanagerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addingAlarm();

    }

    private void addingAlarm() {
        Intent intent = new Intent(this, NotificationReceiver.class);
        PendingIntent pendingIntent= PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_IMMUTABLE);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long currentTime = System.currentTimeMillis();

        //2 sec alarm
        long hour24 = 1000*2;
        alarmManager.set(AlarmManager.RTC_WAKEUP,currentTime+hour24,pendingIntent);
    }
}