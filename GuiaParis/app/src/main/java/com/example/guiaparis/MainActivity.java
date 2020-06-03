package com.example.guiaparis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public abstract class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap map;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync( this);

    }

    public void OnMapReady(GoogleMap googleMap){
        map = googleMap;
        Intent myIntent = getIntent();
        double lat = Double.parseDouble(myIntent.getStringExtra("Lat"));
        double _long = Double.parseDouble(myIntent.getStringExtra("Long"));
        String name = myIntent.getStringExtra("name");
        /*
        double lat = 19.169257;
        double _long = 73.341601;
        String name = "Maharashtra";
    */
        LatLng Location = new LatLng(lat,_long);
        map.addMarker(new MarkerOptions().position(Location).title(name));
        map.moveCamera(CameraUpdateFactory.newLatLng(Location));
    }


}