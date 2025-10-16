package com.example.myapplication;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
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

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.main);
        AnimationDrawable bg_animation = (AnimationDrawable) relativeLayout.getBackground();
        bg_animation.start();

        final ImageView pilka = (ImageView) findViewById(R.id.pila);
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.bg_animation_second);

        anim.setFillAfter(true);

        ScaleAnimation scaleAnimation = getScaleAnimation(pilka, anim);

        pilka.startAnimation(scaleAnimation);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                pilka.startAnimation(scaleAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });
    }

    @NonNull
    private static ScaleAnimation getScaleAnimation(ImageView pilka, Animation anim) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1, 3,
                1, 3,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f
        );

        scaleAnimation.setDuration(3000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                pilka.startAnimation(anim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });
        return scaleAnimation;

    }

}
