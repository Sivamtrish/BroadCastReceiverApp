package com.example.broadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "ExampleBroadcastReceive";


    @Override
    public void onReceive(Context context, Intent intent) {


        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Boolean bootCompleted = intent.getBooleanExtra(Intent.ACTION_BOOT_COMPLETED, false);
            Toast.makeText(context, "device boot is completed", Toast.LENGTH_SHORT).show();
            Log.w(TAG, "your device is booting: " + bootCompleted);
        } else {
            Toast.makeText(context, "your device is not booting", Toast.LENGTH_SHORT).show();
        }

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            Boolean notConnected = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            Toast.makeText(context, "device is not connected", Toast.LENGTH_SHORT).show();
//            Log.d(TAG, "your device is connected: " + notConnected);
        } else {
            Toast.makeText(context, "your device is not connected", Toast.LENGTH_SHORT).show();
        }
    }
}
//An implicit broadcast does not specify the component name, but we just listen for the action and perform it
//static means we register our broadcast receiver in the manifest file and this way we can receive our
// broadcast even if our app isn't running. If all the apps register for it at the same time, and if it is started all will run at thesame time