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

public class ActivityShopping extends AppCompatActivity {
    SharedPreferences preferences;
    Keys key= new Keys();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping);
        preferences= getSharedPreferences(key.FILENAME, 0);
        Button btn3 = (Button) findViewById(R.id.btnMacysInfo);
        if (btn3 != null) {
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(ActivityShopping.this, ActivityMacys.class);
                    PendingIntent pendingIntent =
                            TaskStackBuilder.create(ActivityShopping.this)
                                    // add all of DetailsActivity's parents to the stack,
                                    // followed by DetailsActivity itself
                                    .addNextIntentWithParentStack(i)
                                    .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                    startActivity(i);
                }
            });

            Button btn4 = (Button) findViewById(R.id.btnGameStopInfo);
            if (btn4 != null) {
                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(ActivityShopping.this, ActivityGameStop.class);
                        PendingIntent pendingIntent =
                                TaskStackBuilder.create(ActivityShopping.this)
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
    public void onClick(View v){
        SharedPreferences.Editor editor = preferences.edit();
        switch (v.getId()){
            case R.id.btnAddMacys:
                editor.putBoolean(key.MACYS,true);
                editor.commit();
                break;
            case R.id.btnAddGameStop:
                editor.putBoolean(key.GAMESTOP,true);
                editor.commit();
                break;
            case R.id.cc:
                editor.putBoolean(key.COMIC_CENTRAL, true);
                editor.commit();
                break;
            case R.id.midCom:
                editor.putBoolean(key.MID_COMICS, true);
                editor.commit();
                break;

        }
        Toast.makeText(ActivityShopping.this, "Saved to My Locations", Toast.LENGTH_LONG).show();
    }

}