package com.example.ownroadrider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyDestinationListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<CardForDestination> list = new ArrayList<>();
    Handler handler;
    Integer type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_destination_list);
        Intent intent = getIntent();
        type = intent.getIntExtra("type",0);

        RecyclerView recyclerView = findViewById(R.id.listDestRecyclerView);
        recyclerView.setAdapter(new ListDestCustomAdapter(list, R.layout.list_destination_item_layout));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        handler = new Handler();
            handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                recyclerView.setAdapter(new ListDestCustomAdapter(list, R.layout.list_destination_item_layout));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }
        }, 1000);   // 1000 = 1초 후 도출

        AssetManager assetManager = getAssets();
        try{
            String path = intent.getStringExtra("listDestFilePath");
            InputStream is = assetManager.open(path);

            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            StringBuffer buffer = new StringBuffer();
            String line = reader.readLine();
            while(line!=null){
                buffer.append(line+"\n");
                line=reader.readLine();
            }

            String jsonData = buffer.toString();
            JSONArray jsonArray = new JSONArray(jsonData);
            Integer length = jsonArray.length();
            if(type == 1) {
                length -= 1;
            }

            for(int i = 0; i < length; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String destName = jsonObject.getString("destName");
                String location = jsonObject.getString("location");
                String imgStr = jsonObject.getString("destImg");
                Integer iResId = getResources().getIdentifier( imgStr, "drawable", this.getPackageName() );

                list.add(new CardForDestination(destName, location, iResId, type));
            }
        } catch (IOException e) {throw new RuntimeException(e);} catch (JSONException e) {throw new RuntimeException(e);
        }
    }
}