package com.example.broadcastreceiverapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /**
     * This is how to create a context Broadcast Receiver
     * Initialize your broadcast receiver
     **/
    AirplaneModeStateReceiver airplaneModeStateReceiver = new AirplaneModeStateReceiver();
    TimeZoneChangeBroadcastReceiver timeZoneChangeBroadcastReceiver = new TimeZoneChangeBroadcastReceiver();
    ExampleBroadcastReceiver exampleBroadCastReceiver = new ExampleBroadcastReceiver();
    BatteryLowReceiver batteryLowReceiver= new BatteryLowReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(airplaneModeStateReceiver, intentFilter1);

        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(Intent.ACTION_TIMEZONE_CHANGED);
        this.registerReceiver(timeZoneChangeBroadcastReceiver, intentFilter2);

        IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction(Intent.ACTION_BOOT_COMPLETED);
        intentFilter3.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        this.registerReceiver(exampleBroadCastReceiver, intentFilter3);

        IntentFilter intentFilter4 = new IntentFilter();
        intentFilter4.addAction(Intent.ACTION_BATTERY_LOW);
        this.registerReceiver(batteryLowReceiver, intentFilter4);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(airplaneModeStateReceiver);
        this.unregisterReceiver(timeZoneChangeBroadcastReceiver);
        this.unregisterReceiver(exampleBroadCastReceiver);
        this.unregisterReceiver(batteryLowReceiver);

    }

}