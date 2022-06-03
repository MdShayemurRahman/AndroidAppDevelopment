package com.example.permissiondemoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements LocationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGPS(View view) {
        //todo: start listing to users location through location manager
        //todo: 1. location permission specified in android manifest file
        //todo: ask user's permission run-time before accessing GPS (dangerous permission)
        //todo: Update the latitude and longitude in the UI
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        //todo:2 check if the user granted permission for GPS
        //todo: if not, let's prompt and ask the user to give it
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //todo we don't have permission so ask it
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    0
            );
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        //todo: now we can read the latitude and longitude from "location" parameter
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        //todo: update the UI
        TextView gpsTextView = findViewById(R.id.gpsText);
        gpsTextView.setText("Lat: " + latitude + "\n" + "Long: " + longitude);
    }

    public void makeCall(View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
            return;
        }
        //todo we don't have permission so ask it
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0449856804"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void startMap(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:location.getLatitude(),location.getLongitude()?z=11"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}