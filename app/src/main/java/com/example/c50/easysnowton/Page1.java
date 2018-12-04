package com.example.c50.easysnowton;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;

public class Page1  extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewPager;
    private TabLayout tablayout2;
    private ViewPager viewPager2;
    private static int pos;
    //private static String URL2;
    //private ArrayList<String> snowToCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
        //snowToCheck = new ArrayList<>();
        //Intent intent3 = getIntent();

        ArrayList<String> snowListToCheck = MainActivity.getData();

        tablayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        tablayout2 = (TabLayout) findViewById(R.id.tablayout2_id);
        viewPager2 = (ViewPager) findViewById(R.id.viewpager2_id);

        ViewPagerAdapter adapt = new ViewPagerAdapter(getSupportFragmentManager());
        ViewPagerAdapter adapt2 = new ViewPagerAdapter(getSupportFragmentManager());

        //Adding snowtam fragment
        if (snowListToCheck != null){

            for(int i=0; i<snowListToCheck.size(); i++){

                adapt.addFragment(new Snow(), snowListToCheck.get(i));

                //Adapter setup for each snowtam fragment
                viewPager.setAdapter(adapt);
                tablayout.setupWithViewPager(viewPager);

                //Intent myIntent2 = new Intent(getBaseContext(),   Map.class);
                //startActivity(myIntent2);
                //myIntent2.putExtra("URL2",snowListToCheck.get(i));

                Log.d("Message : ", "Non Null");
            }

            //Adding raw and decoded fragments
            adapt2.addFragment(new Decoded(), "Decoded");
            adapt2.addFragment(new Raw(), "Raw");

            //Adapter Setup
            viewPager2.setAdapter(adapt2);
            tablayout2.setupWithViewPager(viewPager2);
        }

        //Button back
        final Button button_back = findViewById(R.id.back_id);
        button_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button_add
                //setContentView(R.layout.activity_main);
                pos = 0;
                finish();


            }
        });

        //Button map
        final Button button_map = findViewById(R.id.map_id);
        button_map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button_add
                Intent myIntent = new Intent(getBaseContext(),   Map.class);
                startActivity(myIntent);
            }
        });

        TabLayout.OnTabSelectedListener myListener = new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pos = tab.getPosition();
                ViewPagerAdapter adapt3 = new ViewPagerAdapter(getSupportFragmentManager());

                adapt3.addFragment(new Decoded(), "Decoded");
                adapt3.addFragment(new Raw(), "Raw");

                //Adapter Setup
                viewPager2.setAdapter(adapt3);
                tablayout2.setupWithViewPager(viewPager2);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
        tablayout.addOnTabSelectedListener(myListener);

    }

    public static int getPos(){

        return pos;
    }

}
