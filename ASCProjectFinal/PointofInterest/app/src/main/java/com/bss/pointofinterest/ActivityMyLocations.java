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
    public static ArrayList<String> userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_locations);
        userData = new ArrayList<>();
        updateData();
    }



    public void updateData(){
        LinearLayout root = (LinearLayout) findViewById(R.id.locationRootLayout);
        if (root.getChildCount() > 0){
            root.removeAllViews();
        }

        SharedPreferences settings = getSharedPreferences(key.FILENAME, 0);
        for(int i = 0; i < key.RESTAURANTS.size(); i++){
            boolean returnedData = settings.getBoolean(key.RESTAURANTS.get(i), false);
            if(returnedData){
                userData.add(key.RESTAURANTS.get(i));
                displayLocation(key.RESTAURANTS.get(i));
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

        Button btn = new Button(ActivityMyLocations.this);
        btn.setText(location + " -");
        btn.setTextSize(30);
        btn.setTextColor(Color.RED);
        btn.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        parent.addView(btn);
        root.addView(parent);

    }
}
