package com.ardakaplan.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //JAVA TEST
        JavaClass.test();

        //KOTLIN TEST
        KotlinClass.Companion.test2();
    }

    @Override
    public void onBackPressed() {

        Log.d("XXXX", "KOTLIN*****************************************************");
        //KOTLIN TEST
        new KotlinClass().test();


        Log.d("XXXX", "JAVA*****************************************************");

        JavaClass.test();
    }
}
