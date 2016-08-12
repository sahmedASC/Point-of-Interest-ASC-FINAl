package com.bss.pointofinterest;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityRestaurants extends AppCompatActivity {

    SharedPreferences preferences;
    Keys key= new Keys();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_list);
        preferences= getSharedPreferences(key.FILENAME, 0);
        Button btn = (Button) findViewById(R.id.btnDallasBBQInfo);
        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(ActivityRestaurants.this, ActivityDallasBBQ.class);
                    PendingIntent pendingIntent =
                            TaskStackBuilder.create(ActivityRestaurants.this)
                                    // add all of DetailsActivity's parents to the stack,
                                    // followed by DetailsActivity itself
                                    .addNextIntentWithParentStack(i)
                                    .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                    startActivity(i);
                }
            });
        }
        Button btn2 = (Button) findViewById(R.id.btnMcDonaldsInfo);
        if (btn2 != null) {
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(ActivityRestaurants.this, ActivityMcDonalds.class);
                    PendingIntent pendingIntent =
                            TaskStackBuilder.create(ActivityRestaurants.this)
                                    // add all of DetailsActivity's parents to the stack,
                                    // followed by DetailsActivity itself
                                    .addNextIntentWithParentStack(i)
                                    .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                    startActivity(i);
                }
            });
        }
    }
    public void onClick(View v){
        SharedPreferences.Editor editor = preferences.edit();
        switch (v.getId()){
            case R.id.btnAddDallasBBQ:
                editor.putBoolean(key.DALLAS_BBQ,true);
                editor.commit();
                Toast.makeText(ActivityRestaurants.this, "Saved to My Locations", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnAddMcDonalds:
                editor.putBoolean(key.MCDONALDS,true);
                editor.commit();
                Toast.makeText(ActivityRestaurants.this, "Saved to My Locations", Toast.LENGTH_LONG).show();
                break;
        }
    }

}