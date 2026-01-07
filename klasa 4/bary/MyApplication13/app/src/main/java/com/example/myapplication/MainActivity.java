package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    int naladowanie;
    boolean naladowano;


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
        ProgressBar progressBar = findViewById(R.id.ladowanieProgressBar);
        TextView textView = findViewById(R.id.ladowanieTextView);
        SeekBar seekBar = findViewById(R.id.ladowanieSeekBar);
        Button button = findViewById(R.id.ladowanieButton);
        EditText editText = findViewById(R.id.ocena);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (!editText.getText().toString().equals("")){
                    int ocena = Integer.parseInt(String.valueOf(editText.getText()));
                    ratingBar.setRating(ocena);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });
        ratingBar.setOnClickListener(v -> {
            int wynik = Integer.parseInt(String.valueOf(ratingBar.getRating()));
            editText.setText(wynik);
        });

        naladowanie= progressBar.getProgress();


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                naladowanie = progress;
                progressBar.setProgress(naladowanie);
                textView.setText("Poziom naładowania: "+naladowanie+" %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Runnable runnable;
                Handler handler = new Handler();
                seekBar.setEnabled(false);
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (naladowanie<100)
                        {
                            naladowanie+=1;
                            progressBar.setProgress(naladowanie);
                            seekBar.setProgress(naladowanie);
                            textView.setText("Poziom naładowania: "+naladowanie+" %");
                            handler.postDelayed(this,100);
                            }
                        else
                        {
                            seekBar.setEnabled(true);
                            Toast.makeText(MainActivity.this, "Naładowano w 100%", Toast.LENGTH_SHORT).show();
                        }
                    }
                };
                handler.post(runnable);
            }
        });




    }
}