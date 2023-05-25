package com.example.broadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class TimeZoneChangeBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "TimeZoneChangeBroadcast";

    @Override
    public void onReceive(Context context, Intent intent) {

        /** This type of intent is used when you want to detect time zone change**/
        //This gets the type of action
        String timeZoneString = intent.getAction();
        Toast.makeText(context, timeZoneString, Toast.LENGTH_LONG).show();

        String timeZone = intent.getStringExtra("time-zone");
        Log.d(TAG, "You have changed your Timezone to: " + timeZone);


    }
}