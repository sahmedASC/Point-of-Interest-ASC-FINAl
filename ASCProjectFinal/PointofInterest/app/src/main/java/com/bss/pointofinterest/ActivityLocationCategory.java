package com.bss.pointofinterest;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
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
                    Intent i = new Intent(ActivityLocationCategory.this, ActivityRestaurants.class);
                    PendingIntent pendingIntent =
                            TaskStackBuilder.create(ActivityLocationCategory.this)
                                    // add all of DetailsActivity's parents to the stack,
                                    // followed by DetailsActivity itself
                                    .addNextIntentWithParentStack(i)
                                    .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                    startActivity(i);
                }
            });
        }

        Button btnStore = (Button) findViewById(R.id.btnStores);
        if(btnStore != null){
            btnStore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(ActivityLocationCategory.this, ActivityShopping.class);
                    PendingIntent pendingIntent =
                            TaskStackBuilder.create(ActivityLocationCategory.this)
                                    // add all of DetailsActivity's parents to the stack,
                                    // followed by DetailsActivity itself
                                    .addNextIntentWithParentStack(i)
                                    .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                    startActivity(i);
                }
            });
        }
    }
}