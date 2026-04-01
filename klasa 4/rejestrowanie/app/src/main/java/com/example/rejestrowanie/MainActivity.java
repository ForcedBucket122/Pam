package com.example.rejestrowanie;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText haslo1;
    private EditText haslo2;
    private Button zatwierdz;
    private TextView wynik;
    private String e;
    private String h1;
    private String h2;

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

        email = findViewById(R.id.email);
        haslo1 = findViewById(R.id.haslo1);
        haslo2 = findViewById(R.id.haslo2);
        zatwierdz = findViewById(R.id.zatwierdz);
        wynik = findViewById(R.id.wynik);


        zatwierdz.setOnClickListener(v -> czyPoprawnie());
    }

    public void czyPoprawnie(){
        String e = String.valueOf(email.getText());
        String h1 = String.valueOf(haslo1.getText());
        String h2 = String.valueOf(haslo2.getText());

        if (e.contains("@") && Objects.equals(h1, h2) $$){
            wynik.setText(String.format("%s%s", getString(R.string.witaj), e));
        } else if (!e.contains("@")) {
            wynik.setText(R.string.nieprawid_owy_adres_e_mail);
        } else if (!Objects.equals(h1, h2)) {
            wynik.setText(R.string.has_a_si_r_ni);
        }else{
            wynik.setText("BŁĄD");
        }
    }
    public boolean haslo(String x){

        boolean czyPoprawnie = false;
        String alfabet = "qwertyuioplkjhgfdsazxcvbnm";
        alfabet= alfabet.toUpperCase();
        char[] tab = alfabet.toCharArray();

        int[] cyfry = {0,1,2,3,4,5,6,7,8,9};
        for (char i:tab) {
            if (x.contains(String.valueOf(i))) {
                czyPoprawnie=true;

            }
        }
         return czyPoprawnie;
        }
    }
}