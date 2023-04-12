package com.example.ownroadrider;


import android.os.Bundle;

import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;


public class Map_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);


        MapView mapView_2 = new MapView(Map_view.this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view2);
        mapViewContainer.addView(mapView_2);
        mapView_2.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(35.1805, 128.1087), 5, true);
    }
}