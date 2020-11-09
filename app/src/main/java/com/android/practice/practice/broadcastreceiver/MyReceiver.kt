package com.android.practice.practice.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Received an intent.", Toast.LENGTH_SHORT).show()

        if (intent?.action.equals(MyReciverActivity.ACTION1)) {
            Toast.makeText(context, "We received an intent for Action 1", Toast.LENGTH_SHORT).show()
        } else if (intent?.action.equals(MyReciverActivity.ACTION2)) {
            Toast.makeText(context, "We received an intent for Action 2", Toast.LENGTH_SHORT).show()
        }
    }
}