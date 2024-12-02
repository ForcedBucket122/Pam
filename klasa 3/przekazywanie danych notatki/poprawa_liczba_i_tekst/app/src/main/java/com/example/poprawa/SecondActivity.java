package com.example.poprawa;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    public static final String KEY_NAME = "klucz";
    public static final String KEY_NAME1 = "klucz1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Bundle bundle = getIntent().getExtras();
//        assert bundle != null;
        int liczba = bundle.getInt(KEY_NAME1, 0);
        String tekst = bundle.getString(KEY_NAME, "");

        TextView wynikLiczba = findViewById(R.id.wynikLiczba);
        TextView wynikTekst = findViewById(R.id.wynikTekst);

        wynikLiczba.setText(String.valueOf(liczba));
        wynikTekst.setText(tekst);
    }
}
