package com.example.playdiary.playdiary;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import Utilities.TextHighlighterOnTouchListener;

/**
 * Created by BALE on 23/03/2017.
 */

public class ActivitySignIn extends AppCompatActivity {
    EditText authorName, password;
    TextView signInButton, forgot;
    ImageView eye;
    Typeface robotoThin, robotoLight, gothic, avenirNextRegular;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        forgot = (TextView)findViewById(R.id.forgot);
        signInButton = (TextView)findViewById(R.id.signInButton);
        authorName = (EditText)findViewById(R.id.authorName);
        password = (EditText)findViewById(R.id.password);
        robotoThin = Typeface.createFromAsset(getAssets(),"fonts/RobotoThin.ttf");
        robotoLight = Typeface.createFromAsset(getAssets(),"fonts/RobotoLight.ttf");
        gothic = Typeface.createFromAsset(getAssets(),"fonts/Gothic.TTF");
        avenirNextRegular = Typeface.createFromAsset(getAssets(),"fonts/avenir-next-regular.ttf");
        password.setTypeface(gothic, Typeface.NORMAL);
        signInButton.setTypeface(gothic, Typeface.NORMAL);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitySignIn.this, ActivityFeed.class);
                startActivity(intent);
            }
        });
        authorName.setTypeface(gothic, Typeface.NORMAL);
        authorName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length() < 1){
                    authorName.setText("@");
                }
                else if( s.toString().length() > 1){
                    if (s.toString().indexOf("@") != 0) {
                        int i = s.toString().indexOf("@");
                        Editable val = s.replace(0, i, "");
                        authorName.setText(val);
                    }
                }
            }
        });
        authorName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(authorName.getText().length() == 0){
                    authorName.setText("@");
                }
            }
        });
        forgot.setTypeface(gothic, Typeface.NORMAL);
        forgot.setOnTouchListener(new TextHighlighterOnTouchListener(forgot));
        String data = forgot.getText().toString();
        SpannableString contentx = new SpannableString(data);
        contentx.setSpan(new UnderlineSpan(), 0, data.length(), 0);
        forgot.setText(contentx);
        signInButton.setOnTouchListener(new TextHighlighterOnTouchListener(signInButton));
        eye = (ImageView)findViewById(R.id.eye);
        eye.setOnTouchListener(new eyeListener());
    }
    private class eyeListener implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                password.setTransformationMethod(null);
                //password.setInputType(EditorInfo.TYPE_CLASS_TEXT);
                eye.setAlpha((float)0.6);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                eye.setAlpha((float) 1.0);
                password.setTransformationMethod(new PasswordTransformationMethod());
            }
            return false;
        }
    }
}
