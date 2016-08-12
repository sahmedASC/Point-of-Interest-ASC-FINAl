package com.bss.pointofinterest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ActivityRestaurants extends AppCompatActivity {

    SharedPreferences preferences;
    Keys key= new Keys();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_list);
        preferences= getSharedPreferences(key.FILENAME, 0);
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