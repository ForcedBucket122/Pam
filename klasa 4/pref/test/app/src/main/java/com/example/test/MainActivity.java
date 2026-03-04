package com.example.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText wiek;
    EditText name;
    TextView wyswietl;
    TextView uruchomienia;
    SharedPreferences sharedPreferences;
    SharedPreferences sharedPreferences2;
    int i2 =0;

    public static final String mypreferences = "mypref";
    public static final String mypreferences2 = "mypref2";
    public static final String Imie = "imieKey";
    public static final String Wiek = "wiekKey";
    public static final String ile = "ileKey";

    String text = "";

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
        uruchomienia = findViewById(R.id.uruchomienia);

        Button zapisz = findViewById(R.id.zapisz);
        Button wyczysc = findViewById(R.id.wyczysc);

        sharedPreferences = getSharedPreferences(mypreferences, Context.MODE_PRIVATE);
        sharedPreferences2 = getSharedPreferences(mypreferences2, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences2.edit();
        editor.putInt(ile, i2);
        editor.apply();

        loadData();
        ileRazy();

        zapisz.setOnClickListener(v -> Zapisz());
        wyczysc.setOnClickListener(v -> Wyczysc());
    }

    public void loadData(){
            text += sharedPreferences.getString(Imie, "") + " ";
            text += sharedPreferences.getString(Wiek, "");
        wyswietl.setText(text);
    }
    public void Zapisz() {
        String n = name.getText().toString().trim();
        String w = wiek.getText().toString().trim();

        if (n.equals("")||n.equals(null)){
            Toast.makeText(this, "Wpisz imie!", Toast.LENGTH_SHORT).show();
        } else if (w.equals("")||w.equals(null)) {
            Toast.makeText(this, "Wpisz wiek!", Toast.LENGTH_SHORT).show();
        }else{

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(Imie, n);
            editor.putString(Wiek, w);
            editor.apply();

            text = n + " " + w;
            wyswietl.setText(text);

            name.setText("");
            wiek.setText("");

            Toast.makeText(this, "Zapisano", Toast.LENGTH_SHORT).show();
        }

    }

    public void Wyczysc() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        name.setText("");
        wiek.setText("");
        text = "";
        wyswietl.setText("");
    }
    public void ileRazy(){
        i2 = sharedPreferences2.getInt(ile, 0);
        i2++;
        uruchomienia.setText(String.valueOf(i2));
    }
}
