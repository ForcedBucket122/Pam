package com.example.myapplication;

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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity{

    private ListView lista;
    private EditText editText;
    private EditText editText2;
    private ArrayList<String> data;
    private LinkedList<Integer> data2;
    private ArrayAdapter<String > adapter;
    private ArrayAdapter<Integer> adapter2;
    private ListView listaLiczb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.lista);

        editText = (EditText) findViewById(R.id.edit_Text);

        data = new ArrayList<>();

        data.add("piłka");
        data.add("basen");
        data.add("buty");
        data.add("stół");
        data.add("półka");

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                data);
        lista.setAdapter(adapter);





        listaLiczb = (ListView) findViewById(R.id.listaLiczb);

        editText2 = (EditText) findViewById(R.id.edit_Text2);

        data2 = new LinkedList<Integer>();

        data2.add(1);
        data2.add(67);
        data2.add(67);
        data2.add(67);
        data2.add(67);
        data2.add(67);

        adapter2 = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_list_item_1,
                data2);
        listaLiczb.setAdapter(adapter2);


    }

    public void onBtnClick(View view) {
        String text = String.valueOf(editText.getText());
        data.add(text);
        adapter.notifyDataSetChanged();
    }

    public void onBtnClickClear(View view) {
        data.clear();
        adapter.notifyDataSetChanged();
    }

    public void Dodaj_liczbe(View view) {
        int liczba = Integer.parseInt(String.valueOf(editText2.getText()));
        data2.add(liczba);
        adapter2.notifyDataSetChanged();
    }

    public void Wyczysc_liczby(View view) {
        data2.clear();
        adapter2.notifyDataSetChanged();
    }
}