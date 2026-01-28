package com.example.zaliczeniejsz;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    private SeekBar seekBar;
    private TextView textSeekBar;
    private RatingBar ratingBar;
    private TextView textRatingBar;
    private Button zatwierdz;
    private ProgressBar progressBar;

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
        seekBar = findViewById(R.id.seekB);
        textSeekBar = findViewById(R.id.wartoscSeekB);
        ratingBar = findViewById(R.id.ratingB);
        textRatingBar = findViewById(R.id.wartoscRatingB);
        zatwierdz = findViewById(R.id.zatwierdz);
        progressBar = findViewById(R.id.progressB);
        LinearLayout main = findViewById(R.id.main);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSeekBar.setText(String.valueOf(progress));
                if (progress<4){
                    main.setBackgroundColor(Color.GREEN);
                }else {
                    main.setBackgroundColor(Color.YELLOW);
                }
                if (progress>3){
                    progressBar.setProgress(30);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            int lGwiazdek = (int) rating;
            textRatingBar.setText("Twoja ocena "+String.valueOf(lGwiazdek)+ " gwiazdek");
            if (rating>=2){
                progressBar.setProgress(70);
            }
            if (rating<3) {
                textRatingBar.setTextColor(Color.RED);
            }
            if (rating==3 || rating==4){
                textRatingBar.setTextColor(Color.BLACK);
            }
            if (rating>4){
                textRatingBar.setTextColor(Color.GREEN);
            }

        });

        zatwierdz.setOnClickListener(v -> {
            progressBar.setProgress(100);
            Toast.makeText(MainActivity.this, "Formularz  uzupełniony", Toast.LENGTH_SHORT).show();
        });

    }
}