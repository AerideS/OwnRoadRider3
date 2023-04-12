package com.example.ownroadrider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapPolyline;
import net.daum.mf.map.api.MapView;


public class MapSearchActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        int[][] matrixGN = new int[][]{
                {0, 24 - 12, 39, 56, Integer.MAX_VALUE},
                {24 - 12, 0, Integer.MAX_VALUE, 74 - 37, 85 - 38},
                {39, Integer.MAX_VALUE, 0, 85, 96},
                {56, 74 - 37, 85, 0, 14},
                {Integer.MAX_VALUE, 85 - 38, 96, 14, 0}
        };

        double[][] region_position = {
                {35.1805, 128.1087},          //진주
                {35.0613, 128.1072},         //사천
                {35.2371, 128.6066},         //창원
                {34.8918, 128.6206},         //거제
                {34.8953, 127.8828},         //남해
                {35.1407, 128.484}           //마산
        };

        
        Intent intent = getIntent();
        String st = intent.getStringExtra("start");          //출발지 받아오기
        String ed = intent.getStringExtra("end");             //목적지 받아오기
        Dijkstra dj=new Dijkstra(5, matrixGN);

        String[]rot =new String[3];


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



        MapPolyline polyline = new MapPolyline();           //맵구현 부
        polyline.setTag(1000);
        polyline.setLineColor(Color.argb(128, 255, 51, 0)); // Polyline 컬러 지정.
        MapView mapView = new MapView(MapSearchActivity.this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);
        MapPOIItem startpoint = new MapPOIItem();
        MapPOIItem edpoint = new MapPOIItem();
        MapPoint start_j = MapPoint.mapPointWithGeoCoord(region_position[0][0], region_position[0][1]);     //마커 찍을 좌표 설정 MapPointer 는 좌표 저장하는 클래스
        switch (st) {                                     //시작점 찍기
            case "진주":
                startpoint.setMapPoint(start_j);
                startpoint.setTag(0);
                startpoint.setItemName("진주");
                startpoint.setMarkerType(MapPOIItem.MarkerType.BluePin);
                startpoint.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
                mapView.addPOIItem(startpoint);
                polyline.addPoint(MapPoint.mapPointWithGeoCoord(35.1805, 128.1087));      //진주
                break;
        }

        switch (rot[1]) {                                   //경유지찍기
            case "사천":
                MapPoint ed_s = MapPoint.mapPointWithGeoCoord(region_position[1][0], region_position[1][1]);     //마커 찍을 좌표 설정 MapPointer 는 좌표 저장하는 클래스
                edpoint.setMapPoint(ed_s);
                edpoint.setTag(0);
                edpoint.setItemName("사천");
                edpoint.setMarkerType(MapPOIItem.MarkerType.BluePin);
                edpoint.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
                mapView.addPOIItem(edpoint);

                polyline.addPoint(MapPoint.mapPointWithGeoCoord(region_position[1][0], region_position[1][1]));     //사천
                break;
            case "창원":
                MapPoint ed_c = MapPoint.mapPointWithGeoCoord(region_position[2][0], region_position[2][1]);     //마커 찍을 좌표 설정 MapPointer 는 좌표 저장하는 클래스
                edpoint.setMapPoint(ed_c);
                edpoint.setTag(0);
                edpoint.setItemName("창원");
                edpoint.setMarkerType(MapPOIItem.MarkerType.BluePin);
                edpoint.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
                mapView.addPOIItem(edpoint);
 
                polyline.addPoint(MapPoint.mapPointWithGeoCoord(region_position[2][0], region_position[2][1]));     //창원
                break;
            case "거제":
                MapPoint ed_g = MapPoint.mapPointWithGeoCoord(region_position[3][0], region_position[3][1]);     //마커 찍을 좌표 설정 MapPointer 는 좌표 저장하는 클래스
                edpoint.setMapPoint(ed_g);
                edpoint.setTag(0);
                edpoint.setItemName("거제");
                edpoint.setMarkerType(MapPOIItem.MarkerType.BluePin);
                edpoint.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
                mapView.addPOIItem(edpoint);

                polyline.addPoint(MapPoint.mapPointWithGeoCoord(region_position[3][0], region_position[3][1]));     //거제
                break;
            case "남해":
                MapPoint ed_n = MapPoint.mapPointWithGeoCoord(region_position[4][0], region_position[4][1]);     //마커 찍을 좌표 설정 MapPointer 는 좌표 저장하는 클래스
                edpoint.setMapPoint(ed_n);
                edpoint.setTag(0);
                edpoint.setItemName("남해");
                edpoint.setMarkerType(MapPOIItem.MarkerType.BluePin);
                edpoint.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
                mapView.addPOIItem(edpoint);

                polyline.addPoint(MapPoint.mapPointWithGeoCoord(region_position[4][0], region_position[4][1]));     //남해
                break;
            case "마산":
                MapPoint ed_m = MapPoint.mapPointWithGeoCoord(region_position[5][0], region_position[5][1]);     //마커 찍을 좌표 설정 MapPointer 는 좌표 저장하는 클래스
                edpoint.setMapPoint(ed_m);
                edpoint.setTag(0);
                edpoint.setItemName("마산");
                edpoint.setMarkerType(MapPOIItem.MarkerType.BluePin);
                edpoint.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
                mapView.addPOIItem(edpoint);

                polyline.addPoint(MapPoint.mapPointWithGeoCoord(region_position[5][0], region_position[5][1]));     //마산
                break;
        }


        switch (ed) {                                                   //도착지
            case "사천":
                MapPoint ed_s = MapPoint.mapPointWithGeoCoord(region_position[1][0], region_position[1][1]);     //마커 찍을 좌표 설정 MapPointer 는 좌표 저장하는 클래스
                edpoint.setMapPoint(ed_s);
                edpoint.setTag(0);
                edpoint.setItemName("사천");
                edpoint.setMarkerType(MapPOIItem.MarkerType.BluePin);
                edpoint.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
                mapView.addPOIItem(edpoint);

                polyline.addPoint(MapPoint.mapPointWithGeoCoord(region_position[1][0], region_position[1][1]));     //사천
                break;
            case "창원":
                MapPoint ed_c = MapPoint.mapPointWithGeoCoord(region_position[2][0], region_position[2][1]);     //마커 찍을 좌표 설정 MapPointer 는 좌표 저장하는 클래스
                edpoint.setMapPoint(ed_c);
                edpoint.setTag(0);
                edpoint.setItemName("창원");
                edpoint.setMarkerType(MapPOIItem.MarkerType.BluePin);
                edpoint.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
                mapView.addPOIItem(edpoint);

                polyline.addPoint(MapPoint.mapPointWithGeoCoord(region_position[2][0], region_position[2][1]));     //창원
                break;
            case "거제":
                MapPoint ed_g = MapPoint.mapPointWithGeoCoord(region_position[3][0], region_position[3][1]);     //마커 찍을 좌표 설정 MapPointer 는 좌표 저장하는 클래스
                edpoint.setMapPoint(ed_g);
                edpoint.setTag(0);
                edpoint.setItemName("거제");
                edpoint.setMarkerType(MapPOIItem.MarkerType.BluePin);
                edpoint.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
                mapView.addPOIItem(edpoint);

                polyline.addPoint(MapPoint.mapPointWithGeoCoord(region_position[3][0], region_position[3][1]));     //거제
                break;
            case "남해":
                MapPoint ed_n = MapPoint.mapPointWithGeoCoord(region_position[4][0], region_position[4][1]);     //마커 찍을 좌표 설정 MapPointer 는 좌표 저장하는 클래스
                edpoint.setMapPoint(ed_n);
                edpoint.setTag(0);
                edpoint.setItemName("남해");
                edpoint.setMarkerType(MapPOIItem.MarkerType.BluePin);
                edpoint.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
                mapView.addPOIItem(edpoint);

                polyline.addPoint(MapPoint.mapPointWithGeoCoord(region_position[4][0], region_position[4][1]));     //남해
                break;
            case "마산":
                MapPoint ed_m = MapPoint.mapPointWithGeoCoord(region_position[5][0], region_position[5][1]);     //마커 찍을 좌표 설정 MapPointer 는 좌표 저장하는 클래스
                edpoint.setMapPoint(ed_m);
                edpoint.setTag(0);
                edpoint.setItemName("마산");
                edpoint.setMarkerType(MapPOIItem.MarkerType.BluePin);
                edpoint.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
                mapView.addPOIItem(edpoint);

                polyline.addPoint(MapPoint.mapPointWithGeoCoord(region_position[5][0], region_position[5][1]));     //마산
                break;
        }
        mapView.addPolyline(polyline);
        MapPointBounds mapPointBounds = new MapPointBounds(polyline.getMapPoints());
        int padding = 100;
        mapView.moveCamera(CameraUpdateFactory.newMapPointBounds(mapPointBounds, padding));


    }
}
