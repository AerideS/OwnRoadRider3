package com.example.ownroadrider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
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
        recyclerView.setAdapter(new CustomAdapter(list, R.layout.card_view_item_layout, getApplicationContext()));

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                recyclerView.setAdapter(new CustomAdapter(list, R.layout.card_view_item_layout, getApplicationContext()));
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
            Context mContext;
            mContext =  getApplicationContext();

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String scheduleTitle = jsonObject.getString("scheduleTitle");
                String course = jsonObject.getString("course");
                Integer rating = jsonObject.getInt("rating");
                String imgStr = jsonObject.getString("dest1Img");
                Integer iResId1 = getResources().getIdentifier( imgStr, "drawable", this.getPackageName() );
                imgStr = jsonObject.getString("dest2Img");
                Integer iResId2 = getResources().getIdentifier( imgStr, "drawable", this.getPackageName() );
                imgStr = jsonObject.getString("dest3Img");
                Integer iResId3 = getResources().getIdentifier( imgStr, "drawable", this.getPackageName() );
                String totalReview = jsonObject.getString("totalReview");
                /*JSONObject flag = jsonObject.getJSONObject("flag");
                int aa = flag.getInt("aa");
                int bb = flag.getInt("bb");*/

                list.add(new CardForSchedule(scheduleTitle, course, iResId1, iResId2, iResId3, rating,totalReview));
            }
        } catch (IOException e) {throw new RuntimeException(e);} catch (JSONException e) {throw new RuntimeException(e);}
    }
}