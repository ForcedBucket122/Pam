package com.example.myapplication67;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    private Button wyslij;

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


        Toolbar toolbar = findViewById(R.id.tolbar);
        setSupportActionBar(toolbar);

        Toolbar messengerToolbar = findViewById(R.id.messenger);
        messengerToolbar.inflateMenu(R.menu.messenger_toolbar);
        messengerToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.open){
                    Toast.makeText(MainActivity.this, "Create a new group", Toast.LENGTH_SHORT).show();
                    return true;
                }if(id == R.id.logo){
                    Toast.makeText(MainActivity.this, "Go to Facebook", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.camera){
            Toast.makeText(this, "Go to camera", Toast.LENGTH_SHORT).show();
        }if(id == R.id.group){
            Toast.makeText(this, "Create a new group", Toast.LENGTH_SHORT).show();
        }if(id == R.id.broadcast){
            Toast.makeText(this, "Create a new broadcast", Toast.LENGTH_SHORT).show();
        }if(id == R.id.linked){
            Toast.makeText(this, "Check linked devices", Toast.LENGTH_SHORT).show();
        }if(id == R.id.settings){
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        return  true;
    }
}
