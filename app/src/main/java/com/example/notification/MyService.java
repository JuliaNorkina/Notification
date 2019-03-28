package com.example.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import java.util.Random;

public class MyService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int number = MathUtil.calculateFactorial(new Random().nextInt(8));
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "1").
                setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Result of calculate factorial")
                .setContentText("Result = " + number);

        Notification notification = builder.build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
