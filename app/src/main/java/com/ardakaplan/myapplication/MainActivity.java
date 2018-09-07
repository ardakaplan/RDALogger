package com.ardakaplan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ardakaplan.rdalogger.RDALogger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RDALogger.start(getString(R.string.app_name)).enableLogging(true);

        RDALogger.info("HI GUYS");
    }
}
