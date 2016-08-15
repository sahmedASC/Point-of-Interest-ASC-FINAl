package com.bss.pointofinterest;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ActivityCheckMap extends BroadcastReceiver {

    @Override
    public void onReceive(final Context arg0, Intent arg1) {
        Thread t = new Thread(new Runnable() {
            String apiKey = "AIzaSyCskKiWaerqiOo2gadGRBp3nd0qJB3yrd4";
            String site = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=40.7425588,-74.0082725&radius=500&key=" + apiKey;
            Context self  = arg0;
            @Override
            public void run() {
                try{
                    URL url = new URL(site);
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setInstanceFollowRedirects(false);
                    conn.connect();

                    InputStream is = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line = null;
                    while((line = reader.readLine()) != null){
                        Log.i("TEST", line);
//                        for(int i = 0; i < ActivityMyLocations.userData.size(); i++){
//                            if(line.toUpperCase().contains(ActivityMyLocations.userData.get(i).toUpperCase())){
//                                Log.i("LOCATION_DATA_FOUND", ActivityMyLocations.userData.get(i));
//                            }
//                        }
                        if(line.toUpperCase().contains("The Old Homestead Steakhouse".toUpperCase())){
                            Vibrator v = (Vibrator) self.getSystemService(Context.VIBRATOR_SERVICE);
                            v.vibrate(1000);
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