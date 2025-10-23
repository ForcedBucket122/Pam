package com.example.myapplication;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final ImageView ludzik = (ImageView) findViewById(R.id.ludzik);
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.bg_animation);
        final Animation gora = AnimationUtils.loadAnimation(this, R.anim.gora);
        final Animation dol = AnimationUtils.loadAnimation(this, R.anim.dol);
        final Animation srodek = AnimationUtils.loadAnimation(this, R.anim.srodek);

        anim.setFillAfter(true);
        gora.setFillAfter(true);
        dol.setFillAfter(true);
        srodek.setFillAfter(true);

        TranslateAnimation translateAnimation =new TranslateAnimation(
                450, -450,
                Animation.RELATIVE_TO_SELF,0.5f
                );
        translateAnimation.setDuration(3000);
        translateAnimation.setFillAfter(true);

        TranslateAnimation translateAnimation2 =new TranslateAnimation(
                -450, 0,
                Animation.RELATIVE_TO_SELF,0.5f
        );

        translateAnimation2.setDuration(1500);
        translateAnimation2.setFillAfter(true);

        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 1440,
                100, 100,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotateAnimation.setDuration(1500);
        rotateAnimation.setFillAfter(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(
              1, 25,
              1, 25,
              Animation.RELATIVE_TO_SELF, 0.5f,
              Animation.RELATIVE_TO_SELF, 0.5f
        );
        scaleAnimation.setDuration(1500);
        scaleAnimation.setFillAfter(true);

        ScaleAnimation scaleAnimation2 = new ScaleAnimation(
              25, 3,
              25, 3,
              Animation.RELATIVE_TO_SELF, 0.5f,
              Animation.RELATIVE_TO_SELF, 0.5f
        );
        scaleAnimation2.setDuration(1500);
        scaleAnimation2.setFillAfter(true);

        ludzik.startAnimation(anim);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                ludzik.startAnimation(translateAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                ludzik.startAnimation(translateAnimation2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });

        translateAnimation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                ludzik.startAnimation(rotateAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                ludzik.startAnimation(scaleAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                ludzik.setImageResource(R.drawable.salute);
                ludzik.startAnimation(scaleAnimation2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });
        scaleAnimation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                ludzik.startAnimation(gora);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });
        gora.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                ludzik.startAnimation(dol);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });
        dol.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                ludzik.startAnimation(srodek);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });
        srodek.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                ludzik.setImageResource(R.drawable.ludzik);
                ludzik.startAnimation(anim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });
    }

}
