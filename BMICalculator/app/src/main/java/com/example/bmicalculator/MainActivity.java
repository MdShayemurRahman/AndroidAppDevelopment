package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input1, input2;
    Button btn;
    TextView result, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = (EditText) findViewById(R.id.weight);
        input2 = (EditText) findViewById(R.id.height);
        btn = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.result);
        status = (TextView) findViewById(R.id.status);
    }


    public void calculate(View view) {
        String i1 = input1.getText().toString();
        String i2 = input2.getText().toString();
        String stat = status.getText().toString();

        float weightVal = Float.parseFloat(i1);
        float heightVal = Float.parseFloat(i2) / 100;

        float bmi = weightVal / (heightVal * heightVal);

        if(bmi < 18.5) {
            stat = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            stat = "Healthy";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            stat = "Overweight";
        } else {
            stat = "Obese";
        }
        result.setText("Your BMI: " + bmi + "\n" + "Status: " + stat);
    }
}