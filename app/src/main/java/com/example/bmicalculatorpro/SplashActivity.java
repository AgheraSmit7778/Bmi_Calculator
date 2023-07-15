package com.example.bmicalculatorpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView me = findViewById(R.id.imageView);
        ImageView we = findViewById(R.id.imageView2);


                Animation aa = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeing);
                me.startAnimation(aa);

                Animation bb = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
                we.startAnimation(bb);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent iHome = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(iHome);
                finish();

            }
        },3000);
    }
}