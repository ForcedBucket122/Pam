package com.example.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText wiek;
    private EditText name;
    private TextView wyswietl;
    private SharedPreferences sharedPreferences;
    public static final String mypreferences = "mypref";
    public static final String Imie = "imieKey";
    public static final String Wiek = "wiekKey";

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
        wiek = findViewById(R.id.wiek);
        name = findViewById(R.id.imie);
        wyswietl = findViewById(R.id.zapisaneDane);
        String text = "";
        sharedPreferences = getSharedPreferences(mypreferences, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(Imie))
            text+=sharedPreferences.getString(Imie, "");
        if (sharedPreferences.contains(Wiek))
            text+= " " +sharedPreferences.getString(Wiek, "");

        wyswietl.setText(text);

        Button zapisz = findViewById(R.id.zapisz);
        Button wyczysc = findViewById(R.id.wyczysc);

        zapisz.setOnClickListener(v -> Zapisz());
        wyczysc.setOnClickListener(v -> Wyczysc());
    }

    public void Zapisz(){
        String n = name.getText().toString();
        String w = String.valueOf(Integer.parseInt(wiek.getText().toString()));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Imie, n);
        editor.putString(Wiek, w);
        editor.apply();

        String text="";
        if (sharedPreferences.contains(Imie))
            text+=sharedPreferences.getString(Imie, "");
        if (sharedPreferences.contains(Wiek))
            text+= " "+ sharedPreferences.getString(Wiek, "");

        wyswietl.setText(text);
        name.setText(" ");
        wiek.setText(" ");
    }
    public void Wyczysc(){


    }
}