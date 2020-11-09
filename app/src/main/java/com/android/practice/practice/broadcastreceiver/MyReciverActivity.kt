package com.android.practice.practice.broadcastreceiver

import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.android.practice.practice.R

class MyReciverActivity : AppCompatActivity() {
    private lateinit var myReceiver: MyReceiver
    private var TAG = "MyReciverActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_reciver)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, ReceiverFragment()).commit();
        }
        myReceiver = MyReceiver()
    }

    override fun onResume() {
        super.onResume()
        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver, IntentFilter(ACTION2));
    }

    override fun onPause() {
        super.onPause()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver)
        unregisterReceiver(myReceiver);
        Log.e(TAG, "receiver should be unregistered")
    }

    companion object {
        const val ACTION1 = "com.android.practice.practice.one"
        const val ACTION2 = "com.android.practice.practice.two"
    }
}