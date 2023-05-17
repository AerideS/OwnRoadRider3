package com.example.ownroadrider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.PolylineOverlay;

import java.util.Arrays;

public class Map_search extends AppCompatActivity implements OnMapReadyCallback {
    private MapView mapView;
    int[][] matrixGN = new int[][]{
            {0,27,Integer.MAX_VALUE,Integer.MAX_VALUE,27,51,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,
                    Integer.MAX_VALUE,35,63,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,31,Integer.MAX_VALUE,Integer.MAX_VALUE},      //창원
            {27,0,Integer.MAX_VALUE,61,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,59,
                    Integer.MAX_VALUE,Integer.MAX_VALUE,64,Integer.MAX_VALUE,58,50,41,Integer.MAX_VALUE,Integer.MAX_VALUE},      //진주
            {Integer.MAX_VALUE,Integer.MAX_VALUE,0,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,100,Integer.MAX_VALUE,Integer.MAX_VALUE,
                    Integer.MAX_VALUE,Integer.MAX_VALUE,79,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},   //통영
            {Integer.MAX_VALUE,61,Integer.MAX_VALUE,0,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,
                    Integer.MAX_VALUE,Integer.MAX_VALUE,63,22,81,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},      //사천
            {27,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0,31,Integer.MAX_VALUE,18,Integer.MAX_VALUE,
                    Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},      //김해
            {51,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,31,0,Integer.MAX_VALUE,38,Integer.MAX_VALUE,
                    Integer.MAX_VALUE,46,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},      //밀양
            {Integer.MAX_VALUE,Integer.MAX_VALUE,100,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0,Integer.MAX_VALUE,Integer.MAX_VALUE,
                    Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},      //거제
            {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,18,38,Integer.MAX_VALUE,0,Integer.MAX_VALUE,
                    Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},   //양산
            {Integer.MAX_VALUE,59,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0,
                    Integer.MAX_VALUE,50,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,66,30,Integer.MAX_VALUE,28},      //의령
            {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,
                    0,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,56,85,Integer.MAX_VALUE,29,Integer.MAX_VALUE},      //함양
            {35,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,46,Integer.MAX_VALUE,Integer.MAX_VALUE,50,
                    Integer.MAX_VALUE,0,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,47,Integer.MAX_VALUE,30},      //창녕
            {63,64,79,63,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,
                    Integer.MAX_VALUE,Integer.MAX_VALUE,0,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},      //고성
            {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,22,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,
                    Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0,70,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},   //남해
            {Integer.MAX_VALUE,58,Integer.MAX_VALUE,81,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,
                    56,Integer.MAX_VALUE,Integer.MAX_VALUE,70,0,69,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},      //하동
            {Integer.MAX_VALUE,50,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,66,
                    85,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,69,0,Integer.MAX_VALUE,30,31},      //산청
            {31,41,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,30,
                    Integer.MAX_VALUE,47,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0,Integer.MAX_VALUE,Integer.MAX_VALUE},      //함안
            {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,
                    29,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,30,Integer.MAX_VALUE,0,27},  //거창
            {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,28,
                    Integer.MAX_VALUE,30,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,31,Integer.MAX_VALUE,27,0}      //합천
    };

