package com.example.benny.broadcastforordered;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by benny on 16/11/29.
 */
public class Anotherreceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"receive a ordered broadcast",Toast.LENGTH_LONG).show();
    }
}
