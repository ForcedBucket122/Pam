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
    AlertDialog.Builder dialogBuilder;
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
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(
                this,R.array.wyksztalcenie, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        dialogBuilder= new AlertDialog.Builder(this);
        dialogBuilder.setMessage("Czy na pewno chcesz wyczyscic formularz?");
        dialogBuilder.setPositiveButton("Tak", (dialog, which) -> {
            EditText login = findViewById(R.id.login);
            EditText password = findViewById(R.id.password);
            EditText pesel = findViewById(R.id.pesel);
            EditText email = findViewById(R.id.email);

            RadioButton m = findViewById(R.id.male);
            RadioButton k = findViewById(R.id.female);

            CheckBox akceptuj = findViewById(R.id.checkbox);

//            Spinner wyksztalcenie = findViewById(R.id.spinner);


            login.setText("");
            password.setText("");
            pesel.setText("");
            email.setText("");

            m.setChecked(false);
            k.setChecked(false);

            akceptuj.setChecked(false);

            spinner.setSelection(0);
        });
        dialogBuilder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });
        dialogBuilder.create();

    }
    public void Clear(View view){
        dialogBuilder.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}