package com.example.benny.broadcastforoffline;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by benny on 16/12/2.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCllector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCllector.removeActivity(this);
    }
}
