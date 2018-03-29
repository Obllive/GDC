package com.firstofficialproject.aritra.ghuredekhi;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SignUpInputPassword extends AppCompatActivity implements View.OnClickListener{
    TextView ghure_dekhi_title_text;
    ImageView close_button_action_bar;
    Intent i,j,k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_input_password);
        ghure_dekhi_title_text = findViewById(R.id.Ghure_Dekhi_title_text);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Papaya_Sunrise.otf");
        ghure_dekhi_title_text.setTypeface(typeface);
        close_button_action_bar = findViewById(R.id.close_button_action_bar);
        close_button_action_bar.setOnClickListener(this);
        j = new Intent(SignUpInputPassword.this, SignUpInput.class);
        k = new Intent(SignUpInputPassword.this, PackageDetails.class);
    }
    public void onBackPressed() {
        startActivity(j);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close_button_action_bar:
                startActivity(k);
                finish();
                break;
        }
    }
}
