package com.bss.pointofinterest;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button newLocBtn = (Button) findViewById(R.id.btnNewLocation);

        // handle button press for the new location button
        if(newLocBtn != null) {
            newLocBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, ActivityLocationCategory.class);
                    PendingIntent pendingIntent =
                            TaskStackBuilder.create(MainActivity.this)
                                    // add all of DetailsActivity's parents to the stack,
                                    // followed by DetailsActivity itself
                                    .addNextIntentWithParentStack(i)
                                    .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                    startActivity(i);
                }
            });
        }
        Button myLocationsBtn = (Button) findViewById(R.id.btnSavedLocations);
        // handle the button press for the my location button
        if(myLocationsBtn != null){
            myLocationsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(MainActivity.this, ActivityMyLocations.class);
                    PendingIntent pendingIntent =
                            TaskStackBuilder.create(MainActivity.this)
                                    // add all of DetailsActivity's parents to the stack,
                                    // followed by DetailsActivity itself
                                    .addNextIntentWithParentStack(in)
                                    .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                    startActivity(in);
                }
            });
        }
    }
}
