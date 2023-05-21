package com.example.ownroadrider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class  AdvancedSearchActivity extends AppCompatActivity {

    private ImageButton homeButton;
    private ImageButton categoryButton;
    private ImageButton mapButton;
    private ImageButton detailSearchButton;
    private ImageButton mypageButton_m;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search);

        //하단 네이게이션바
        //홈
        homeButton=findViewById(R.id.homeButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //카테고리
        categoryButton=findViewById(R.id.categoryButton);

        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //맵
        mapButton=findViewById(R.id.mapButton);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdvancedSearchActivity.this, Map_view.class);
                startActivity(intent);
            }
        });

        //검색
        detailSearchButton=findViewById(R.id.detailSearchButton);

        detailSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdvancedSearchActivity.class);
                startActivity(intent);
            }
        });
        //마이페이지
        mypageButton_m=findViewById(R.id.mypageButton);

        mypageButton_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdvancedSearchActivity.this, MyPageActivity.class);
                startActivity(intent);
            }
        });
    }
}
