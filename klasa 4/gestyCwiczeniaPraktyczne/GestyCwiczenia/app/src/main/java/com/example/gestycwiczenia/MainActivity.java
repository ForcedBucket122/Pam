package com.example.gestycwiczenia;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener{
    private GestureDetector detector;
    public int i=0;
    private TextView textView;
    private RelativeLayout layout;

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
         detector= new GestureDetector(this, this);
         textView = findViewById(R.id.licznik);
         layout = findViewById(R.id.layout);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDoubleTap(@NonNull MotionEvent e) {
        Toast.makeText(this, "podwójne kliknięcie", Toast.LENGTH_SHORT).show();
        licznikUpdate();
        zmianaKoloru(android.R.color.holo_blue_dark);
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
        Toast.makeText(this, "pojedyncze kliknięcie", Toast.LENGTH_SHORT).show();
        licznikUpdate();
        zmianaKoloru(android.R.color.holo_green_dark);
        return false;
    }

    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
        Toast.makeText(this, "przesunięcie palcem", Toast.LENGTH_SHORT).show();
        licznikUpdate();
        zmianaKoloru(android.R.color.holo_orange_dark);
        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent e) {
        Toast.makeText(this, "Długie przytrzymanie", Toast.LENGTH_SHORT).show();
        licznikUpdate();
        zmianaKoloru(android.R.color.holo_red_dark);
    }

    @Override
    public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {

        return false;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent e) {
        return false;
    }
    public void licznikUpdate(){
        i++;
        textView.setText("Licznik wykonanych gestów: "+i);
    }
    public void zmianaKoloru(int kolorId){
        layout.setBackgroundColor(ContextCompat.getColor(this, kolorId));
    }
}