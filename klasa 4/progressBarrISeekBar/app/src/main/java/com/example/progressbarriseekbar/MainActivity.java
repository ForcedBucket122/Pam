package com.example.progressbarriseekbar;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

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

        ProgressBar pBar = findViewById(R.id.pBar);
        SeekBar sBar = findViewById(R.id.sBar);
        RatingBar rBar = findViewById(R.id.rate);
        TextView textView = findViewById(R.id.tekst);
        ProgressBar progressBar = findViewById(R.id.progress_horizontal);

        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                pBar.setProgress(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new CountDownTimer(20000, 100) {
            @Override
            public void onFinish() {
                progressBar.setProgress(200);
            }

            @Override
            public void onTick(long l) {
                int progress = Math.toIntExact(((20000 - l) / 100));
                progressBar.setProgress(progress);
            }
        }.start();

        rBar.setOnRatingBarChangeListener((ratingBar, v, b) -> textView.setText(String.valueOf(v)));

    }
}