package com.bss.pointofinterest;


import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ActivityCheckMap extends BroadcastReceiver {

    @Override
    public void onReceive(final Context arg0, Intent arg1) {
        Thread t = new Thread(new Runnable() {
            // TODO: 8/15/2016 Get user's latitude and longitude. 
            String apiKey = "AIzaSyCskKiWaerqiOo2gadGRBp3nd0qJB3yrd4";
            double lat = 40.7425588, lon = -74.0082725;
            Context self = arg0;
            Keys key = new Keys();

            @Override
            public void run() {
                Vibrator v = (Vibrator) self.getSystemService(Context.VIBRATOR_SERVICE);
                try{
                    Log.i("TEST", "---"+lat + ", "+lon+"----");
                    String site = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=40.7398848,-73.9922705&radius=1500&key=" + apiKey;
                    URL url = new URL(site);
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setInstanceFollowRedirects(false);
                    conn.connect();

                    InputStream is = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line = null;
                   /*Reference the shared preferences data, get the name of places stored. Store 
                   * it in a list. Check in the while loop with the list from MyLocations.
                   * Vibrate, and display informaiton if true.*/

                    while((line = reader.readLine()) != null){
                        Log.i("TEST", line);
                        for(int i=0;i<ActivityMyLocations.userData.size();i++){
                            if (line.toUpperCase().contains(ActivityMyLocations.userData.get(i).toUpperCase())){
                                v.vibrate(1000);
                                break;
                            }
                        }

                        if(line.toUpperCase().contains("Chelsea Inn".toUpperCase())){
                            v.vibrate(1500);
                            break;
                        }

                    }

                }catch (Exception ex){
                }
            }
        });
        t.start();
    }

}