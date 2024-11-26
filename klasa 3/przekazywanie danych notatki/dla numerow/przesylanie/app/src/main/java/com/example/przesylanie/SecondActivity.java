package com.example.przesylanie;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public static final String KEY_TEXT = "klucz dla liczby";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Bundle bundle = getIntent().getExtras();
        int numer = bundle.getInt(KEY_TEXT,0);
        TextView wyswietl = (TextView) findViewById(R.id.tekst);
        wyswietl.setText("odebrałem:"+numer);
    }
}
