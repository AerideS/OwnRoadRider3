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
    private ImageButton categoryButton;
    private ImageButton mapButton;
    private ImageButton detailSearchButton;
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
        manageReviewBtn = (Button) findViewById(R.id.manageReviewBtn);
        checkedDestBtn = (Button) findViewById(R.id.checkedDestBtn);
        listDestBtn = (Button) findViewById(R.id.listDestBtn);
        recommendScheduleBtn = (Button) findViewById(R.id.recommendScheduleBtn);

        clickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.settingBtn:
                        Toast.makeText(getApplicationContext(), "설정 버튼", Toast.LENGTH_SHORT).show();
                        Log.d(this.getClass().getName(), "설정 버튼");
                        break;
                    case R.id.manageReviewBtn:
                        Toast.makeText(getApplicationContext(), "나의 리뷰 관리", Toast.LENGTH_SHORT).show();
                        Log.d(this.getClass().getName(), "나의 리뷰 관리");
                        break;
                    case R.id.checkedDestBtn:
                        Toast.makeText(getApplicationContext(), "내가 본 여행지", Toast.LENGTH_SHORT).show();
                        Log.d(this.getClass().getName(), "내가 본 여행지");
                        break;
                    case R.id.listDestBtn:
                        Toast.makeText(getApplicationContext(), "관심 여행지 목록", Toast.LENGTH_SHORT).show();
                        Log.d(this.getClass().getName(), "관심 여행지 목록");
                        break;
                    case R.id.recommendScheduleBtn:
                        Toast.makeText(getApplicationContext(), "여행 고수들의 추천 일정!", Toast.LENGTH_SHORT).show();
                        Log.d(this.getClass().getName(), "여행 고수들의 추천 일정!");
                        break;
                }
            }
        };

        settingBtn.setOnClickListener(clickListener);
        manageReviewBtn.setOnClickListener(clickListener);
        checkedDestBtn.setOnClickListener(clickListener);
        listDestBtn.setOnClickListener(clickListener);
        recommendScheduleBtn.setOnClickListener(clickListener);
    }

    private void SetNavBtn() {
        homeButton=(ImageButton)findViewById(R.id.homeButton);
        categoryButton=findViewById(R.id.categoryButton);
        mapButton=findViewById(R.id.mapButton);
        detailSearchButton=findViewById(R.id.detailSearchButton);

        navClickListener = new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.homeButton:
                        Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(homeIntent);
                        break;
                    case R.id.categoryButton:
                        Toast.makeText(getApplicationContext(),"카테고리 선택",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.mapButton:
                        Intent mapIntent = new Intent(MyPageActivity.this, Map_view.class);
                        startActivity(mapIntent);
                        break;
                    case R.id.detailSearchButton:
                        Intent searchIntent = new Intent(MyPageActivity.this, AdvancedSearchActivity.class);
                        startActivity(searchIntent);
                        break;
                }
            }
        };

        homeButton.setOnClickListener(navClickListener);
        categoryButton.setOnClickListener(navClickListener);
        mapButton.setOnClickListener(navClickListener);
        detailSearchButton.setOnClickListener(navClickListener);
    }
}