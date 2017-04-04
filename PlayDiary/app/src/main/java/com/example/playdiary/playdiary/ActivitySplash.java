package com.example.playdiary.playdiary;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by BALE on 22/03/2017.
 */

public class ActivitySplash extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ActivitySplash.this, ActivityDefault.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
