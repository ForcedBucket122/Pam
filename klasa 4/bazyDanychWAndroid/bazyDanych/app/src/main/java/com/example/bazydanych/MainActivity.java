package com.example.bazydanych;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Asystent asystent = new Asystent(this);
    Cursor k;

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
        TextView tekst = findViewById(R.id.tekst1);
        dodajDane();
        k=asystent.wypiszCalosc();
        while (k.moveToNext()){
            int id=k.getInt(0);
            String imie = k.getString(1);
            String nazwisko = k.getString(2);
            String klasa = k.getString(3);
            tekst.setText(String.format("%s\n%d. %s %s %s", tekst.getText(), id, imie, nazwisko, klasa));
        }
        k.close();
    }
    public void dodajDane(){
        int ilosc2 = asystent.policz();
        if (ilosc2==0){
            asystent.dodaj("Jan","Kowalski","1PT");
            asystent.dodaj("Ewa","Nowak","2PT");
            asystent.dodaj("Stanisław","Malinowski","3PT");
        }
    }
}