package com.example.widoki;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    public void wypiszTekst(View view) {
        EditText text = findViewById(R.id.pole1);
        String pobrany = text.getText().toString();
        TextView napis = findViewById(R.id.tekst1);
        napis.setText(pobrany);
    }

    public void wlaczony(View view) {
        TextView text1 = findViewById(R.id.tekst2);
        boolean stan=((ToggleButton) view).isChecked();
        if (stan){
            text1.setText("Wyraziłeś zgodę na jesiotra");
        }else{
            text1.setText("Nie wyraziłeś zgody na jesiotra");
        }
    }

    public void wlaczony_switch(View view) {
        TextView text1 = findViewById(R.id.tekst3);
        boolean stan=((Switch) view).isChecked();
        if (stan){
            text1.setText("Wyraziłeś zgodę na jesiotra");
        }else{
            text1.setText("Nie wyraziłeś zgody na jesiotra");
        }
    }

    public void policz(View view) {
    }
}