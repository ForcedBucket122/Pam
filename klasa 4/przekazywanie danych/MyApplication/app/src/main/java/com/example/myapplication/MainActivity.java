package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    Button przeslij;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        przeslij = findViewById(R.id.wyslij);


        przeslij.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity2.class);
            EditText editText = findViewById(R.id.tekst);
            String tekst = String.valueOf(editText.getText());

            EditText editText1 = findViewById(R.id.liczba);
            int liczba = Integer.parseInt(String.valueOf(editText1.getText()));

            intent.putExtra(MainActivity2.KEY_TEXT, tekst);
            intent.putExtra(MainActivity2.KEY_TEXT2, liczba);

            startActivity(intent);
        });
    }
}
