package com.example.test;

import static android.app.NotificationManager.IMPORTANCE_DEFAULT;

import android.Manifest;
import android.app.Notification;
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
    static final String GROUPID = "GRUPA";
    static final String GROUPID2 = "GRUPA2";

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

//        NotificationChannel channel = new NotificationChannel("id",
//                "powiadomienie",
//                IMPORTANCE_DEFAULT);
//        channel.setDescription("opis kanalu");
//        NotificationManager manager = getSystemService(NotificationManager.class);
//        manager.createNotificationChannel(channel);














        NotificationChannel channel = new NotificationChannel("id",
                "powiadomienia", IMPORTANCE_DEFAULT);
        channel.setDescription("opis");
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);

















        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Toolbar toolbar1 = findViewById(R.id.bottomToolbar);
        toolbar1.inflateMenu(R.menu.bottom_toolbar);

        toolbar1.setOnMenuItemClickListener((Toolbar.OnMenuItemClickListener) item -> {
            int id = item.getItemId();
            if(id==R.id.search){
                Toast.makeText(this, "search1", Toast.LENGTH_SHORT).show();
            }if(id==R.id.profile){
                Toast.makeText(this, "profile1", Toast.LENGTH_SHORT).show();
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
        if(id==R.id.search){
            Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();
        }if(id==R.id.profile){
            Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show();
            wyslijPowiadomienie();
        }
        
        return true;
    }


    public void wyslijPowiadomienie(){
        Intent intent = new Intent(this, NotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                intent,
                PendingIntent.FLAG_IMMUTABLE);

        Intent likeIntent = new Intent(this, Like.class);
        likeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent likePendingIntent = PendingIntent.getActivity(this, 0,
                likeIntent,
                PendingIntent.FLAG_IMMUTABLE);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "id")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentText("tekst")
                .setContentTitle("tytul")
                .setSmallIcon(R.drawable.baseline_person_24)
                .addAction(R.drawable.ic_launcher_foreground, "Like", likePendingIntent)
                .setPriority(IMPORTANCE_DEFAULT)
                .setSortKey("01")
                .setGroup(GROUPID);

        NotificationCompat.Builder builder1 = new NotificationCompat.Builder(this, "id")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentText("tekst1")
                .setContentTitle("tytul1")
                .setSmallIcon(R.drawable.baseline_person_24)
                .addAction(R.drawable.ic_launcher_foreground, "Like", likePendingIntent)
                .setPriority(IMPORTANCE_DEFAULT)
                .setSortKey("02")
                .setGroup(GROUPID);

        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this, "id")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentText("tekst2")
                .setContentTitle("tytul2")
                .setSmallIcon(R.drawable.baseline_person_24)
                .addAction(R.drawable.ic_launcher_foreground, "Like", likePendingIntent)
                .setPriority(IMPORTANCE_DEFAULT)
                .setSortKey("03")
                .setGroup(GROUPID);



        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }


        Intent summaryIntent = new Intent(this, Summary.class);
        summaryIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent summaryPendingIntent = PendingIntent.getActivity(this, 0, summaryIntent,
                PendingIntent.FLAG_IMMUTABLE);

//        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
//        manager.notify(1, builder.build());
//        manager.notify(2, builder.build());
//        manager.notify(3, builder.build());
        NotificationManagerCompat.from(this).notify(3, builder.build());
        NotificationManagerCompat.from(this).notify(2, builder1.build());
        NotificationManagerCompat.from(this).notify(1, builder2.build());

        NotificationCompat.Builder summaryNotification = new NotificationCompat.Builder(this,
                "id")
                .setContentIntent(summaryPendingIntent)
                .setGroup(GROUPID)
                .setSmallIcon(R.drawable.baseline_person_24)
                .setAutoCancel(true)
                .setContentTitle("Tytul grupt")
                .setContentText("zawartosc")
                .setGroupSummary(true);

        NotificationManagerCompat.from(this).notify(0, summaryNotification.build());
    }


    public void wyslijPowiadomienie2(){
        Intent intent = new Intent(this, NotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        Intent likeIntent = new Intent(this, Like.class);
        likeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent likePendingIntent = PendingIntent.getActivity(this, 0, likeIntent, PendingIntent.FLAG_IMMUTABLE);

        Intent summaryIntent = new Intent(this, Summary.class);
        summaryIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent summaryPendingIntent = PendingIntent.getActivity(this, 0, summaryIntent, PendingIntent.FLAG_IMMUTABLE);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "id")
                .setGroup(GROUPID2)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentText("Zawartość1")
                .setContentTitle("tytuł1")
                .addAction(R.drawable.ic_launcher_foreground, "LIKE", likePendingIntent)
                .setPriority(IMPORTANCE_DEFAULT)
                .setSortKey("01")
                .setSmallIcon(R.drawable.baseline_person_24);

        NotificationCompat.Builder builder1 = new NotificationCompat.Builder(this, "id")
                .setGroup(GROUPID2)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentText("Zawartość2")
                .setContentTitle("tytuł2")
                .addAction(R.drawable.ic_launcher_foreground, "LIKE", likePendingIntent)
                .setPriority(IMPORTANCE_DEFAULT)
                .setSortKey("02")
                .setSmallIcon(R.drawable.baseline_person_24);

        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this, "id")
                .setGroup(GROUPID2)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentText("Zawartość3")
                .setContentTitle("tytuł3")
                .addAction(R.drawable.ic_launcher_foreground, "LIKE", likePendingIntent)
                .setPriority(IMPORTANCE_DEFAULT)
                .setSortKey("03")
                .setSmallIcon(R.drawable.baseline_person_24);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        NotificationManagerCompat.from(this).notify(1, builder.build());
        NotificationManagerCompat.from(this).notify(2, builder1.build());
        NotificationManagerCompat.from(this).notify(3, builder2.build());

        NotificationCompat.Builder summaryBuilder = new NotificationCompat.Builder(this, "id")
                .setGroup(GROUPID2)
                .setAutoCancel(true)
                .setContentIntent(summaryPendingIntent)
                .setContentText("powiadomienia")
                .setContentTitle("Grupa")
                .setPriority(IMPORTANCE_DEFAULT)
                .setGroupSummary(true)
                .setSmallIcon(R.drawable.baseline_person_24);

        NotificationManagerCompat.from(this).notify(0, summaryBuilder.build());
    }
}