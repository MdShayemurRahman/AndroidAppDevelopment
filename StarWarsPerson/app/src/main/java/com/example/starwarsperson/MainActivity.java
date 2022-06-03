package com.example.starwarsperson;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener  {
    // activity data here
    private float x = 0;
    private float y = 0;
    private float z = 0;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    boolean active = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView sensorValue = findViewById(R.id.dataview);
        sensorValue.setText("X: " + x + " Y: " + y + " Z: " + z);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    // check if there is data saved in the bundle.
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        active = true;
        super.onRestoreInstanceState(savedInstanceState);
        // read the data of the bundle.
        x = savedInstanceState.getFloat("X1");
        y = savedInstanceState.getFloat("Y1");
        z = savedInstanceState.getFloat("Z1");
        TextView sensorValue = findViewById(R.id.dataview);
        sensorValue.setText("X: " + x + " Y: " + y + " Z: " + z);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState){
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putFloat("X1", x);
        savedInstanceState.putFloat("Y1", y);
        savedInstanceState.putFloat("Z1", z);
    }



    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this,accelerometer);
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public void valueChange(View view) {
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        active = true;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        x = sensorEvent.values[0];
        y = sensorEvent.values[1];
        z = sensorEvent.values[2];

        if(active) {
            TextView sensorValue = findViewById(R.id.dataview);
            sensorValue.setText("X: " + x + "\n" + " Y: " + y + "\n" + " Z: " + z);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}