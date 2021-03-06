package com.firstofficialproject.aritra.ghuredekhi;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginSignupPage extends AppCompatActivity implements View.OnClickListener {
    ImageView close_button_action_bar;
    TextView ghure_dekhi_title_text;
    AppCompatButton new_user_sign_up_button;
    Intent i,j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_signup_page);
        close_button_action_bar = findViewById(R.id.close_button_action_bar);
        close_button_action_bar.setOnClickListener(this);
        new_user_sign_up_button = findViewById(R.id.new_user_sign_up_button);
        new_user_sign_up_button.setOnClickListener(this);
        ghure_dekhi_title_text = findViewById(R.id.Ghure_Dekhi_title_text);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Papaya_Sunrise.otf");
        ghure_dekhi_title_text.setTypeface(typeface);
        i = new Intent(LoginSignupPage.this, PackageDetails.class);
        j = new Intent(LoginSignupPage.this, SignUpInput.class);
    }

    public void onBackPressed() {
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.close_button_action_bar:
                startActivity(i);

                finish();
                break;
            case R.id.new_user_sign_up_button:
                startActivity(j);
                finish();
                break;
        }
    }
}
