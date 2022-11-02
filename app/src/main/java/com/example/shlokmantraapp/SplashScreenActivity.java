package com.example.shlokmantraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    Animation animation;
    TextView textView;
    ImageView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        i1=findViewById(R.id.imageView6);
        textView=findViewById(R.id.ttt);
        animation   = AnimationUtils.loadAnimation(this,R.anim.splash);
        i1.startAnimation(animation);
        textView.startAnimation(animation);
        final Intent intent=new Intent(this,MenuActivity.class);
        Thread timer=new Thread(){
            public void run(){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}