    //해양
    double[][] weight_sea = {
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	1	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	1	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	1	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	1	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	1	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	1	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	1	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	1	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	1	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	1	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	1	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	1	},
            {0.5,	1,	0.5,	0.5,	1,	1,	0.5,	1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	1	}
    };

    //산
    double[][] weight_mountain = {
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	1	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	1	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	1	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	1	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	1	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	0.5	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	1	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	1	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	1	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	1	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	0.5	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	1	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	1	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	0.5	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	1	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	0.5	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	0.5	},
            {1,	1,	1,	1,	1,	0.5,	1,	1,	1,	1,	0.5,	1,	1,	0.5,	1,	0.5,	0.5,	1	}
    };

    //유적
    double[][] weight_sites = {
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	},
            {1,	0.5,	1,	1,	0.5,	1,	1,	0.5,	0.5,	0.5,	1,	0.5,	1,	1,	0.5,	1,	1,	0.5	}
    };

    double[][] region_position = {
            {35.2371, 128.6066},        //창원
            {35.1805, 128.1087},        //진주
            {34.8497, 128.4339},        //통영
            {35.0903, 128.0705},        //사천
            {35.2332, 128.8819},        //김해
            {35.4913, 128.7481},        //밀양
            {34.8918, 128.6206},        //거제
            {35.3385, 129.0265},        //양산
            {35.3227, 128.2878},        //의령
            {35.5202, 127.7259},        //함양
            {35.5414, 128.5004},        //창녕
            {34.9754, 128.3234},        //고성
            {34.8953, 127.8828},        //남해
            {35.0642, 127.7556},        //하동
            {35.4138, 127.8741},        //산청
            {35.2795, 128.4075},        //함안
            {35.6875, 127.9056},        //거창
            {35.5667, 128.1684}         //합천
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_search);

        mapView = findViewById(R.id.map_search_view);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {                                        //맵객체 매서드 사용시 여기서 작성
        int num = 0;
        int[][] newGN = new int[matrixGN.length][matrixGN[0].length];
        switch(num) {
            case 0:
                // 가중치 아무것도 없음

                break;
            case 1:
                //해양 가중치
                break;
            case 2:
                //산 가중치
                break;
            case 3:
                //유적 가중치
                break;
        }
        Intent intent = getIntent();
        String st = intent.getStringExtra("start");          //출발지 받아오기
        String ed = intent.getStringExtra("end");             //목적지 받아오기
        Dijkstra dj=new Dijkstra(18, matrixGN);
        String[]rot =new String[3];
        Marker marker_m = new Marker();             //경유지 마커
        Marker marker_e = new Marker();             //도착지 마커

        switch(st){
            case"진주":
                switch (ed){
                    case"사천":
                        rot=dj.algorithm("진주","사천");
                        break;
                    case"창원":
                        rot=dj.algorithm("진주","창원");
                        break;
                    case"거제":
                        rot=dj.algorithm("진주","거제");
                        break;
                    case"남해":
                        rot=dj.algorithm("진주","남해");
                        break;
                    case"마산":
                        rot=dj.algorithm("진주","마산");
                        break;
                }
                break;
            case"사천":
                switch (ed){
                    case"진주":
                        rot=dj.algorithm("사천","진주");
                        break;
                    case"창원":
                        rot=dj.algorithm("사천","창원");
                        break;
                    case"거제":
                        rot=dj.algorithm("사천","거제");
                        break;
                    case"남해":
                        rot=dj.algorithm("사천","남해");
                        break;
                    case"마산":
                        rot=dj.algorithm("사천","마산");
                        break;
                }
                break;
            case"창원":
                switch (ed){
                    case"진주":
                        rot=dj.algorithm("창원","진주");
                        break;
                    case"사천":
                        rot=dj.algorithm("창원","사천");
                        break;
                    case"거제":
                        rot=dj.algorithm("창원","거제");
                        break;
                    case"남해":
                        rot=dj.algorithm("창원","남해");
                        break;
                    case"마산":
                        rot=dj.algorithm("창원","마산");
                        break;
                }
                break;
            case"거제":
                switch (ed){
                    case"진주":
                        rot=dj.algorithm("거제","진주");
                        break;
                    case"사천":
                        rot=dj.algorithm("거제","사천");
                        break;
                    case"창원":
                        rot=dj.algorithm("거제","창원");
                        break;
                    case"남해":
                        rot=dj.algorithm("거제","남해");
                        break;
                    case"마산":
                        rot=dj.algorithm("거제","마산");
                        break;
                }
                break;
            case"남해":
                switch (ed){
                    case"진주":
                        rot=dj.algorithm("남해","진주");
                        break;
                    case"사천":
                        rot=dj.algorithm("남해","사천");
                        break;
                    case"창원":
                        rot=dj.algorithm("남해","창원");
                        break;
                    case"거제":
                        rot=dj.algorithm("남해","거제");
                        break;
                    case"마산":
                        rot=dj.algorithm("남해","마산");
                        break;
                }
                break;
            case"마산":
                switch (ed){
                    case"진주":
                        rot=dj.algorithm("마산","진주");
                        break;
                    case"사천":
                        rot=dj.algorithm("마산","사천");
                        break;
                    case"창원":
                        rot=dj.algorithm("마산","창원");
                        break;
                    case"거제":
                        rot=dj.algorithm("마산","거제");
                        break;
                    case"남해":
                        rot=dj.algorithm("마산","남해");
                        break;
                }
                break;
        }
        switch (st) {                                     //시작점 찍기
            case "진주":
                Marker marker = new Marker();
                marker.setPosition(new LatLng(region_position[1][0], region_position[1][1]));
                marker.setMap(naverMap);
                marker.setWidth(80);
                marker.setHeight(100);
                break;
        }

        switch (rot[1]) {                                   //경유지찍기
            case "사천":
                marker_m.setPosition(new LatLng(region_position[3][0], region_position[3][1]));
                marker_m.setMap(naverMap);
                marker_m.setWidth(80);
                marker_m.setHeight(100);
                break;
            case "창원":
                marker_m.setPosition(new LatLng(region_position[0][0], region_position[0][1]));
                marker_m.setMap(naverMap);
                marker_m.setWidth(80);
                marker_m.setHeight(100);
                break;
            case "거제":
                marker_m.setPosition(new LatLng(region_position[3][0], region_position[3][1]));
                marker_m.setMap(naverMap);
                marker_m.setWidth(80);
                marker_m.setHeight(100);
                break;
            case "남해":
                marker_m.setPosition(new LatLng(region_position[4][0], region_position[4][1]));
                marker_m.setMap(naverMap);
                marker_m.setWidth(80);
                marker_m.setHeight(100);
                break;
            case "마산":
                marker_m.setPosition(new LatLng(region_position[5][0], region_position[5][1]));
                marker_m.setMap(naverMap);
                marker_m.setWidth(80);
                marker_m.setHeight(100);
                break;
        }


        switch (ed) {                                                   //도착지
            case "사천":
                marker_e.setPosition(new LatLng(region_position[2][0], region_position[2][1]));
                marker_e.setMap(naverMap);
                marker_e.setWidth(80);
                marker_e.setHeight(100);
                break;
            case "창원":
                marker_e.setPosition(new LatLng(region_position[0][0], region_position[0][1]));
                marker_e.setMap(naverMap);
                marker_e.setWidth(80);
                marker_e.setHeight(100);
                break;
            case "거제":
                marker_e.setPosition(new LatLng(region_position[3][0], region_position[3][1]));
                marker_e.setMap(naverMap);
                marker_e.setWidth(80);
                marker_e.setHeight(100);
                break;
            case "남해":
                marker_e.setPosition(new LatLng(region_position[4][0], region_position[4][1]));
                marker_e.setMap(naverMap);
                marker_e.setWidth(80);
                marker_e.setHeight(100);
                break;
            case "마산":
                marker_e.setPosition(new LatLng(region_position[5][0], region_position[5][1]));
                marker_e.setMap(naverMap);
                marker_e.setWidth(80);
                marker_e.setHeight(100);
                break;
        }
        naverMap.setCameraPosition(new CameraPosition(new LatLng(35.2519,128.3094),6));
        PolylineOverlay polyline = new PolylineOverlay();
        polyline.setCoords(Arrays.asList(
                new LatLng(region_position[dj.stringToInt(st)][0],region_position[dj.stringToInt(st)][1]),
                new LatLng(region_position[dj.stringToInt(rot[1])][0],region_position[dj.stringToInt(rot[1])][1]),
                new LatLng(region_position[dj.stringToInt(ed)][0],region_position[dj.stringToInt(ed)][1])
        ));
        polyline.setMap(naverMap);
    }
}