package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    public static final String KEY_TEXT = "key_text";
    public static final String KEY_TEXT2 = "key_text2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String tekst = bundle.getString(KEY_TEXT, "");
        int liczba = bundle.getInt(KEY_TEXT2, 0);

        TextView wynik1 = findViewById(R.id.TView);
        TextView wynik2 = findViewById(R.id.NView);

        wynik1.setText(tekst);
        wynik2.setText(String.valueOf(liczba));

    }
}
