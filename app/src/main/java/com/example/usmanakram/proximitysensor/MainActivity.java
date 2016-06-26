package com.example.usmanakram.proximitysensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView proxtv;
    SensorManager sm;
    Sensor proxsensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        proxtv = (TextView)findViewById(R.id.proximity_tv);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        proxsensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        sm.registerListener(this,proxsensor,SensorManager.SENSOR_DELAY_NORMAL);




    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        proxtv.setText(String.valueOf(event.values[0]));


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
