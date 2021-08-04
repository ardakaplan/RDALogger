package com.ardakaplan.myapplication.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ardakaplan.rdalogger.RDALogger;

/**
 * Created by Arda Kaplan at 4.08.2021 - 13:34
 * <p>
 * ardakaplan101@gmail.com
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RDALogger.logLifeCycle(getClass().getSimpleName());
    }

    @Override
    protected void onStart() {
        super.onStart();

        RDALogger.logLifeCycle(getClass().getSimpleName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        RDALogger.logLifeCycle(getClass().getSimpleName());
    }

    @Override
    protected void onResume() {
        super.onResume();

        RDALogger.logLifeCycle(getClass().getSimpleName());
    }

    @Override
    protected void onPause() {
        super.onPause();

        RDALogger.logLifeCycle(getClass().getSimpleName());
    }

    @Override
    protected void onStop() {
        super.onStop();

        RDALogger.logLifeCycle(getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        RDALogger.logLifeCycle(getClass().getSimpleName());
    }
}
