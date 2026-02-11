package com.example.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//1. Klasa sharedpreference umozliwia przechowywanie w pamieci podrecznej danych ktore
// opieraja sie na zmiennych prostych. Klasa tacharakteryzuje sie kluczem oraz wartoscia
public class MainActivity extends AppCompatActivity {

    int count =0;
    public static final String PREF_NAME = "my_prefs";
    public static final String KEY_COUNT = "count";

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

        SharedPreferences preferences = getSharedPreferences(PREF_NAME, 0);
        count = preferences.getInt(KEY_COUNT, 0);

        TextView textView = findViewById(R.id.textView);
        updateTextView(textView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            count++;
            updateTextView(textView);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences preferences = getSharedPreferences(PREF_NAME, 0);
        preferences.edit().putInt(KEY_COUNT, count).apply();
    }

    private void updateTextView(TextView textView){
        textView.setText(String.valueOf(count));
    }
}