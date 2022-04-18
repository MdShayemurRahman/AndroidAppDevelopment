package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openForcast(View view) {
        // Create an intent to open ForcastActivity (navigate into other page)
        Intent intent = new Intent(this, ForcastActivity.class);

        // send some data with the other Activity with the intent.
        intent.putExtra("CITY_NAME", "Tampere");

        // start the activity through intent.
        startActivity(intent);
    }



    public void updateWeather(View view) {
        String weatherDesc = "Cloudy";
        float temperature = 5.4f;
        float windSpeed = 2.0f;

        TextView weatherDescTextView = findViewById(R.id.textViewWeatherDescription);
        weatherDescTextView.setText(weatherDesc);

        TextView temperatureTextView = findViewById(R.id.textViewTemperature);
        temperatureTextView.setText("" + temperature + " C");

        TextView windSpeedTextView = findViewById(R.id.textViewWindSpeed);
        windSpeedTextView.setText("" + windSpeed + " m/s");
    }

}