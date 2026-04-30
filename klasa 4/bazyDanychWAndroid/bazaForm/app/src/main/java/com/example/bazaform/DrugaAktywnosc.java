package com.example.bazaform;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DrugaAktywnosc extends AppCompatActivity {
    Asystent asystent = new Asystent(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.druga_aktywnosc);


        Button button = findViewById(R.id.dodaj1);
        button.setOnClickListener(v -> {
            dodaj();
        });

    }

    public void dodaj(){
        EditText im = findViewById(R.id.imie);
        EditText naz = findViewById(R.id.nazwisko);
        EditText kl =findViewById(R.id.klasa);

        String im2 = im.getText().toString();
        String naz2 = naz.getText().toString();
        String kl2 = kl.getText().toString();

        Intent intent = new Intent(this, DodajDoBazy.class);

        intent.putExtra("imie", im2);
        intent.putExtra("nazwisko", naz2);
        intent.putExtra("klasa", kl2);
        startActivity(intent);
    }
}
