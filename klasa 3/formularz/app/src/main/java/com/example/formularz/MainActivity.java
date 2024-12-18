package com.example.formularz;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

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
        Spinner spinner = findViewById(R.id.edukacja);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.edukacjaTablica, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setMessage("Czy na pewno chcesz wyczyscic formularz?");
        dialogBuilder.setPositiveButton("tak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText login = findViewById(R.id.login);
                EditText password = findViewById(R.id.password);
                EditText pesel = findViewById(R.id.pesel);
                EditText email = findViewById(R.id.email);

                RadioButton m = findViewById(R.id.man);
                RadioButton k = findViewById(R.id.woman);

                CheckBox akceptuj = findViewById(R.id.regulamin);

                Spinner wyksztalcenie = findViewById(R.id.edukacja);


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
        dialogBuilder.setNegativeButton("nie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogBuilder.create();
    }
    public void ClearAll(View view){
        dialogBuilder.show();}

    public void onGenderBtnClick(View view){
        RadioButton m = findViewById(R.id.man);
        RadioButton k = findViewById(R.id.woman);
        if (m.isChecked()){

        } else if (k.isChecked()) {

        }
    }
    public void zaznaczPoleWyboru(View view){boolean isChecked = ((CheckBox)view).isChecked();}

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}