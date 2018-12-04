package com.example.c50.easysnowton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);


        final Button button_back = findViewById(R.id.mapBack_id);
        button_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button_add
                //setContentView(R.layout.activity_main);
                finish();

            }
        });
    }

}
