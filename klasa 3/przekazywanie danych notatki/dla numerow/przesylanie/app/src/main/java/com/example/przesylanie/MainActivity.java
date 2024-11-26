package com.example.przesylanie;

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
        setContentView(R.layout.activity_main);
    }
    public void Otworz(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        EditText edit = (EditText) findViewById(R.id.editText);
        int odbierz = Integer.parseInt(String.valueOf(edit.getText()));
        intent.putExtra(SecondActivity.KEY_TEXT, odbierz);
        startActivity(intent);
    }
}