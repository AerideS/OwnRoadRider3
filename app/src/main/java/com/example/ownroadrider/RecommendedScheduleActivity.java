package com.example.ownroadrider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RecommendedScheduleActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<CardForSchedule> list = new ArrayList<>();
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_schedule);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new CustomAdapter(list, R.layout.card_view_item_layout));

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                recyclerView.setAdapter(new CustomAdapter(list, R.layout.card_view_item_layout));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }
        }, 1000);   // 1000 = 1초 후 도출

        AssetManager assetManager = getAssets();

        try{
            InputStream is = assetManager.open("jsons/schedule.json");
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

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String scheduleTitle = jsonObject.getString("scheduleTitle");
                String course = jsonObject.getString("course");
                Integer rating = jsonObject.getInt("rating");
                String dest1Img = jsonObject.getString("dest1Img");
                String dest2Img = jsonObject.getString("dest2Img");
                String dest3Img = jsonObject.getString("dest3Img");
                String totalReview = jsonObject.getString("totalReview");
                /*JSONObject flag = jsonObject.getJSONObject("flag");
                int aa = flag.getInt("aa");
                int bb = flag.getInt("bb");*/

                list.add(new CardForSchedule(scheduleTitle, course, dest1Img, dest2Img, dest3Img, rating,totalReview));
            }
        } catch (IOException e) {throw new RuntimeException(e);} catch (JSONException e) {throw new RuntimeException(e);}
    }
}