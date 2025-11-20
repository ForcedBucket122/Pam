package com.example.notyfikacja;

import static android.app.NotificationManager.IMPORTANCE_DEFAULT;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "aktual";
    private static final String GROUP_KEY = "AKTUALIZACJE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tworzenie kana powiadomień
        NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID,
                "Aktualizacje",
                NotificationManager.IMPORTANCE_DEFAULT
        );
        channel.setDescription("Powiadomienia o aktualizacjach aplikacji");
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);

        Button wyslij = findViewById(R.id.przycisk);
        wyslij.setOnClickListener(v -> wyslijPowiadomienia());
    }

    private void wyslijPowiadomienia() {
        // Intenty dla akcji
        Intent instalujIntent = new Intent(this, Instaluj.class);
        PendingIntent instalujPendingIntent = PendingIntent.getActivity(this, 1, instalujIntent, PendingIntent.FLAG_IMMUTABLE);

        Intent wyjdzIntent = new Intent(this, Wyjdz.class);
        PendingIntent wyjdzPendingIntent = PendingIntent.getActivity(this, 2, wyjdzIntent, PendingIntent.FLAG_IMMUTABLE);

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);

        // 4 powiadomienia o aktualizacjach
        for (int i = 1; i <= 4; i++) {
            Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_android_black_24dp)
                    .setContentTitle("Aktualizacja aplikacji " + i)
                    .setContentText("Dostępna aktualizacja dla aplikacji " + i)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT) // medium
                    .setGroup(GROUP_KEY)
                    .addAction(R.drawable.ic_launcher_foreground, "Instaluj", instalujPendingIntent)
                    .addAction(R.drawable.ic_launcher_foreground, "Wyjdź", wyjdzPendingIntent)
                    .build();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            manager.notify(i, notification);
        }

        // Powiadomienie podsumowujące grupę
        Notification summaryNotification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentTitle("4 nowe aktualizacje")
                .setContentText("Masz 4 aplikacje do zaktualizowania")
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("Aktualizacja aplikacji 1")
                        .addLine("Aktualizacja aplikacji 2")
                        .addLine("Aktualizacja aplikacji 3")
                        .addLine("Aktualizacja aplikacji 4")
                        .setSummaryText("Aktualizacje"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setGroup(GROUP_KEY)
                .setGroupSummary(true)
                .build();

        manager.notify(0, summaryNotification);
    }
}
