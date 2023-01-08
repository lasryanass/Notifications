package com.tp2.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification(view);
            }
        });
    }
    private void sendNotification(View view) {
        NotificationChannel mChannel;
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "default");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.rockstargames.com/gta-v"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                intent, PendingIntent.FLAG_IMMUTABLE);
        String CHANNEL_ID = "channel_1";
        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.drawable.ic_launcher_foreground);
        /// Notification title and text
//        mBuilder.setContentTitle("My Notification");
        mBuilder.setContentTitle("TP2 notification");
//        mBuilder.setContentText("Hello World!");
        mBuilder.setContentText("Anass LASRY, Yassine HAMDANE, Ghita SALAME, Adnane EL BOUHALI");
        /// Tap action
        mBuilder.setContentIntent(pendingIntent);
        /// Action button
        mBuilder.addAction(R.drawable.ic_launcher_foreground, "Action", pendingIntent);
        /// Lock screen visibility
        mBuilder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
        mChannel = new NotificationChannel(CHANNEL_ID, this.getString(R.string.app_name), importance);
        mChannel.setDescription("notification");
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.createNotificationChannel(mChannel);
        mBuilder.setChannelId(CHANNEL_ID);
        mNotificationManager.notify(001, mBuilder.build());
    }
}