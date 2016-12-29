package com.util.diablo.utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.util.diablo.utils.rsa.RSATest;

import static android.R.attr.centerX;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final String INFO = "hello girl,your steal my heart!";

    private TextView textView;
    private Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        long time = System.currentTimeMillis();
//        System.out.println(TimeUtiles.formatData(time, TimeUtiles.FORMAT1));
//        System.out.println(TimeUtiles.getYMDHMS(time));
        intitViews();
    }

    private void intitViews() {
        Button encodeBtn = (Button) findViewById(R.id.rsa_encode);
        encodeBtn.setOnClickListener(this);
        Button decodeBtn = (Button) findViewById(R.id.rsa_decode);
        decodeBtn.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.textView);
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rsa_decode:
                System.out.println("解密后的结果为:" + RSATest.decodeInfo(RSATest.encodeInfo(INFO, MainActivity.this), MainActivity.this));
                break;
            case R.id.rsa_encode:
                System.out.println("加密后的结果为:" + RSATest.encodeInfo(INFO, MainActivity.this));
                break;
            case R.id.start:
                startAnimation();
                break;
        }
    }

    private void startAnimation(){

    }
}
