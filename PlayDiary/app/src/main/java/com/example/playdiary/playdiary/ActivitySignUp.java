package com.example.playdiary.playdiary;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import Utilities.ImageHighlighterOnTouchListener;
import Utilities.TextHighlighterOnTouchListener;

/**
 * Created by BALE on 22/03/2017.
 */

public class ActivitySignUp extends AppCompatActivity {
    EditText surname, firstname, email, phoneNumber, password, authorName, diaryName;
    TextView createButton, termsLink;
    CheckBox checkBox;
    ImageView eye;
    Typeface robotoThin, robotoLight, gothic, avenirNextRegular;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        robotoThin = Typeface.createFromAsset(getAssets(),"fonts/RobotoThin.ttf");
        robotoLight = Typeface.createFromAsset(getAssets(),"fonts/RobotoLight.ttf");
        gothic = Typeface.createFromAsset(getAssets(),"fonts/Gothic.TTF");
        avenirNextRegular = Typeface.createFromAsset(getAssets(),"fonts/avenir-next-regular.ttf");
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        surname = (EditText)findViewById(R.id.surname);
        firstname = (EditText)findViewById(R.id.firstname);
        email = (EditText)findViewById(R.id.email);
        phoneNumber = (EditText)findViewById(R.id.phoneNumber);
        password = (EditText)findViewById(R.id.password);
        authorName = (EditText)findViewById(R.id.authorName);
        diaryName = (EditText)findViewById(R.id.diaryName);
        eye = (ImageView)findViewById(R.id.eye);
        eye.setOnTouchListener(new eyeListener());
        surname.setTypeface(gothic, Typeface.NORMAL);
        firstname.setTypeface(gothic, Typeface.NORMAL);
        email.setTypeface(gothic, Typeface.NORMAL);
        phoneNumber.setTypeface(gothic, Typeface.NORMAL);
        password.setTypeface(gothic, Typeface.NORMAL);
        authorName.setTypeface(gothic, Typeface.NORMAL);
        diaryName.setTypeface(gothic, Typeface.NORMAL);

        authorName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(authorName.getText().length() == 0){
                    authorName.setText("@");
                }
            }
        });
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
        createButton =  (TextView)findViewById(R.id.createButton);
        createButton.setOnTouchListener(new TextHighlighterOnTouchListener(createButton));
        createButton.setTypeface(gothic, Typeface.NORMAL);
        termsLink = (TextView)findViewById(R.id.termsLink);
        termsLink.setOnTouchListener(new TextHighlighterOnTouchListener(termsLink));
        String data = termsLink.getText().toString();
        SpannableString contentx = new SpannableString(data);
        contentx.setSpan(new UnderlineSpan(), 0, data.length(), 0);
        termsLink.setText(contentx);
        termsLink.setTypeface(gothic, Typeface.NORMAL);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        checkBox.setTypeface(gothic, Typeface.NORMAL);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivitySignUp.this);
                View view = getLayoutInflater().inflate(R.layout.dialog_sign_up_confirmation, null);
                builder.setView(view);
                TextView title = (TextView)view.findViewById(R.id.title);
                TextView message = (TextView)view.findViewById(R.id.message);
                EditText confirmationCode = (EditText)view.findViewById(R.id.confirmationCode);
                TextView confirmConfirmationCode = (TextView)view.findViewById(R.id.confirmConfirmationCode);
                title.setTypeface(gothic, Typeface.NORMAL);
                message.setTypeface(gothic, Typeface.NORMAL);
                confirmationCode.setTypeface(gothic, Typeface.NORMAL);
                confirmConfirmationCode.setTypeface(gothic, Typeface.NORMAL);
                confirmConfirmationCode.setOnTouchListener(new TextHighlighterOnTouchListener(confirmConfirmationCode));
                final AlertDialog dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                confirmConfirmationCode.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
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
