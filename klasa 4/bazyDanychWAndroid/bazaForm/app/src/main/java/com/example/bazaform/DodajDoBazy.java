package com.example.bazaform;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DodajDoBazy extends AppCompatActivity {
    Asystent asystent = new Asystent(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.dodaj_do_bazy);


        Button wpisz = findViewById(R.id.wpisz1);
        Button wypisz = findViewById(R.id.wypisz1);

        Bundle bundle = getIntent().getExtras();

        String imie = bundle.getString("imie");
        String nazwisko = bundle.getString("nazwisko");
        String klasa = bundle.getString("klasa");

        asystent.dodaj(imie, nazwisko, klasa);

        wpisz.setOnClickListener(v -> {
            Intent intent = new Intent(this, DrugaAktywnosc.class);
            startActivity(intent);

        });
        wypisz.setOnClickListener(v -> {
            Intent intent = new Intent(this, WypiszDane.class);
            startActivity(intent);
        });
    }

}
