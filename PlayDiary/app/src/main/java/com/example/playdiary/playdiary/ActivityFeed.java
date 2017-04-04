package com.example.playdiary.playdiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import Utilities.ImageHighlighterOnTouchListener;

/**
 * Created by BALE on 27/03/2017.
 */

public class ActivityFeed extends AppCompatActivity{
    ImageView button3;
    LinearLayout reflectorDashboard;
    int state = 0;
    Animation loadAnimation, loadAnimation2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        button3 = (ImageView)findViewById(R.id.button3);
        reflectorDashboard = (LinearLayout)findViewById(R.id.reflectorDashboard);
        button3.setOnTouchListener(new ImageHighlighterOnTouchListener(button3));
        loadAnimation = AnimationUtils.loadAnimation(ActivityFeed.this, R.anim.animation_reflector_dashboard);
        loadAnimation2 = AnimationUtils.loadAnimation(ActivityFeed.this, R.anim.animation_reflector_dashboard_reverse);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(state == 1){
                    reflectorDashboard.startAnimation(loadAnimation2);
                    reflectorDashboard.setVisibility(View.INVISIBLE);
                    state = 0;
                }
                else {
                    reflectorDashboard.startAnimation(loadAnimation);
                    reflectorDashboard.setVisibility(View.VISIBLE);
                    state = 1;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_feed,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.settingsMenu){
            Intent intent = new Intent(ActivityFeed.this, ActivitySettings.class);
            startActivity(intent);
        }
        return true;
    }
}
