package com.example.zadaniekalendarz;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

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

        Calendar c =Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);

        EditText data = findViewById(R.id.data);

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                data.setText(String.format("%02d", dayOfMonth)+"."+String.format("%02d", month)+"."+year);
            }
        }, year, month, dayOfMonth);

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
        Button wyslij = findViewById(R.id.wyslij);
        wyslij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText imie = findViewById(R.id.imie);
                EditText nazwisko = findViewById(R.id.nazwisko);
                String dane = String.valueOf(data.getText()) +
                        imie.getText() +
                        nazwisko.getText();
                TextView wynik = findViewById(R.id.wynik);
                wynik.setText(dane);
            }
        });
    }
}