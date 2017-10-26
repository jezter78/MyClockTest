package com.example.johnny.myclock;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    final static int IMAGEVIEW_SIZE = 500; //size of the clock hand
    final static float ROTATION_STEP = 360 / 60; //each seconds of clock

    float rotationAngle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dynamically create the clock hand image
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.main_layout);

        final ImageView clockHandImage = new ImageView(this);
        clockHandImage.setImageResource(R.drawable.clockhand);

        LinearLayout.LayoutParams para = new LinearLayout.LayoutParams(
                IMAGEVIEW_SIZE, IMAGEVIEW_SIZE);
        clockHandImage.setLayoutParams(para);
        mainLayout.addView(clockHandImage);

        //set center and rotate the clock hand
        clockHandImage.setPivotX(IMAGEVIEW_SIZE / 2);
        clockHandImage.setPivotY(IMAGEVIEW_SIZE / 2);

        final CountDownTimer clockTimer = new CountDownTimer(61000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                rotationAngle = rotationAngle+ROTATION_STEP;
                clockHandImage.setRotation(rotationAngle);
            }

            @Override
            public void onFinish() {
                cancel();
                //clockHandImage.setRotation(360);
                start();
                rotationAngle=0;
            }
        }.start();

        /*
        //animate the clock
        clockHandImage.animate()
                .rotation(360)
                .setDuration(60000)
                .start();
                */

    }
}
