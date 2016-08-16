package com.bss.pointofinterest;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivityMyLocations extends AppCompatActivity {

    Keys key = new Keys();
    public static ArrayList<String> userData  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_locations);
        updateData();
    }

    public void updateData(){
        for (int i=0;i<userData.size();i++){
            userData.remove(i);
        }
        LinearLayout root = (LinearLayout) findViewById(R.id.locationRootLayout);
        if (root.getChildCount() > 0){
            root.removeAllViews();

            LinearLayout parent = new LinearLayout(this);
            parent.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            parent.setOrientation(LinearLayout.HORIZONTAL);
            parent.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 20, 0, 20);
            parent.setLayoutParams(layoutParams);
            TextView t = new TextView(this);
            t.setText("Tap to remove");
            t.setTextSize(25);
            parent.addView(t);
            root.addView(parent);
        }
        SharedPreferences settings = getSharedPreferences(key.FILENAME, 0);
        for(int i = 0; i < key.LOCATIONS.size(); i++){
            boolean returnedData = settings.getBoolean(key.LOCATIONS.get(i), false);
            if(returnedData){
                userData.add(key.LOCATIONS.get(i).trim());
                displayLocation(key.LOCATIONS.get(i));
            }
        }
    }


    /**
     * This function will display the user's saved location
     * @param location
     */
    private void displayLocation(String location){

        // The top layout of the page
        LinearLayout root = (LinearLayout) findViewById(R.id.locationRootLayout);

        LinearLayout parent = new LinearLayout(this);

        parent.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        parent.setOrientation(LinearLayout.HORIZONTAL);
        parent.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 20, 0, 20);
        parent.setLayoutParams(layoutParams);

        final Button btn = new Button(ActivityMyLocations.this);
        btn.setText(location);
        btn.setTextSize(30);
        btn.setTextColor(Color.RED);
        btn.setBackgroundColor(Color.argb(1, 255, 255, 255));
        btn.setHorizontalFadingEdgeEnabled(false);
        btn.setVerticalFadingEdgeEnabled(false);
        btn.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        parent.addView(btn);
        root.addView(parent);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn.getText().equals(key.DALLAS_BBQ)){
                   SharedPreferences preferences= getSharedPreferences(key.FILENAME, 0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean(key.DALLAS_BBQ,false);
                    editor.commit();
                    updateData();
                }
                if(btn.getText().equals(key.MCDONALDS)){
                    SharedPreferences preferences= getSharedPreferences(key.FILENAME, 0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean(key.MCDONALDS,false);
                    editor.commit();
                    updateData();
                }
                if (btn.getText().equals(key.MACYS)){
                    SharedPreferences preferences= getSharedPreferences(key.FILENAME, 0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean(key.MACYS,false);
                    editor.commit();
                    updateData();
                }
                if (btn.getText().equals(key.GAMESTOP)){
                    SharedPreferences preferences= getSharedPreferences(key.FILENAME, 0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean(key.GAMESTOP,false);
                    editor.commit();
                    updateData();
                }
                if (btn.getText().equals(key.COMIC_CENTRAL)){
                    SharedPreferences preferences= getSharedPreferences(key.FILENAME, 0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean(key.COMIC_CENTRAL,false);
                    editor.commit();
                    updateData();
                }
                if (btn.getText().equals(key.MID_COMICS)){
                    SharedPreferences preferences= getSharedPreferences(key.FILENAME, 0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean(key.MID_COMICS,false);
                    editor.commit();
                    updateData();
                }
            }
        });

    }

}
