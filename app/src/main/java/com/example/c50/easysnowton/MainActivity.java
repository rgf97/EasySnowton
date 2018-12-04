package com.example.c50.easysnowton;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<SnowtanItem> snowtanList;
    private static final ArrayList<String> snowListToCheck = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillSnowtanList();

        final AutoCompleteTextView editText = findViewById(R.id.actv);
        AutoCompleteSnowtanAdapter adapter = new AutoCompleteSnowtanAdapter(this, snowtanList);
        editText.setAdapter(adapter);

        final LinearLayout linearLayout = findViewById(R.id.linearLayout);


        //Button add
        final Button button_add = findViewById(R.id.button_id);
        button_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button_add
                String snow_add = editText.getText().toString();
                linearLayout.addView(createNewTextView(snow_add));
                snowListToCheck.add(snow_add);
                Log.d("Snow : ", snowListToCheck.get(0));
            }
        });



        final Button button_clear = findViewById(R.id.button);
        button_clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button_add
                linearLayout.removeAllViews();
                snowListToCheck.clear();

            }
        });


        //Button check
        final Button button_check = findViewById(R.id.button2);
        button_check.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Code here executes on main thread after user presses button_add
                //setContentView(R.layout.page1);
                Log.d("Snow : ", snowListToCheck.get(0));
                Intent myIntent = new Intent(getBaseContext(),   Page1.class);
                startActivity(myIntent);
                myIntent.putStringArrayListExtra("snowToCheck", snowListToCheck);

            }

        });


    }


    private TextView createNewTextView(String s){

        final TextView textView = new TextView(this);
        textView.setTextSize(30);
        textView.setText(s);
        return textView;
    }

    public static ArrayList<String> getData(){

        return snowListToCheck;
    }

    private void fillSnowtanList(){

        snowtanList = new ArrayList<>();
        snowtanList.add(new SnowtanItem("ENBO",R.drawable.norway_flag));
        snowtanList.add(new SnowtanItem("LFPG",R.drawable.france_flag));
        snowtanList.add(new SnowtanItem("LFKS",R.drawable.france_flag));
        snowtanList.add(new SnowtanItem("LFRR",R.drawable.france_flag));
        snowtanList.add(new SnowtanItem("LFFR",R.drawable.france_flag));
        snowtanList.add(new SnowtanItem("LFXX",R.drawable.france_flag));
        snowtanList.add(new SnowtanItem("KATL",R.drawable.us_flag));
        snowtanList.add(new SnowtanItem("ZBAA",R.drawable.china_flag));
        snowtanList.add(new SnowtanItem("OMDB",R.drawable.dubai_flag));
        snowtanList.add(new SnowtanItem("RJTT",R.drawable.japan_flag));
        snowtanList.add(new SnowtanItem("KLAX",R.drawable.us_flag));
        snowtanList.add(new SnowtanItem("KORD",R.drawable.us_flag));
        snowtanList.add(new SnowtanItem("EGLL",R.drawable.uk_flag));
        snowtanList.add(new SnowtanItem("VHHH",R.drawable.hk_flag));
        snowtanList.add(new SnowtanItem("ZSPD",R.drawable.china_flag));
        snowtanList.add(new SnowtanItem("EHAM",R.drawable.netherlands_flag));
        snowtanList.add(new SnowtanItem("KDFW",R.drawable.us_flag));
        snowtanList.add(new SnowtanItem("ZGGG",R.drawable.china_flag));
        snowtanList.add(new SnowtanItem("EDDF",R.drawable.germany_flag));
        snowtanList.add(new SnowtanItem("LTBA",R.drawable.turkey_flag));
        snowtanList.add(new SnowtanItem("VIDP",R.drawable.india_flag));
        snowtanList.add(new SnowtanItem("WIII",R.drawable.indonesia_flag));
        snowtanList.add(new SnowtanItem("WSSS",R.drawable.singapore_flag));
        snowtanList.add(new SnowtanItem("RKSI",R.drawable.sk_flag));
        snowtanList.add(new SnowtanItem("KDEN",R.drawable.us_flag));
        snowtanList.add(new SnowtanItem("VTBS",R.drawable.thailand_flag));
        snowtanList.add(new SnowtanItem("KJFK",R.drawable.us_flag));
        snowtanList.add(new SnowtanItem("WMKK",R.drawable.malaysia_flag));
        snowtanList.add(new SnowtanItem("KSFO",R.drawable.us_flag));
        snowtanList.add(new SnowtanItem("LEMD",R.drawable.spain_flag));
        snowtanList.add(new SnowtanItem("ZUUU",R.drawable.china_flag));
        snowtanList.add(new SnowtanItem("KLAS",R.drawable.us_flag));
        snowtanList.add(new SnowtanItem("LEBL",R.drawable.spain_flag));
        snowtanList.add(new SnowtanItem("VABB",R.drawable.india_flag));
        snowtanList.add(new SnowtanItem("CYYZ",R.drawable.canada_flag));

    }
}
