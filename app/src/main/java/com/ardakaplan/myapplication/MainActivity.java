package com.ardakaplan.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //JAVA TEST
        JavaClass.test();

        //KOTLIN TEST
        KotlinClass.Companion.test();
    }
}
