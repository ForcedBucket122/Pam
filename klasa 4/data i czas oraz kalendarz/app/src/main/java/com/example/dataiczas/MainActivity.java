package com.example.dataiczas;

import android.os.Bundle;
import android.view.View;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public TimePicker picker;
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
        TextClock zegar1 = this.findViewById(R.id.zegar1);
        zegar1.setFormat12Hour(null);
        zegar1.setTimeZone("Europe/Warsaw");
        picker = findViewById(R.id.timePicker);
        picker.setIs24HourView(true);


    }

    public void Pobierz(View view) {

        int hour, minute;
        hour = picker.getHour();
        minute = picker.getMinute();
        TextView textView = findViewById(R.id.tekst);
        textView.setText("Wybrana godzina "+ hour + ":"+String.format("%02d", minute));
    }
}