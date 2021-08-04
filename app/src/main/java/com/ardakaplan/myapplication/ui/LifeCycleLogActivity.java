package com.ardakaplan.myapplication.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.ardakaplan.myapplication.R;

/**
 * Created by Arda Kaplan at 4.08.2021 - 13:55
 * <p>
 * ardakaplan101@gmail.com
 */
public class LifeCycleLogActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.life_cycle_log_activity);
    }

    public static void open(Activity activity) {

        activity.startActivity(new Intent(activity, LifeCycleLogActivity.class));
    }

}