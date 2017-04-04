package com.example.playdiary.playdiary;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
<<<<<<< HEAD
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
=======


import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class ActivitySplash extends AppCompatActivity {
    Handler handler;
    Button signInButton, signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        signInButton = (Button)findViewById(R.id.signInButton);
        signUpButton = (Button)findViewById(R.id.signUpButton);
        signInButton.setOnTouchListener(new ButtonTouchListener());
        signUpButton.setOnTouchListener(new ButtonTouchListener());
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitySplash.this, ActivitySignIn.class);
                startActivity(intent);
            }
        });
        handler = new Handler(Looper.getMainLooper());

    }

    private class ButtonTouchListener implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                Button source = (Button)v;
                source.setAlpha((float)0.6);
            }
            else{
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Button source = (Button)v;
                    source.setAlpha((float)1.0);
                }
            }
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
>>>>>>> 935e08bfff1d957224d552bc41cb6381151f361b
    }
}
