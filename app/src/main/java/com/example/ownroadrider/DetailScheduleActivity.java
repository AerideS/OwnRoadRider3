package com.example.ownroadrider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.media.Rating;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DetailScheduleActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<CardForDetailSchedule> list = new ArrayList<>();
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_schedule);

        Intent intent = getIntent();

        TextView scheduleTitleTxt = findViewById(R.id.totalScheduleTitleTxt);
        TextView courseTxt = findViewById(R.id.detailCourseTxt);
        TextView totalReviewTxt = findViewById(R.id.detailTotalReviewTxt);
        RatingBar ratingBar = findViewById(R.id.totalRatingBar);

        scheduleTitleTxt.setText(intent.getStringExtra("추천경로제목"));
        courseTxt.setText(intent.getStringExtra("추천경로"));
        totalReviewTxt.setText(intent.getStringExtra("총평가"));
        ratingBar.setRating(intent.getIntExtra("총평점", 3));

        RecyclerView recyclerView = findViewById(R.id.detailRecycler_view);
        recyclerView.setAdapter(new DetailCustomAdapter(list, R.layout.detail_schedule_card_view_item_layout));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                recyclerView.setAdapter(new DetailCustomAdapter(list, R.layout.detail_schedule_card_view_item_layout));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }
        }, 1000);   // 1000 = 1초 후 도출

        AssetManager assetManager = getAssets();

        try{
            String path = intent.getStringExtra("추천경로파일");
            Log.d("추천 경로 파일 경로", path);
            /*InputStream is = null;
            switch(path) {
                case "jsons/detail_1_schedule.json":
                    is = assetManager.open("jsons/detail_1_schedule.json");
                    break;
                case "jsons/detail_2_schedule.json":
                    is = assetManager.open("jsons/detail_2_schedule.json");
                    break;
            }*/
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

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String destTitle = jsonObject.getString("destTitle");
                Integer rating = jsonObject.getInt("rating");
                String review = jsonObject.getString("review");
                String imgStr = jsonObject.getString("destImg");
                Integer iResId = getResources().getIdentifier( imgStr, "drawable", this.getPackageName() );

                list.add(new CardForDetailSchedule(destTitle, rating, review, iResId));
            }
        } catch (IOException e) {throw new RuntimeException(e);} catch (JSONException e) {throw new RuntimeException(e);}
    }
}