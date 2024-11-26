package com.example.nauka;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActicity extends AppCompatActivity {
    public static final String KEY_TEXT = "klucz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Bundle bundle = getIntent().getExtras();
        int wyswietl = bundle.getInt(KEY_TEXT, 0);
        TextView text = findViewById(R.id.wynik);
        text.setText(String.valueOf(wyswietl));
    }
}
