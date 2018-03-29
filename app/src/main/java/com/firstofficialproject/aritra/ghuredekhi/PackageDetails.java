package com.firstofficialproject.aritra.ghuredekhi;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PackageDetails extends AppCompatActivity implements View.OnClickListener {
    ImageView menu_button, location_input_pin, profile_navigation_pin;
    TextView ghure_dekhi_title_text;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.package_details);
        menu_button = findViewById(R.id.menu_button);
        menu_button.setOnClickListener(this);
        location_input_pin = findViewById(R.id.location_input_pin);
        location_input_pin.setOnClickListener(this);
        profile_navigation_pin = findViewById(R.id.profile_navigation_pin);
        profile_navigation_pin.setOnClickListener(this);
        ghure_dekhi_title_text = findViewById(R.id.Ghure_Dekhi_title_text);
        Typeface T1 = Typeface.createFromAsset(getAssets(), "fonts/Papaya_Sunrise.otf");
        ghure_dekhi_title_text.setTypeface(T1);
        i = new Intent(PackageDetails.this, LoginSignupPage.class);
        initialization();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.location_input_pin:
                PopupMenu location_pop_up = new PopupMenu(PackageDetails.this, location_input_pin);
                location_pop_up.getMenuInflater().inflate(R.menu.location_pop_up_menu, location_pop_up.getMenu());
                location_pop_up.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        startActivity(i);
                        finish();
                        return true;
                    }
                });
                location_pop_up.show();
                break;
            case R.id.profile_navigation_pin:
                startActivity(i);
                finish();
                break;
        }
    }

    private void initialization() {
        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new SubjectAdapter(generateData()));
    }

    private List<Subject> generateData() {
        List<Subject> subjectList = new ArrayList<>();
        String names_of_packages[] = {"Bangkok", "Malaysia", "Australia", "Nepal", "Ladakh", "Darjeeling"};
        String prices_of_packages[] = {"Rs.3500", "Rs.7800", "Rs.5600", "Rs.4500", "Rs.3500", "Rs.3200"};
        for (int index = 0; index < 6; index++) {
            Subject subject = new Subject();
            subject.setName_of_destination(names_of_packages[index]);
            subject.setPrice_of_package(prices_of_packages[index]);
            subjectList.add(subject);
        }
        return subjectList;
    }
}
