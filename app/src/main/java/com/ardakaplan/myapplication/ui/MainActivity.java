package com.ardakaplan.myapplication.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ardakaplan.myapplication.test.JavaClass;
import com.ardakaplan.myapplication.test.KotlinClass;
import com.ardakaplan.myapplication.R;
import com.ardakaplan.rdalogger.RDALogger;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.mainActivity_button_lifeCycle).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                RDALogger.debug("BUTTON CLICKED");

                LifeCycleLogActivity.open(MainActivity.this);
            }
        });

        //JAVA TEST
        JavaClass.test();

        //KOTLIN TEST
        KotlinClass.Companion.test();
    }


}
