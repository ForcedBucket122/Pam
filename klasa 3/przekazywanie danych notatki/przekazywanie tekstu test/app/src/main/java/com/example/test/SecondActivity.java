package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public static final String KEY_TEXT = "klucz";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Bundle bundle = getIntent().getExtras();
        String text = bundle.getString(KEY_TEXT,"");
        TextView wyswietl = (TextView) findViewById(R.id.tekst);
        wyswietl.setText("odebrałem:"+text);
    }

}
