package com.firstofficialproject.aritra.ghuredekhi;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SignUpInput extends AppCompatActivity implements View.OnClickListener {
    TextView ghure_dekhi_title_text;
    ImageView close_button_action_bar;
    AppCompatButton existing_user_sign_in_button, sign_up_button;
    Intent i, j, k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_input);
        close_button_action_bar = findViewById(R.id.close_button_action_bar);
        close_button_action_bar.setOnClickListener(this);
        existing_user_sign_in_button = findViewById(R.id.existing_user_sign_in_button);
        existing_user_sign_in_button.setOnClickListener(this);
        sign_up_button = findViewById(R.id.sign_up_button);
        sign_up_button.setOnClickListener(this);
        ghure_dekhi_title_text = findViewById(R.id.Ghure_Dekhi_title_text);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Papaya_Sunrise.otf");
        ghure_dekhi_title_text.setTypeface(typeface);
        i = new Intent(SignUpInput.this, SignUpInputPassword.class);
        j = new Intent(SignUpInput.this, LoginSignupPage.class);
        k = new Intent(SignUpInput.this, PackageDetails.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close_button_action_bar:
                startActivity(k);
                finish();
                break;
            case R.id.existing_user_sign_in_button:
                startActivity(j);
                finish();
                break;
            case R.id.sign_up_button:
                startActivity(i);
                finish();
                break;
        }
    }

    public void onBackPressed() {
        startActivity(j);
        finish();
    }
}
