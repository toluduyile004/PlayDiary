package com.example.playdiary.playdiary;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import Utilities.TextHighlighterOnTouchListener;

public class ActivityDefault extends AppCompatActivity {
    TextView loginButton, signUpButton, past, present, future;
    ImageView welcomeImage;
    Typeface robotoThin, robotoLight, gothic, avenirNextRegular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_default);
        robotoThin = Typeface.createFromAsset(getAssets(),"fonts/RobotoThin.ttf");
        robotoLight = Typeface.createFromAsset(getAssets(),"fonts/RobotoLight.ttf");
        gothic = Typeface.createFromAsset(getAssets(),"fonts/Gothic.TTF");
        avenirNextRegular = Typeface.createFromAsset(getAssets(),"fonts/avenir-next-regular.ttf");
        welcomeImage = (ImageView)findViewById(R.id.welcomeImage);
        loginButton = (TextView)findViewById(R.id.loginButton);
        signUpButton = (TextView)findViewById(R.id.signUpButton);
        loginButton.setOnTouchListener(new TextHighlighterOnTouchListener(loginButton));
        signUpButton.setOnTouchListener(new TextHighlighterOnTouchListener(signUpButton));
        loginButton.setTypeface(gothic, Typeface.NORMAL);
        signUpButton.setTypeface(gothic, Typeface.NORMAL);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDefault.this, ActivitySignUp.class);
                startActivity(intent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDefault.this, ActivitySignIn.class);
                startActivity(intent);
            }
        });
        past = (TextView)findViewById(R.id.past);
        present = (TextView)findViewById(R.id.present);
        future = (TextView)findViewById(R.id.future);
        past.setTypeface(gothic, Typeface.NORMAL);
        present.setTypeface(gothic, Typeface.NORMAL);
        future.setTypeface(gothic, Typeface.NORMAL);
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
    }


}
