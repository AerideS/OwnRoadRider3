package com.example.ownroadrider;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class HamanMujinjeongDetailActivity extends AppCompatActivity {

    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 4;
    private CircleIndicator3 mIndicator;

    private ImageButton homeButton;
    private ImageButton categoryButton;
    private ImageButton mapButton;
    private ImageButton detailSearchButton;
    private ImageButton mypageButton_m;
    private Button route_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.haman_mujinjeong_detail);



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
                Toast.makeText(getApplicationContext(),"카테고리 선택",Toast.LENGTH_LONG).show();
            }
        });
        //맵
        mapButton=findViewById(R.id.mapButton);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HamanMujinjeongDetailActivity.this, Map_view.class);
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
                Toast.makeText(getApplicationContext(),"내정보 선택",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(HamanMujinjeongDetailActivity.this, MyPageActivity.class);
                startActivity(intent);
            }
        });
        route_search=findViewById(R.id.route_search);

        route_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.addCategory(Intent.CATEGORY_BROWSABLE);

                List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                if (list == null || list.isEmpty()) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                } else {
                    startActivity(intent);
                }
            }
        });
        /**
         * 가로 슬라이드 뷰 Fragment
         */

        //ViewPager2
        mPager = findViewById(R.id.sliderViewPager);
        //Adapter
        pagerAdapter = new Image_Slider_Haman_Mujinjeong(this, num_page);
        mPager.setAdapter(pagerAdapter);
        //Indicator
        mIndicator = findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        mIndicator.createIndicators(num_page,0);
        //ViewPager Setting
        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        /**
         * 이 부분 조정하여 처음 시작하는 이미지 설정.
         * 2000장 생성하였으니 현재위치 1002로 설정하여
         * 좌 우로 슬라이딩 할 수 있게 함. 거의 무한대로
         */

        mPager.setCurrentItem(1000); //시작 지점
        mPager.setOffscreenPageLimit(4); //최대 이미지 수

        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    mPager.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mIndicator.animatePageSelected(position%num_page);
            }
        });
    }

}