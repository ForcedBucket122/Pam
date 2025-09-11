package com.example.widoki;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

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
    int kwota=0;
    public void policz(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        if ((view.getId())==R.id.dostawa) {
            if (checked) {
                kwota = kwota + 10;
            }
            else {
                kwota = kwota - 10;
            }
        }
        else if ((view.getId())==R.id.platnosc) {
            if (checked) {
                kwota = kwota + 5;
            }
            else {
                kwota = kwota - 5;
            }
        }
        else if ((view.getId())==R.id.opakowanie){
                if (checked){
                    kwota=kwota+20;
                }
                else {
                    kwota=kwota-20;
                }
        }
        TextView textView = findViewById(R.id.tekst5);
        textView.setText("Do zapłaty dodatkowo "+kwota+" złotych");
    }

    public void wyczysc(View view) {
        EditText editText = findViewById(R.id.pole1);
        TextView textView1 = findViewById(R.id.tekst1);
        TextView textView3 = findViewById(R.id.tekst3);
        TextView textView5 = findViewById(R.id.tekst5);
        CheckBox dostawa = findViewById(R.id.dostawa);
        CheckBox platnosc = findViewById(R.id.platnosc);
        CheckBox opakowanie = findViewById(R.id.opakowanie);

        editText.setText("");
        textView1.setText("");
        textView3.setText("");
        textView5.setText("");

        dostawa.setChecked(false);
        platnosc.setChecked(false);
        opakowanie.setChecked(false);
    }

    public void zaznaczona(View view) {
        RadioGroup radioGroup = findViewById(R.id.radop_group);
        int id = radioGroup.getCheckedRadioButtonId();
        TextView textView = findViewById(R.id.tekst_kolor);

        if (id == R.id.czerwony) {
            textView.setTextColor(Color.parseColor("#FF0000"));
        }else if(id==R.id.zielony){
            textView.setTextColor(Color.parseColor("#00FF00"));
        }else if (id==R.id.niebieski){
            textView.setTextColor(Color.parseColor("#0000FF"));
        }
    }

    public void sprawdzOdpowiedz(View view) {
        String tekst1="Odpowiedz prawidłowa";
        String tekst2="Odpowiedz błędna";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(this, tekst1, duration);
        Toast toast2 = Toast.makeText(this, tekst2, duration);

        Spinner kolor = findViewById(R.id.spinner);
        String wybor = String.valueOf(kolor.getSelectedItem());

        if(wybor.equals("zielony")){
            toast.show();
        }else{
            toast2.show();
        }
    }
}