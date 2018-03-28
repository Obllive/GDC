package com.firstofficialproject.aritra.ghuredekhi;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PackageDetails extends AppCompatActivity implements View.OnClickListener
{
    ImageView menu_button,location_input_pin;
    TextView ghure_dekhi_title_text;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.package_details);
        menu_button = (ImageView)findViewById(R.id.menu_button);
        menu_button.setOnClickListener(this);
        location_input_pin = (ImageView)findViewById(R.id.location_input_pin);
        location_input_pin.setOnClickListener(this);
        ghure_dekhi_title_text = (TextView)findViewById(R.id.Ghure_Dekhi_title_text);
        Typeface T1 = Typeface.createFromAsset(getAssets(), "fonts/Papaya_Sunrise.otf");
        ghure_dekhi_title_text.setTypeface(T1);
        initialization();

    }
    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.location_input_pin:
                PopupMenu location_pop_up = new PopupMenu(PackageDetails.this,location_input_pin);
                location_pop_up.getMenuInflater().inflate(R.menu.location_pop_up_menu,location_pop_up.getMenu());
                location_pop_up.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Intent i = new Intent(PackageDetails.this,LoginSignupPage.class);
                        startActivity(i);
                        finish();
                        return true;
                    }
                });
                location_pop_up.show();
                break;
        }
    }
    private void initialization() {
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new SubjectAdapter(generateData()));
    }
    private List<Subject> generateData(){
        List<Subject> subjectList = new ArrayList<>();
        String names_of_packages[] = {"Bangkok","Malaysia","Australia","Nepal","Ladakh","Darjeeling"};
        String prices_of_packages[] = {"Rs.3500","Rs.7800","Rs.5600","Rs.4500","Rs.3500","Rs.3200"};
        for(int index = 0; index < 6; index++){
            Subject subject = new Subject();
            subject.setName_of_destination(names_of_packages[index]);
            subject.setPrice_of_package(prices_of_packages[index]);
            subjectList.add(subject);
        }
        return subjectList;
    }
}

