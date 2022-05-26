package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    // how to make a simple request: read more, https://google.github.io/volley/simple.html
    private RequestQueue queue;
    String url = "https://api.openweathermap.org/data/2.5/weather?q=tampere&units=metric&appid=641e6a95d36a4f8c2fbb81ab27ae53cb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this); // instantiate the request queue.
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

        // make request to open weather map api.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                // this is a successful callback
                    Toast.makeText(this, response, Toast.LENGTH_LONG).show();

                    // parse the data from JSON object.
                    parseJsonAndUpdateUI(response);

                }, error -> {
                // error callback
                    Toast.makeText(this, "Oops! error", Toast.LENGTH_LONG).show();
                });

        queue.add(stringRequest);


    }

    private void parseJsonAndUpdateUI(String response) {
        String weatherDesc = "";
        double temperature = 0.0;
        double windSpeed = 0.0;

        // parse the data from response
        // 1. Convert the response into JSONObject.
        try {
            JSONObject weather = new JSONObject(response);
            temperature = weather.getJSONObject("main").getDouble("temp");
            weatherDesc = weather.getJSONArray("weather").getJSONObject(0).getString("main");
            windSpeed = weather.getJSONObject("wind").getDouble("speed");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        // 2. Update data in the Screen.
        TextView weatherDescTextView = findViewById(R.id.textViewWeatherDescription);
        weatherDescTextView.setText(weatherDesc);

        TextView temperatureTextView = findViewById(R.id.textViewTemperature);
        temperatureTextView.setText("" + temperature + " C");

        TextView windSpeedTextView = findViewById(R.id.textViewWindSpeed);
        windSpeedTextView.setText("" + windSpeed + " m/s");
    }

}