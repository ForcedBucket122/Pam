package com.example.myapplication;

import static com.example.myapplication.SecondActivity.KEY_NAME;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
    public void OnClickSend(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        EditText tekst = findViewById(R.id.tekst);
        EditText liczba = findViewById(R.id.liczba);

        String Tekst = String.valueOf(tekst.getText());
        int Liczba = Integer.parseInt(String.valueOf(liczba.getText()));

        intent.putExtra(SecondActivity, KEY_NAME, tekst);
        intent.putExtra(SecondActivity, KEY_NAME, liczba);
        startActivity(intent);
    }
}