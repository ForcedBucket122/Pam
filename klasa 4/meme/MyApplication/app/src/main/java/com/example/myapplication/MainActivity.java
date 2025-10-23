package com.example.myapplication;


import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final ImageView donald = findViewById(R.id.tusk);
        final ImageView opel = findViewById(R.id.opel);
        final Animation idzie = AnimationUtils.loadAnimation(this, R.anim.tusk_idzie);
        final Animation jedzie = AnimationUtils.loadAnimation(this, R.anim.opel_jedzie);
        final Animation umiera = AnimationUtils.loadAnimation(this, R.anim.tusk_umiera);

        idzie.setFillAfter(true);
        jedzie.setFillAfter(true);
        umiera.setFillAfter(true);

        donald.startAnimation(idzie);
        idzie.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                opel.setVisibility(VISIBLE);
                opel.startAnimation(jedzie);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {
                donald.setImageResource(R.drawable.donald);
                donald.setVisibility(VISIBLE);
            }
        });
        jedzie.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                opel.setVisibility(INVISIBLE);
                donald.startAnimation(umiera);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });
        umiera.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                donald.startAnimation(idzie);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {
                donald.setImageResource(R.drawable.martwytusk);
            }
        });

    }

}
