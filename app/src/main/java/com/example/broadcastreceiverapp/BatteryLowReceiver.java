package com.example.broadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BatteryLowReceiver extends BroadcastReceiver {
    private static final String TAG = "BatteryLowReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        String getBatteryState= intent.getStringExtra("BATTERY_LOW");

        if (Intent.ACTION_BATTERY_LOW.equals(intent.getAction())) {
            CharSequence text = "You have a low battery, some system functions may not work!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            Log.d(TAG, "onReceive phone battery state: "+ getBatteryState);
        }
        else{
            Toast.makeText(context, "your battery is beyond average", Toast.LENGTH_SHORT).show();
        }
    }
}