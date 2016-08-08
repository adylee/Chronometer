package com.example.administrator.chronometer;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);
        final Button start = (Button) findViewById(R.id.start);
        Button stop  = (Button) findViewById(R.id.stop);
        Button reset = (Button) findViewById(R.id.reset);
        long timeInterval=0;

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer chronometer) {

                        chronometer.stop();
                        Log.v("TimeInterval",String.valueOf(SystemClock.elapsedRealtime()- chronometer.getBase()));
                        //start.setEnabled(true);

                    }
                });
            }
        });

    }
}
