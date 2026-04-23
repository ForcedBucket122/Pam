package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gestureDetector = new GestureDetector(this, this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        zamianaKolorow(android.R.color.holo_blue_dark);
        return true;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent e) {
        zamianaKolorow(android.R.color.holo_green_light);
    }

    @Override
    public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
        zamianaKolorow(android.R.color.holo_green_light);
        return true;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent e) {
        zamianaKolorow(android.R.color.holo_green_light);
    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent e) {
        zamianaKolorow(android.R.color.holo_green_light);
        return true;
    }

    private void zamianaKolorow(int colorId){
        RelativeLayout layout = findViewById(R.id.layout);
        layout.setBackgroundColor(ContextCompat.getColor(this, colorId));
        new Handler(Looper.getMainLooper()).postDelayed(() -> layout.setBackground(null), 500);
    }

    @Override public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) { return false; }
}
