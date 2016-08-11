package com.bss.pointofinterest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button newLocBtn = (Button) findViewById(R.id.btnNewLocation);
        if(newLocBtn != null) {
            newLocBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, ActivityLocationCategory.class);
                    startActivity(i);
                }
            });
        }
    }
}
