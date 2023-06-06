package com.ardakaplan.myapplication.ui;

import android.os.Bundle;
import android.view.View;

import com.ardakaplan.myapplication.R;
import com.ardakaplan.myapplication.test.JavaClass;
import com.ardakaplan.myapplication.test.KotlinClass;
import com.ardakaplan.rdalogger.RDALogger;
import com.ardakaplan.rdalogger.RDALoggerNonListened;

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

        //log to call listener
        RDALogger.info("this is INFO log");
        RDALogger.debug("this is DEBUG log");
        RDALogger.warn("this is WARN log");
        RDALogger.verbose("this is VERBOSE log");
        RDALogger.error("this is ERROR log");
        RDALogger.error(new RuntimeException("TEST EXCEPTION"));

        //non listener logs
        RDALoggerNonListened.info("this is NON LISTENER INFO log");
        RDALoggerNonListened.debug("this is NON LISTENER DEBUG log");
        RDALoggerNonListened.warn("this is NON LISTENER WARN log");
        RDALoggerNonListened.verbose("this is NON LISTENER VERBOSE log");
        RDALoggerNonListened.error("this is NON LISTENER ERROR log");
        RDALoggerNonListened.error(new RuntimeException("TEST EXCEPTION"));

        //KOTLIN TEST
        KotlinClass.Companion.test();
    }


}
