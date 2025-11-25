package com.example.notyfikacje_i_toolbar_nauka;

import static android.app.NotificationManager.IMPORTANCE_DEFAULT;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.appsearch.PackageIdentifier;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        NotificationChannel channel = new NotificationChannel("id",
                "powiadomienie", IMPORTANCE_DEFAULT);
        channel.setDescription("opis powiadomienia");
        NotificationManager manager =getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);





        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Toolbar bottom = findViewById(R.id.bottom);
        bottom.inflateMenu(R.menu.bottom_toolbar);
        bottom.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();
            if(id == R.id.open){
                Toast.makeText(this, "open", Toast.LENGTH_SHORT).show();
            }
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.open) {
            Toast.makeText(this, "open", Toast.LENGTH_SHORT).show();
            wyslijPowiadomienie();
        } else if (id == R.id.profile) {
            Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.settings) {
            Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.search) {
            Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public void wyslijPowiadomienie(){
        Intent intent = new Intent(this, NotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent =PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_IMMUTABLE);

        Intent likeIntent = new Intent(this, Like.class);
        likeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent likePendingIntent = PendingIntent.getActivity(this, 0, likeIntent,
                PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "id")
                .setSmallIcon(R.drawable.outline_account_circle_24)
                .setContentTitle("Tytuł")
                .setContentText("Zawartosc")
                .addAction(R.drawable.ic_launcher_foreground, "Like", likePendingIntent)
                .setContentIntent(pendingIntent)
                .setPriority(IMPORTANCE_DEFAULT)
                .setAutoCancel(true);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
        != PackageManager.PERMISSION_GRANTED){
            return;
        }
        NotificationManagerCompat.from(this).notify(0, builder.build());

    }
}