package com.example.data_i_czas;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TimePicker picker;
    private DatePickerDialog datePickerDialog;

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

        TextClock clock = findViewById(R.id.clock);
        clock.setTimeZone("Europe/Warsaw");
        clock.setFormat12Hour(null);

        picker = findViewById(R.id.timePicker);
        picker.setIs24HourView(true);

        Calendar calendar = Calendar.getInstance();

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                TextView textView = findViewById(R.id.data);
                textView.setText(dayOfMonth+"."+String.format("%02d", monthOfYear+1)+ "."+year);
            }
        }, year, month, day);
    }

    public void godzina(View view) {
        int hour,minute;
        hour = picker.getHour();
        minute = picker.getMinute();
        TextView textView = findViewById(R.id.godzina);
        textView.setText(hour + ":" + minute);
    }

    public void data(View view) {
        datePickerDialog.show();
    }

}