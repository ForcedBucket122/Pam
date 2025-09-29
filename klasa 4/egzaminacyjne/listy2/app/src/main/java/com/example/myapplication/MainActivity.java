package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity{

    private EditText zawodnik;
    private ListView lista;
    private ListView mapa;
    private LinkedList <String> zawodnicy;
    private ArrayAdapter <String > adapter;
//    private ArrayAdapter <Integer, String> adapter2;
    private HashMap <Integer, String> druzyny;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        zawodnik = findViewById(R.id.zawodnik);

        zawodnicy = new LinkedList<String>();
        druzyny = new HashMap<Integer, String >();
//        druzyny

        lista = findViewById(R.id.lista);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                zawodnicy);


        lista.setAdapter(adapter);
//        mapa.setAdapter(adapter2);
    }

    public void DodajZawodnika(View view) {
        String tekst = String.valueOf(zawodnik.getText());
        zawodnicy.add(tekst);
        adapter.notifyDataSetChanged();
    }
}