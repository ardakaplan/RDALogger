package com.ardakaplan.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ardakaplan.rdalogger.RDALogger;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.mainActivity_button_lifeCycle).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                LifeCycleLogActivity.open(MainActivity.this);
            }
        });

//        //JAVA TEST
//        JavaClass.test();
//
//        //KOTLIN TEST
//        KotlinClass.Companion.test();
    }


}
