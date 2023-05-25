package com.example.broadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AirplaneModeStateReceiver extends BroadcastReceiver {

    private static final String TAG = "MyBroadCastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {


        Boolean isOn = intent.getBooleanExtra("state", false);
        Log.d(TAG, "onReceive: Airplane mode is on: " + isOn);

    }
}