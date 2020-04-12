package com.ardakaplan.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ardakaplan.rdalogger.RDALogger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RDALogger.info("HI GUYS");
    }
}
