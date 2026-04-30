package com.example.bazaform;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WypiszDane extends AppCompatActivity {
    Asystent asystent = new Asystent(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.wypisz_dane);

        TextView textView = findViewById(R.id.tekst1);
        Button wpisz = findViewById(R.id.wpisz2);

        Cursor k = asystent.wypiszCalosc();

        while (k.moveToNext()){
            int id = k.getInt(0);
            String imie2 = k.getString(1);
            String nazwisko2 = k.getString(2);
            String klasa2 = k.getString(3);

            textView.setText(String.format("%s\n%d. %s %s %s", textView.getText(), id, imie2, nazwisko2, klasa2));

        }

        wpisz.setOnClickListener(v -> {
            Intent intent = new Intent(this, DrugaAktywnosc.class);
            startActivity(intent);

        });

    }

}
