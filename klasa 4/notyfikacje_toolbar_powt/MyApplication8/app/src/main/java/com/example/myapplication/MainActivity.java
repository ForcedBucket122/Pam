package com.example.myapplication;

import static android.app.NotificationManager.IMPORTANCE_DEFAULT;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
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
    static final String ID = "IDWIADOMOSCI";

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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NotificationChannel channel = new NotificationChannel(ID,
                "wiadomosci",
                IMPORTANCE_DEFAULT);
        channel.setDescription("wiadomosci");
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);

        wyslijWiadomosc();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.udostepnij){
            Toast.makeText(this, "Udostępnij", Toast.LENGTH_SHORT).show();
        }if (id==R.id.ulubione){
            Toast.makeText(this, "Ulubione", Toast.LENGTH_SHORT).show();
        }if (id==R.id.edytuj){
            Toast.makeText(this, "Edytuj", Toast.LENGTH_SHORT).show();
        }if (id==R.id.usun){
            Toast.makeText(this, "Usuń", Toast.LENGTH_SHORT).show();
        }if (id==R.id.kopiuj){
            Toast.makeText(this, "Kopiuj", Toast.LENGTH_SHORT).show();
        }if (id==R.id.przenies){
            Toast.makeText(this, "Przenieś", Toast.LENGTH_SHORT).show();
        }if (id==R.id.ukryj){
            Toast.makeText(this, "Ukryj", Toast.LENGTH_SHORT).show();
        }if (id==R.id.ustaw_jako_tapete){
            Toast.makeText(this, "Ustaw jako tapetę", Toast.LENGTH_SHORT).show();
        }if (id==R.id.szczegoly){
            Toast.makeText(this, "Szczegóły", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    public void wyslijWiadomosc(){
        Intent intent = new Intent(this, Wiadomosc.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        Intent intentOznaczJakoPrzeczytane = new Intent(this, OznaczJakoPrzeczytane.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntentOznaczJakoPrzeczytane = PendingIntent.getActivity(this, 0, intentOznaczJakoPrzeczytane, PendingIntent.FLAG_IMMUTABLE);

        Intent intentOdpowiedz = new Intent(this, Odpowiedz.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntentOdpowiedz = PendingIntent.getActivity(this, 0, intentOdpowiedz, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, ID)
                .setSmallIcon(R.drawable.baseline_message_24)
                .setContentTitle("Piofczyk")
                .setContentText("Witam")
                .setAutoCancel(true)
                .setPriority(IMPORTANCE_DEFAULT)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.outline_eyeglasses_24, "Oznacz jako przeczytane",pendingIntentOznaczJakoPrzeczytane)
                .addAction(R.drawable.outline_reply_24, "Odpowiedz",pendingIntentOdpowiedz);

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
        NotificationManagerCompat.from(this).notify(0, builder.build());
    }
}