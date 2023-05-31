package com.example.ownroadrider;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.PolylineOverlay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Map_search extends AppCompatActivity implements OnMapReadyCallback {
    private MapView mapView;

    private ListView List;
    private ArrayList<String> dataSample;

    // 가중치 곱 함수
    public void multiplyMatix(int[][] newGN, double[][] map) {
        for(int i = 0; i < 18; i++){
            for(int j = 0; j < 18; j++) {
                newGN[i][j] =(int) (newGN[i][j] * map[i][j]);
            }
        }
    }

    private String[] vertex = {"창원", "진주", "통영", "사천", "김해","밀양", "거제", "양산", "의령",
            "함양", "창녕", "고성", "남해", "하동", "산청", "함안", "거창", "합천"};
    public int stringToInt(String s) {              // String to Int
        int x = 0;
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i].equals(s)) x = i;
        }
        return x;
    }
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
        
        // newGN에 matrixGN 깊은 복사
        for(int i = 0; i < 18; i++) {
            for(int j = 0; j < 18; j++) {
                newGN[i][j] = matrixGN[i][j];
            }
        }

        boolean[] state = getIntent().getBooleanArrayExtra("state");  // 0 = 유적, 1 = 산, 2 = 바다
        
        // 유적, 산, 바다 모두 선택
        if(state[0] && state[1] && state[2]) {
            multiplyMatix(newGN, weight_sites);
            multiplyMatix(newGN, weight_mountain);
            multiplyMatix(newGN, weight_sea);
        }
        // 유적, 산 선택
        else if (state[0] && state[1]) {
            multiplyMatix(newGN, weight_sites);
            multiplyMatix(newGN, weight_mountain);
        }
        // 산, 바다 선택
        else if(state[1] && state[2]) {
            multiplyMatix(newGN, weight_mountain);
            multiplyMatix(newGN, weight_sea);
        }
        // 유적 선택
        else if(state[0]) {
            multiplyMatix(newGN, weight_sites);
        }
        // 산 선택
        else if(state[1]) {
            multiplyMatix(newGN, weight_mountain);
        }
        // 바다 선택
        else if(state[2]){
            multiplyMatix(newGN, weight_sea);
        }
        else {

        }

        Intent intent = getIntent();
        String st = intent.getStringExtra("start");          //출발지 받아오기
        String ed = intent.getStringExtra("end");             //목적지 받아오기
        Dijkstra dj=new Dijkstra(18, newGN);

        for(int i = 0; i < 3; i++) {
            Log.d("check" + Integer.toString(i), Boolean.toString(state[i]));
        }
        String[]rot =dj.algorithm(vertex[dj.stringToInt(st)],vertex[dj.stringToInt(ed)]);
        Collections.reverse(Arrays.asList(rot));
        Marker marker_s = new Marker();
        Marker marker_m = new Marker();             //경유지 마커
        Marker marker_m_2= new Marker();
        Marker marker_m_3= new Marker();
        Marker marker_m_4= new Marker();
        Marker marker_e = new Marker();             //도착지 마커
        int rot_num=rot.length-2;                   //경유지 수
        double mid_camera_point_la;                 //카메라 중심점 위도
        double mid_camera_point_long;               //카메라 중심점 경도

        naverMap.setCameraPosition(new CameraPosition(new LatLng(35.2519,128.3094),6));
        PolylineOverlay polyline = new PolylineOverlay();

        marker_s.setPosition(new LatLng(region_position[stringToInt(rot[0])][0], region_position[stringToInt(rot[0])][1]));                 //시작점 찍기
        marker_s.setMap(naverMap);
        marker_s.setWidth(80);
        marker_s.setHeight(100);

        InfoWindow infoWindow_start = new InfoWindow();
        infoWindow_start.setAdapter(new InfoWindow.DefaultTextAdapter(getApplication()) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "출발";
            }
        });

        infoWindow_start.open(marker_s);

        switch (rot_num){                   //경유지 수 별 경유지 점찍기
            case 0:
                break;
            case 1:
                marker_m.setPosition(new LatLng(region_position[stringToInt(rot[1])][0], region_position[stringToInt(rot[1])][1]));
                marker_m.setMap(naverMap);
                marker_m.setWidth(80);
                marker_m.setHeight(100);
                break;
            case 2:
                marker_m.setPosition(new LatLng(region_position[stringToInt(rot[1])][0], region_position[stringToInt(rot[1])][1]));
                marker_m.setMap(naverMap);
                marker_m.setWidth(80);
                marker_m.setHeight(100);
                marker_m_2.setPosition(new LatLng(region_position[stringToInt(rot[2])][0], region_position[stringToInt(rot[2])][1]));
                marker_m_2.setMap(naverMap);
                marker_m_2.setWidth(80);
                marker_m_2.setHeight(100);
                break;
            case 3:
                marker_m.setPosition(new LatLng(region_position[stringToInt(rot[1])][0], region_position[stringToInt(rot[1])][1]));
                marker_m.setMap(naverMap);
                marker_m.setWidth(80);
                marker_m.setHeight(100);
                marker_m_2.setPosition(new LatLng(region_position[stringToInt(rot[2])][0], region_position[stringToInt(rot[2])][1]));
                marker_m_2.setMap(naverMap);
                marker_m_2.setWidth(80);
                marker_m_2.setHeight(100);
                marker_m_3.setPosition(new LatLng(region_position[stringToInt(rot[3])][0], region_position[stringToInt(rot[3])][1]));
                marker_m_3.setMap(naverMap);
                marker_m_3.setWidth(80);
                marker_m_3.setHeight(100);
                marker_m_4.setPosition(new LatLng(region_position[stringToInt(rot[3])][0], region_position[stringToInt(rot[3])][1]));
                marker_m_4.setMap(naverMap);
                marker_m_4.setWidth(80);
                marker_m_4.setHeight(100);
                break;
        }

        InfoWindow infoWindow_m = new InfoWindow();                 //정보창 추가
        infoWindow_m.setAdapter(new InfoWindow.DefaultTextAdapter(getApplication()) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "경유";
            }
        });
        InfoWindow infoWindow_m_2 = new InfoWindow();
        infoWindow_m_2.setAdapter(new InfoWindow.DefaultTextAdapter(getApplication()) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "경유";
            }
        });

        InfoWindow infoWindow_m_3 = new InfoWindow();
        infoWindow_m_3.setAdapter(new InfoWindow.DefaultTextAdapter(getApplication()) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "경유";
            }
        });

        InfoWindow infoWindow_m_4 = new InfoWindow();
        infoWindow_m_4.setAdapter(new InfoWindow.DefaultTextAdapter(getApplication()) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "경유";
            }
        });

        infoWindow_m.open(marker_m);
        infoWindow_m_2.open(marker_m_2);
        infoWindow_m_3.open(marker_m_3);
        infoWindow_m_4.open(marker_m_4);

        marker_e.setPosition(new LatLng(region_position[stringToInt(rot[rot.length-1])][0], region_position[stringToInt(rot[rot.length-1])][1]));           //끝점찍기
        marker_e.setMap(naverMap);
        marker_e.setWidth(80);
        marker_e.setHeight(100);

        InfoWindow infoWindow_end = new InfoWindow();
        infoWindow_end.setAdapter(new InfoWindow.DefaultTextAdapter(getApplication()) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "도착";
            }
        });

        infoWindow_end.open(marker_e);

        switch (rot_num){               //경유지 수 마다 다른 카메라 중심점계산
            case 0:
                mid_camera_point_la = (region_position[stringToInt(rot[0])][0]+region_position[stringToInt(rot[rot.length-1])][0])/2;
                mid_camera_point_long = (region_position[stringToInt(rot[0])][1]+region_position[stringToInt(rot[rot.length-1])][1])/2;
                naverMap.setCameraPosition(new CameraPosition(new LatLng(mid_camera_point_la,mid_camera_point_long),7));
                break;
            case 1:
                mid_camera_point_la = (region_position[stringToInt(rot[0])][0]+region_position[stringToInt(rot[1])][0]+region_position[stringToInt(rot[rot.length-1])][0])/3;
                mid_camera_point_long = (region_position[stringToInt(rot[0])][1]+region_position[stringToInt(rot[1])][1]+region_position[stringToInt(rot[rot.length-1])][1])/3;
                naverMap.setCameraPosition(new CameraPosition(new LatLng(mid_camera_point_la,mid_camera_point_long),7));
                break;
            case 2:
                mid_camera_point_la = (region_position[stringToInt(rot[0])][0]+region_position[stringToInt(rot[1])][0]+region_position[stringToInt(rot[2])][0]+region_position[stringToInt(rot[rot.length-1])][0])/4;
                mid_camera_point_long = (region_position[stringToInt(rot[0])][1]+region_position[stringToInt(rot[1])][1]+region_position[stringToInt(rot[2])][1]+region_position[stringToInt(rot[rot.length-1])][1])/4;
                naverMap.setCameraPosition(new CameraPosition(new LatLng(mid_camera_point_la,mid_camera_point_long),7));
                break;
            case 3:
                mid_camera_point_la = (region_position[stringToInt(rot[0])][0]+region_position[stringToInt(rot[1])][0]+region_position[stringToInt(rot[2])][0]+region_position[stringToInt(rot[3])][0]+region_position[stringToInt(rot[rot.length-1])][0])/5;
                mid_camera_point_long = (region_position[stringToInt(rot[0])][1]+region_position[stringToInt(rot[1])][1]+region_position[stringToInt(rot[2])][1]+region_position[stringToInt(rot[3])][1]+region_position[stringToInt(rot[rot.length-1])][1])/5;
                naverMap.setCameraPosition(new CameraPosition(new LatLng(mid_camera_point_la,mid_camera_point_long),7));
                break;
            case 4:
                mid_camera_point_la = (region_position[stringToInt(rot[0])][0]+region_position[stringToInt(rot[1])][0]+region_position[stringToInt(rot[2])][0]+region_position[stringToInt(rot[3])][0]+region_position[stringToInt(rot[4])][0]+region_position[stringToInt(rot[rot.length-1])][0])/6;
                mid_camera_point_long = (region_position[stringToInt(rot[0])][1]+region_position[stringToInt(rot[1])][1]+region_position[stringToInt(rot[2])][1]+region_position[stringToInt(rot[3])][1]+region_position[stringToInt(rot[4])][1]+region_position[stringToInt(rot[rot.length-1])][1])/6;
                naverMap.setCameraPosition(new CameraPosition(new LatLng(mid_camera_point_la,mid_camera_point_long),7));
                break;

        }
        switch (rot_num){               //경유지 수 마다 다른 선 계산
            case 0:
                polyline.setCoords(Arrays.asList(
                        new LatLng(region_position[dj.stringToInt(st)][0],region_position[dj.stringToInt(st)][1]),
                        new LatLng(region_position[dj.stringToInt(ed)][0],region_position[dj.stringToInt(ed)][1])
                ));
                polyline.setMap(naverMap);
                break;
            case 1:
                polyline.setCoords(Arrays.asList(
                        new LatLng(region_position[dj.stringToInt(st)][0],region_position[dj.stringToInt(st)][1]),
                        new LatLng(region_position[dj.stringToInt(rot[1])][0],region_position[dj.stringToInt(rot[1])][1]),
                        new LatLng(region_position[dj.stringToInt(ed)][0],region_position[dj.stringToInt(ed)][1])
                ));
                polyline.setMap(naverMap);
                break;
            case 2:
                polyline.setCoords(Arrays.asList(
                        new LatLng(region_position[dj.stringToInt(st)][0],region_position[dj.stringToInt(st)][1]),
                        new LatLng(region_position[dj.stringToInt(rot[1])][0],region_position[dj.stringToInt(rot[1])][1]),
                        new LatLng(region_position[dj.stringToInt(rot[2])][0],region_position[dj.stringToInt(rot[2])][1]),
                        new LatLng(region_position[dj.stringToInt(ed)][0],region_position[dj.stringToInt(ed)][1])
                ));
                polyline.setMap(naverMap);
                break;
            case 3:
                polyline.setCoords(Arrays.asList(
                        new LatLng(region_position[dj.stringToInt(st)][0],region_position[dj.stringToInt(st)][1]),
                        new LatLng(region_position[dj.stringToInt(rot[1])][0],region_position[dj.stringToInt(rot[1])][1]),
                        new LatLng(region_position[dj.stringToInt(rot[2])][0],region_position[dj.stringToInt(rot[2])][1]),
                        new LatLng(region_position[dj.stringToInt(rot[3])][0],region_position[dj.stringToInt(rot[3])][1]),
                        new LatLng(region_position[dj.stringToInt(ed)][0],region_position[dj.stringToInt(ed)][1])
                ));
                polyline.setMap(naverMap);;
                break;
            case 4:
                polyline.setCoords(Arrays.asList(
                        new LatLng(region_position[dj.stringToInt(st)][0],region_position[dj.stringToInt(st)][1]),
                        new LatLng(region_position[dj.stringToInt(rot[1])][0],region_position[dj.stringToInt(rot[1])][1]),
                        new LatLng(region_position[dj.stringToInt(rot[2])][0],region_position[dj.stringToInt(rot[2])][1]),
                        new LatLng(region_position[dj.stringToInt(rot[3])][0],region_position[dj.stringToInt(rot[3])][1]),
                        new LatLng(region_position[dj.stringToInt(rot[4])][0],region_position[dj.stringToInt(rot[4])][1]),
                        new LatLng(region_position[dj.stringToInt(ed)][0],region_position[dj.stringToInt(ed)][1])
                ));
                polyline.setMap(naverMap);;
                break;
        }

        dataSample = new ArrayList<String>();

        for(int i=0;i<rot.length;i++){                  //출발,경유,도착지 넣기
            dataSample.add(rot[i]);
        }
        dataSample.add("길찾기");

        List = findViewById(R.id.listView);
        List_Adapter buttonListAdapter = new List_Adapter(this, dataSample);
        List.setAdapter(buttonListAdapter);


    }
}