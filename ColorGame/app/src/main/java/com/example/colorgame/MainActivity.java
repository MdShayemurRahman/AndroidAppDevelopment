package com.example.colorgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Boolean press = false;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeButtonColor(View view) {
        button = (Button) view;
        press = ! press;
        if(press == true) {
            button.setBackgroundColor(Color.YELLOW);
            button.setTextColor(Color.BLACK);
            button.setText("Clicked!");
        } else {
            button.setBackgroundColor(Color.BLUE);
            button.setTextColor(Color.WHITE);
            button.setText("Button");
        }
    }
}