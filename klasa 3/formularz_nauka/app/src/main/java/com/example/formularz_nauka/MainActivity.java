package com.example.formularz_nauka;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    AlertDialog.Builder dialog;
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
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.wyksztalcenie, android.R.layout.simple_spinner_item
        );
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Reset");
        dialog.setMessage("Czy na pewno chcesz kontynuowac?");
        dialog.setPositiveButton("tak", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText login = findViewById(R.id.login);
                EditText password = findViewById(R.id.password);
                EditText pesel = findViewById(R.id.pesel);
                EditText email = findViewById(R.id.email);

                RadioButton m = findViewById(R.id.male);
                RadioButton k = findViewById(R.id.female);

                CheckBox akceptuj = findViewById(R.id.checkbox);

                Spinner wyksztalcenie = findViewById(R.id.spinner);


                login.setText("");
                password.setText("");
                pesel.setText("");
                email.setText("");

                m.setChecked(false);
                k.setChecked(false);

                akceptuj.setChecked(false);

                wyksztalcenie.setSelection(0);

                //reset wszystkiego
            }
        });
        dialog.setNegativeButton("nie", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.create();
    }
    public void Clear(View view) {
        dialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}