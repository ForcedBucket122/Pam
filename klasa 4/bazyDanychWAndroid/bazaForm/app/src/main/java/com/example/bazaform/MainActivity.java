package com.example.bazaform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
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
        Button button = findViewById(R.id.dodaj);
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

        Intent intent = new Intent(this, DrugaAktywnosc.class);

        intent.putExtra("imie", im2);
        intent.putExtra("nazwisko", naz2);
        intent.putExtra("klasa", kl2);
        startActivity(intent);
    }
}