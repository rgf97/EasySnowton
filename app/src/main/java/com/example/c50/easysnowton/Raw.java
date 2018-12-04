package com.example.c50.easysnowton;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import android.content.Intent;



public class Raw extends Fragment {

    View view;
    TextView myTextView;
    private final static String URL1 = "https://v4p4sz5ijk.execute-api.us-east-1.amazonaws.com/anbdata/states/notams/notams-list?api_key=d68658c0-f5b3-11e8-bcbc-8b85ceef896a&format=json&type=&Qcode=&locations=";
    private final static String URL3 = "&qstring=&states=&ICAOonly=";
    private String URL;
    public String SnowTam;

    public Raw() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.raw, container, false);
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        //String URL2 = getActivity().getIntent().getStringExtra("URL2");
        ArrayList<String> URLList = MainActivity.getData();
        int pos = Page1.getPos();

        if (URLList != null) {

            ArrayList<View> rawList = new ArrayList<>();
            ArrayList<JsonArrayRequest> requestList = new ArrayList<>();

            for (int i = 0; i < URLList.size(); i++) {

                String URL2 = URLList.get(i);
                URL = URL1 + URL2 + URL3;


                JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET,
                        URL, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject notamObject = response.getJSONObject(i);
                                SnowTam = notamObject.getString("all");
                                //Log.d("Snowtam :", SnowTam.toString());
                                if (SnowTam.contains("SNOWTAM")) {
                                    Log.d("Snowtam :", SnowTam.toString());
                                    TextView tv = (TextView) view.findViewById(R.id.textView_raw);
                                    tv.setText(SnowTam.toString());

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("error", error.getMessage());
                    }
                });

                requestList.add(arrayRequest);

            }

            queue.add(requestList.get(pos));

        }

        return view;
    }



}


