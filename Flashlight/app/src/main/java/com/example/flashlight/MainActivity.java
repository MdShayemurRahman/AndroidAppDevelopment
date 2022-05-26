package com.example.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private boolean torchOn = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void setTorchOnOff(View view) {

        // Connect the camera manager.
        CameraManager cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
        try {
            // ask if there is a camera, which has a flashlight.
            for( String id: cameraManager.getCameraIdList() ) {
                CameraCharacteristics cameraChar = cameraManager.getCameraCharacteristics(id);

                if(cameraChar.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)) {
                    // set the flashlight of that camera on (torch mode to true)
                    if(!torchOn) { cameraManager.setTorchMode(id, true); }
                    else { cameraManager.setTorchMode(id, false); }
                    torchOn = !torchOn;
                }
            }
        } catch(CameraAccessException e){
            e.printStackTrace();
        }

    }

    public void startSensors(View view) {
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

//        for(Sensor s: sensorList ) {
//            Toast.makeText(this, s.getName(), Toast.LENGTH_SHORT).show();
//        }
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        TextView sensorText = (TextView) findViewById(R.id.sensorTextView);
        sensorText.setText("X: " + x + "Y: " + y + "Z: " + z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}