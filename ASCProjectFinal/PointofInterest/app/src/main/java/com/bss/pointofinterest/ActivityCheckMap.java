package com.bss.pointofinterest;


import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ActivityCheckMap extends IntentService{

    Keys key = new Keys();
    long time = 0;
    long tStart = System.currentTimeMillis();
    long tEnd = System.currentTimeMillis();
    int delay = 30;

    public ActivityCheckMap() {
        super("mapApiService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        while(true) {
            long prev = tEnd;
            tEnd = System.currentTimeMillis();
            time += tEnd - tStart;
            tStart = prev;
            if(time > delay * 1000) {
                // TODO: 8/12/2016 Do all api stuff here:
                Toast.makeText(ActivityCheckMap.this, "4", Toast.LENGTH_SHORT).show();
                time = 0;
            }
        }
    }
}
