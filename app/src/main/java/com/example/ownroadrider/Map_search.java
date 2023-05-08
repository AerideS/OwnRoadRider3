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
            {0, 24 - 12, 39, 56, Integer.MAX_VALUE},
            {24 - 12, 0, Integer.MAX_VALUE, 74 - 37, 85 - 38},
            {39, Integer.MAX_VALUE, 0, 85, 96},
            {56, 74 - 37, 85, 0, 14},
            {Integer.MAX_VALUE, 85 - 38, 96, 14, 0}
    };

    double[][] region_position = {
            {35.2371, 128.6066},         //창원
            {35.1805, 128.1087},         //진주
            {35.0903, 128.0705},         //사천
            {34.8918, 128.6206},         //거제
            {34.8953, 127.8828},         //남해
            {35.1407, 128.484}           //마산
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

        Intent intent = getIntent();
        String st = intent.getStringExtra("start");          //출발지 받아오기
        String ed = intent.getStringExtra("end");             //목적지 받아오기
        Dijkstra dj=new Dijkstra(5, matrixGN);
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
                marker.setPosition(new LatLng(35.1805, 128.1087));
                marker.setMap(naverMap);
                marker.setWidth(80);
                marker.setHeight(100);
                break;
        }

        switch (rot[1]) {                                   //경유지찍기
            case "사천":
                marker_m.setPosition(new LatLng(region_position[2][0], region_position[2][1]));
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

        double mid_camera_point_la = (region_position[dj.stringToInt(st)][0]+region_position[dj.stringToInt(st)][0]+region_position[dj.stringToInt(st)][0])/3;
        double mid_camera_point_long = (region_position[dj.stringToInt(st)][1]+region_position[dj.stringToInt(st)][1]+region_position[dj.stringToInt(st)][1])/3;
        naverMap.setCameraPosition(new CameraPosition(new LatLng(mid_camera_point_la,mid_camera_point_long),6));
        PolylineOverlay polyline = new PolylineOverlay();
        polyline.setCoords(Arrays.asList(
                new LatLng(region_position[dj.stringToInt(st)][0],region_position[dj.stringToInt(st)][1]),
                new LatLng(region_position[dj.stringToInt(rot[1])][0],region_position[dj.stringToInt(rot[1])][1]),
                new LatLng(region_position[dj.stringToInt(ed)][0],region_position[dj.stringToInt(ed)][1])
        ));
        polyline.setMap(naverMap);
    }
}