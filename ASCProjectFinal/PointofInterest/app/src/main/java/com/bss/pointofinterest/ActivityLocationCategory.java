package com.bss.pointofinterest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityLocationCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_categories);
        Button btnFood = (Button) findViewById(R.id.btnFood);
        if(btnFood !=null){
            btnFood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(ActivityLocationCategory.this, ActivityRestaurants.class));
                }
            });
        }

    }
}