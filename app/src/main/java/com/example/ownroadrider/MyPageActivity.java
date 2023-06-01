package com.example.ownroadrider;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MyPageActivity extends AppCompatActivity {

    private ImageButton settingBtn;
    private Button manageReviewBtn;
    private Button checkedDestBtn;
    private Button listDestBtn;
    private Button recommendScheduleBtn;
    private Button.OnClickListener clickListener;
    private ImageButton homeButton;
    private ImageButton mapButton;
    private ImageButton.OnClickListener navClickListener;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        SetMyPageBtn();
        SetNavBtn();
    }

    private void SetMyPageBtn() {
        settingBtn = (ImageButton) findViewById(R.id.settingBtn);
        checkedDestBtn = (Button) findViewById(R.id.checkedDestBtn);
        listDestBtn = (Button) findViewById(R.id.listDestBtn);
        recommendScheduleBtn = (Button) findViewById(R.id.recommendScheduleBtn);

        clickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.settingBtn:
                        break;
                    case R.id.checkedDestBtn:
                        Intent checkedDestIntent = new Intent(MyPageActivity.this, MyDestinationListActivity.class);
                        checkedDestIntent.putExtra("type", 0);
                        checkedDestIntent.putExtra("listDestFilePath", "jsons/list_destination.json");
                        startActivity(checkedDestIntent);
                        break;
                    case R.id.listDestBtn:
                        Intent listDesIntent = new Intent(MyPageActivity.this, MyDestinationListActivity.class);
                        listDesIntent.putExtra("type", 1);
                        listDesIntent.putExtra("listDestFilePath", "jsons/list_destination.json");
                        startActivity(listDesIntent);
                        break;
                    case R.id.recommendScheduleBtn:
                        Intent recommedIntent = new Intent(MyPageActivity.this, RecommendedScheduleActivity.class);
                        startActivity(recommedIntent);
                        break;
                }
            }
        };

        settingBtn.setOnClickListener(clickListener);
        checkedDestBtn.setOnClickListener(clickListener);
        listDestBtn.setOnClickListener(clickListener);
        recommendScheduleBtn.setOnClickListener(clickListener);
    }

    private void SetNavBtn() {
        homeButton=(ImageButton)findViewById(R.id.homeButton);
        mapButton=findViewById(R.id.mapButton);

        navClickListener = new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.homeButton:
                        Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(homeIntent);
                        break;
                    case R.id.mapButton:
                        Intent mapIntent = new Intent(MyPageActivity.this, Map_view.class);
                        startActivity(mapIntent);
                        break;
                }
            }
        };

        homeButton.setOnClickListener(navClickListener);
        mapButton.setOnClickListener(navClickListener);
    }
}