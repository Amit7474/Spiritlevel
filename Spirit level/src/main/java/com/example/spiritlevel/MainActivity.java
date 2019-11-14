package com.example.spiritlevel;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    TextView x, y, z, position;
    ImageView bubble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        x = (TextView) findViewById(R.id.X);
        y = (TextView) findViewById(R.id.Y);
        z = (TextView) findViewById(R.id.Z);
        position = (TextView) findViewById(R.id.position);
        bubble = (ImageView) findViewById(R.id.bubble);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            x.setText(String.format("%.2f", event.values[0]));
            y.setText(String.format("%.2f", event.values[1]));
            z.setText(String.format("%.2f", event.values[2]));
            double multiplieInstance = (double) -1*event.values[1];
            bubble.setX(872 + (float) multiplieInstance * 45);
            position.setText(String.format("%.2f", bubble.getX()));

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
